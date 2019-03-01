package com.aonyi.torneo.control;

import com.aonyi.torneo.dao.*;
import com.aonyi.torneo.modelo.*;
import com.aonyi.torneo.utils.TorneoLogger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
/**
 * Clase controladora para la Inscripción
 * @author faguirre
 */
public class GestorInscripcion {

    // Instancia un objeto Dao para Inscripcion
    private final InscripcionDao inscripcionDao;
    private final AspiranteDao aspiranteDao;
    private final CategoriaDao categoriaDao;
    private final CompetenciaDao competenciaDao;
    private final EscuelaDao escuelaDao;
    private final EstadoInscripcionDao estadoInscripcionDao;
    private final CambioEstadoDao cambioEstadoDao;
    private final TorneoDao torneoDao;

    
    /**
     * Método constructor que recibe un objeto Logger para registro de actividades
     * Recibe como parámetros los Objetos Dao, para implementar la inyección de dependencias
     * @param inscripcionDao
     * @param aspiranteDao
     * @param categoriaDao
     * @param competenciaDao
     * @param escuelaDao
     * @param estadoInscripcionDao
     * @param cambioEstadoDao
     * @param torneoDao
     */
    public GestorInscripcion(InscripcionDao inscripcionDao,
                             AspiranteDao aspiranteDao,
                             CategoriaDao categoriaDao,
                             CompetenciaDao competenciaDao,
                             EscuelaDao escuelaDao,
                             EstadoInscripcionDao estadoInscripcionDao,
                             CambioEstadoDao cambioEstadoDao,
                             TorneoDao torneoDao){        
        // Guarda los objetos Dao recibidos por parámetro
        this.categoriaDao = categoriaDao;
        this.competenciaDao = competenciaDao;
        this.inscripcionDao = inscripcionDao;
        this.aspiranteDao = aspiranteDao;             
        this.escuelaDao = escuelaDao;
        this.estadoInscripcionDao = estadoInscripcionDao;
        this.cambioEstadoDao = cambioEstadoDao;
        this.torneoDao = torneoDao;
    }
  
    
    /**
     * Crea y devuelve un nuevo Aspirante
     * @param nombre
     * @param apellido
     * @param direccion
     * @param fecha
     * @param sexo
     * @param dni
     * @param escuela
     * @return Aspirante
     * @throws java.text.ParseException
     */
    public Aspirante crearAspirante(String nombre, String apellido, String direccion, String fecha, 
                                    String sexo, Integer dni, Escuela escuela) throws Exception{
        
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date fchNacimiento = formatter.parse(fecha);
            
            // Crea una instancia de Aspirante
            Aspirante aspirante = new Aspirante(nombre,apellido,direccion,fchNacimiento,sexo,dni,escuela);

            // Relaciona al aspirante con la Escuela
            escuela.addAspirante(aspirante);

            // Actualiza la lista de aspirantes de la escuela
            this.escuelaDao.guardar(escuela);
            
            // Retorna el Aspirante creado
        return aspirante;
        } catch (ParseException e) {       
            String errMsg = "Error en el formato de la fecha. Debe ser dd/mm/aaaa";
            TorneoLogger.getLogger().severe(errMsg);
            throw new Exception(errMsg);
        }        
    }
    
    /**
     * Registra una Inscripción 
     * @param aspirante
     * @param categoria
     * @param competencia
     * @param fecha 
     */
    public void registrarInscripcion(Date fecha, Aspirante aspirante, Competencia competencia, Categoria categoria ){
        // Recupera el torneo vigente
        Torneo torneo = this.getTorneoVigente();
        
        // Crea la inscripción
        Inscripcion inscripcion = new Inscripcion(torneo,fecha,aspirante,competencia,categoria);
        
        // Recupera el estado inicial de la inscripción: "Registrada".
        EstadoInscripcion estadoInicial = this.estadoInscripcionDao.buscarPorNombre("Registrada");

        // Establece el primer estado de la inscripción en el Histórico de estados
        CambioEstado cambioEstado = new CambioEstado(inscripcion, estadoInicial, new Date());
        
        this.cambioEstadoDao.guardar(cambioEstado);
    }
    
    /**
     * Devuelve la lista de competencias
     * @return lista de compentencias
     */
    public List<Competencia> getListaCompetencias(){
        return this.getTorneoVigente().getCompetencias();
    }
    
    /**
     * Devuelve la lista de categorías
     * @return lista de categorías
     */
    public List<Categoria> getListaCategorias(){
        return this.categoriaDao.getLista();
    }
    
    /**
     * Devuelve la lista de escuelas
     * @return lista de escuelas
     */
    public List<Escuela> getListaEscuelas(){
        return this.escuelaDao.getLista();
    }
    
    /**
     * Devuelve la lista de aspirantes
     * @return lista de aspirantes
     */
    public List<Aspirante> getListaAspirantes(){
        return this.aspiranteDao.getLista();
    }
    
    /**
     * Devuelve un Aspirante buscando por el nombre
     * @param nombre
     * @return 
     */
    public Aspirante getAspirantePorNombre(String nombre){
       return this.aspiranteDao.buscarPorNombre(nombre);
    }
    
    /**
     * Devuelve la categoría recomendada para un Aspirante
     * @param aspirante
     * @return
     */
    public Categoria getCategoriaRecomendadaAspirante(Aspirante aspirante){
        Categoria retorno = null;
        // Recorre todas las la categorías y selecciona la correspondiente al aspirante
        for (Categoria c: this.getListaCategorias()){
            if (c.getEdadDesde() <= aspirante.getEdad() && c.getEdadHasta() >= aspirante.getEdad()){
                if (aspirante.getSexo().equals(c.getSexo())){
                    retorno = c;
                }
            }
        }
        return retorno;
    }   
    
    /**
     * Devuelve el torneo vigente
     * @return
     */
    public Torneo getTorneoVigente(){
        List<Torneo> torneos = this.torneoDao.getLista();
        Torneo torneo = null;
        for (Torneo t: torneos){
            torneo = (t.isVigente())?t:torneo;
        }
        return torneo;
    }    
}
