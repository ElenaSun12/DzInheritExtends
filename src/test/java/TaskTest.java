import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @Test
    public void testSimpleMathes() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean actual = simpleTask.matches("Позвонить");
        Assertions.assertTrue(actual);
    }

    @Test
    public void testSimpleNotMathes() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean actual = simpleTask.matches("Написать");
        Assertions.assertFalse(actual);
    }

    @Test
    public void testEpicMathes() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        boolean actual = epic.matches("Яйца");
        Assertions.assertTrue(actual);
    }

    @Test
    public void testEpicNotMathes() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        boolean actual = epic.matches("Зелень");
        Assertions.assertFalse(actual);
    }

    @Test
    void testMatchesTopic() {
        Meeting meeting = new Meeting(1, "Рабочая встреча", "Проект X", "2024-05-20");
        Assertions.assertTrue(meeting.matches("Рабочая"));
    }

    @Test
    void testMatchesProject() {
        Meeting meeting = new Meeting(2, "Рабочая встреча", "Проект X", "2024-05-20");
        Assertions.assertTrue(meeting.matches("Проект"));
    }

    @Test
    void testNoMatch() {
        Meeting meeting = new Meeting(6, "Рабочая встреча", "Проект X", "2024-05-20");
        Assertions.assertFalse(meeting.matches("Прогулка"));
    }
}
