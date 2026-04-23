import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class TrainManagementAppTest {

    @Test
    void testException_ValidCapacityCreation() {
        assertDoesNotThrow(() -> {
            PassengerBogie b = new PassengerBogie("B1", 80, "Sleeper");
            assertEquals(80, b.getCapacity());
        });
    }

    @Test
    void testException_NegativeCapacityThrowsException() {
        Exception exception = assertThrows(InvalidCapacityException.class, () -> {
            new PassengerBogie("B1", -10, "Sleeper");
        });

        assertEquals("Capacity must be greater than zero", exception.getMessage());
    }

    @Test
    void testException_ZeroCapacityThrowsException() {
        assertThrows(InvalidCapacityException.class, () -> {
            new PassengerBogie("B1", 0, "Sleeper");
        });
    }

    @Test
    void testException_ExceptionMessageValidation() {
        Exception exception = assertThrows(InvalidCapacityException.class, () -> {
            new PassengerBogie("B1", -5, "Sleeper");
        });

        assertEquals("Capacity must be greater than zero", exception.getMessage());
    }

    @Test
    void testException_ObjectIntegrityAfterCreation() throws InvalidCapacityException {
        PassengerBogie b = new PassengerBogie("B1", 90, "AC Chair");

        assertEquals("B1", b.getId());
        assertEquals(90, b.getCapacity());
        assertEquals("AC Chair", b.getCategory());
    }

    @Test
    void testException_MultipleValidBogiesCreation() {
        assertDoesNotThrow(() -> {
            PassengerBogie b1 = new PassengerBogie("B1", 70, "Sleeper");
            PassengerBogie b2 = new PassengerBogie("B2", 60, "AC Chair");
            PassengerBogie b3 = new PassengerBogie("B3", 100, "First Class");

            assertNotNull(b1);
            assertNotNull(b2);
            assertNotNull(b3);
        });
    }
}