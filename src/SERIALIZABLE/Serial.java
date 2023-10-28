package SERIALIZABLE;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import APP.Cisternas;
import APP.Compuestas;
import APP.Depositos;
import APP.Simples;
import APP.Tanques;

public class Serial {

    public List<String> guardarTanquesRegularOMalEstado(List<Depositos> depositos) {
        List<String> info = new ArrayList<>();
        try {
            FileWriter oos = new FileWriter("verificar.dat");
            String line = "";
            for (int i = 0; i < depositos.size(); i++) {
                if (depositos.get(i) != null && depositos.get(i) instanceof Tanques) {
                    Tanques auxTanques = (Tanques) depositos.get(i);
                    line = "<<Tanque>> Capacidad: " + auxTanques.getCapacidad() + "Estado: " + auxTanques.getEstado()
                            + "Tipo de abasto: " + auxTanques.getTipoAbasto() + "Material: " + auxTanques.getMaterial();
                } else if (depositos.get(i) != null && depositos.get(i) instanceof Cisternas) {
                    if ((Cisternas) (depositos.get(i)) instanceof Simples) {
                        Simples simplesAux = (Simples) depositos.get(i);
                        line = "<<Cisterna simple>> Capacidad: " + simplesAux.getCapacidad() + "Estado: "
                                + simplesAux.getEstado() + "Tipo de abasto: " + simplesAux.getTipoAbasto()
                                + "Material: " + simplesAux.getForma();
                    } else {
                        Compuestas compuestasAux = (Compuestas) depositos.get(i);
                        line = "<<Cisterna compuesta>> Capacidad: " + compuestasAux.getCapacidad() + "Estado: "
                                + compuestasAux.getEstado() + "Tipo de abasto: " + compuestasAux.getTipoAbasto()
                                + "Material: " + compuestasAux.getCantidadCompartimentos();
                    }
                }
                info.add(line);
                oos.write(line + "\n");
            }
            oos.close();
            return info;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Ha ocurrido un error");
            return null;
        }
    }

    public void conocerCapacidadTotalCisternasInfo(List<Cisternas> cisternas) {
        try {
            FileWriter oos = new FileWriter("cisternas.dat");
            String line = "";
            for (int i = 0; i < cisternas.size(); i++) {
                if (cisternas.get(i) != null) {
                    line = "Capacidad: " + cisternas.get(i).getCapacidad();
                }
                oos.write(line + "\n");
            }
            oos.close();
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error");
            e.printStackTrace();
        }
    }
}
