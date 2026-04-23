import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrainManagementAppTest {

    @Test
    void testRegex_ValidTrainID() {
        assertTrue(TrainManagementApp.validateTrainId("TRN-1234"));
    }

    @Test
    void testRegex_InvalidTrainIDFormat() {
        assertFalse(TrainManagementApp.validateTrainId("TRAIN12"));
        assertFalse(TrainManagementApp.validateTrainId("TRN12A"));
        assertFalse(TrainManagementApp.validateTrainId("1234-TRN"));
    }

    @Test
    void testRegex_ValidCargoCode() {
        assertTrue(TrainManagementApp.validateCargoCode("PET-AB"));
    }

    @Test
    void testRegex_InvalidCargoCodeFormat() {
        assertFalse(TrainManagementApp.validateCargoCode("PET-ab"));
        assertFalse(TrainManagementApp.validateCargoCode("PET123"));
        assertFalse(TrainManagementApp.validateCargoCode("AB-PET"));
    }

    @Test
    void testRegex_TrainIDDigitLengthValidation() {
        assertFalse(TrainManagementApp.validateTrainId("TRN-123"));
        assertFalse(TrainManagementApp.validateTrainId("TRN-12345"));
    }

    @Test
    void testRegex_CargoCodeUppercaseValidation() {
        assertFalse(TrainManagementApp.validateCargoCode("PET-Ab"));
        assertFalse(TrainManagementApp.validateCargoCode("PET-aB"));
    }

    @Test
    void testRegex_EmptyInputHandling() {
        assertFalse(TrainManagementApp.validateTrainId(""));
        assertFalse(TrainManagementApp.validateCargoCode(""));
    }

    @Test
    void testRegex_ExactPatternMatch() {
        assertFalse(TrainManagementApp.validateTrainId("TRN-1234X"));
        assertFalse(TrainManagementApp.validateCargoCode("PET-ABC"));
    }
}