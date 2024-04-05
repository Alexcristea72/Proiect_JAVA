package model;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Date;
import java.util.List;

public class ServiciuBancar {

    private List<ContBancar> conturi;
    private Map<String, Double> rateSchimb = new HashMap<>();
    private List<CardBancar> carduri = new ArrayList<>();
    private List<Tranzactie> tranzactii = new ArrayList<>();

    public ServiciuBancar() {
        conturi = new ArrayList<>();
        rateSchimb.put("EUR", 1.0); 
        rateSchimb.put("USD", 1.18); 
        rateSchimb.put("GBP", 0.86); 
    }



    public void adaugaRataSchimb(String codValuta1, String codValuta2, double rata) {
        rateSchimb.put(codValuta1 + "-" + codValuta2, rata);
        rateSchimb.put(codValuta2 + "-" + codValuta1, 1 / rata); 
    }

    public double convertesteValuta(double suma, String valutaSursa, String valutaDestinatie) {
        if (valutaSursa.equals(valutaDestinatie)) {
            return suma; 
        }
        String cheie = valutaSursa + "-" + valutaDestinatie;
        if (rateSchimb.containsKey(cheie)) {
            double rata = rateSchimb.get(cheie);
            return suma * rata; 
        } else {
            System.out.println("Nu există o rată de schimb definită între " + valutaSursa + " și " + valutaDestinatie);
            return -1; 
        }
    }
    public void adaugaCont(ContBancar cont) {
        conturi.add(cont);
    }

    public void afiseazaConturi() {
        System.out.println("Lista conturilor bancare:");
        for (ContBancar cont : conturi) {
            System.out.println("-----------------------------------------");
            System.out.println("Numar cont: " + cont.getNumarCont());
            System.out.println("Proprietar: " + cont.getProprietar());
            System.out.println("Sold curent: " + cont.getSold());
            System.out.println("-----------------------------------------");
        }
    }

    public void emiteCardBancar(String numarCont, String numeDetinator) {
        ContBancar cont = cautaCont(numarCont);
        if (cont != null) {
            CardBancar cardNou = new CardBancar(numeDetinator, cont);
            carduri.add(cardNou);
            System.out.println("A fost emis un card bancar nou pentru clientul " + numeDetinator + ".");
        } else {
            System.out.println("Nu s-a putut emite cardul bancar. Contul bancar nu a fost găsit.");
        }
    }
    public ContBancar cautaCont(String numarCont) {
        for (ContBancar cont : conturi) {
            if (cont.getNumarCont().equals(numarCont)) {
                return cont;
            }
        }
        return null; 
    }
    public boolean transferBaniExtern(String numarContSursa, String numarContDestinatie, double suma) {
        ContBancar contSursa = cautaCont(numarContSursa);
        ContBancar contDestinatie = cautaCont(numarContDestinatie);

        if (contSursa != null && contDestinatie != null) {
            if (contSursa.getSold() >= suma) {
                contSursa.retragere(suma);
                contDestinatie.depozit(suma);
                Tranzactie tranzactie = new Tranzactie(suma, numarContSursa, numarContDestinatie);
                tranzactii.add(tranzactie);
                System.out.println("Transferul de " + suma + " lei către contul " + numarContDestinatie + " a fost efectuat cu succes.");
                return true;
            } else {
                System.out.println("Nu există suficiente fonduri în contul sursă pentru a efectua transferul.");
            }
        } else {
            System.out.println("Nu s-au putut găsi conturile specificate pentru transfer.");
        }
        return false;
    }
    public void blocheazaContBancar(String numarCont) {
        ContBancar cont = cautaCont(numarCont);
        if (cont != null) {
            cont.blocheazaCont();
        } else {
            System.out.println("Nu s-a putut găsi contul specificat pentru blocare.");
        }
    }
    public void deblocheazaContBancar(String numarCont) {
        ContBancar cont = cautaCont(numarCont);
        if (cont != null) {
            cont.deblocheazaCont();
        } else {
            System.out.println("Nu s-a putut găsi contul specificat pentru deblocare.");
        }
    }
    public void afiseazaIstoricTranzactii(String numarCont) {
        ContBancar cont = cautaCont(numarCont);
        if (cont != null) {
            System.out.println("Istoricul de tranzacții pentru contul " + numarCont + ":");
            for (Tranzactie tranzactie : tranzactii) {
                if (tranzactie.getContSursa().equals(numarCont) || tranzactie.getContDestinatie().equals(numarCont)) {
                    tranzactie.afisareInformatii();
                }
            }
        } else {
            System.out.println("Nu s-a putut găsi contul specificat pentru afișarea istoricului de tranzacții.");
        }
    }
    public List<Tranzactie> getTranzactii() {
        return tranzactii;
    }

        public void efectueazaAudit(ServiciuBancar serviciuBancar) {
            List<Tranzactie> tranzactii = serviciuBancar.getTranzactii();
            
            System.out.println("Audit bancar:");

            for (Tranzactie tranzactie : tranzactii) {
                if (verificaTranzactie(tranzactie)) {
                    System.out.println("Tranzacția " + tranzactie + " este conformă.");
                } else {
                    System.out.println("Tranzacția " + tranzactie + " nu este conformă.");
                }
            }

        }

        private boolean verificaTranzactie(Tranzactie tranzactie) {
            Date dataCurenta = new Date();

            return (tranzactie.getSuma() > 0 && !tranzactie.getData().after(dataCurenta));
        }

    public List<Tranzactie> getTranzactiiInInterval(Date dataInceput, Date dataSfarsit) {
        List<Tranzactie> tranzactiiInInterval = new ArrayList<>();
        for (Tranzactie tranzactie : tranzactii) {
            if (tranzactie.getData().after(dataInceput) && tranzactie.getData().before(dataSfarsit)) {
                tranzactiiInInterval.add(tranzactie);
            }
        }
        return tranzactiiInInterval;
    }
}
