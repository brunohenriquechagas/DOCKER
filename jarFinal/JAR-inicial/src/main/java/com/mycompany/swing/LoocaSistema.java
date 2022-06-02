
package com.mycompany.swing;


public class LoocaSistema {
   
     public Integer ID;
     public String sistemaOperacional;
     public String fabricante;
     public Integer arquitetura;
     public String permissoes;

    @Override
    public String toString() {
        return String.format(
                              "\nSistema Operacional = %s"
                            + "\nFabricante = %s"
                            + "\nArquitetura = %d"
                            + "\nPermissões = %s",
                           // ID,
                            sistemaOperacional,
                            fabricante,
                            arquitetura,
                          //  Inicializado,
                         //   TempoDeAtividade,
                            permissoes);
    }
   // public String Inicializado;
   // public String TempoDeAtividade;
  

    public LoocaSistema() {
    }

    public LoocaSistema(Integer ID, String sistemaOperacional, String fabricante, Integer arquitetura, String permissoes) {
        this.ID = ID;
        this.sistemaOperacional = sistemaOperacional;
        this.fabricante = fabricante;
        this.arquitetura = arquitetura;
        //this.Inicializado = Inicializado;
      //  this.TempoDeAtividade = TempoDeAtividade;
       this.permissoes = permissoes;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getsistemaOperacional() {
        return sistemaOperacional;
    }

    public void setsistemaOperacional(String sistemaOperacional) {
        this.sistemaOperacional = sistemaOperacional;
    }

    public String getfabricante() {
        return fabricante;
    }

    public void setfabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public Integer getarquitetura() {
        return arquitetura;
    }

    public void setarquitetura(Integer arquitetura) {
        this.arquitetura = arquitetura;
    }

   // public String getInicializado() {
     //   return Inicializado;
   // }

   // public void setInicializado(String Inicializado) {
    //    this.Inicializado = Inicializado;
  //  }

   // public String getTempoDeAtividade() {
    //    return TempoDeAtividade;
   // }

   // public void setTempoDeAtividade(String TempoDeAtividade) {
   //     this.TempoDeAtividade = TempoDeAtividade;
   // }

    public String getpermissoes() {
        return permissoes;
    }

    public void setpermissoes(String Permissoes) {
        this.permissoes = Permissoes;
    }

}
