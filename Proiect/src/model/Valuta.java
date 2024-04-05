package model;

public class Valuta {
    private String codValutar;
    protected String simbol;
    private double rataSchimb;

    
    public Valuta(String codValutar, String simbol, double rataSchimb) {
        this.codValutar = codValutar;
        this.simbol = simbol;
        this.rataSchimb = rataSchimb;
    }

    public String getCodValutar() {
        return codValutar;
    }

    public String getSimbol() {
        return simbol;
    }

    public double getRataSchimb() {
        return rataSchimb;
    }

    public void afisareInformatii() {
        System.out.println("Cod valutar: " + codValutar);
        System.out.println("Simbol: " + simbol);
        System.out.println("Rata de schimb: " + rataSchimb);
    }
}
