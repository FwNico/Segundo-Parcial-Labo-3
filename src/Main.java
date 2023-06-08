import Exceptions.KitNoDisponibleException;
import Models.Paciente;
import Models.Persona;
import Contenedora.Sistema;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class Main {
    public static void main(String[] args) throws Exception {

        File file = new File("urgente.dat");
        //ObjectMapper mapper = new ObjectMapper();
        Sistema ssm = new Sistema();

        //hardcodeo de pacientes
        Paciente p1 = new Paciente("Nicolas", "Duarte", 28, "Las Lilas", "38685277", "Estudiante");
        Paciente p2 = new Paciente("Cristian", "Gomez", 34, "Belgrano", "41967324", "Gasista");
        Paciente p3 = new Paciente("Maria", "Perez", 27, "San Martin", "26744311", "Vendedora");
        Paciente p4 = new Paciente("Juan", "Castro", 38, "Pueyrredon", "32765900", "Profesor");
        Paciente p5 = new Paciente("Eva", "Mendez", 21, "Cerrito", "42765933", "Maestra");

        //Ingreso de pacientes
        ssm.ingresar(p1);
        ssm.ingresar(p2);
        ssm.ingresar(p3);
        ssm.ingresar(p4);
        ssm.ingresar(p5);

        System.out.println(ssm.listaPacientes());

        //testeo de pacientes
        ssm.testear(p1);
        ssm.testear(p2);
        ssm.testear(p3);
        ssm.testear(p4);
        ssm.testear(p5);
        ssm.mostrarTesteados();

        //aislar casos
        ssm.aislar(p1);
        ssm.aislar(p2);


    }


}