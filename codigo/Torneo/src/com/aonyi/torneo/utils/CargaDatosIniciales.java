package com.aonyi.torneo.utils;

import com.aonyi.torneo.dao.*;
import com.aonyi.torneo.modelo.*;
import java.util.Arrays;
import java.util.Date;

/**
 * Clase que carga datos iniciales para complementar al CU Registrar inscripción de
 * Aspirantes
 * @author faguirre
 */
public class CargaDatosIniciales {
    
    public static void cargar(EscuelaDao escDao, CompetenciaDao comDao, CategoriaDao catDao, 
                              EstadoInscripcionDao estDao, TorneoDao torDao, SedeDao sedDao){       
        
            
        //Crea un conjunto de escuelas
        Escuela e1 = new Escuela();
        e1.setNombre("Colegio Carbó");
        Escuela e2 = new Escuela();
        e2.setNombre("Colegio Corazón de María");
        Escuela e3 = new Escuela();
        e3.setNombre("Colegio del Carmen");
        Escuela e4 = new Escuela();
        e4.setNombre("Colegio Monserrat");
        Escuela e5 = new Escuela();
        e5.setNombre("Colegio Nacional General San Martín");
        Escuela e6 = new Escuela();
        e6.setNombre("Escuela Agrotécnica Número 23");
        Escuela e7 = new Escuela();
        e7.setNombre("Escuela Normal Superior Número 10");
        Escuela e8 = new Escuela();
        e8.setNombre("Instituto Hellen Keller");
              
 
        //Carga el listado de Escuelas
        escDao.guardar(e1);
        escDao.guardar(e2);
        escDao.guardar(e3);
        escDao.guardar(e4);
        escDao.guardar(e5);
        escDao.guardar(e6);
        escDao.guardar(e7);
        escDao.guardar(e8);        
                
        //Crea un conjunto de competencias
        Competencia c1 = new Competencia();
        c1.setNombre("100 metros llanos");
        Competencia c2 = new Competencia();
        c2.setNombre("300 metros con posta");
        Competencia c3 = new Competencia();
        c3.setNombre("500 metros con posta");
        Competencia c4 = new Competencia();
        c4.setNombre("50 metros con valla");
        Competencia c5 = new Competencia();
        c5.setNombre("Salto en largo");
        
        //Guarda el listado de Competencias
        comDao.guardar(c5);
        comDao.guardar(c4);
        comDao.guardar(c3);
        comDao.guardar(c2);
        comDao.guardar(c1);
        
        //Crea una Sede
        Sede s = new Sede();
        s.setNombre("Villa María");
        
        //Guarda la seda
        sedDao.guardar(s);
        
        //Crea un torneo
        Torneo t = new Torneo();
        t.setNombre("Torneo Evita");
        t.setFecha(new Date());
        t.setSede(s);
        t.setVigente(true);        
        t.setCompetencias(Arrays.asList(c1,c2,c3,c4,c5));
        
        //Guarda el torneo
        torDao.guardar(t);
        
        //Crea un conjunto de Categorías
        Categoria t1 = new Categoria();
        t1.setNombre("Infantiles Varones");
        t1.setEdadDesde(8);
        t1.setEdadHasta(12);
        t1.setSexo(Sexo.MASCULINO);
        Categoria t2 = new Categoria();
        t2.setNombre("Infantiles Mujeres");
        t2.setEdadDesde(8);
        t2.setEdadHasta(12);
        t2.setSexo(Sexo.FEMENINO);
        Categoria t3 = new Categoria();
        t3.setNombre("Menores Varones");
        t3.setEdadDesde(13);
        t3.setEdadHasta(18);
        t3.setSexo(Sexo.MASCULINO);
        Categoria t4 = new Categoria();
        t4.setNombre("Menores Mujeres");
        t4.setEdadDesde(13);
        t4.setEdadHasta(18);
        t4.setSexo(Sexo.FEMENINO);
                
        
        //Carga el listado de categorias
        catDao.guardar(t4);
        catDao.guardar(t3);
        catDao.guardar(t2);
        catDao.guardar(t1);
        
        // Crea un conjunto de Estados de Inscripción
        EstadoInscripcion ei1 = new EstadoInscripcion();
        ei1.setNombre("Registrada");
        EstadoInscripcion ei2 = new EstadoInscripcion();
        ei2.setNombre("Pre-aprobada");
        EstadoInscripcion ei3 = new EstadoInscripcion();
        ei3.setNombre("Aprobada");
        
        // Carga los estados de inscripción
        estDao.guardar(ei3);
        estDao.guardar(ei2);
        estDao.guardar(ei1);
                
    }
    
}
