
package com.mycompany.swing;

public class LoocaHardware {
    
    
    public Integer qtdDiscos;
    public String nomeDisco;
    public Long tamanhoDisco;
    public Long memoriaTotal;
    public String processadorNome;
    public Double temperaturaAtual;

    public LoocaHardware(Integer qtdDiscos, String nomeDisco, Long tamanhoDisco, Long memoriaTotal, String processadorNome, Double temperaturaAtual) {
        this.qtdDiscos = qtdDiscos;
        this.nomeDisco = nomeDisco;
        this.tamanhoDisco = tamanhoDisco;
        this.memoriaTotal = memoriaTotal;
        this.processadorNome = processadorNome;
        this.temperaturaAtual = temperaturaAtual;
    }

    public LoocaHardware() {
    }

    public Integer getQtdDiscos() {
        return qtdDiscos;
    }

    public void setQtdDiscos(Integer qtdDiscos) {
        this.qtdDiscos = qtdDiscos;
    }

    public String getNomeDisco() {
        return nomeDisco;
        
    }

    public void setNomeDisco(String nomeDisco) {
        this.nomeDisco = nomeDisco;
    }

    public Long getTamanhoDisco() {
        return tamanhoDisco;
    }

    public void setTamanhoDisco(Long tamanhoDisco) {
        this.tamanhoDisco = tamanhoDisco;
    }

    public Long getMemoriaTotal() {
        return memoriaTotal;
    }

    public void setMemoriaTotal(Long memoriaTotal) {
        this.memoriaTotal = memoriaTotal;
    }

    public String getProcessadorNome() {
        return processadorNome;
    }

    public void setProcessadorNome(String processadorNome) {
        this.processadorNome = processadorNome;
    }

    public Double getTemperaturaAtual() {
        return temperaturaAtual;
    }

    public void setTemperaturaAtual(Double temperaturaAtual) {
        this.temperaturaAtual = temperaturaAtual;
    }

    @Override
    public String toString() {
        return String.format("Quantidade de discos = %d"
                             + "\nNome do disco = %s"
                             + "\nTamanho do disco = %d"
                             + "\nMemoria Toltal = %d"
                             + "\nNome do Processador = %s"
                             + "\nTemperatura atual = %.2f",
                             qtdDiscos,
                             nomeDisco,
                             tamanhoDisco,
                             memoriaTotal,
                             processadorNome,
                             temperaturaAtual
                             );
    }
}
