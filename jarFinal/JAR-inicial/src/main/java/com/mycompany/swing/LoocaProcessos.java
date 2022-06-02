package com.mycompany.swing;

import com.github.britooo.looca.api.group.processos.Processo;

public class LoocaProcessos {
    
    public Integer PID;
    public String Nome;
    public Double usoCPU;
     public Long usoMemoria;
     public Long bytesUtilizados;
    public Long memVirtualUtilizada;
   
    
    public Integer totalProcessos;
    public Integer threads;

    public LoocaProcessos(Integer PID,String Nome,Double usoCPU,Long usoMemoria,Long bytesUtilizados, Long memVirtualUtilizada,  Integer totalProcessos, Integer threads) {
        this.PID = PID;
        this.Nome = Nome;
        this.usoCPU = usoCPU;
        this.usoMemoria = usoMemoria;
        this.bytesUtilizados = bytesUtilizados;
        this.memVirtualUtilizada = memVirtualUtilizada;
        this.totalProcessos = totalProcessos;
        this.threads = threads;
    }

    public LoocaProcessos() {
    }

    public Double getUsoCPU() {
        return usoCPU;
    }

    public void setUsoCPU(Double usoCPU) {
        this.usoCPU = usoCPU;
    }

    public Long getBytesUtilizados() {
        return bytesUtilizados;
    }

    public void setBytesUtilizados(Long bytesUtilizados) {
        this.bytesUtilizados = bytesUtilizados;
    }
    
    public String getNome()        
    {
        return Nome;
    }
    
    public void setNome(String Nome)
    {
        this.Nome = Nome;
    }
    
    public Long getUsoMemoria()
    {
        return usoMemoria;
    }
    
    public void setUsoMemoria(Long usoMemoria)
            
    {
        this.usoMemoria = usoMemoria;
    }

    public Long getMemVirtualUtilizada() {
        return memVirtualUtilizada;
    }

    public void setMemVirtualUtilizada(Long memVirtual) {
        this.memVirtualUtilizada = memVirtual;
    }

    public Integer getPID() {
        return PID;
    }

    public void setPid(Integer pid) {
        this.PID = PID;
    }
 
    public Integer getTotalProcessos() {
        return totalProcessos;
    }

    public void setTotalProcessos(Integer totalProcessos) {
        this.totalProcessos = totalProcessos;
    }

    public Integer getThreads() {
        return threads;
    }

    public void setThreads(Integer threads) {
        this.threads = threads;
    }

    public LoocaProcessos(String Nome, Double usoCPU, Long usoMemoria) {
        this.Nome = Nome;
        this.usoCPU = usoCPU;
        this.usoMemoria = usoMemoria;
    }

  
    
    
   
}