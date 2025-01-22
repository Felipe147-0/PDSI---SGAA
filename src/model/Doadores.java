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
public class Doadores extends DataAccessObject {
    private int idd;
    private String nome;
    private String cpf;
    private String telefone;
    
    private Doacoes doacoes;

    public Doadores() {
        super("doadores");
    }

    
    
    
    public Doacoes getDoacoes() {
        return doacoes;
    }

    public void setDoacoes(Doacoes doacoes) {
        this.doacoes = doacoes;
    }
    
    
    
    
    

    public int getIdd() {
        return idd;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setIdd(int idd) {
        if( idd != this.idd ){
            this.idd = idd;
            addChange("id", this.idd);
        }
    }

    public void setNome(String nome) {
        if( nome == null){
            if (this.nome != null) {
                this.nome = nome;
                addChange("nome", null);
            }
        } else {
            if (!nome.equals(this.nome)) {
                this.nome = nome;
                addChange("nome", this.nome);
            }
        }
    }

    public void setCpf(String cpf) {
         if( cpf == null ) {
            if( this.cpf != null ) {
                this.cpf = cpf;
                addChange("cpf", null);
            }
        } else {
            if( !cpf.equals(this.cpf) ) {
                this.cpf = cpf;
                addChange("cpf", this.cpf);
            }
        }
    }

    public void setTelefone(String telefone) {
         if( !telefone.equals( this.telefone ) ) {
            this.telefone = telefone;
            addChange("telefone", this.telefone);
        }
    }
    
   

    @Override
    protected String getWhereClauseForOneEntry() {
        return " id = " + this.idd;
    }

    @Override
    protected void fill(ArrayList<Object> data) throws Exception {
        idd = (int) data.get(0);
        
        if( data.get(1) == null) nome = null;
        else nome = (String) data.get(1);
        
        if( data.get(2) == null ) cpf = null;
        else cpf = (String) data.get(2);
        
        if( data.get(3) == null ) telefone = null;
        else telefone = (String) data.get(3);
    }
    
    @Override
    public boolean equals(Object obj) {
        if( obj instanceof Doadores ) {
            Doadores aux = (Doadores) obj;
            
            if( getIdd() == aux.getIdd() ) {
                return true;
            } else {
                return false;
            }            
        } else { 
            return false;
        }        
    } 
}
