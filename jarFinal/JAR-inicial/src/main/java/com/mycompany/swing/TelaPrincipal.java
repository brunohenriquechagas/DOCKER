package com.mycompany.swing;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.discos.DiscosGroup;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.group.processos.Processo;
import static java.nio.file.StandardOpenOption.CREATE;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import static javax.swing.text.html.HTML.Attribute.ID;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class TelaPrincipal extends javax.swing.JFrame {

    private Funcionario funcionario;

    // classe de de conexão com o banco
    private Connection connection;

    //conexão com o banco
    private JdbcTemplate template;

    // looca
    private Looca looca;

    public TelaPrincipal(Funcionario idsFuncionario) {

        this.funcionario = idsFuncionario;
        this.connection = new Connection();
        this.template = new JdbcTemplate(connection.getDatasource());
        this.looca = new Looca();

        initComponents();

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                inicializacao();
            }
        });
    }

    private void inicializacao() {
        Timer timer = new Timer();
        Integer delay = 1000;
        Integer interval = 5000;

        Integer idDaMaquina = buscarIdDaMaquina();

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

                System.out.println("Atualizando dados...");

                buscarProcessos(idDaMaquina);
                buscarHistorico(idDaMaquina);

            }
        }, delay, interval);

        buscarDadosHardware(idDaMaquina);
    }

    private Integer buscarIdDaMaquina() {
        /////////////////////  Pegando o id da Maquina    ///////////////////////
        List<maquina> idMaquina = template.query("select idMaquina from [dbo].[Maquina] \n"
                + "JOIN [dbo].[FUNCIONARIO] on fkUsuario = idFuncionario \n"
                + "WHERE idFuncionario = " + funcionario.getIdFuncionario(),
                new BeanPropertyRowMapper(maquina.class));

        System.out.println("pegando o ID MAQUINA" + idMaquina.toString());

        return idMaquina.get(0).getIdMaquina();
    }

    private void buscarProcessos(Integer idDaMaquina) {
        System.out.println("Buscando processos...");

        List<Processo> processos = looca.getGrupoDeProcessos().getProcessos();
        List<Processo> processosFiltrados = new ArrayList<>();
        Date dataHoraProcesso = new Date();

        for (Processo processo : processos) {
            if (processo.getUsoCpu() > 1 || processo.getUsoMemoria() > 1) {
                processosFiltrados.add(processo);
            }
        }

        System.out.println(String.format("Salvando %d processos", processosFiltrados.size()));

        Integer totalProcessos = looca.getGrupoDeProcessos().getTotalProcessos();
        Integer threads = looca.getGrupoDeProcessos().getTotalThreads();

        String inserirDadosProcessos = "Insert into Processos VALUES "
                + "(?,?,?,?,?,?,?,?,?,?)";

        template.batchUpdate(inserirDadosProcessos, new BatchPreparedStatementSetter() {

            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                Integer pid = processosFiltrados.get(i).getPid();
                String nome = processosFiltrados.get(i).getNome();
                Double usoCpu = processosFiltrados.get(i).getUsoCpu();
                Double usoMemoria = processosFiltrados.get(i).getUsoMemoria();
                Long bytesUtilizados = processosFiltrados.get(i).getBytesUtilizados();
                Long memVirtualUtilizada = processosFiltrados.get(i).getMemoriaVirtualUtilizada();
                
                System.out.println("Inserindo processo: " + pid + " " + nome + " CPU: " + usoCpu + " Memória: " + usoMemoria + " Datahora: " + dataHoraProcesso);
                
                ps.setInt(1, idDaMaquina);
                ps.setInt(2, pid);
                ps.setString(3, nome);
                ps.setDouble(4, usoCpu);
                ps.setDouble(5, usoMemoria);
                ps.setLong(6, bytesUtilizados);
                ps.setLong(7, memVirtualUtilizada);
                ps.setInt(8, totalProcessos);
                ps.setInt(9, threads);
                ps.setTimestamp(10, new Timestamp(dataHoraProcesso.getTime()));
            }

            @Override
            public int getBatchSize() {
                return processosFiltrados.size();
            }

        });
    }

    private void buscarDadosHardware(Integer idDaMaquina) {
        System.out.println("Buscando dados de hardware...");

        DiscosGroup disco = looca.getGrupoDeDiscos();
        Memoria memoria = looca.getMemoria();
        Processador processador = looca.getProcessador();

        List<Disco> listaDeDisco = disco.getDiscos();

        for (int i = 0; i < listaDeDisco.size(); i++) {

            String nomeDisco = disco.getDiscos().get(i).getNome();
            Long tamanhoDisco = disco.getDiscos().get(i).getTamanho();
            String modeloDisco = disco.getDiscos().get(i).getModelo();
            Integer qtdDiscos = disco.getQuantidadeDeDiscos();
            Long memoriaTotal = memoria.getTotal();
            String processadorNome = processador.getNome();

            //Para Mysql local
            //  String inserirDadosHardware = "Insert into ComponentesHardware VALUES" 
            //          + "(null,1,?,?,?,?,?,?);";
            //Para AZURE
            String inserirDadosHardware = "Insert into ComponentesHardware VALUES"
                    + "(?,?,?,?,?,?,?);";

            template.update(inserirDadosHardware,
                    idDaMaquina,
                    nomeDisco,
                    tamanhoDisco,
                    modeloDisco,
                    qtdDiscos,
                    memoriaTotal,
                    processadorNome);
        }
    }

    private void buscarHistorico(Integer idDaMaquina) {
        System.out.println("Buscando histórico...");

        Date data = new Date();
         DiscosGroup disco = looca.getGrupoDeDiscos();
        List<Disco> listaDeDisco = disco.getDiscos();
        
        for(Integer i = 0; i < listaDeDisco.size(); i++)
        {
            System.out.println("BYTES DE LEITURA: " +  listaDeDisco.get(i).getBytesDeLeitura());
        }
        
        //MySQL local         
        //String inserirHistorico = "Insert into Historico VALUES "
        //   + "(null,1,?,?,?,?,?,?,?);";

        Memoria memoria = looca.getMemoria();
        Processador processador = looca.getProcessador();

        String tempoInicializado = looca.getSistema().getInicializado().toString();
        String tempoDeAtividade = looca.getSistema().getTempoDeAtividade().toString();
        String temperaturaAtual = looca.getTemperatura().toString();
        Long memoriaEmUso = memoria.getEmUso();
        Long memoriaDisponível = memoria.getDisponivel();
        Double processadorUso = processador.getUso();

        //AZURE
        String inserirHistorico = "Insert into Historico VALUES "
                + "(?,?,?,?,?,?,?,?);";

        template.update(inserirHistorico, idDaMaquina, data, tempoInicializado, tempoDeAtividade,
                temperaturaAtual, memoriaEmUso, memoriaDisponível, processadorUso);

        System.out.println("Data " + data);
        System.out.println("Tempo inicializado " + tempoInicializado);
        System.out.println("Tempo de atividade " + tempoDeAtividade);
        System.out.println("Temperatura atual " + temperaturaAtual);
        System.out.println("Memoria em uso " + memoriaEmUso);
        System.out.println("Memoria disponível " + memoriaDisponível);
        System.out.println("Uso do processador " + processadorUso);
        
       
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        onda = new javax.swing.JLabel();
        logoBarco = new javax.swing.JLabel();
        painelDados = new javax.swing.JPanel();
        tituloCapturandoDados = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        dadosMaquina = new javax.swing.JTextArea();
        fundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 1000));
        getContentPane().setLayout(null);

        onda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/gui/img/OndaRoxaParaCima.png"))); // NOI18N
        getContentPane().add(onda);
        onda.setBounds(-120, 460, 1120, 350);

        logoBarco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/gui/img/feito-removebg-preview.png"))); // NOI18N
        getContentPane().add(logoBarco);
        logoBarco.setBounds(610, 90, 280, 250);

        painelDados.setBackground(new java.awt.Color(255, 255, 255));
        painelDados.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tituloCapturandoDados.setBackground(new java.awt.Color(0, 0, 0));
        tituloCapturandoDados.setForeground(new java.awt.Color(0, 0, 0));
        tituloCapturandoDados.setText("Capturando dados da máquina:");

        dadosMaquina.setColumns(20);
        dadosMaquina.setRows(5);
        jScrollPane1.setViewportView(dadosMaquina);

        javax.swing.GroupLayout painelDadosLayout = new javax.swing.GroupLayout(painelDados);
        painelDados.setLayout(painelDadosLayout);
        painelDadosLayout.setHorizontalGroup(
            painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDadosLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelDadosLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelDadosLayout.createSequentialGroup()
                        .addComponent(tituloCapturandoDados, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(82, 82, 82))))
        );
        painelDadosLayout.setVerticalGroup(
            painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDadosLayout.createSequentialGroup()
                .addComponent(tituloCapturandoDados)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        getContentPane().add(painelDados);
        painelDados.setBounds(130, 50, 450, 480);

        fundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/gui/img/fundo.png"))); // NOI18N
        getContentPane().add(fundo);
        fundo.setBounds(0, 0, 1000, 720);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea dadosMaquina;
    private javax.swing.JLabel fundo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel logoBarco;
    private javax.swing.JLabel onda;
    private javax.swing.JPanel painelDados;
    private javax.swing.JLabel tituloCapturandoDados;
    // End of variables declaration//GEN-END:variables
}
