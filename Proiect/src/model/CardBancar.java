package model;

public class CardBancar {

	private static int numarCardGlobal = 1000; 
    private int numarCard; 
    private String dataExpirare;
    private int codSecuritate;
    private String proprietar;
    private ContBancar contAsociat;

    public CardBancar(String proprietar, ContBancar contAsociat) {
    	this.numarCard = generateNumarCard();
        this.dataExpirare = generateDataExpirare();
        this.codSecuritate = generateCodSecuritate();
        this.proprietar = proprietar;
        this.contAsociat = contAsociat;
    }
    private int generateNumarCard() {
        return ++numarCardGlobal; 
    }

    private String generateDataExpirare() {
        return "MM/YY";
    }

    private int generateCodSecuritate() {
        return (int) (Math.random() * 900) + 100;
    }
    public int getNumarCard() {
        return numarCard;
    }

    public String getDataExpirare() {
        return dataExpirare;
    }

    public int getCodSecuritate() {
        return codSecuritate;
    }

    public String getProprietar() {
        return proprietar;
    }

    public void afisareInformatii() {
        System.out.println("Numar card: " + numarCard);
        System.out.println("Data expirare: " + dataExpirare);
        System.out.println("Cod securitate: " + codSecuritate);
        System.out.println("Proprietar: " + proprietar);
    }
}
