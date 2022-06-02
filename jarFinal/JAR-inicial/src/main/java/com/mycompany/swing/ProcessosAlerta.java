
package com.mycompany.swing;

public class ProcessosAlerta {
    public String Nome;
    public Long usoMemoria;
    public Long usoCPU;

    public Long getUsoCPU() {
        return usoCPU;
    }

    public void setUsoCPU(Long usoCPU) {
        this.usoCPU = usoCPU;
    }

    public ProcessosAlerta() {
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public Long getUsoMemoria() {
        return usoMemoria;
    }

    public void setUsoMemoria(Long usoMemoria) {
        this.usoMemoria = usoMemoria;
    }

    @Override
    public String toString() {
        
        return "Nome= " + Nome + "\nusoMemoria=" + usoMemoria + " MG" + "\nuso CPU = " 
                + usoCPU + "%"+"\n\n";
    }
    
    
    
}
