package com.aonyi.torneo.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Torneo vigente
 * @author faguirre
 */
public class Torneo {
    private long id;
    private String nombre;
    private Date fecha;
    private Sede sede;
    private boolean vigente;
    private List<Competencia> competencias = new ArrayList();
    
    public Torneo(){
        
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
     * @return the sede
     */
    public Sede getSede() {
        return sede;
    }

    /**
     * @param sede the sede to set
     */
    public void setSede(Sede sede) {
        this.sede = sede;
    }

    /**
     * @return the competencias
     */
    public List<Competencia> getCompetencias() {
        return competencias;
    }

    /**
     * @param competencias the competencias to set
     */
    public void setCompetencias(List<Competencia> competencias) {
        this.competencias = competencias;
    }

    /**
     * @return the vigente
     */
    public boolean isVigente() {
        return vigente;
    }

    /**
     * @param vigente the vigente to set
     */
    public void setVigente(boolean vigente) {
        this.vigente = vigente;
    }
    
    @Override
    public String toString(){
        return this.nombre;
    }


}
