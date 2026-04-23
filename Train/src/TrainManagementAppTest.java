import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class TrainManagementAppTest {

    private List<Bogie> createSampleBogies() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new PassengerBogie("B1", 80, "Sleeper"));
        bogies.add(new PassengerBogie("B2", 60, "AC Chair"));
        bogies.add(new PassengerBogie("B3", 72, "First Class"));
        bogies.add(new PassengerBogie("B4", 50, "Sleeper"));
        return bogies;
    }

    @Test
    void testReduce_TotalSeatCalculation() {
        List<Bogie> bogies = createSampleBogies();

        int total = bogies.stream()
                .map(b -> b.getCapacity())
                .reduce(0, Integer::sum);

        assertEquals(80 + 60 + 72 + 50, total);
    }

    @Test
    void testReduce_MultipleBogiesAggregation() {
        List<Bogie> bogies = createSampleBogies();

        int total = bogies.stream()
                .map(b -> b.getCapacity())
                .reduce(0, Integer::sum);

        assertEquals(262, total);
    }

    @Test
    void testReduce_SingleBogieCapacity() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new PassengerBogie("B1", 90, "Sleeper"));

        int total = bogies.stream()
                .map(b -> b.getCapacity())
                .reduce(0, Integer::sum);

        assertEquals(90, total);
    }

    @Test
    void testReduce_EmptyBogieList() {
        List<Bogie> bogies = new ArrayList<>();

        int total = bogies.stream()
                .map(b -> b.getCapacity())
                .reduce(0, Integer::sum);

        assertEquals(0, total);
    }

    @Test
    void testReduce_CorrectCapacityExtraction() {
        List<Bogie> bogies = createSampleBogies();

        List<Integer> capacities = bogies.stream()
                .map(b -> b.getCapacity())
                .toList();

        assertTrue(capacities.containsAll(Arrays.asList(80, 60, 72, 50)));
    }

    @Test
    void testReduce_AllBogiesIncluded() {
        List<Bogie> bogies = createSampleBogies();

        int total = bogies.stream()
                .map(b -> b.getCapacity())
                .reduce(0, Integer::sum);

        int manualSum = 0;
        for (Bogie b : bogies) {
            manualSum += b.getCapacity();
        }

        assertEquals(manualSum, total);
    }

    @Test
    void testReduce_OriginalListUnchanged() {
        List<Bogie> bogies = createSampleBogies();
        int originalSize = bogies.size();

        int total = bogies.stream()
                .map(b -> b.getCapacity())
                .reduce(0, Integer::sum);

        assertEquals(originalSize, bogies.size());
        assertEquals(4, bogies.size());
    }
}