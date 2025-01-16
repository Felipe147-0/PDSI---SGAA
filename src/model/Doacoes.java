/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import controller.DataAccessObject;
import java.util.ArrayList;

/**
 *
 * @author felip
 */
public class Doacoes extends DataAccessObject {
    
    private int id;
    private String tipoDoacao;
    private String descricao;
    private String valor;
    private String dataDoacao;
   
    private Doadores doadores;


    public Doacoes() {
        super("doacoes");
    }

    public int getId() {
        return id;
    }

    public String getTipoDoacao() {
        return tipoDoacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getValor() {
        return valor;
    }

    public String getDataDoacao() {
        return dataDoacao;
    }
    
    public Doadores getDoadores() {
        return doadores;
    }
    
    public void setId(int id) {
        if( id != this.id ) {
            this.id = id;
            addChange("id", this.id);
        }
    }

    public void setTipoDoacao(String tipoDoacao) {
        if( tipoDoacao == null ) {
            if( this.tipoDoacao != null ) {
                this.tipoDoacao = tipoDoacao;
                addChange("tipo_doacao", null);
            }
        } else {
            if( !tipoDoacao.equals(this.tipoDoacao) ) {
                this.tipoDoacao = tipoDoacao;
                addChange("tipo_doacao", this.tipoDoacao);
            }
        }
    }

    public void setDescricao(String descricao) {
        if( descricao == null ) {
            if( this.descricao != null ) {
                this.descricao = descricao;
                addChange("descricao", null);
            }
        } else {
            if( !descricao.equals(this.descricao) ) {
                this.descricao = descricao;
                addChange("descricao", this.descricao);
            }
        }
    }

    public void setValor(String valor) {
        if( valor == null ) {
            if( this.valor != null ) {
                this.valor = valor;
                addChange("valor", null);
            }
        } else {
            if( !valor.equals(this.valor) ) {
                this.valor = valor;
                addChange("valor", this.valor);
            }
        }
    }

    public void setDataDoacao(String dataDoacao) {
       if( dataDoacao == null ) {
            if( this.dataDoacao != null ) {
                this.dataDoacao = dataDoacao;
                addChange("data_doacao", null);
            }
        } else {
            if( !dataDoacao.equals(this.dataDoacao) ) {
                this.dataDoacao = dataDoacao;
                addChange("data_doacao", this.dataDoacao);
            }
        }
    }

    public void setDoadores(Doadores doadores) throws Exception {
        if( doadores == null ) {
            if( this.doadores != null ) {
                this.doadores = doadores;
                addChange("doadores_id", null);
            }
        } else {
            if( this.doadores == null ) {
                this.doadores = new Doadores();
                this.doadores.setId( doadores.getId() );
                this.doadores.load();
                addChange( "doadores_id", this.doadores.getId() );
            } else {
                if( !doadores.equals( this.doadores ) ) { // é precriso fazer um @Override do método equals na classe Doadores
                    this.doadores.setId( doadores.getId() );
                    this.doadores.load();
                    addChange( "doadores_id", this.doadores.getId() );
                }
            }
        }
        
    }
    
    @Override
    protected String getWhereClauseForOneEntry() {
        return " id = " + this.id;
    }

    @Override
    protected void fill(ArrayList<Object> data) throws Exception {
       
        id = (int) data.get(0);
        
        if( data.get(1) == null) tipoDoacao = null;
        else tipoDoacao = (String) data.get(1);
        
        if( data.get(2) == null) descricao = null;
        else descricao = (String) data.get(2);
        
        if( data.get(3) == null) valor = null;
        else valor = (String) data.get(3);
        
        if( data.get(4) == null) dataDoacao = null;
        else dataDoacao = (String) data.get(4).toString();
        
        if( data.get(5) != null ) {
            doadores = new Doadores();
            
            doadores.setId( (int) data.get(5) );
            doadores.load();                                 
        } else {
            doadores = null;
        } 
        
        
    }
    
    
}
