package model;

import java.util.Date;

public class Chat {

    private int id;
    private int idSender;
    private int idRecipient;
    private Date date;

    /*public Chat(int id, int idSender, int idRecipient, Date date) {
        this.id = id;
        this.idSender = idSender;
        this.idRecipient = idRecipient;
        this.date = date;
    }*/

    public void setId(int id) {
        this.id = id;
    }

    public void setIdSender(int idSender) {
        this.idSender = idSender;
    }

    public void setIdRecipient(int idRecipient) {
        this.idRecipient = idRecipient;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public int getIdSender() {
        return idSender;
    }

    public int getIdRecipient() {
        return idRecipient;
    }

    public Date getDate() {
        return date;
    }
}
