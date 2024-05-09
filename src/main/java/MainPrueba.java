import buses.Servicio;

import java.io.IOException;

public class MainPrueba {
    public static void main(String[] args) {
        Servicio malaga = new Servicio("Malaga");
        try {
            malaga.leeBuses("data/buses.txt");
        }catch (IOException e){
            throw new RuntimeException("El fichero no existe");
        }
        for(int i = 0; i<malaga.getBuses().size(); i++){
            System.out.println(malaga.getBuses().get(i).toString());
        }
    }
}
