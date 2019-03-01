package com.aonyi.torneo.dao;

import com.aonyi.torneo.utils.HibernateSession;
import com.aonyi.torneo.utils.TorneoLogger;
import java.util.List;
import java.util.logging.Level;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 * Clase que implementa la interfaz genérica DAO utilizando Hibernate.
 * @author faguirre
 * @param <T>
 */
public class GenericHibernateDao<T> implements IGenericDao<T> {

    public GenericHibernateDao(){
        
    }
    
    @Override
    public void guardar(T objeto) {        
        TorneoLogger.getLogger().log(Level.INFO, "Se va a guardar el objeto {0}", objeto);
        Session session = HibernateSession.getSession();
        session.beginTransaction();
        session.merge(objeto);
        session.getTransaction().commit();
        session.close();
        TorneoLogger.getLogger().log(Level.INFO, "Se va a guardó exitosamente el objeto {0}", objeto);
    }

    @Override
    public List<T> getLista(Class<T> tipo) {
        Session session = HibernateSession.getSession();
        Criteria criteria = session.createCriteria(tipo);
        return criteria.list();
    }

    @Override
    public void borrar(T objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T buscarPorNombre(Class<T> clase, String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T buscarPorId(Class<T> clase, long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
