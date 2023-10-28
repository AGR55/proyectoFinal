package GUI;

import APP.Cisternas;
import APP.Compuestas;
import APP.Depositos;
import APP.Simples;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class ModeloTabla1 extends AbstractTableModel {
    ArrayList<Cisternas> cisternas;

    public ModeloTabla1(ArrayList<Cisternas> cisternas) {
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


}
