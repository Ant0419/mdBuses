package buses;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
public class Servicio {
    private String ciudad;
    private ArrayList<Bus> buses;
    public Servicio(String city){
        ciudad=city;
        buses = new ArrayList<>();
    }
    public String getCiudad(){
        return ciudad;
    }
    public ArrayList<Bus> getBuses(){
        return buses;
    }

    public void leeBuses(String file) throws IOException {
        Path path = Path.of(file);
        try(BufferedReader br = Files.newBufferedReader(path)) {
            String linea = br.readLine();
            while (linea != null) {
                String[] lineaSeparada = linea.split(",");
                if(lineaSeparada.length != 3) {
                    System.out.println("Error datos de autobus incorrector: "+ linea);
                }else {
                    try {
                        Bus aux = new Bus(Integer.parseInt(lineaSeparada[0]), lineaSeparada[1]);
                        aux.setCodLinea(Integer.parseInt(lineaSeparada[2]));
                        buses.add(aux);
                    } catch (Exception e) {
                        System.out.println("Error al procesar la linea: " + linea);
                    }
                }
                linea = br.readLine();
            }
        }
    }
    //---------SEGUNDA---PARTE-----------------------------------------------------------------------------
}
