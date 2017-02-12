package database.dao.jdbc;

import model.SchoolClass;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class ClassDao {

    private static final String SELECT_ALL = "SELECT * FROM class";

    public static Set<SchoolClass> getAllClasses() {
        return DataAccess.getAllEntities(SchoolClass.class, SELECT_ALL);
    }

    public static SchoolClass getClassById(int classId) {
        return DataAccess.getEntity(SchoolClass.class, SELECT_ALL + " WHERE id = " + classId);
    }
}
