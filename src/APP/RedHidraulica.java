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

    public List<Integer> capacidadOrdenada() {
        String[] orden = { "Fibrocemento", "Metal", "Plastico" };
        List<Cisternas> auxCis = getCisternas();
        List<Tanques> auxTan = getTanques();
        List<Integer> capacidadOrdenada = new ArrayList<>();
        int cantidadCisternas = getCisternas().size();
        int cantidadTanques = getTanques().size();

        for (int i = 0; i < orden.length; i++) {
            for (int j = 0; j < cantidadTanques; j++) {
                if (auxTan.get(j).getMaterial().equals(orden[i])) {
                    capacidadOrdenada.add(auxTan.get(j).getCapacidad());
                }
            }
        }
        for (int i = 0; i < cantidadCisternas; i++) {
            if (auxCis.get(i) instanceof Simples) {
                capacidadOrdenada.add(auxCis.get(i).getCapacidad());
            }
        }
        for (int i = 0; i < cantidadCisternas; i++) {
            if (auxCis.get(i) instanceof Compuestas) {
                capacidadOrdenada.add(auxCis.get(i).getCapacidad());
            }
        }
        return capacidadOrdenada;
    }

    public String[] cantidadMedios() {
        String[] medios = { "Bombas", "Turbinas", "Cisternas", "Tanques" };
        int cantidadBombas = 0;
        int cantidadTurbinas = 0;
        int cantidadCisternas = getCisternas().size();
        int cantidadTanques = getTanques().size();

        for (int i = 0; i < motores.size(); i++) {
            if (motores.get(i) != null) {
                if (motores.get(i) instanceof BombasDeAgua) {
                    cantidadBombas++;
                } else {
                    cantidadTanques++;
                }
            }
        }

        int[] cantidades = { cantidadBombas, cantidadTurbinas, cantidadCisternas, cantidadTanques };
        String[] info = new String[medios.length];

        for (int i = 0; i < cantidades.length; i++) {
            info[i] = "La cantidad de " + medios[i] + " es" + cantidades[i];
        }
        return info;
    }
}
