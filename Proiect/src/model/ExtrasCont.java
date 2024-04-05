package model;

import java.util.ArrayList;
import java.util.List;

public class ExtrasCont {
    private List<Tranzactie> tranzactii;
    private double soldCurent;

    public ExtrasCont(List<Tranzactie> tranzactii, double soldCurent) {
        this.tranzactii = tranzactii;
        this.soldCurent = soldCurent;
    }

    public void adaugaTranzactie(Tranzactie tranzactie) {
        tranzactii.add(tranzactie);
    }

    public void afisareExtras() {
        System.out.println("Extras de cont:");
        System.out.println("------------------------------");
        for (Tranzactie tranzactie : tranzactii) {
            System.out.println("Data tranzactiei: " + tranzactie.getData());
            System.out.println("Suma: " + tranzactie.getSuma());
            System.out.println("Cont sursa: " + tranzactie.getContSursa());
            System.out.println("Cont destinatie: " + tranzactie.getContDestinatie());
            System.out.println("------------------------------");
        }
        System.out.println("Sold curent: " + soldCurent);
    }
}
