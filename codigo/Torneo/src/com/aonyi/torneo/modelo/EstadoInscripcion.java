package com.aonyi.torneo.modelo;


/**
 * 
 * @author faguirre
 */
public class EstadoInscripcion {

    private long id;
    private String nombre;
    
    public EstadoInscripcion(){
        
    }
    
    public EstadoInscripcion(String nombre){
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
    
    @Override
    public String toString(){
        return this.nombre;
    }
    

}//end EstadoInscripcion�n