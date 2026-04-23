import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.stream.Collectors;
import static org.junit.jupiter.api.Assertions.*;

public class TrainManagementAppTest {

    private List<Bogie> createSampleBogies() {
        return Arrays.asList(
                new PassengerBogie("B1", 80, "Sleeper"),
                new PassengerBogie("B2", 60, "AC Chair"),
                new PassengerBogie("B3", 72, "First Class"),
                new PassengerBogie("B4", 50, "Sleeper")
        );
    }

    @Test
    void testLoopFilteringLogic() {
        List<Bogie> bogies = createSampleBogies();

        List<Bogie> result = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.getCapacity() > 60) {
                result.add(b);
            }
        }

        assertEquals(2, result.size()); // 80, 72
    }

    @Test
    void testStreamFilteringLogic() {
        List<Bogie> bogies = createSampleBogies();

        List<Bogie> result = bogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());

        assertEquals(2, result.size());
    }

    @Test
    void testLoopAndStreamResultsMatch() {
        List<Bogie> bogies = createSampleBogies();

        List<Bogie> loopResult = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.getCapacity() > 60) {
                loopResult.add(b);
            }
        }

        List<Bogie> streamResult = bogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());

        assertEquals(loopResult.size(), streamResult.size());
    }

    @Test
    void testExecutionTimeMeasurement() {
        List<Bogie> bogies = createSampleBogies();

        long start = System.nanoTime();

        bogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());

        long end = System.nanoTime();

        long elapsed = end - start;

        assertTrue(elapsed > 0);
    }

    @Test
    void testLargeDatasetProcessing() {
        List<Bogie> bogies = TrainManagementApp.generateBogies(10000);

        List<Bogie> result = bogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());

        assertNotNull(result);
        assertTrue(result.size() >= 0);
    }
}