package vacunacion;


import java.util.HashMap;
import java.util.logging.Logger;

public class VacunacionManager{

    static final Logger logger = Logger.getLogger(VacunacionManager.class.getName());
    private static final VacunacionManager manager = new VacunacionManager();
    HashMap<String, CentroVacunacion> centrosVacunacion = new HashMap<>();
    static float totalVacunation = 22935533;


    VacunacionManager(){
        //
    }

    public static VacunacionManager instantiate(){
        return manager;
    }

    public static int authenticate(String username, String password){
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
        return vacunados*100/ totalVacunation;
    }

    public float coberturaVacunacion(){
        var vacunados = 0;
        for (var center : this.centrosVacunacion.values()){
            vacunados = vacunados + center.getVacunadosCompleto();
        }
        return vacunados*100/ totalVacunation;
    }

    public int numeroCentrosVacunacion(){
        return this.centrosVacunacion.size();}

    public int personasVacunadasParcial(){
        var vacunados = 0;
        for (var center : this.centrosVacunacion.values()){
            vacunados = vacunados + center.getVacunados();
        }
        return vacunados;
    }
    public int personasVacunadasCompleto(){
        var vacunados = 0;
        for (var center : this.centrosVacunacion.values()){
            vacunados = vacunados + center.getVacunadosCompleto();
        }
        return vacunados;
    }

}
