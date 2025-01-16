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
public class Adocoes extends DataAccessObject{
    
    private int id;
    private String dataAdocao;
    private int idAnimal; //int idAnimal
    private int idAdotantes;

    public int getIdAnimal() {
        return idAnimal;
    }

    public int getIdAdotantes() {
        return idAdotantes;
    }

    public Adocoes() {
        super("adocoes");
    }

    public int getId() {
        return id;
    }

    public String getDataAdocao() {
        return dataAdocao;
    }
    /*
    public Animais getAnimais() {
        return animais;
    }

    public Adotantes getAdotantes() {
        return adotantes;
    }
    */
    
    
    //setter

    public void setId(int id) {
        if( id != this.id ){
            this.id = id;
            addChange("id", this.id);
        }
    }

    public void setDataAdocao(String dataAdocao) {
        if( dataAdocao == null){
            if (this.dataAdocao != null) {
                this.dataAdocao = dataAdocao;
                addChange("data_adocao", null);
            }
        } else {
            if (!dataAdocao.equals(this.dataAdocao)) {
                this.dataAdocao = dataAdocao;
                addChange("data_adocao", this.dataAdocao);
            }
        }
    }

    public void setIdAnimal(int idAnimal) {
        this.idAnimal = idAnimal;
        
    }

    public void setIdAdotantes(int idAdotantes) {
        this.idAdotantes = idAdotantes;
    }
    
    /*
    public void setAnimais(Animais animais) throws Exception{
        
        if( animais == null ) {
            if( this.animais != null ) {
                this.animais = animais;
                addChange("animais_id", null);
            }
        } else {
            if( this.animais == null ) {
                this.animais = new Animais();
                this.animais.setId( animais.getId() );
                this.animais.load();
                addChange( "animais_id", this.animais.getId() );
            } else {
                if( !animais.equals( this.animais ) ) { // é precriso fazer um @Override do método equals na classe animais
                    this.animais.setId( animais.getId() );
                    this.animais.load();
                    addChange( "animais_id", this.animais.getId() );
                }
            }
        }
        
    }*/
    /*
    public void setAdotantes(Adotantes adotantes) throws Exception{
        if( adotantes == null ) {
            if( this.adotantes != null ) {
                this.adotantes = adotantes;
                addChange("adotantes_id", null);
            }
        } else {
            if( this.adotantes == null ) {
                this.adotantes = new Adotantes();
                this.adotantes.setId( adotantes.getId() );
                this.adotantes.load();
                addChange( "adotantes_id", this.adotantes.getId() );
            } else {
                if( !adotantes.equals( this.adotantes ) ) { // é precriso fazer um @Override do método equals na classe Adotantes
                    this.adotantes.setId( adotantes.getId() );
                    this.adotantes.load();
                    addChange( "adotantes_id", this.adotantes.getId() );
                }
            }
        }
    }
    */
    
    @Override
    protected String getWhereClauseForOneEntry() {
        return " id = " + this.id;
    }

    @Override
    protected void fill(ArrayList<Object> data) throws Exception{
        
        id = (int) data.get(0);
        
        if( data.get(1) == null) dataAdocao = null;
        else dataAdocao = (String) data.get(1);
       
        idAnimal = (int) data.get(2);
        
        idAdotantes = (int) data.get(3);
        /*
        if( data.get(2) != null ) {
            animais = new Animais();
            animais.setId( (int) data.get(2) );
            animais.load();                                 
        } else {
            animais = null;
        }
        
        if( data.get(3) != null ) {
            adotantes = new Adotantes();
            adotantes.setId( (int) data.get(3) );
            adotantes.load();                                 
        } else {
            adotantes = null;
        } 
        */
    }
    
    
}
