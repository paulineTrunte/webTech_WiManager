package de.htwberlin.webtech.wiManager.persistance;

import javax.persistence.*;

@Entity(name = "students")
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id")
    private Long id;

    @Column(name= "vorname", nullable = false)
    private String vorname;

    @Column(name= "name", nullable = false)
    private String name;

    @Column(name= "matrikel_Nr", nullable = false)
    private int matrikelNr;

    @Column(name= "email", nullable = false)
    private String email;

    public StudentEntity(String vorname, String name, String email, int matrikelNr) {
        this.vorname = vorname;
        this.name = name;
        this.matrikelNr = this.matrikelNr;
        this.email = this.email;
    }

    protected StudentEntity(){}

    public long getId() {
        return id;
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

    public int getMatrikelNr() {
        return matrikelNr;
    }

    public void setMatrikelNr(int matrikelNr) {
        this.matrikelNr = matrikelNr;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
