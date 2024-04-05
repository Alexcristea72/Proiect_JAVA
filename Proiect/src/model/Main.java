package model;

public class Main {
    public static void main(String[] args) {
        System.out.println("Buna ziua, aveti urmatoarele optiuni: ");
        System.out.println("Creare Cont: ");
        System.out.println("Emitere Card: ");
        System.out.println("Efectuati un transfer: ");
        System.out.println("Blocare Cont: ");
        System.out.println("Deblocare Cont: ");

    	ServiciuBancar serviciuBancar = new ServiciuBancar();

        serviciuBancar.adaugaCont(new ContBancar("123456", 1000.0, "Alex Cristea"));
        serviciuBancar.adaugaCont(new ContBancar("654321", 500.0, "Rusu Mihai"));

        serviciuBancar.emiteCardBancar("123456", "Alex Cristea");

        serviciuBancar.transferBaniExtern("123456", "654321", 200.0);

        serviciuBancar.afiseazaIstoricTranzactii("123456");

        serviciuBancar.blocheazaContBancar("123456");

        serviciuBancar.deblocheazaContBancar("123456");
    }
}

