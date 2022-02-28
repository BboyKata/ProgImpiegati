/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progimpiegati;

import java.util.Scanner;

/**
 *
 * @author Studente
 */
public class ProgImpiegati {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int c = 0;
        Scanner myObj = new Scanner(System.in);
        System.out.println("Quanti impiegati ha la tua azienda? ");
        Azienda azienda = new Azienda(Integer.parseInt(myObj.nextLine()));

        do {

            System.out.println("\n1) Aggiungi impiegato;\n2) Aggiungi stipendio ad un impiegato;\n3) Aggiungi stesso stipendio a tutti;");
            System.out.println("4) Stampa informazioni generali;\n5) Stampa informazioni impiegato;");
            System.out.println("6) Stampa media stipendi generali;\n7) Stampa media stipendi impiegato;");
            System.out.println("8) Stampa stipendi generali;\n9) Stampa stipendio totale impiegato;");
            System.out.println("10) Verifica presenza impiegato;\n11) Stampa impiegati con lo stesso ruolo;\n0) Esci;");
            System.out.println("Inserire operazione: ");
            c = Integer.parseInt(myObj.nextLine());
            switch (c) {
                case 0:
                    System.out.println("Arrivederci");
                    break;
                case 1:
                    if (!azienda.aggiungiImpiegato()) {
                        System.out.println("L'azienda è al pieno!");
                    } else {
                        System.out.println("Impiegato inserito");
                    }
                    break;
                case 2:
                    System.out.println("Inserire cognome impiegato: ");
                    String cognome = myObj.nextLine();
                    if (azienda.isImpiegatoInserito(cognome)) {
                        System.out.println("Inserire importo stipendio: ");
                        azienda.aggiungiStipendio(cognome, Float.parseFloat(myObj.nextLine()));
                        System.out.println("Stipendio inserito");

                    } else {
                        System.out.println("Stipendio inserito");
                    }
                    break;
                case 3:
                    System.out.println("Inserire importo stipendio: ");
                    azienda.aggiungiStipendioATutti(Float.parseFloat(myObj.nextLine()));
                    System.out.println("Stipendio aggiunto correttamente a tutti");
                    break;
                case 4:
                    azienda.stampaInformazioniGenerali();
                    break;
                case 5:
                    System.out.println("Inserire cognome impiegato: ");
                    cognome = myObj.nextLine();
                    if (azienda.isImpiegatoInserito(cognome)) {
                        azienda.stampaInformazioniDipendente(cognome);
                    } else {
                        System.out.println("L'impiegato non fa parte dell'azienda");
                    }
                    break;
                case 6:
                    System.out.println("La media degli stipendi è: " + azienda.mediaStipendiTot());
                    break;
                case 7:
                    System.out.println("Inserire cognome impiegato: ");
                    cognome = myObj.nextLine();
                    if (!azienda.isImpiegatoInserito(cognome)) {
                        azienda.mediaImpiegato(cognome);
                    }else{
                        System.out.println("L'impiegato non fa parte dell'azienda");
                    }
                    break;
                case 8:
                    System.out.println("Il totale degli stipendi è: " + azienda.totStipendiGenerali());
                    break;
                case 9:
                    System.out.println("Inserire cognome impiegato: ");
                    cognome = myObj.nextLine();
                    if (!azienda.isImpiegatoInserito(cognome)) {
                        azienda.stipendioImpiegato(cognome);
                    }else{
                        System.out.println("L'impiegato non fa parte dell'azienda");
                    }
                    break;
                case 10:
                    System.out.println("Inserire cognome impiegato: ");
                    if (azienda.isImpiegatoInserito(myObj.nextLine())) {
                        System.out.println("L'impiegato c'è");
                    } else {
                        System.out.println("L'impiegato non c'è");
                    }
                    break;
                case 11:
                    System.out.println("Inserire ruolo: ");
                    if (!azienda.stampaPerRuolo(myObj.nextLine())) {
                        System.out.println("Questo ruolo non c'è");
                    }
                    break;
                case 12:
                    System.out.println("Inserire cognome impiegato: ");
                    cognome = myObj.nextLine();
                    if (!azienda.isImpiegatoInserito(cognome)) {
                        azienda.rimuoviImpiegato(cognome);
                        System.out.println("Impiegato rimosso correttamente");
                    }else{
                        System.out.println("L'impiegato non faceva già parte dell'azienda");
                    }
                    break;
                default:
                    System.out.println("Errore, reinserire");
                    break;
            }

        } while (c != 0);
    }

}
