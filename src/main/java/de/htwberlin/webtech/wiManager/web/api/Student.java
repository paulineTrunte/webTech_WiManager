package de.htwberlin.webtech.wiManager.web.api;

import java.util.List;

public class Student {

    private long id;
    private String vorname;
    private String name;
    private String email;

    private String password;
    private int matrikelNr;

    private List<Long> modulesBelegt;

    private List<Long> modulesBestanden;

    private double notenDurchschnitt;


    public Student(long id, String vorname, String name, int matrikelNr, String email, String password,
                   double notenDurchschnitt, List<Long> moduleIdsBelegt, List<Long> moduleIdsBestanden) {
        this.id = id;
        this.vorname = vorname;
        this.name = name;
        this.email = email;
        this.matrikelNr = this.matrikelNr;
        this.password = password;
        this.notenDurchschnitt = notenDurchschnitt;
        this.modulesBelegt = moduleIdsBelegt;
        this.modulesBestanden = moduleIdsBestanden;
    }

    public Student(long id, String vorname, String name, String email, String password, int matrikelNr, double notenDurchschnitt) {
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

    public List<Long> getModulesBelegt() { return modulesBelegt; }

    public void setModulesBelegt(List<Long> modulesBelegt) { this.modulesBelegt = modulesBelegt; }

    public List<Long> getModulesBestanden() { return modulesBestanden; }

    public void setModulesBestanden(List<Long> modulesBestanden) { this.modulesBestanden = modulesBestanden;}

    public double getNotenDurchschnitt() { return notenDurchschnitt; }

    public void setNotenDurchschnitt(double notenDurchschnitt) { this.notenDurchschnitt = notenDurchschnitt; }
}
