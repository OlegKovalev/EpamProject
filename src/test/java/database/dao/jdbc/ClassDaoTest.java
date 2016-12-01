package database.dao.jdbc;


import model.SchoolClass;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class ClassDaoTest {

    ClassDao classDao;
    List<SchoolClass> listClasses;

    @Before
    public void setUp() throws Exception {
        classDao = new ClassDao();
        assertNotNull(classDao);
    }

    @Test
    public void getAllClasses() throws Exception {
        listClasses = new ArrayList<>(classDao.getAllClasses());
        assertTrue(listClasses.size() >= 4);
    }

    @Test
    public void getClassById() throws Exception {
        assertEquals(7, classDao.getClassById(1).getNumber());
        assertEquals("А", classDao.getClassById(2).getPrefix());
    }

    @Test
    public void getClassByNumberAndPrefix() throws Exception {
        SchoolClass obtainedSchoolClass = classDao.getClassByNumberAndPrefix(7, "Б");
        assertNotNull(obtainedSchoolClass);
        assertEquals(7, obtainedSchoolClass.getNumber());
        assertEquals("Б", obtainedSchoolClass.getPrefix());
    }

    @Ignore
    @Test
    public void insertClass() throws Exception {
        SchoolClass schoolClass = new SchoolClass();
        schoolClass.setId(1);
        schoolClass.setNumber(9);
        schoolClass.setPrefix("Д");
        
        classDao.insertClass(schoolClass);
        SchoolClass obtainedClass = classDao.getClassByNumberAndPrefix(schoolClass.getNumber(), schoolClass.getPrefix());
        
        assertEquals(9, obtainedClass.getNumber());
        assertEquals("Д", obtainedClass.getPrefix());
    }
}
