package APP;

public class Tanques extends Depositos{
    private String material;

    public Tanques(int capacidad, String estado, String tipoAbasto, String material) {
        super(capacidad, estado, tipoAbasto);
        this.material=material;
    }

    public String getMaterial() {
        return material;
    }
}
