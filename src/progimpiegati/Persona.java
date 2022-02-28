/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progimpiegati;

/**
 *
 * @author Matteo
 */
public class Persona {

    private String nome;
    private String cognome;
    private int annoNascita;

    public Persona(String nome, String cognome, int annoNascita) {
        this.nome = nome;
        this.cognome = cognome;
        this.annoNascita = annoNascita;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public int getAnnoNascita() {
        return annoNascita;
    }

    public void setAnnoNascita(int annoNascita) {
        this.annoNascita = annoNascita;
    }

    public int calcolaAnni() {
        return 2022 - annoNascita;
    }

    public void stampaInformazioni() {
        System.out.println("Nome: " + nome + " Cognome: " + cognome + " Anno Nascita: " + annoNascita);
    }
}
