package Vacunacion;


import java.util.HashMap;
import java.util.logging.Logger;

public class VacunacionManager{

    static final Logger logger = Logger.getLogger(VacunacionManager.class.getName());
    private static final VacunacionManager manager = new VacunacionManager();
    HashMap<String, CentroVacunacion> centrosVacunacion = new HashMap<>();
    static float TOTAL_VACUNATION = 22935533;


    VacunacionManager(){
        //
    }

    public static VacunacionManager Instantiate(){
        return manager;
    }

    public static int Authenticate(String username, String password){
        if (username.length() != password.length()){
            logger.info("Not authorized");
            return 401;
        }
        for(int i = password.length()-1; i >= 0 ; i--){
            if (password.charAt(i) != username.charAt((username.length()-i)-1)){
                logger.info("Not authorized");
                return 401;
            }
        }
        logger.info("Succesfully login");
        return 200;
    }

    public float avanceVacunacion(){
        var vacunados = 0;
        for (var center : this.centrosVacunacion.values()){
            vacunados = vacunados + center.getVacunados();
        }
        return vacunados*100/TOTAL_VACUNATION;
    };

    public float coberturaVacunacion(){
        var vacunados = 0;
        for (var center : this.centrosVacunacion.values()){
            vacunados = vacunados + center.getVacunados();
        }
        return vacunados*100/TOTAL_VACUNATION;
    };

    public int numeroCentrosVacunacion(){
        return this.centrosVacunacion.size();};

    public int personasVacunadasParcial(){
        return 0;
    }
    public static int personasVacunadasCompleto(){
        return 0;
    };

}

