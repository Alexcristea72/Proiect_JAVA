package model;

import java.util.Date;
import java.time.LocalDate;

public class Tranzactie {
    private Date data;
    private double suma;
    private String contSursa;
    private String contDestinatie;

    public Tranzactie(double suma, String contSursa, String contDestinatie) {
        this.data = new Date(); 
        this.suma = suma;
        this.contSursa = contSursa;
        this.contDestinatie = contDestinatie;
    }

    public Date getData() {
        return data;
    }

    public double getSuma() {
        return suma;
    }

    public String getContSursa() {
        return contSursa;
    }

    public String getContDestinatie() {
        return contDestinatie;
    }

    public void afisareInformatii() {
        System.out.println("Data tranzactiei: " + data);
        System.out.println("Suma: " + suma);
        System.out.println("Cont sursa: " + contSursa);
        System.out.println("Cont destinatie: " + contDestinatie);
    }
}
