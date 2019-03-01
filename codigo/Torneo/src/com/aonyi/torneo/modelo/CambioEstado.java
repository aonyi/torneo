package com.aonyi.torneo.modelo;

import java.util.Date;

/**
 * 
 * @author faguirre
 */
public class CambioEstado {

    private long id;
    private Date fecha;
    private Inscripcion inscripcion;
    private EstadoInscripcion estado;
    
    public CambioEstado(){
        
    }
    
    public CambioEstado(Inscripcion inscripcion, EstadoInscripcion estado, Date fecha){
        this.inscripcion = inscripcion;
        this.estado = estado;
        this.fecha = fecha;
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
     * @return the inscripcion
     */
    public Inscripcion getInscripcion() {
        return inscripcion;
    }

    /**
     * @param inscripcion the inscripcion to set
     */
    public void setInscripcion(Inscripcion inscripcion) {
        this.inscripcion = inscripcion;
    }

    /**
     * @return the estado
     */
    public EstadoInscripcion getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(EstadoInscripcion estado) {
        this.estado = estado;
    }
     
        
        
}//end HistoricoEstado