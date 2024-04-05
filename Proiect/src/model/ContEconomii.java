package model;

public class ContEconomii extends ContBancar {
    private double dobanda;

    public ContEconomii(String numarCont, double sold, String proprietar, double dobanda) {
        super(numarCont, sold, proprietar);
        this.dobanda = dobanda;
    }

    public double getDobanda() {
        return dobanda;
    }

    public void setDobanda(double dobanda) {
        this.dobanda = dobanda;
    }

    @Override
    public void afisareInformatii() {
        super.afisareInformatii();
        System.out.println("Dobanda: " + dobanda);
    }
}
