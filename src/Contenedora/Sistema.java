package Contenedora;

import Exceptions.KitNoDisponibleException;
import Models.Paciente;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class Sistema{

    private Integer cantidadKit = 4;

    LinkedHashSet<Paciente> pacientes;
    Map<Integer, String> testeados;

    public Sistema(){
        pacientes = new LinkedHashSet<>();
        testeados = new HashMap<>();
    }

    public Integer getCantidadKit() {
        return cantidadKit;
    }

    public void setCantidadKit(Integer cantidadKit) {
        this.cantidadKit = cantidadKit;
    }

    public void ingresar(Paciente paciente) throws KitNoDisponibleException {
        try {
            if(cantidadKit<= 0){
            throw new KitNoDisponibleException();
            }else{
                paciente.setNumKit(getCantidadKit());
                this.pacientes.add(paciente);
                setCantidadKit(getCantidadKit()-1);
            }
        } catch (KitNoDisponibleException e) {
            System.out.println("No quedan reactivos");
            setCantidadKit(100);
            System.out.println("Fueron agregados mas kits");
        }finally {
            paciente.setNumKit(getCantidadKit());
            this.pacientes.add(paciente);
            //setCantidadKit(getCantidadKit()-1);
        }
    }


    public String listaPacientes(){
        String lista = "";
        if(pacientes.isEmpty()){
            lista = "No hay pacientes en la lista";
        }else{
            for (Paciente pac: pacientes){
                lista += pac.toString() + "\n";

            }
        }
        return lista;
    }

    public void testear (Paciente paciente){
        testeados.put(paciente.getNumKit(), "" + paciente.getDni() + " - " + paciente.getTemperatura());
    }

    public void aislar(Paciente paciente) throws Exception{

        try {
            if(paciente.getTemperatura()>37){
                throw new Exception();
            }else{
                System.out.println("Paciente sano");
            }
        } catch (Exception e) {

            System.out.println("El paciente cuyo kit es: " + paciente.getNumKit() + " , del barrio: " + paciente.getBarrio() + " debe ser aislado urgente");
        }
    }

    public void mostrarTesteados(){
        for(Map.Entry info: testeados.entrySet()){
            System.out.println("KEY(Numero de Kit): " + info.getKey() + " - VALUE(DNI - Temperatura): " + info.getValue().toString());
        }
    }



}
