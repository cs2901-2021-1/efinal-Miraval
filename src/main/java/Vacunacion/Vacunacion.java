package Vacunacion;

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
        Authenticate();
    }

    public static void Authenticate(){
        viewManager.AuthenticatotView();
        var username = scanner.next();
        var password = scanner.next();
        VacunacionManager.Authenticate(username, password);
        int code = VacunacionManager.Authenticate(username, password);
        if (code == 200){
            state = "AUTHENTICATED";
            viewManager.mainView();
            mainMenu();
        }
        else if (code == 401){
            Authenticate();
        }
    }

    public static void mainMenu(){
        var option = scanner.next();
        if (option.equals("D")){
            viewManager.CerrarSesion();
            Authenticate();
        }
    }



}
