package vacunacion;

import java.security.SecureRandom;
import java.util.LinkedList;

public class CentroVacunacion {
    private String nombre;
    private LinkedList<Persona> personasAsignadas = new LinkedList<>();
    private int porVacunar;
    SecureRandom random = new SecureRandom();

    CentroVacunacion(String nombre){
        this.nombre = nombre;
        porVacunar = random.nextInt(20000);
        for(int i = 0; i < porVacunar; i++){
            personasAsignadas.add(new Persona());
        }
    }

    int getVacunados(){
        var vacunadosParcial = 0;
        for(var persona : personasAsignadas){
            if(persona.getStatus().equals("PrimeraDosis")){
                vacunadosParcial = vacunadosParcial+1;
            }
        }
        return vacunadosParcial;
    }

    int getVacunadosCompleto(){
        var vacunadosCompleto = 0;
        for(var persona : personasAsignadas){
            if(persona.getStatus().equals("Completo")){
                vacunadosCompleto = vacunadosCompleto+1;
            }
        }
        return vacunadosCompleto;
    }

    String getNombre(){return nombre;}

    int getPorVacunar(){
        return porVacunar;
    }
}
