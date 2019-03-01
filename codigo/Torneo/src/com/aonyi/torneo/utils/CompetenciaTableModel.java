package com.aonyi.torneo.utils;

import com.aonyi.torneo.modelo.Competencia;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * 
 * Clase  utilizada para configurar los datos  que se mostrarán en la tabla de competencias.
 * Extiende la definición de un AbstracTableModel
 * @author faguirre
 */
public class CompetenciaTableModel extends AbstractTableModel {
    
    // Array de String que contiene los nombres de las columnas.
    private final String[] nombreColumnas = { "", "Disciplina"};
    // Array de Object que contiene los datos que se mostrarán en la tabla (JTable)
    private final Object[][] datos;
    
    /**
     *
     * @param competencias
     */
    public CompetenciaTableModel(List<Competencia> competencias){
        // Instancia el array de Object que contendrá los datos a mostrarse en la tabla
        this.datos = new Object[competencias.size()][2];
        // Carga el array de Object con el List recibido como parámetro
        for (int i = 0; i < competencias.size(); i++){
            this.datos[i][0] = Boolean.FALSE;       //Carga el check que permitirá seleccionar la competencia         
            this.datos[i][1] = competencias.get(i); //Carga la instancia de Competencia
        }          
    }

    /**
     * Método que devuelve los tipos de datos de las columnas
     * En el caso de la columna 0, se forza a devolver la clase Boolean para 
     * que muestre el check en la celda y no el valor como string ("true"/"false")
     * @param c
     * @return
     */
    @Override
    public Class getColumnClass(int c) {
        if (c == 0) {
            return Boolean.class;
        } else { 
            return super.getColumnClass(c);
        }        
     }
    
    /**
     * Método que devuelve el nombre de la columna
     * @param c
     * @return
     */
    @Override
    public String getColumnName(int c){
        return this.nombreColumnas[c];
    }
    
    /**
     * Método que devuelve la cantidad de filas
     * @return
     */
    @Override
    public int getRowCount() {
        return this.datos.length;
    }

    /**
     * Método que devuelve la cantidad de columnas
     * @return
     */
    @Override
    public int getColumnCount() {
        return this.nombreColumnas.length;
    }
    
     /**
     * Método que devuelve el valor de una celda
     * @param f
     * @param c
     * @return
     */
    @Override
    public Object getValueAt(int f, int c) {
        return this.datos[f][c];
    }
    
    /**
     * Método que indica que celdas de la tabla serán editables.
     * En este caso solamente la primera columna (selección)
     * @param f
     * @param c
     * @return
     */
    @Override
    public boolean isCellEditable(int f, int c) {
        return (c == 0);
    }    
    
    /**
     * Método que modifica el valor de una celda.
     * @param value
     * @param f
     * @param c
     */
    @Override
    public void setValueAt(Object value, int f, int c) {
        this.datos[f][c] = value;
        fireTableCellUpdated(f, c);
    }
    

    
}

