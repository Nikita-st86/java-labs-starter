package edu.course.lab02;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProjectTaskTest {

    @Test
    void testCreateAndChangeStatus() {
        ProjectTask task = new ProjectTask("T1", "Fix bug", 10);
        task.changeStatus(TaskStatus.DONE);
        assertTrue(task.isCompleted());
    }

    @Test
    void testEmptyIdThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> new ProjectTask("", "Fix bug", 10));
    }
}
