package SERIALIZABLE;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import APP.Cisternas;
import APP.Compuestas;
import APP.Depositos;
import APP.Simples;
import APP.Tanques;

public class Serial {

    public void guardarTanquesRegularOMalEstado(List<Depositos> depositos) {
        try {
            FileWriter oos = new FileWriter("verificar.dat");
            String line = "";
            for (int i = 0; i < depositos.size(); i++) {
                if (depositos.get(i) != null && depositos.get(i) instanceof Tanques) {
                    Tanques auxTanques = (Tanques) depositos.get(i);
                    line = "<<Tanque>> Capacidad: " + auxTanques.getCapacidad() + "Estado: " + auxTanques.getEstado()
                            + "Tipo de abasto: " + auxTanques.getTipoAbasto() + "Material: " + auxTanques.getMaterial();
                } else if (depositos.get(i) != null && depositos.get(i) instanceof Cisternas) {
                    if (depositos.get(i) instanceof Simples) {
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
                System.out.println(line);
                oos.write(line + "\n");
            }
            oos.close();
        } catch (IOException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public void conocerCapacidadTotalCisternasInfo() {

    }
}
