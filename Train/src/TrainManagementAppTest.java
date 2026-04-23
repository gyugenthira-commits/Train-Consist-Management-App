import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrainManagementAppTest {

    @Test
    void testCargo_SafeAssignment() {
        GoodsBogie b = new GoodsBogie("G1", "Cylindrical");
        b.assignCargo("Petroleum");

        assertEquals("Petroleum", b.getCargo());
    }

    @Test
    void testCargo_UnsafeAssignmentHandled() {
        GoodsBogie b = new GoodsBogie("G1", "Rectangular");
        b.assignCargo("Petroleum");

        assertNull(b.getCargo());
    }

    @Test
    void testCargo_CargoNotAssignedAfterFailure() {
        GoodsBogie b = new GoodsBogie("G1", "Rectangular");
        b.assignCargo("Petroleum");

        assertNull(b.getCargo());
    }

    @Test
    void testCargo_ProgramContinuesAfterException() {
        GoodsBogie b = new GoodsBogie("G1", "Rectangular");

        b.assignCargo("Petroleum"); // fails
        b.assignCargo("Coal");      // should succeed

        assertEquals("Coal", b.getCargo());
    }

    @Test
    void testCargo_FinallyBlockExecution() {
        GoodsBogie b = new GoodsBogie("G1", "Rectangular");

        assertDoesNotThrow(() -> {
            b.assignCargo("Petroleum");
        });
    }
}