package model;

public class Chat {

    private int id;
    private int idSender;
    private int idRecipient;

    public Chat(int id, int idSender, int idRecipient) {
        this.id = id;
        this.idSender = idSender;
        this.idRecipient = idRecipient;
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
}
