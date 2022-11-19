package de.htwberlin.webtech.wiManager.web.api;

public class Student {

    private long id;
    private String vorname;
    private String name;

    private String email;

    private int matrikelNr;

    public Student(long id, String vorname, String name, String email, int matrikelNr) {
        this.id = id;
        this.vorname = vorname;
        this.name = name;
        this.email = email;
        this.matrikelNr = matrikelNr;
    }

    public Student() {

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

    public void setMatrikelNr(int matrikelNr) {
        this.matrikelNr = matrikelNr;
    }
}