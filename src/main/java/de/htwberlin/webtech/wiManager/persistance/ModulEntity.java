package de.htwberlin.webtech.wiManager.persistance;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "modules")
public class ModulEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Wert wir immer um 1 nach oben gezählt
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "modul name", nullable = false)
    private String modulName;

    @Column(name = "semester", nullable = true)
    private int semester;

    @Column(name = "art", nullable = false)
    private String art;

    @Column(name = "form", nullable = true)
    private String form;

    @Column(name = "sws", nullable = true)
    private String sws;

    @Column(name = "lp", nullable = false)
    private int lp;

    @Column(name = "belegt", nullable = true)
    private boolean belegt;

    @Column(name = "bestanden", nullable = true)
    private boolean bestanden;



    public ModulEntity(String modulName, int semester, String art, String form, String sws, int lp,
                       boolean belegt, boolean bestanden) {
        this.modulName = modulName;
        this.semester = semester;
        this.art = art;
        this.form = form;
        this.sws = sws;
        this.lp = lp;
        this.belegt = belegt;
        this.bestanden = bestanden;
    }

    protected ModulEntity() {
    }


    public Long getId() {
        return id;
    }

    public String getModulName() {
        return modulName;
    }

    public void setModulName(String modulName) {
        this.modulName = modulName;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getArt() {
        return art;
    }

    public void setArt(String art) {
        this.art = art;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public String getSws() {
        return sws;
    }

    public void setSws(String sws) {
        this.sws = sws;
    }

    public int getLp() {
        return lp;
    }

    public void setLp(int lp) {
        this.lp = lp;
    }

    public boolean isBelegt() {return belegt;}

    public void setBelegt(boolean belegt) {this.belegt = belegt;}

    public boolean isBestanden() {return bestanden;}

    public void setBestanden(boolean bestanden) {this.bestanden = bestanden;}
}
