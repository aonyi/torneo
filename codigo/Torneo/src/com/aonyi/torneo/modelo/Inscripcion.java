package com.aonyi.torneo.modelo;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Clase que representa la inscripción de un aspirante a una competencia 
 * dentro del torneo vigente
 * @author faguirre
 */
public class Inscripcion {

    private long id;
    private Torneo torneo;
    private Date fecha;
    private Aspirante aspirante;
    private Competencia competencia;
    private Categoria categoria;
    
    public Inscripcion(){
        
    }
    
    public Inscripcion(Torneo torneo, Date fecha, Aspirante aspirante, Competencia competencia, Categoria categoria){
        this.torneo = torneo;
        this.fecha = fecha;
        this.aspirante = aspirante;
        this.competencia = competencia;
        this.categoria = categoria;
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
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the aspirante
     */
    public Aspirante getAspirante() {
        return aspirante;
    }

    /**
     * @param aspirante the aspirante to set
     */
    public void setAspirante(Aspirante aspirante) {
        this.aspirante = aspirante;
    }

    /**
     * @return the compentencias
     */
    public Competencia getCompetencia() {
        return this.competencia;
    }

    /**
     * @param compentencia the compentencias to set
     */
    public void setCompetencia(Competencia compentencia) {
        this.competencia = compentencia;
    }

    /**
     * @return the categoria
     */
    public Categoria getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
    /**
     * Sobrecarga del método ToString para devolver los datos básicos de la Inscripcion
     * @return Datos de la Inscripcion
     */
    @Override
    public String toString(){
        // Instancia de SimpleDateFormat que se utilizará para formatear la salida de fecha
        SimpleDateFormat formatoDia = new SimpleDateFormat("dd.MM.yyyy");
        
        String retorno = "Inscripción de : " + this.aspirante.toString();
        retorno += " en la Categoría: " + this.categoria.getNombre();
        retorno += " a la Competencia: " + this.competencia.getNombre();  
        retorno += "con Fecha: " + formatoDia.format(this.fecha);           
        return retorno;
    }
    
    /**
     *
     * @return
     */
    public String getNombre(){
        return this.aspirante.getNombre() ;
    }

    /**
     * @return the torneo
     */
    public Torneo getTorneo() {
        return torneo;
    }

    /**
     * @param torneo the torneo to set
     */
    public void setTorneo(Torneo torneo) {
        this.torneo = torneo;
    }
    
}//end Inscripcion