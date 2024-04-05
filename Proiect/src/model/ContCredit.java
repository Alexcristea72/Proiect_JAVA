package model;
public class ContCredit extends ContBancar {
    private double limitaCredit;
    private double dobanda;

    public ContCredit(String numarCont, double sold, String proprietar, double limitaCredit, double dobanda) {
        super(numarCont, sold, proprietar);
        this.limitaCredit = limitaCredit;
        this.dobanda = dobanda;
    }

    public double getLimitaCredit() {
        return limitaCredit;
    }

    public void setLimitaCredit(double limitaCredit) {
        this.limitaCredit = limitaCredit;
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
        System.out.println("Limita credit: " + limitaCredit);
        System.out.println("Dobanda: " + dobanda);
    }
}
