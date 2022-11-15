package de.htwberlin.webtech.wiManager.web.api;

public class StudentCreateOrUpdateRequest {

    private String vorname;
    private String name;

    public StudentCreateOrUpdateRequest(String vorname, String name) {
        this.vorname = vorname;
        this.name = name;
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
