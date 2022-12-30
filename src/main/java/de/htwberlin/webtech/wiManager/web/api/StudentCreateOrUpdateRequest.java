package de.htwberlin.webtech.wiManager.web.api;

public class StudentCreateOrUpdateRequest {

    private String vorname;
    private String name;

    private String email;

    private int matrikelNr;

    private String password;


    public StudentCreateOrUpdateRequest(String vorname, String name, String email, String password,
                                        int matrikelNr) {
        this.vorname = vorname;
        this.name = name;
        this.email = email;
        this.password = password;
        this.matrikelNr = matrikelNr;
    }

    public StudentCreateOrUpdateRequest(){}

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

    public String getPassword() {return password;}

    public void setPassword(String password) {this.password = password;}

    public int getMatrikelNr() {
        return matrikelNr;
    }

    public void setMatrikelNr(int matrikelNr) {
        this.matrikelNr = matrikelNr;
    }
}
