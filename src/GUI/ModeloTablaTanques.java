package GUI;

import APP.Tanques;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class ModeloTablaTanques extends AbstractTableModel {
    ArrayList<Tanques> tanques;
    String[] titulos={"Capacidad", "Estado", "Tipo de abasto", "Material"};

    public ModeloTablaTanques(ArrayList<Tanques> tanques) {
        this.tanques = tanques;
    }

    @Override
    public int getRowCount() {
        return tanques.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Tanques tanque=tanques.get(rowIndex);
        switch (columnIndex){
            case 0: return tanque.getCapacidad();
            case 1: return tanque.getEstado();
            case 2: return tanque.getTipoAbasto();
            case 3: return tanque.getMaterial();
            default: return null;
        }
    }

    public String getColumnName(int colums){
        return titulos[colums];
    }
}