import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class TrainManagementAppTest {

    private List<Bogie> createSampleBogies() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new PassengerBogie("B1", 80, "Sleeper"));
        bogies.add(new PassengerBogie("B2", 70, "AC Chair"));
        bogies.add(new PassengerBogie("B3", 60, "First Class"));
        bogies.add(new PassengerBogie("B4", 50, "Sleeper"));
        return bogies;
    }

    @Test
    void testFilter_CapacityGreaterThanThreshold() {
        List<Bogie> bogies = createSampleBogies();

        List<Bogie> result = bogies.stream()
                .filter(b -> b.getCapacity() > 70)
                .collect(Collectors.toList());

        assertEquals(1, result.size());
        assertEquals(80, result.get(0).getCapacity());
    }

    @Test
    void testFilter_CapacityEqualToThreshold() {
        List<Bogie> bogies = createSampleBogies();

        List<Bogie> result = bogies.stream()
                .filter(b -> b.getCapacity() > 70)
                .collect(Collectors.toList());

        // 70 should NOT be included
        assertFalse(result.stream().anyMatch(b -> b.getCapacity() == 70));
    }

    @Test
    void testFilter_CapacityLessThanThreshold() {
        List<Bogie> bogies = createSampleBogies();

        List<Bogie> result = bogies.stream()
                .filter(b -> b.getCapacity() > 70)
                .collect(Collectors.toList());

        assertFalse(result.stream().anyMatch(b -> b.getCapacity() < 70));
    }

    @Test
    void testFilter_MultipleBogiesMatching() {
        List<Bogie> bogies = createSampleBogies();

        List<Bogie> result = bogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());

        assertEquals(2, result.size()); // 80 and 70
    }

    @Test
    void testFilter_NoBogiesMatching() {
        List<Bogie> bogies = createSampleBogies();

        List<Bogie> result = bogies.stream()
                .filter(b -> b.getCapacity() > 100)
                .collect(Collectors.toList());

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_AllBogiesMatching() {
        List<Bogie> bogies = createSampleBogies();

        List<Bogie> result = bogies.stream()
                .filter(b -> b.getCapacity() > 40)
                .collect(Collectors.toList());

        assertEquals(bogies.size(), result.size());
    }

    @Test
    void testFilter_EmptyBogieList() {
        List<Bogie> bogies = new ArrayList<>();

        List<Bogie> result = bogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_OriginalListUnchanged() {
        List<Bogie> bogies = createSampleBogies();
        int originalSize = bogies.size();

        List<Bogie> result = bogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());

        assertEquals(originalSize, bogies.size());
        assertEquals(4, bogies.size()); // unchanged
    }
}