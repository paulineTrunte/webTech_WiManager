package de.htwberlin.webtech.wiManager.web.api;

import java.util.List;

public class Student {

    private long id;
    private String vorname;
    private String name;
    private String email;
    private String password;
    private int matrikelNr;



    public Student(long id, String vorname, String name,String email, String password, int matrikelNr) {
        this.id = id;
        this.vorname = vorname;
        this.name = name;
        this.email = email;
        this.matrikelNr = matrikelNr;
        this.password = password;
    }

    public Student(long id, String vorname, String name, int email, String password, String matrikelNr, List<Long> notenDurchschnitt, List<Long> lpGesamt) {
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getMatrikelNr() {
        return matrikelNr;
    }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public void setMatrikelNr(int matrikelNr) {
        this.matrikelNr = matrikelNr;
    }
}
