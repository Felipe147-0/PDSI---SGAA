/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package model;

/**
 *
 * @author felip
 */
public enum TipoUsuarioEnum { //admin,func
    
    ADMINISTRADOR("administrador"),
    FUNCIONARIO("funcionario");
 
    private String descricao;
    
    
    TipoUsuarioEnum(String descricao) {
        this.descricao = descricao;       
    }
    public String getDescricao(){
        return descricao;
    }
}
