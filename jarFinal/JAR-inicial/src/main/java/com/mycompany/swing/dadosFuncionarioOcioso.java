
package com.mycompany.swing;

public class dadosFuncionarioOcioso {
    private Integer idFuncionario;
    private String Nome;
    private String Cargo;
    private String hostName;
    private String tempoInicializado;

    public dadosFuncionarioOcioso() {
    }

    public dadosFuncionarioOcioso(Integer idFuncionario, String Nome, String Cargo, String hostName, String tempoInicializado) {
        this.idFuncionario = idFuncionario;
        this.Nome = Nome;
        this.Cargo = Cargo;
        this.hostName = hostName;
        this.tempoInicializado = tempoInicializado;
    }

    public Integer getIdFuncionario() {
        return idFuncionario;
    }

    @Override
    public String toString() {
        return "Dados Funcionario:"
                + "\nidFuncionario=" + idFuncionario 
                + "\nNome=" + Nome
                + "\nCargo=" + Cargo 
                + "\nhostName=" + hostName
                + "\ntempoInicializado=" + tempoInicializado;
    }

    public void setIdFuncionario(Integer idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getCargo() {
        return Cargo;
    }

    public void setCargo(String Cargo) {
        this.Cargo = Cargo;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getTempoInicializado() {
        return tempoInicializado;
    }

    public void setTempoInicializado(String tempoInicializado) {
        this.tempoInicializado = tempoInicializado;
    }
    
    
}
