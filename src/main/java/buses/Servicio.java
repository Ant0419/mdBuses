package buses;
import java.io.*;
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
    public ArrayList<Bus> filtra(Criterio criterio){
        ArrayList<Bus> busesFiltrado = new ArrayList<>();
        for(int i=0; i<buses.size(); ++i){
            if(criterio.esSeleccionable(buses.get(i))){
                busesFiltrado.add(buses.get(i));
            }
        }
        return busesFiltrado;
    }
    public void guarda(String file, Criterio criterio) throws FileNotFoundException {
        try (PrintWriter pw = new PrintWriter(file)) {
            guarda(pw, criterio);
        }catch (FileNotFoundException e){
            throw new FileNotFoundException("No se ha encontrado el archivo.");
        }
    }
    public void guarda(PrintWriter pw, Criterio criterio){
        ArrayList<Bus> listaFiltrada = filtra(criterio);
        for (Bus bus : listaFiltrada) {
            pw.println(bus.toString());
        }
    }
}
