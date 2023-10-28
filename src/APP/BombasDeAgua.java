package APP;

public class BombasDeAgua extends Motores{
    private int tiempoBombeo;

    public BombasDeAgua(String estado, int regimen, int tiempoBombeo) {
        super(estado, regimen);
        this.tiempoBombeo = tiempoBombeo;
    }

    public int getTiempoBombeo() {
        return tiempoBombeo;
    }
}
