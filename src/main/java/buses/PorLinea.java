package buses;

public class PorLinea implements Criterio{
    private int codLinea;
    public PorLinea(int linea){
        codLinea = linea;
    }
    @Override
    public boolean esSeleccionable(Bus bus) {
        boolean seleccionable = false;
        if(codLinea == bus.getCodLinea()){
            seleccionable=true;
        }
        return seleccionable;
    }
}
