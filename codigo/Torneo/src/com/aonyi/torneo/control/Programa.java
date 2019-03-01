package com.aonyi.torneo.control;

import com.aonyi.torneo.dao.*;
import com.aonyi.torneo.ui.FrmRegistrarInscripciones;
import com.aonyi.torneo.utils.CargaDatosIniciales;
import javax.swing.JFrame;

/**
 * Clase que representa el Programa
 * @author faguirre
 */
public class Programa {    
    
    public static void main(String[] args){
        
        Programa programa = new Programa();
        programa.run();
    }
    
    private void run(){      
               
        //Instancia el Dao para las Escuelas
        EscuelaDao escDao = new EscuelaDao(new GenericHibernateDao<>());
        
        //Instancia el Dao para Aspirantes
        AspiranteDao aspDao = new AspiranteDao(new GenericHibernateDao<>());       
        
        //Instancia el Dao para Competencia
        CompetenciaDao comDao = new CompetenciaDao(new GenericHibernateDao<>());
        
        //Instancia el Dao para Categoria
        CategoriaDao catDao = new CategoriaDao(new GenericHibernateDao<>());
        
        //Crea el Dao para Inscripcion
        InscripcionDao insDao = new InscripcionDao(new GenericHibernateDao<>());
        
        //Crea el Dao para Estado de Inscripcion
        EstadoInscripcionDao estDao = new EstadoInscripcionDao(new GenericHibernateDao<>());
        
        //Crea el Dao para el Historico de estados
        CambioEstadoDao cambDao = new CambioEstadoDao(new GenericHibernateDao<>());
        
        //Crea el Dao para  Torneo
        TorneoDao torDao = new TorneoDao(new GenericHibernateDao<>());
        
        //Crea el Dao para Sede
        SedeDao sedDao = new SedeDao(new GenericHibernateDao<>());
        
        // Carga datos iniciales
        CargaDatosIniciales.cargar(escDao, comDao, catDao, estDao, torDao, sedDao);

        //Crea una inscripcion
        GestorInscripcion gestor = new GestorInscripcion(insDao,aspDao,catDao,comDao,escDao,estDao,cambDao,torDao);
        
        // Levanta la interfaz de usuario
        this.levantarInterfaz(gestor);        
    }
    /**
     * Levanta la GUI
     * @param gestor 
     */
    private void levantarInterfaz(GestorInscripcion gestor){
        JFrame frmRegistrarAspirantes = new FrmRegistrarInscripciones(gestor);
        frmRegistrarAspirantes.pack();
        frmRegistrarAspirantes.setVisible(true);
        
    }
}