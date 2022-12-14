package de.htwberlin.webtech.wiManager.web.api;

public class ModulCreateOrUpdateRequest {

    private String modulName;
    private int semester;
    private String art;
    private String form;
    private String sws;
    private int lp;
    private boolean belegt;
    private boolean bestanden;



    public ModulCreateOrUpdateRequest(String modulName, int semester, String art, String form, String sws, int lp,
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

    public ModulCreateOrUpdateRequest() {}

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

    public boolean isBelegt() { return belegt; }

    public void setBelegt(boolean belegt) { this.belegt = belegt; }

    public boolean isBestanden() { return bestanden; }

    public void setBestanden(boolean bestanden) { this.bestanden = bestanden; }
}
