package ClassesAuxiliares;

public class Hora {
    private int horas, minutos, segundos;

    //Construtores
    public Hora(int horas, int minutos, int segundos) {
        if (horas < 0 || horas > 23) {
            //**Exception "Hóra inválida"
        }
        else this.horas = horas;

        if (minutos < 0 || minutos > 59) {
            //**Exception "Minutos inválidos"
        }
        else this.minutos = minutos;

        if (segundos < 0 || segundos > 59) {
            //**Exception "Minutos inválidos"
        }
        else this.segundos = segundos;
    }

    public Hora(int horas, int minutos) {
        if (horas < 0 || horas > 23) {
            //**Exception "Hóra inválida"
        }
        else this.horas = horas;

        if (minutos < 0 || minutos > 59) {
            //**Exception "Minutos inválidos"
        }
        else this.minutos = minutos;

        this.segundos = 0;
    }

    public Hora(Hora hora) {
        this.horas = hora.getHoras();
        this.minutos = hora.getMinutos();
        this.segundos = hora.getSegundos();
    }

    //Métodos GET
    public int getHoras() {
        return horas;
    }

    public int getMinutos() {
        return minutos;
    }

    public int getSegundos() {
        return segundos;
    }

    //Métodos SET
    public void setHora(int horas, int minutos, int segundos) {
        if (horas < 0 || horas > 23) {
            //**Exception "Hóra inválida"
        }
        else this.horas = horas;

        if (minutos < 0 || minutos > 59) {
            //**Exception "Minutos inválidos"
        }
        else this.minutos = minutos;

        if (segundos < 0 || segundos > 59) {
            //**Exception "Minutos inválidos"
        }
        else this.segundos = segundos;
    }

    public void setHora(int horas, int minutos) {
        if (horas < 0 || horas > 23) {
            //**Exception "Hóra inválida"
        }
        else this.horas = horas;

        if (minutos < 0 || minutos > 59) {
            //**Exception "Minutos inválidos"
        }
        else this.minutos = minutos;

        this.segundos = 0;
    }

    //**Colocar exceptions
}
