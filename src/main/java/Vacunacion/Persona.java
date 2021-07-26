package Vacunacion;

import java.security.SecureRandom;

public class Persona {
    int edad;
    String status;
    SecureRandom random = new SecureRandom();

    Persona(){
        edad = random.nextInt(80);
        status = "Sin vacunarse";
    }

    int getEdad(){return edad;}
    String getStatus(){return status;}

}
