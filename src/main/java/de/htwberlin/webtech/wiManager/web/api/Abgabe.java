package de.htwberlin.webtech.wiManager.web.api;

import java.util.Date;

public class Abgabe {

    private long id;

    private int semester;

    private String modulName;

    private Date frist;

    private String notificationMessage;


    public Abgabe(long id, int semester, String modulName, Date frist, String notificationMessage){
        this.id = id;
        this.semester = semester;
        this.modulName = modulName;
        this.frist = frist;
        this.notificationMessage = notificationMessage;
    }

    public Abgabe(){}

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public int getSemester() { return semester; }

    public void setSemester(int semester) { this.semester = semester; }

    public String getModulName() { return modulName; }

    public void setModulName(String modulName) { this.modulName = modulName; }

    public Date getFrist() { return frist; }

    public void setFrist(Date frist) { this.frist = frist; }

    public String getNotificationMessage() { return notificationMessage; }

    public void setNotificationMessage(String notificationMessage) { this.notificationMessage = notificationMessage;  }

}
