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
    private Animais idAnimal; 
    private Adotantes idAdotantes;

    public Adocoes() {
        super("adocoes");
    }

    public int getId() {
        return id;
    }

    public String getDataAdocao() {
        return dataAdocao;
    }

    public Animais getIdAnimal() {
        return idAnimal;
    }

    public Adotantes getIdAdotantes() {
        return idAdotantes;
    }
     
    //setters

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

    public void setIdAnimal(Animais idAnimal) throws Exception {
        //this.idAnimal = idAnimal;
        if( idAnimal == null ) {
            if( this.idAnimal != null ) {
                this.idAnimal = idAnimal;
                addChange("animais_id", null);
            }
        } else {
            if( this.idAnimal == null ) {
                this.idAnimal = new Animais();
                this.idAnimal.setId( idAnimal.getId() );
                this.idAnimal.load();
                addChange( "animais_id", this.idAnimal.getId() );
            } else {
                if( !idAnimal.equals( this.idAnimal ) ) { // é precriso fazer um @Override do método equals na classe idAnimal
                    this.idAnimal.setId( idAnimal.getId() );
                    this.idAnimal.load();
                    addChange( "animais_id", this.idAnimal.getId() );
                }
            }
        }
    }

    public void setIdAdotantes(Adotantes idAdotantes) throws Exception{
        //this.idAdotantes = idAdotantes;
        if( idAdotantes == null ) {
            if( this.idAdotantes != null ) {
                this.idAdotantes = idAdotantes;
                addChange("adotantes_id", null);
            }
        } else {
            if( this.idAdotantes == null ) {
                this.idAdotantes = new Adotantes();
                this.idAdotantes.setId_a( idAdotantes.getId_a() );
                this.idAdotantes.load();
                addChange( "adotantes_id", this.idAdotantes.getId_a() );
            } else {
                if( !idAdotantes.equals( this.idAdotantes ) ) { // é precriso fazer um @Override do método equals na classe Adotantes
                    this.idAdotantes.setId_a( idAdotantes.getId_a() );
                    this.idAdotantes.load();
                    addChange( "adotantes_id", this.idAdotantes.getId_a() );
                }
            }
        }
    }
    
    
    @Override
    protected String getWhereClauseForOneEntry() {
        return " id = " + this.id;
    }

    @Override
    protected void fill(ArrayList<Object> data) throws Exception{
        
        id = (int) data.get(0);
        
        if( data.get(1) == null) dataAdocao = null;
        else dataAdocao = (String) data.get(1).toString();
       
        if( data.get(2) != null ) {
            idAnimal = new Animais();
            idAnimal.setId( (int) data.get(2) );
            idAnimal.load();                                 
        } else {
            idAnimal = null;
        }
        
        if( data.get(3) != null ) {
            idAdotantes = new Adotantes();
            idAdotantes.setId_a( (int) data.get(3) );
            idAdotantes.load();                                 
        } else {
            idAdotantes = null;
        } 
        
    }
       
}
