package Vacunacion;

import java.security.SecureRandom;
import java.util.Vector;

public class CentroVacunacion {
    private String nombre;
    private Vector<Persona> personasAsignadas = new Vector<>();
    private int porVacunar;
    private int vacunados;
    private String status;
    SecureRandom random = new SecureRandom();

    CentroVacunacion(String nombre){
        this.nombre = nombre;
        porVacunar = random.nextInt(20000);
        for(int i = 0; i < porVacunar; i++){
            personasAsignadas.addElement(new Persona());
        }
        vacunados = 0;
        status = "DESACTIVADO";
    };

    int getVacunados(){
        return vacunados;
    }

    String getNombre(){return nombre;}

    int getPorVacunar(){
        return porVacunar;
    }
}
