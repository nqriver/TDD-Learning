package pl.myprojects.ddt.gradebook;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class SubjectTest {

    @Test
    public void shouldBeAbleToCreateSubject() {
        Subject subject = new Subject("biology");
        assertNotNull(subject);
    }

    @Test
    public void shouldBeAbleToComputeAverageNote() {
        Subject subject = new Subject("maths");
        subject.addGrade(4);
        subject.addGrade(5);
        assertEquals(4.5, subject.getAverage(), 0.001);
    }
}
