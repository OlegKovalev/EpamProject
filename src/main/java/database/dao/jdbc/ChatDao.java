package database.dao.jdbc;

import model.Chat;

import java.util.List;

public class ChatDao {

    public static final String SELECT_ALL = "SELECT * FROM chat";

    //not finished
    public static List<Chat> getAllMessagesForRecipient(int idRecipient) {
        return DataAccess.getAllEntities(Chat.class, SELECT_ALL + " WHERE recipient_id = " + idRecipient);
    }
}

 /*   public static void insertMessage(Chat newMark) {
        DataAccess.execute("INSERT INTO mark (lesson_id, student_id, day, mark) VALUES " +
                "(" + newMark.getLesson_id() + "," + newMark.getStudent_id() + "," + newMark.getDay() +
                "," + newMark.getMark() + ")");
    }*/

   /* public static Chat getMessage(int userId) {
        return DataAccess.getEntity(Chat.class, SELECT_ALL + " WHERE id = " + userId);
    }*/
