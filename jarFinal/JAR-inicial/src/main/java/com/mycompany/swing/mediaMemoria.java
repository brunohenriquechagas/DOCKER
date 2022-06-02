
package com.mycompany.swing;


public class mediaMemoria {
    public Integer idMaquina;
    public Long mediaMemoria;

    public mediaMemoria() {
    }

    public mediaMemoria(Integer idMaquina, Long mediaMemoria) {
        this.idMaquina = idMaquina;
        this.mediaMemoria = mediaMemoria;
    }
    
    

    public Integer getIdMaquina() {
        return idMaquina;
    }

    public void setIdMaquina(Integer idMaquina) {
        this.idMaquina = idMaquina;
    }

    public Long getMediaMemoria() {
        return mediaMemoria;
    }

    public void setMediaMemoria(Long mediaMemoria) {
        this.mediaMemoria = mediaMemoria;
    }

    @Override
    public String toString() {
        return "mediaMemoria{" + "idMaquina=" + idMaquina + ", mediaMemoria=" + mediaMemoria + '}';
    }
    
    
}
