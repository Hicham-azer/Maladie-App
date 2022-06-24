package com.example.gestiondemaladies.persistance;

/**
 * Created by el ansari on 08/01/2017.
 */

public class docteur {

    private int id;
    private String login;
    private String password;

    public docteur() {
    }

    public docteur(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

