package GUI;

import APP.Cisternas;
import APP.Compuestas;
import APP.Simples;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class ModeloTablaCisternas extends AbstractTableModel {
    ArrayList<Cisternas> cisternas;
    String[] titulos={"Capacidad", "Estado", "Tipo de abasto", "Forma", "Cantidad de compartimentos"};

    public ModeloTablaCisternas(ArrayList<Cisternas> cisternas) {
        this.cisternas = cisternas;
    }

    @Override
    public int getRowCount() {
        return cisternas.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cisternas cisterna=cisternas.get(rowIndex);
        switch (columnIndex){
            case 0: return cisterna.getCapacidad();
            case 1: return cisterna.getEstado();
            case 2: return cisterna.getTipoAbasto();
            case 3: if (cisterna instanceof Simples) return((Simples)cisterna).getForma(); else return null;
            case 4: if (cisterna instanceof Compuestas) return((Compuestas)cisterna).getCantidadCompartimentos(); else return null;
            default: return null;
        }
    }

    public String getColumnName(int colums){
        return titulos[colums];
    }
}
