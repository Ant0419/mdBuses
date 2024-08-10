package buses;

public class PorLinea implements Criterio{
    private int codLinea;
    public PorLinea(int linea){
        codLinea = linea;
    }
    @Override
    public boolean esSeleccionable(Bus bus) {
       return codLinea == bus.getCodLinea();
    }
}
