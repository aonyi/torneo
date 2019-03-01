package com.aonyi.torneo.utils;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Clase auxiliar que contiene la configuración del logger a utilizar en todo el sistema
 * Implementa una variante del patrón de diseño Singleton
 * @author faguirre
 */
public class TorneoLogger {
    
    private static Logger logger;
    
    public static Logger getLogger(){
        try{
            if (logger == null){
                logger = Logger.getLogger("Torneo");
                logger.addHandler(new ConsoleHandler());
                logger.addHandler(new FileHandler("torneo.log",true));           
            }            
        }catch (IOException | SecurityException e) {
            JOptionPane.showMessageDialog(null,e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
        return logger;
    }
    
    
}
