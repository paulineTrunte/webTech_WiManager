package de.htwberlin.webtech.wiManager.persistance;

import javax.persistence.*;

@Entity(name = "students")
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id")
    private long id;

    @Column(name= "vorname", nullable = false)
    private String vorname;

    @Column(name= "name", nullable = false)
    private String name;

    public StudentEntity(String vorname, String name) {
        this.vorname = vorname;
        this.name = name;
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
}
