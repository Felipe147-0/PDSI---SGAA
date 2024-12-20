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
public class Usuarios extends DataAccessObject {
    
    private int id;
    private String nome;
    private String login;
    private String senha;
    private enum tipoUsuario{administrador, funcionario}; // remover?
    
    public Usuarios(){  
        super ("usuarios");     
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }
    
    //setter

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

    public void setLogin(String login) {
        if( login == null){
            if (this.login != null) {
                this.login = login;
                addChange("login", null);
            }
        } else {
            if (!login.equals(this.login)) {
                this.login = login;
                addChange("login", this.login);
            }
        }
    }

    public void setSenha(String senha) {
        if( senha == null ) {
            if( this.senha != null ) {
                this.senha = senha;
                addChange("senha", null);
            }
        } else {
            if( !senha.equals(this.senha) ) {
                this.senha = senha;
                addChange("senha", this.senha);
            }
        }
    }
    
    

    @Override
    protected String getWhereClauseForOneEntry() {
        return " id = " + this.id;
    }

    @Override
    protected void fill(ArrayList<Object> data) {
        id = (int) data.get(0);
        
        if( data.get(1) == null) nome = null;
        else nome = (String) data.get(1);
        
        if( data.get(2) == null) login = null;
        else login = (String) data.get(2);
        
        if( data.get(3) == null) senha = null;
        else senha = (String) data.get(3);
        
        
    }
    
}
