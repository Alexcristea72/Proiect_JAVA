package model;

public class Client {

	private String nume;
    private String adresa;
    private String numarTelefon;
    private String email;

    public Client(String nume, String adresa, String numarTelefon, String email) {
        this.nume = nume;
        this.adresa = adresa;
        this.numarTelefon = numarTelefon;
        this.email = email;
    }

    public String getNume() {
        return nume;
    }

    public String getAdresa() {
        return adresa;
    }

    public String getNumarTelefon() {
        return numarTelefon;
    }

    public String getEmail() {
        return email;
    }

    public void afisareInformatii() {
        System.out.println("Nume: " + nume);
        System.out.println("Adresa: " + adresa);
        System.out.println("Numar de telefon: " + numarTelefon);
        System.out.println("Email: " + email);
    }
}
