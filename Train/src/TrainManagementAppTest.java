import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.stream.Collectors;
import static org.junit.jupiter.api.Assertions.*;

public class TrainManagementAppTest {

    private List<Bogie> createSampleBogies() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new PassengerBogie("B1", 80, "Sleeper"));
        bogies.add(new PassengerBogie("B2", 60, "AC Chair"));
        bogies.add(new PassengerBogie("B3", 72, "First Class"));
        bogies.add(new PassengerBogie("B4", 50, "Sleeper"));
        bogies.add(new PassengerBogie("B5", 65, "AC Chair"));
        return bogies;
    }

    @Test
    void testGrouping_BogiesGroupedByType() {
        List<Bogie> bogies = createSampleBogies();

        Map<String, List<Bogie>> result = bogies.stream()
                .collect(Collectors.groupingBy(Bogie::getType));

        assertTrue(result.containsKey("Sleeper"));
        assertTrue(result.containsKey("AC Chair"));
        assertTrue(result.containsKey("First Class"));
    }

    @Test
    void testGrouping_MultipleBogiesInSameGroup() {
        List<Bogie> bogies = createSampleBogies();

        Map<String, List<Bogie>> result = bogies.stream()
                .collect(Collectors.groupingBy(Bogie::getType));

        assertEquals(2, result.get("Sleeper").size());
        assertEquals(2, result.get("AC Chair").size());
    }

    @Test
    void testGrouping_DifferentBogieTypes() {
        List<Bogie> bogies = createSampleBogies();

        Map<String, List<Bogie>> result = bogies.stream()
                .collect(Collectors.groupingBy(Bogie::getType));

        assertEquals(3, result.keySet().size());
    }

    @Test
    void testGrouping_EmptyBogieList() {
        List<Bogie> bogies = new ArrayList<>();

        Map<String, List<Bogie>> result = bogies.stream()
                .collect(Collectors.groupingBy(Bogie::getType));

        assertTrue(result.isEmpty());
    }

    @Test
    void testGrouping_SingleBogieCategory() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new PassengerBogie("B1", 80, "Sleeper"));
        bogies.add(new PassengerBogie("B2", 70, "Sleeper"));

        Map<String, List<Bogie>> result = bogies.stream()
                .collect(Collectors.groupingBy(Bogie::getType));

        assertEquals(1, result.size());
        assertTrue(result.containsKey("Sleeper"));
    }

    @Test
    void testGrouping_MapContainsCorrectKeys() {
        List<Bogie> bogies = createSampleBogies();

        Map<String, List<Bogie>> result = bogies.stream()
                .collect(Collectors.groupingBy(Bogie::getType));

        assertTrue(result.keySet().containsAll(
                Arrays.asList("Sleeper", "AC Chair", "First Class")
        ));
    }

    @Test
    void testGrouping_GroupSizeValidation() {
        List<Bogie> bogies = createSampleBogies();

        Map<String, List<Bogie>> result = bogies.stream()
                .collect(Collectors.groupingBy(Bogie::getType));

        assertEquals(2, result.get("Sleeper").size());
        assertEquals(2, result.get("AC Chair").size());
        assertEquals(1, result.get("First Class").size());
    }

    @Test
    void testGrouping_OriginalListUnchanged() {
        List<Bogie> bogies = createSampleBogies();
        int originalSize = bogies.size();

        Map<String, List<Bogie>> result = bogies.stream()
                .collect(Collectors.groupingBy(Bogie::getType));

        assertEquals(originalSize, bogies.size());
        assertEquals(5, bogies.size());
    }
}