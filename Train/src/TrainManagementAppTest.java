import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class TrainManagementAppTest {

    private boolean validateSafety(List<GoodsBogie> bogies) {
        return bogies.stream()
                .allMatch(b ->
                        !b.getType().equalsIgnoreCase("Cylindrical") ||
                                b.getCargo().equalsIgnoreCase("Petroleum")
                );
    }

    @Test
    void testSafety_AllBogiesValid() {
        List<GoodsBogie> bogies = Arrays.asList(
                new GoodsBogie("G1", "Cylindrical", "Petroleum"),
                new GoodsBogie("G2", "Open", "Coal")
        );

        assertTrue(validateSafety(bogies));
    }

    @Test
    void testSafety_CylindricalWithInvalidCargo() {
        List<GoodsBogie> bogies = Arrays.asList(
                new GoodsBogie("G1", "Cylindrical", "Coal")
        );

        assertFalse(validateSafety(bogies));
    }

    @Test
    void testSafety_NonCylindricalBogiesAllowed() {
        List<GoodsBogie> bogies = Arrays.asList(
                new GoodsBogie("G1", "Open", "Coal"),
                new GoodsBogie("G2", "Box", "Grain")
        );

        assertTrue(validateSafety(bogies));
    }

    @Test
    void testSafety_MixedBogiesWithViolation() {
        List<GoodsBogie> bogies = Arrays.asList(
                new GoodsBogie("G1", "Cylindrical", "Petroleum"),
                new GoodsBogie("G2", "Cylindrical", "Coal") // invalid
        );

        assertFalse(validateSafety(bogies));
    }

    @Test
    void testSafety_EmptyBogieList() {
        List<GoodsBogie> bogies = new ArrayList<>();

        assertTrue(validateSafety(bogies)); // no violations
    }
}