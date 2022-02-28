/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progimpiegati;

/**
 *
 * @author Studente
 */
public class Impiegato extends Persona {

    private int nStipendi;
    private String qualifica;
    private float totStipendio;

    public Impiegato() {
        super(null, null, 0);
        this.nStipendi = 0;
        this.totStipendio = 0;
    }

    
    public Impiegato(String qualifica, String nome, String cognome, int annoNascita) {
        super(nome, cognome, annoNascita);
        this.nStipendi = 0;
        this.qualifica = qualifica;
        this.totStipendio = 0;
    }

    public float mediaStipendi() {
        if(nStipendi == 0){
            return 0;
        }
        return totStipendio / nStipendi;
    }

    public void aggiungiStipendio(float stipendio) {
        this.totStipendio += stipendio;
        nStipendi++;
    }

    public int getnStipendi() {
        return nStipendi;
    }

    public String getQualifica() {
        return qualifica;
    }

    public void setQualifica(String qualifica) {
        this.qualifica = qualifica;
    }

    public float getTotStipendio() {
        return totStipendio;
    }

    @Override
    public void stampaInformazioni() {
        System.out.println("Impiegato " + getNome() + " " + getCognome() + ": ");
        System.out.println("Ruolo: " + getQualifica() + " Media Stipendi: " + mediaStipendi());
        System.out.println("Numero stipendi: " + nStipendi + " Totale: " + totStipendio);
    }

}
