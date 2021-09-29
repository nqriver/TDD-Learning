package pl.myprojects.ddt.gradebook;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

public class GradeBookTest {

    private static final String SUBJECT = "mathematics";
    private static final String OTHER_SUBJECT = "physics";

    private GradeBook gradeBook;

    @BeforeEach
    void setUp() {
        gradeBook = new GradeBook();
        gradeBook.addSubject(SUBJECT);
    }

    @Test
    public void shouldBeAbleToCreateGradeBook() {
        var gradeBook = new GradeBook();
        gradeBook.addSubject(SUBJECT);
        assertNotNull(gradeBook);
    }

    @Test
    public void shouldntAllowToAddExistingSubject() {
        assertThrows(IllegalArgumentException.class, () -> gradeBook.addSubject(SUBJECT));
    }

    @Test
    public void shouldntAllowToGetNonexistentSubject() {
        assertThrows(IllegalArgumentException.class, () -> gradeBook.getSubject(OTHER_SUBJECT));
    }

    @Test
    public void shouldGetExistingSubject() {
        var retrievedSubject = gradeBook.getSubject("mathematics");
        assertEquals(retrievedSubject.getName(), SUBJECT);
    }

    @Test
    void shouldAddGrade() {
        gradeBook.addSubject(OTHER_SUBJECT);
        gradeBook.addGrade(OTHER_SUBJECT, 2.5);
    }

    @Test
    void shouldntAllowToAddGradeToNonexistentSubject() {
        GradeBook newGradeBook = new GradeBook();
        assertThrows(IllegalArgumentException.class, () -> newGradeBook.addGrade(OTHER_SUBJECT, 2));
    }

    @Test
    void shouldComputeGlobalAverageGrade() {
        gradeBook.addSubject(OTHER_SUBJECT);
        gradeBook.addGrade(OTHER_SUBJECT, 2);
        gradeBook.addGrade(OTHER_SUBJECT, 4);
        gradeBook.addGrade(SUBJECT, 6);
        gradeBook.addGrade(SUBJECT, 1);
        gradeBook.addGrade(SUBJECT, 5);
        gradeBook.addGrade(SUBJECT, 2);
        gradeBook.addGrade(SUBJECT, 2);

        var globalAverage = gradeBook.getAverageGradeFromAllSubjects();
        assertEquals(3.1, globalAverage, 0.001);
    }



    @Test
    void shouldComputeGlobalAverageGrade_2() {
        gradeBook.addSubject(OTHER_SUBJECT);
        gradeBook.addGrade(OTHER_SUBJECT, 2);
        gradeBook.addGrade(OTHER_SUBJECT, 4);
        gradeBook.addGrade(OTHER_SUBJECT, 1);
        gradeBook.addGrade(SUBJECT, 3);
        gradeBook.addGrade(SUBJECT, 6);
        gradeBook.addGrade(SUBJECT, 1);

        var globalAverage = gradeBook.getAverageGradeFromAllSubjects();
        assertEquals(2.833, globalAverage, 0.001);
    }
}
