package model;

public class ContBancar {
    private String numarCont;
    private double sold;
    private String proprietar;
	private boolean activ;

    public ContBancar(String numarCont, double sold, String proprietar) {
        this.numarCont = numarCont;
        this.sold = sold;
        this.proprietar = proprietar;
        boolean activ;
    }

    public String getNumarCont() {
        return numarCont;
    }

    public double getSold() {
        return sold;
    }

    public String getProprietar() {
        return proprietar;
    }

    public void depozit(double suma) {
        sold += suma;
        System.out.println("Suma " + suma + " depozitata cu succes. Soldul curent: " + sold);
    }

    public void retragere(double suma) {
        if (suma <= sold) {
            sold -= suma;
            System.out.println("Suma " + suma + " retrasa cu succes. Soldul curent: " + sold);
        } else {
            System.out.println("Fonduri insuficiente pentru retragere.");
        }
    }
    public void blocheazaCont() {
        this.activ = false;
        System.out.println("Contul " + numarCont + " a fost blocat temporar.");
    }

    public void deblocheazaCont() {
        this.activ = true;
        System.out.println("Contul " + numarCont + " a fost deblocat.");
    }

    public boolean isActiv() {
        return activ;
    }
    public void afisareInformatii() {
        System.out.println("Activ: " + isActiv());
        System.out.println("Numar cont: " + numarCont);
        System.out.println("Proprietar: " + proprietar);
        System.out.println("Sold curent: " + sold);
    }
}
