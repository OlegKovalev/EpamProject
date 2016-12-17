package database.dao.jdbc;

import model.SchoolClass;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class ClassDao {

    public static final String SELECT_ALL = "SELECT * FROM class";

    public static Set<SchoolClass> getAllClasses() {
//        List<SchoolClass> classList = DataAccess.getAllEntities(SchoolClass.class, SELECT_ALL);
        return DataAccess.getAllEntities(SchoolClass.class, SELECT_ALL);
//        return classSet;
    }

    public static SchoolClass getClassById(int classId) {
        return DataAccess.getEntity(SchoolClass.class, SELECT_ALL + " WHERE id = " + classId);
    }

    public static SchoolClass getClassByNumberAndPrefix(int number, String prefix) {
        return DataAccess.getEntity(SchoolClass.class, SELECT_ALL + " WHERE number = " + number +
                " AND prefix = '" + prefix + "'");
    }

    public static void insertClass(SchoolClass newClass) {
        DataAccess.execute("INSERT INTO class (number, prefix) VALUES " +
                "(" + newClass.getNumber() + ", '" + newClass.getPrefix() + "')");
    }
}
