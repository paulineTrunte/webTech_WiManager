package de.htwberlin.webtech.wiManager.web.api;

public class StudentCreateOrUpdateRequest {

    private String vorname;
    private String name;

    private String email;

    private int matrikelNr;

    private String password;

    private double notenDurchschnitt;

    private int lpGesamt;

    public StudentCreateOrUpdateRequest(String vorname, String name, String email, String password,
                                        int matrikelNr, double notenDurchschnitt, int lpGesamt) {
        this.vorname = vorname;
        this.name = name;
        this.email = email;
        this.password = password;
        this.matrikelNr = matrikelNr;
        this.notenDurchschnitt = notenDurchschnitt;
        this.lpGesamt = lpGesamt;
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

    public double getNotenDurchschnitt(){ return notenDurchschnitt;}

    public void setNotenDurchschnitt(double notenDurchschnitt){ this.notenDurchschnitt = notenDurchschnitt;}

    public int getLpGesamt() {return lpGesamt;}

    public void setLpGesamt(int lpGesamt){ this.lpGesamt = lpGesamt;}
}
