package APP;

public abstract class Motores {
    protected String estado;
    protected int regimen;

    public Motores(String estado, int regimen) {
        this.estado = estado;
        this.regimen = regimen;
    }

    public int getRegimen() {
        return regimen;
    }

    public String getEstado() {
        return estado;
    }
}
