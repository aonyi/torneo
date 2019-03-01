
package com.aonyi.torneo.modelo;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

/**
 * @author faguirre
 * @version 1.0
 * @created 02-feb.-2019 15:09:54
 */
public class Aspirante {

    private long id;
    private String nombre;
    private String apellido;
    private Date fchNacimiento;
    private String sexo;
    private String direccion;
    private Integer dni;
    private Escuela escuela;
    
    public Aspirante(){
        
    }
    
    public Aspirante(String nombre, String apellido, String direccion, Date fchNacimiento, String sexo, 
                     Integer dni, Escuela escuela){
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.fchNacimiento = fchNacimiento;
        this.sexo = sexo;
        this.dni = dni;
        this.escuela  = escuela;             
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
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
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
     * @return the fchNacimiento
     */
    public Date getFchNacimiento() {
        return fchNacimiento;
    }

    /**
     * @param fchNacimiento the fchNacimiento to set
     */
    public void setFchNacimiento(Date fchNacimiento) {
        this.fchNacimiento = fchNacimiento;
    }

    /**
     * @return the dni
     */
    public Integer getDni() {
        return dni;
    }

    /**
     * @param dni the dni to set
     */
    public void setDni(Integer dni) {
        this.dni = dni;
    }
    /**
     * Sobrecarga del método ToString para devolver los datos básicos del Aspirante
     * @return Datos del Aspirante
     */
    @Override
    public String toString(){
        return this.nombre + " " + this.apellido;
    }
    /**
     * Devuelve la edad del aspirante
     * @return 
     */
    
     /**
     * @return the escuela
     */
    public Escuela getEscuela() {
        return escuela;
    }

    /**
     * @param escuela the escuela to set
     */
    public void setEscuela(Escuela escuela) {
        this.escuela = escuela;
    }
    public Integer getEdad(){        
        /* La fecha de nacimiento está almacenada como un objeto Date para 
         * mantener la facilidad en la implementación, ya que aplicando StringFormater
         * se puede visualizar las fechas con los formatos que se quisieran en forma
         * simple.
         * El problema de Date es que es un objeto discontinuado, por lo que se hace 
         * necesario utilizar APIs mas nuevas.
         * Normalmente utilizaría la clase Calendar, pero se decidió utilizar la API
         * JSR 310 que se introdujo en Java 7 para manejo de fechas, mas moderna
         * y mas simple.
         */                
        Instant instant = this.fchNacimiento.toInstant(); // Instant es el equivalente a Date
        ZonedDateTime zdt = instant.atZone(ZoneId.systemDefault()); // Instant no tiene el concepto de zona de tiempo
        LocalDate nacimientoDate = zdt.toLocalDate();// Convierte Instant a LocalDate
        
        LocalDate hoy = LocalDate.now(); // Obtiene la fecha de hoy 
        Period edad = Period.between(nacimientoDate, hoy); // Compara fechas con el método de la clase Period
        
        return edad.getYears(); // Devuelve los años incluidos en un período        
    }

   
}//end Aspirante