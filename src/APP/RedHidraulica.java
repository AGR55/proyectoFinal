package APP;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import SERIALIZABLE.Serial;

public class RedHidraulica {
    private List<Depositos> depositos;
    private List<Motores> motores;
    private int cantidadDepositos = getCantidadDepositos();
    private int cantidadMotores = getCantidadMotores();

    public RedHidraulica(List<Motores> motores) {
        this.depositos = new ArrayList<Depositos>();
        this.motores = motores;
    }

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

    public List<Depositos> getDepositos() {
        return depositos;
    }

    public List<Motores> getMotores() {
        return motores;
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

    public List<Turbinas> getTurbinas() {
        List<Turbinas> turbinas = new ArrayList<>();

        for (int i = 0; i < cantidadMotores; i++) {
            if (motores.get(i) instanceof Turbinas) {
                turbinas.add((Turbinas) motores.get(i));
            }
        }
        return turbinas;
    }

    public List<String> infoDepositos(String tipoAbasto) throws IOException {
        List<String> lista = null;
        for (int i = 0; i < cantidadDepositos; i++) {
            Serial serial = new Serial();
            if (depositos.get(i).getEstado().equals("Mal") || depositos.get(i).getEstado().equals("Regular")
                    && depositos.get(i).getTipoAbasto().equals(tipoAbasto)) {
                lista = serial.guardarTanquesRegularOMalEstado(depositos);
            }
        }
        return lista;
    }

    public List<Integer> capacidadOrdenada() {
        String[] orden = { "Fibrocemento", "Metal", "Plastico" };
        List<Cisternas> auxCis = getCisternas();
        List<Tanques> auxTan = getTanques();
        List<Integer> capacidadOrdenada = new ArrayList<>();
        int cantidadCisternas = getCisternas().size();
        int cantidadTanques = getTanques().size();
        String[] clas = { "Simple", "Compuesta" };

        for (int i = 0; i < orden.length; i++) {
            for (int j = 0; j < cantidadTanques; j++) {
                if (auxTan.get(j).getMaterial().equals(orden[i])) {
                    capacidadOrdenada.add(auxTan.get(j).getCapacidad());
                }
            }
        }
        for (int i = 0; i < clas.length; i++) {
            for (int j = 0; j < cantidadCisternas; j++) {
                if (auxCis.get(j).clasificacion().equals(clas[i])) {
                    capacidadOrdenada.add(auxCis.get(j).getCapacidad());
                }
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

    public double tiempoPromedio() {
        double tiempo = 0;

        for (int i = 0; i < cantidadMotores; i++) {
            if (motores.get(i) instanceof BombasDeAgua) {
                if (((BombasDeAgua) motores.get(i)).estado.equals("Bueno")) {
                    tiempo += ((BombasDeAgua) motores.get(i)).getTiempoBombeo();
                }
            }
        }
        return tiempo / cantidadMotores;
    }

    public List<String> estadoTurbinas() {
        List<String> estados = new ArrayList<>();
        List<Turbinas> turbinasAux = getTurbinas();
        int cantidadTurbinas = 0;
        int indice = 0;
        int mayor = 0;

        for (int i = 0; i < turbinasAux.size(); i++) {
            if (turbinasAux.get(i) != null) {
                cantidadTurbinas++;
            }
        }

        for (int i = 0; i < cantidadTurbinas; i++) {
            if (turbinasAux.get(i).getFuerza() > mayor) {
                mayor = turbinasAux.get(i).getFuerza();
                indice = i;
            }
        }
        estados.add(turbinasAux.get(indice).getEstado());

        for (int i = 0; i < cantidadTurbinas; i++) {
            if (turbinasAux.get(i).getFuerza() == mayor) {
                estados.add(turbinasAux.get(i).getEstado());
            }
        }
        return estados;
    }

    public void guardarCapacidadCisternas(int compartimentos, String forma) throws IOException {
        List<Cisternas> cisternasAux = getCisternas();
        int cantidadCisternas = 0;
        Serial serial = new Serial();

        for (int i = 0; i < cisternasAux.size(); i++) {
            if (cisternasAux.get(i) != null) {
                cantidadCisternas++;
            }
        }

        for (int i = 0; i < cantidadCisternas; i++) {
            if (cisternasAux.get(i) instanceof Simples) {
                if (((Simples) cisternasAux.get(i)).getForma() != forma) {
                    cisternasAux.remove(i);
                }
            } else {
                if (((Compuestas) cisternasAux.get(i)).getCantidadCompartimentos() != compartimentos) {
                    cisternasAux.remove(i);
                }
            }
        }
        serial.conocerCapacidadTotalCisternasInfo(cisternasAux);
    }
}
