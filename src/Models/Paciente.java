package Models;

import java.util.Random;

public class Paciente extends Persona{
    private Integer temperatura;
    private Integer numKit;

    public Paciente() {
    }

    public Paciente(String nombre, String apellido, Integer edad, String barrio, String dni, String ocupacion) {
        super(nombre, apellido, edad, barrio, dni, ocupacion);
        tomaTemperatura();
        this.numKit = numKit;
    }

    public Integer getTemperatura() {
        return temperatura;
    }

    public Integer getNumKit() {
        return numKit;
    }

    public void setNumKit(Integer numKit) {
        this.numKit = numKit;
    }

    public void tomaTemperatura(){
        Random r = new Random();
        Integer n = r.nextInt(36, 39);
        this.temperatura = n;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                super.toString() +
                "temperatura=" + temperatura +
                ", numKit=" + numKit +
                '}';
    }

}
