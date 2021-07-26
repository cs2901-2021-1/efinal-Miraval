package Vacunacion;

import java.security.SecureRandom;
import java.util.Vector;

public class CentroVacunacion {
    private String nombre;
    private Vector<Persona> personasAsignadas = new Vector<>();
    private int porVacunar;
    private String status;
    SecureRandom random = new SecureRandom();

    CentroVacunacion(String nombre){
        this.nombre = nombre;
        porVacunar = random.nextInt(20000);
        for(int i = 0; i < porVacunar; i++){
            personasAsignadas.addElement(new Persona());
        }
        status = "DESACTIVADO";
    };

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
