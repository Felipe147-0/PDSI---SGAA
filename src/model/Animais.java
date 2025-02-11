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
public class Animais extends DataAccessObject{
    
    private int id;
    private String nome;
    private String especie;
    private String raca;
    private String idade;
    private SexoEnum sexo;
    private String saude;
    private String dataEntrada;
    private String disponivelAdocao;
    
    public Animais() {
        super("animais");
    }

    public SexoEnum getSexo() {
        return sexo;
    }

    public String getDisponivelAdocao() {
        return disponivelAdocao;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEspecie() {
        return especie;
    }

    public String getRaca() {
        return raca;
    }

    public String getIdade() {
        return idade;
    } 

    public String getSaude() {
        return saude;
    }

    public String getDataEntrada() {
        return dataEntrada;
    }

    //setters

    
    public void setId(int id) {
        if( id != this.id ){
            this.id = id;
            addChange("id", this.id);
        }
    }

    public void setNome(String nome) {
         if(this.nome != nome){
            this.nome = nome;
            addChange("nome", this.nome);
        }
    }

    public void setEspecie(String especie) {
        if(this.especie != especie){
            this.especie = especie;
            addChange("especie", this.especie);
        }
    }

    public void setRaca(String raca) {
        if( raca == null){
            if (this.raca != null) {
                this.raca = raca;
                addChange("raca", null);
            }
        } else {
            if (!raca.equals(this.raca)) {
                this.raca = raca;
                addChange("raca", this.raca);
            }
        }
    }

    public void setIdade(String idade) {
        if( idade == null ) {
            if( this.idade != null ) {
                this.idade = idade;
                addChange("idade", null);
            }
        } else {
            if( !idade.equals(this.idade) ) {
                this.idade = idade;
                addChange("idade", this.idade);
            }
        }
    }   

    public void setSaude(String saude) {
        if(this.saude != saude){
            this.saude = saude;
            addChange("saude", this.saude);
        }
    }

    public void setDataEntrada(String dataEntrada) {

        if( dataEntrada == null ) {
            if( this.dataEntrada != null ) {
                this.dataEntrada = dataEntrada;
                addChange("data_entrada", null);
            }
        } else {
            if( !dataEntrada.equals(this.dataEntrada) ) {
                this.dataEntrada = dataEntrada;
                addChange("data_entrada", this.dataEntrada);
            }
        }
    }

    public void setSexo(SexoEnum sexo) {
        if (this.sexo != sexo) {
            this.sexo = sexo;
            addChange("sexo", sexo.name());
        }
           
    }

    public void setDisponivelAdocao(String disponivelAdocao) {
       // this.disponivelAdocao = disponivelAdocao;
        if( disponivelAdocao == null ) {
            if( this.disponivelAdocao != null ) {
                this.disponivelAdocao = disponivelAdocao;
                addChange("disponivel_adocao", null);
            }
        } else {
            if( !disponivelAdocao.equals(this.disponivelAdocao) ) {
                this.disponivelAdocao = disponivelAdocao;
                addChange("disponivel_adocao", this.disponivelAdocao);
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
        
        if( data.get(2) == null) especie = null;
        else especie = (String) data.get(2);
        
        if( data.get(3) == null) raca = null;
        else raca = (String) data.get(3);
        
        if( data.get(4) == null) idade = null;
        else idade = (String) data.get(4);

        if (data.get(5) == null) {
            sexo = null;
        } else {
            sexo = SexoEnum.valueOf((String) data.get(5).toString().toUpperCase());
        }
      
        if( data.get(6) == null) saude = null;
        else saude = (String) data.get(6);
        
        if( data.get(7) == null) dataEntrada = null;
        else dataEntrada = (String) data.get(7).toString();
        
        if( data.get(8) == null) disponivelAdocao = null;
        else disponivelAdocao = (String) data.get(8);
    }
    
    @Override
    public boolean equals(Object obj) {
        if( obj instanceof Animais ) {
            Animais aux = (Animais) obj;
            
            if( getId() == aux.getId() ) {
                return true;
            } else {
                return false;
            }            
        } else { 
            return false;
        }        
    }
    
}
