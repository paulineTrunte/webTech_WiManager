package de.htwberlin.webtech.wiManager.web.api;

import java.time.LocalDate;
import java.util.Date;

public class Abgabe {

    private long id;

    private int semester;

    private String modulName;

    private LocalDate frist;

    private String notificationMessage;


    public Abgabe(long id, int semester, String modulName, LocalDate frist, String notificationMessage){
        this.id = id;
        this.semester = semester;
        this.modulName = modulName;
        this.frist = frist;
        this.notificationMessage = notificationMessage;
    }

    public Abgabe(int semester, String modulName, LocalDate frist, String notificationMessage){
        this.id = id;
        this.semester = semester;
        this.modulName = modulName;
        this.frist = frist;
        this.notificationMessage = notificationMessage;
    }

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public int getSemester() { return semester; }

    public void setSemester(int semester) { this.semester = semester; }

    public String getModulName() { return modulName; }

    public void setModulName(String modulName) { this.modulName = modulName; }

    public LocalDate getFrist() { return frist; }

    public void setFrist(LocalDate frist) { this.frist = frist; }

    public String getNotificationMessage() { return notificationMessage; }

    public void setNotificationMessage(String notificationMessage) { this.notificationMessage = notificationMessage;  }

    @Override
    public String toString() {
        return "Abgabe{" +
                "id=" + id +
                ", semester=" + semester +
                ", modulName='" + modulName + '\'' +
                ", frist=" + frist +
                ", notificationMessage='" + notificationMessage + '\'' +
                '}';
    }

}
