package buses;

import java.util.Objects;

public class Bus {
    private int codBus;
    private int codLinea;
    private String matricula;
    public Bus(int codigoBus, String mat){
        codBus = codigoBus;
        matricula = mat;
    }
    public void setCodLinea(int codLinea){
        this.codLinea=codLinea;
    }
    public int getCodBus() {
        return codBus;
    }
    public int getCodLinea() {
        return codLinea;
    }
    public String getMatricula() {
        return matricula;
    }
    @Override
    public boolean equals(Object o){
        return (o instanceof Bus p) && p.codBus==codBus && p.matricula.equalsIgnoreCase(matricula);
    }
    @Override
    public int hashCode(){
        return Objects.hash(matricula.toLowerCase(),codBus);
    }
    @Override
    public String toString(){
        return "Bus(" + codBus + "," + matricula + "," + codLinea + ")";
    }
}
