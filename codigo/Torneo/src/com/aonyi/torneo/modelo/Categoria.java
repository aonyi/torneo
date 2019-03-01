package com.aonyi.torneo.modelo;

/**
 * @author faguirre
 * @version 1.0
 * @created 02-feb.-2019 15:16:39
 */
public class Categoria {

    private long id;
    private String nombre;
    private Integer edadDesde;
    private Integer edadHasta;
    private String sexo;
    
    public Categoria(){
        
    }
    
    public Categoria(String nombre, Integer edadDesde, Integer edadHasta, String sexo){
        this.nombre = nombre;
        this.edadDesde = edadDesde;
        this.edadHasta = edadHasta;
        this.sexo = sexo;
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
     * Sobrecarga del método ToString para devolver los datos básicos del Categoria
     * @return Datos de la Categoria
     */
    @Override
    public String toString(){
        return this.nombre;
    }

    /**
     * @return the edadHasta
     */
    public Integer getEdadHasta() {
        return edadHasta;
    }

    /**
     * @param edadHasta the edadHasta to set
     */
    public void setEdadHasta(Integer edadHasta) {
        this.edadHasta = edadHasta;
    }

    /**
     * @return the edadDesde
     */
    public Integer getEdadDesde() {
        return edadDesde;
    }

    /**
     * @param edadDesde the edadDesde to set
     */
    public void setEdadDesde(Integer edadDesde) {
        this.edadDesde = edadDesde;
    }

    /**
     * @return the sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
            
}//end Categoria