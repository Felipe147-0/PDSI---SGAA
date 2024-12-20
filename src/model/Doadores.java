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
    private int id;
    private String nome;
    private String cpf;
    private String telefone;

    public Doadores() {
        super("doadores");
    }

    public int getId() {
        return id;
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

    public void setId(int id) {
        if( id != this.id ){
            this.id = id;
            addChange("id", this.id);
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
    public boolean equals(Object obj) {
        if( obj instanceof Doadores ) {
            Doadores aux = (Doadores) obj;
            
            if( getId() == aux.getId() ) {
                return true;
            } else {
                return false;
            }            
        } else { 
            return false;
        }        
    }    

    @Override
    protected String getWhereClauseForOneEntry() {
        return " id = " + this.id;
    }

    @Override
    protected void fill(ArrayList<Object> data) throws Exception {
        id = (int) data.get(0);
        
        if( data.get(1) == null) nome = null;
        else nome = (String) data.get(1);
        
        if( data.get(2) == null ) cpf = null;
        else cpf = (String) data.get(2);
        
        if( data.get(3) == null ) telefone = null;
        else telefone = (String) data.get(3);
    }
}
