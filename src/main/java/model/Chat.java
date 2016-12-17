package model;

import java.util.Date;

public class Chat implements Comparable {

    private int id;
    private int sender_id;
    private int recipient_id;

    private int message;

    private Date date;

    public void setId(int id) {
        this.id = id;
    }

    public void setSender_id(int sender_id) {
        this.sender_id = sender_id;
    }

    public void setRecipient_id(int recipient_id) {
        this.recipient_id = recipient_id;
    }

    public void setMessage(int message) {
        this.message = message;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public int getSender_id() {
        return sender_id;
    }

    public int getRecipient_id() {
        return recipient_id;
    }

    public int getMessage() {
        return message;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public int compareTo(Object o) {
        Chat chat = (Chat) o;

        long result = date.getTime() - chat.date.getTime();
        if (result != 0) {
            return (int) (result / Math.abs(result));
        }
        return 0;
    }
}
