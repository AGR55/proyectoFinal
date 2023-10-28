package APP;

public class Turbinas extends Motores{
    private int fuerza;
    public Turbinas(String estado, int regimen, int fuerza) {
        super(estado, regimen);
        this.fuerza=fuerza;
    }

    public int getFuerza() {
        return fuerza;
    }
}
