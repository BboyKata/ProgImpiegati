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
public class Azienda {

    private Impiegato[] impiegati;
    private int cont;

    public Azienda(int N) {
        this.impiegati = new Impiegato[N];
        cont = 0;
    }

    public boolean aggiungiImpiegato() {
        if (cont < impiegati.length) {
            Impiegato imp = new Impiegato();
            Scanner myObj = new Scanner(System.in);
            System.out.println("Inserisci il nome dell' impiegato da aggiungere: ");
            imp.setNome(myObj.nextLine());

            System.out.println("Inserisci il cognome dell' impiegato da aggiungere: ");
            imp.setCognome(myObj.nextLine());

            System.out.println("Inserisci l'anno di nascita dell' impiegato da aggiungere: ");
            imp.setAnnoNascita(Integer.parseInt(myObj.nextLine()));

            System.out.println("Inserisci qualifica dell'impiegato da aggiungere: ");
            imp.setQualifica(myObj.nextLine());
            impiegati[cont] = imp;
            cont++;
            return true;
        }
        return false;
    }

    public boolean isImpiegatoInserito(String cognome) {
        for (int i = 0; i < cont; i++) {
            if (impiegati[i].getCognome().equals(cognome)) {
                return true;
            }
        }
        return false;
    }

    private int indiceImpiegato(String cognome) {
        for (int i = 0; i < cont; i++) {
            if (impiegati[i].getCognome().equals(cognome)) {
                return i;
            }
        }
        return -1;
    }

    public void aggiungiStipendio(String cognome, float stipendio) {
        impiegati[indiceImpiegato(cognome)].aggiungiStipendio(stipendio);
    }

    public void aggiungiStipendioATutti(float stipendio) {
        for (int i = 0; i < cont; i++) {
            impiegati[i].aggiungiStipendio(stipendio);
        }
    }

    public void stampaInformazioniDipendente(String cognome) {
        impiegati[indiceImpiegato(cognome)].stampaInformazioni();
        System.out.println("");

    }

    public void stampaInformazioniGenerali() {
        for (int i = 0; i < cont; i++) {
            impiegati[i].stampaInformazioni();
            System.out.println("");
        }
    }

    public float mediaStipendiTot() {
        float tot = 0;
        for (int i = 0; i < cont; i++) {
            tot += impiegati[i].mediaStipendi();
        }
        return tot / cont;
    }

    public void mediaImpiegato(String cognome) {

        System.out.println("La media è di: " + impiegati[indiceImpiegato(cognome)].mediaStipendi());

    }

    public float totStipendiGenerali() {
        float tot = 0;
        for (int i = 0; i < cont; i++) {
            tot += impiegati[i].getTotStipendio();
        }
        return tot;
    }

    public void stipendioImpiegato(String cognome) {
        System.out.println("Lo stipendio totale è di: " + impiegati[indiceImpiegato(cognome)].getTotStipendio());
    }

    public boolean stampaPerRuolo(String ruolo) {
        int c = 0;
        for (int i = 0; i < cont; i++) {
            if (impiegati[i].getQualifica().equals(ruolo)) {
                impiegati[i].stampaInformazioni();
                c++;
            }
        }
        System.out.println("");
        if (c > 0) {
            return true;
        }
        return false;
    }

    private void scalaImpiegati() {
        for (int j = 0; j < impiegati.length; j++) {
            if (impiegati[j] == null) {
                for (int k = j; k < impiegati.length - 1; k++) {
                    if (impiegati[k + 1] != null) {
                        impiegati[k] = impiegati[k + 1];
                    }
                }
            }
        }
    }

    public void rimuoviImpiegato(String cognome) {
        impiegati[indiceImpiegato(cognome)] = null;
        scalaImpiegati();
        cont--;
        impiegati[cont] = null;

    }

}
