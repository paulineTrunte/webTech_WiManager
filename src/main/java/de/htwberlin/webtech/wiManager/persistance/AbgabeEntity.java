package de.htwberlin.webtech.wiManager.persistance;

import javax.persistence.*;
import java.util.Date;

@Entity (name = "abgabe")
public class AbgabeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Wert wir immer um 1 nach oben gezählt
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "semester", nullable = false)
    private int semester;

    @Column(name = "modulName", nullable = false)
    private String modulName;

    @Column(name = "frist", nullable = true)
    private Date frist;

    @Column(name = "notificationMessage", nullable = true)
    private String notificationMessage;


    public AbgabeEntity(int semester, String modulName, Date frist, String notificationMessage){
        this.semester = semester;
        this.modulName = modulName;
        this.frist = frist;
        this.notificationMessage = notificationMessage;
    }

    protected AbgabeEntity() {
    }

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public int getSemester() {return semester;}

    public void setSemester(int semester) {this.semester = semester;}

    public String getModulName() {return modulName;}

    public void setModulName(String modulName) {this.modulName = modulName;}

    public Date getFrist() {return frist;}

    public void setFrist(Date frist) {this.frist = frist;}

    public String getNotificationMessage() {return notificationMessage;}

    public void setNotificationMessage(String notificationMessage) {this.notificationMessage = notificationMessage;}
}
