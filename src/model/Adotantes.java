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
public class Adotantes extends DataAccessObject{
    
    private int id_a;
    private String nome;
    private String cpf;
    private String telefone;
    private String endereco;
    
    public Adotantes() {
        super("adotantes");
    }

    public int getId_a() {
        return id_a;
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

    public String getEndereco() {
        return endereco;
    }
  
    public void setId_a(int id_a) {
         if( id_a != this.id_a ){
            this.id_a = id_a;
            addChange("id", this.id_a);
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

    public void setEndereco(String endereco) {
         if( endereco == null ) {
            if( this.endereco != null ) {
                this.endereco = endereco;
                addChange("endereco", null);
            }
        } else {
            if( !endereco.equals(this.endereco) ) {
                this.endereco = endereco;
                addChange("endereco", this.endereco);
            }
        }
    }
   

    @Override
    protected String getWhereClauseForOneEntry() {
         return " id = " + this.id_a;
    }

    @Override
    protected void fill(ArrayList<Object> data) {
        id_a = (int) data.get(0);
         
        if( data.get(1) == null) nome = null;
        else nome = (String) data.get(1);
         
        if( data.get(2) == null ) cpf = null;
        else cpf = (String) data.get(2);
        
        if( data.get(3) == null ) telefone = null;
        else telefone = (String) data.get(3);
        
        if( data.get(4) == null ) endereco = null;
        else endereco = (String) data.get(4);
         
    }
    @Override
    public boolean equals(Object obj) {
        if( obj instanceof Adotantes ) {
            Adotantes aux = (Adotantes) obj;
            
            if( getId_a() == aux.getId_a() ) {
                return true;
            } else {
                return false;
            }            
        } else { 
            return false;
        }        
    }
    
}
