package pkg2024_1_lab02;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
public class Main {

    public static void main(String[] args) throws ParseException{
        Especialidad espe01 = new Especialidad("MEDICINA INTERNA");
        Especialidad espe02 = new Especialidad("RADIOLOGIA");
        Especialidad espe03 = new Especialidad("OTORRINOLARINGOLOGIA");

        Medico med01 = new Medico("18282901", "NATALI", "LEIVA", "REYES", espe01, "062258", "030568");
        Medico med02 = new Medico("13876114", "RAUL", "NEIRA", "GORRITI", espe02, "059092", "030077");
        Medico med03 = new Medico("29813127", "LUIS", "PEREZ", "LU", espe03, "039811", "029899");

        Paciente pac01 = new Paciente("17920084", "PATRICIA", "FERNANDEZ", "TELLO", 3873);

        Consultorio con01 = new Consultorio(17.8, 'A', 2, "204");

        SalaEspecializada sal01 = new SalaEspecializada(39.8, 'B', 1, "CAYETANO", true);

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        AtencionMedica atm01 = new ConsultaPresencial(pac01, med01, sdf.parse("29-03-2024 16:00"), "DOLOR DE ESPALDA", con01, false);
        AtencionMedica atm02 = new ExamenDiagnostico(pac01, med02, sdf.parse("30-03-2024 08:30"), sal01, TipoExamen.ECOGRAFIA);
        AtencionMedica atm03 = new Teleconsulta(pac01, med03, sdf.parse("01-04-2024 15:30"), "DOLOR DE GARGANTA", Plataforma.ZOOM, "http://pucp.zoom.us/j/98403730464");
        
        pac01.setAtencionesMedicas(new ArrayList<>());
        pac01.getAtencionesMedicas().add(atm01);
        pac01.getAtencionesMedicas().add(atm02);
        pac01.getAtencionesMedicas().add(atm03);
        
        System.out.println("PRIMERA CONSULTA.....");
        System.out.println(atm01.consultarDatos());
        System.out.println(atm02.consultarDatos());
        System.out.println(atm03.consultarDatos());
        
        System.out.println("SEGUNDA CONSULTA.....");
        pac01.listarCitasMedicasProgramadas();
    }
    
}
