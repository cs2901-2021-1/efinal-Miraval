package vacunacion;

import java.util.Scanner;
import java.util.logging.Logger;

public class Vacunacion {
    //Vacunacion application
    Logger logger = Logger.getLogger(Vacunacion.class.getName());
    boolean authenticated = false;
    static Scanner scanner = new Scanner(System.in);
    static ViewManager viewManager = new ViewManager();
    static String state = "NOT_AUTHENTICATED";


    public static void main(String[] args){
        authenticate();
    }

    public static void authenticate(){
        viewManager.authenticatotView();
        var username = scanner.next();
        var password = scanner.next();
        VacunacionManager.authenticate(username, password);
        int code = VacunacionManager.authenticate(username, password);
        if (code == 200){
            state = "AUTHENTICATED";
            viewManager.mainView();
            mainMenu();
        }
        else if (code == 401){
            authenticate();
        }
    }

    public static void mainMenu(){
        var option = scanner.next();
        if (option.equals("A")){
            viewManager.reporteConsolidado();
            viewManager.mainView();
            mainMenu();
        }
        else if (option.equals("B")){
            viewManager.administrarCentros();
            viewManager.mainView();
            mainMenu();
        }
        else if (option.equals("C")){
            viewManager.verReportePorRango();
            viewManager.mainView();
            mainMenu();
        }
        else if (option.equals("D")){
            viewManager.cerrarSesion();
            authenticate();
        }
        else{
            viewManager.mainView();
            mainMenu();
        }
    }



}


