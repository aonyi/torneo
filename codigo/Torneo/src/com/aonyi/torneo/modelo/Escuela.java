package com.aonyi.torneo.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author faguirre
 * @version 1.0
 * @created 02-feb.-2019 15:16:23
 */
public class Escuela {

    private long id;
    private String nombre;
    private String direccion;
    private String telefono;
    private List<Aspirante> aspirantes = new ArrayList<>();
    
    public Escuela(){
        
    }
    
    public Escuela(String nombre, String direccion, String telefono, List<Aspirante> aspirantes){
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.aspirantes = aspirantes;
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
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    /**
     * Carga un aspirante nuevo
     * @param aspirante
     */
    public void addAspirante(Aspirante aspirante){
        this.aspirantes.add(aspirante);
    }
    
    /**
     * Devuelve la lista de aspirantes
     * @return Lista de aspirantes
     */
    public List<Aspirante> getAspirantes(){
        return this.aspirantes;
    }
    
    public void setAspirantes(List<Aspirante> aspirantes){
        this.aspirantes = aspirantes;
    }
    
    /**
     * Sobrecarga del método ToString para devolver los datos básicos de la Escuela
     * @return Datos de la Escuela
     */
    @Override
    public String toString(){
        return this.nombre;
    }
    
    

}//end Escuela