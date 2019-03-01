package com.aonyi.torneo.modelo;

/**
 * @author faguirre
 * @version 1.0
 * @created 02-feb.-2019 15:16:33
 */
public class Competencia {

    private long id;
    private String nombre;
    
    public Competencia(){
        
    }
    
    public Competencia(String nombre){
        this.nombre = nombre;
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * Sobrecarga del método ToString para devolver los datos básicos de la Competencia
     * @return Datos de la Competencia
     */
    @Override
    public String toString(){
        return this.nombre;
    }
            
}//end Competencia