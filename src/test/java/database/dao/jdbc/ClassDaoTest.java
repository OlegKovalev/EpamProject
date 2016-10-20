package database.dao.jdbc;

import model.SchoolClass;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ClassDaoTest {

    ClassDao classDao;
    List<SchoolClass> listClasses;

    @Before
    public void setUp() throws Exception {
        classDao = new ClassDao();
    }

    @Test
    public void getAllClasses() throws Exception {
        listClasses = new ArrayList<>(classDao.getAllClasses());
        assertTrue(listClasses.size() >= 5);
    }

    @Test
    public void getClassById() throws Exception {
        assertEquals(7, classDao.getClassById(1).getNumber());
        assertEquals("А", classDao.getClassById(2).getPrefix());
    }

    @Test
    public void getClassByNumberAndPrefix() throws Exception {
        SchoolClass obtainedSchoolClass = classDao.getClassByNumberAndPrefix(7, "Б");
        assertEquals(7, obtainedSchoolClass.getNumber());
        assertEquals("Б", obtainedSchoolClass.getPrefix());
    }

    @Test
    public void insertClass() throws Exception {
        SchoolClass schoolClass = new SchoolClass(1, 9, "Д");
        classDao.insertClass(schoolClass);
        SchoolClass obtainedClass = classDao.getClassByNumberAndPrefix(schoolClass.getNumber(), schoolClass.getPrefix());
        
        assertEquals(9, obtainedClass.getNumber());
        assertEquals("Д", obtainedClass.getPrefix());
    }
}
