package model;

public class SucursalaBancara {
    private String adresa;
    private String numarTelefon;
    private String programFunctionare;

    public SucursalaBancara(String adresa, String numarTelefon, String programFunctionare) {
        this.adresa = adresa;
        this.numarTelefon = numarTelefon;
        this.programFunctionare = programFunctionare;
    }

    public String getAdresa() {
        return adresa;
    }

    public String getNumarTelefon() {
        return numarTelefon;
    }

    public String getProgramFunctionare() {
        return programFunctionare;
    }

    public void afisareInformatii() {
        System.out.println("Adresa: " + adresa);
        System.out.println("Numar de telefon: " + numarTelefon);
        System.out.println("Program de functionare: " + programFunctionare);
    }
}
