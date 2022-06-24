package com.example.gestiondemaladies.persistance;

/**
 * Created by el ansari on 08/01/2017.
 */

public class maladie {

    private int code;
    private String nom;
    private String description;
    private String causes;
    private String symptomes;
    private String traitement;

    public maladie() {
    }

    public maladie(String nom, String description, String causes, String symptomes, String traitement) {
        this.nom = nom;
        this.description = description;
        this.causes = causes;
        this.symptomes = symptomes;
        this.traitement = traitement;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCauses() {
        return causes;
    }

    public void setCauses(String causes) {
        this.causes = causes;
    }

    public String getSymptomes() {
        return symptomes;
    }

    public void setSymptomes(String symptomes) {
        this.symptomes = symptomes;
    }

    public String getTraitement() {
        return traitement;
    }

    public void setTraitement(String traitement) {
        this.traitement = traitement;
    }
}
