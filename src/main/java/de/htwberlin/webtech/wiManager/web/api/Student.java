package de.htwberlin.webtech.wiManager.web.api;

public class Student {

    private long id;
    private String vorname;
    private String name;

    public Student(long id, String vorname, String name) {
        this.id = id;
        this.vorname = vorname;
        this.name = name;
    }
    public Student(){

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
}
