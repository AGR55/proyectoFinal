package APP;

public class Simples extends Cisternas {
    private String forma;

    public Simples(int capacidad, String estado, String tipoAbasto, String forma) {
        super(capacidad, estado, tipoAbasto);
        this.forma = forma;
    }

    public String getForma() {
        return forma;
    }

    @Override
    public String clasificacion() {
        return "Simple";
    }
}
