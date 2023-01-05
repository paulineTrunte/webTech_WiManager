package de.htwberlin.webtech.wiManager.web.api;

import java.time.LocalDate;

public class AbgabeCreateOrUpdateRequest {

    private long id;

    private int semester;

    private String modulName;

    private LocalDate frist;

    private String notificationMessage;

    public AbgabeCreateOrUpdateRequest(int semester, String modulName, LocalDate frist, String notificationMessage){
        this.semester = semester;
        this.modulName = modulName;
        this.frist = frist;
        this.notificationMessage = notificationMessage;
    }

    public AbgabeCreateOrUpdateRequest(){}

    public int getSemester() {return semester;}

    public void setSemester(int semester) {this.semester = semester;}

    public String getModulName() {return modulName;}

    public void setModulName(String modulName) {this.modulName = modulName;}

    public LocalDate getFrist() {return frist;}

    public void setFrist(LocalDate frist) {this.frist = frist;}

    public String getNotificationMessage() {return notificationMessage;}

    public void setNotificationMessage(String notificationMessage) {this.notificationMessage = notificationMessage;}
}
