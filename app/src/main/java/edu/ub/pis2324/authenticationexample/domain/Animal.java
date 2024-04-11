package edu.ub.pis2324.authenticationexample.domain;

public class Animal {

    private String nom;
    private String raza;
    private int edat;
    private float pes;
    private float mida;

    public Animal(String nom, String raza, int edat, float pes, float mida) {
        this.nom = nom;
        this.raza = raza;
        this.edat = edat;
        this.pes = pes;
        this.mida = mida;
    }

    public Animal() { }

    public String getNom() {
        return nom;
    }

    public String getRaza() {
        return raza;
    }

    public int getEdat() {
        return edat;
    }

    public float getPes() {
        return pes;
    }

    public float getMida() {
        return mida;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public void setEdat(int edat) {
        this.edat = edat;
    }

    public void setPes(float pes) {
        this.pes = pes;
    }

    public void setMida(float mida) {
        this.mida = mida;
    }
    

}
