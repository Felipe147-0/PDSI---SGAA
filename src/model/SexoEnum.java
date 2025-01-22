/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package model;

/**
 *
 * @author felip
 */
public enum SexoEnum {
    
    MASCULINO("Masculino"),
    FEMININO("Feminino");
    
    private String descricao;
    
    SexoEnum(String descricao){
        this.descricao = descricao;
    }
    public String getDescricao(){
        return descricao;
    }
}
