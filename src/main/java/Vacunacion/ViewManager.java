package vacunacion;

import java.util.logging.Logger;

public class ViewManager {

    Logger logger = Logger.getLogger(ViewManager.class.getName());

    ViewManager(){

    }

    public void authenticatotView(){
        var menu = " ";
        menu = menu + "Bienvenido al manager  de vacunación.\n";
        menu = menu + "Por favor ingresa tu usuario y contraseña:\n";
        logger.info(menu);
    }

    public void mainView(){
        var view = " ";
        view = view + "\n\n" + "Bienvenido al manager de vacunación. Aquí podrás estar al tanto del progreso de los vacunados\n";
        view = view + "¿Qué prefiere hacer?\n\n";
        view = view + "A) Visualizar reporte consolidado\n";
        view = view + "B) Administrar centros de vacunación\n";
        view = view + "C) Ver Reporte de vacunación por rango de edad\n";
        view = view + "D) Cerrar Sesión\n";
        logger.info(view);
    }

    public void reporteConsolidado(){
        var view = "";
        view += "Avance de la vacunación: \n";
        view += "Avance de la vacunación: " + VacunacionManager.instantiate().avanceVacunacion() + " %\n";
        view += "Cobertura de la vacunación: " + VacunacionManager.instantiate().coberturaVacunacion() + " %\n";
        view += "Número de centros de vacunación: " + VacunacionManager.instantiate().numeroCentrosVacunacion() + "\n";
        view += "Número de personas vacunadas completamente: " + VacunacionManager.instantiate().personasVacunadasCompleto() + "\n";
        logger.info(view);
    }

    public void administrarCentros(){
        logger.info("Funcionalidad no implementada\n");
    }

    public void verReportePorRango(){
        logger.info("Funcionalidad no implementada\n");
    }

    public void cerrarSesion(){
        var view = "";
        view += "\nCerraste sesión\n\n";
        logger.info(view);
    }
}
