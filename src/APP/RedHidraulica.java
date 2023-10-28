package APP;

import java.util.ArrayList;
import java.util.List;

import SERIALIZABLE.Serial;

public class RedHidraulica {
    private List<Depositos> depositos;
    private List<Motores> motores;
    private int cantidadDepositos = getCantidadDepositos();
    private int cantidadMotores = getCantidadMotores();

    public int getCantidadDepositos() {
        int aux = 0;

        for (int i = 0; i < depositos.size(); i++) {
            if (depositos.get(i) != null) {
                aux++;
            }
        }
        return aux;
    }

    public int getCantidadMotores() {
        int aux = 0;

        for (int i = 0; i < motores.size(); i++) {
            if (motores.get(i) != null) {
                aux++;
            }
        }
        return aux;
    }

    public RedHidraulica(List<Motores> motores) {
        this.depositos = new ArrayList<Depositos>();
        this.motores = motores;
    }

    public List<Depositos> getDepositos() {
        return depositos;
    }

    public List<Cisternas> getCisternas() {
        List<Cisternas> cisternas = new ArrayList<>();

        for (int i = 0; i < cantidadDepositos; i++) {
            if (depositos.get(i) instanceof Cisternas) {
                cisternas.add((Cisternas) depositos.get(i));
            }
        }
        return cisternas;
    }

    public List<Tanques> getTanques() {
        List<Tanques> tanques = new ArrayList<>();

        for (int i = 0; i < cantidadDepositos; i++) {
            if (depositos.get(i) instanceof Tanques) {
                tanques.add((Tanques) depositos.get(i));
            }
        }
        return tanques;
    }

    public void infoDepositos(String tipoAbasto) {
        for (int i = 0; i < cantidadDepositos; i++) {
            Serial serial = new Serial();
            if (depositos.get(i).getEstado().equals("Mal") || depositos.get(i).getEstado().equals("Regular")
                    && depositos.get(i).getTipoAbasto().equals(tipoAbasto)) {
                serial.guardarTanquesRegularOMalEstado(depositos);
            }
        }
    }
}
