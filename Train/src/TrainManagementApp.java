import java.util.regex.*;

public class TrainManagementApp {

    // Regex patterns
    private static final String TRAIN_ID_REGEX = "TRN-\\d{4}";
    private static final String CARGO_CODE_REGEX = "PET-[A-Z]{2}";

    public static void main(String[] args) {

        String trainId = "TRN-1234";
        String cargoCode = "PET-AB";

        boolean isTrainValid = validateTrainId(trainId);
        boolean isCargoValid = validateCargoCode(cargoCode);

        System.out.println("Train ID: " + trainId + " -> " + (isTrainValid ? "Valid" : "Invalid"));
        System.out.println("Cargo Code: " + cargoCode + " -> " + (isCargoValid ? "Valid" : "Invalid"));
    }

    // Validate Train ID
    public static boolean validateTrainId(String trainId) {
        if (trainId == null || trainId.isEmpty()) return false;

        Pattern pattern = Pattern.compile(TRAIN_ID_REGEX);
        Matcher matcher = pattern.matcher(trainId);

        return matcher.matches();
    }

    // Validate Cargo Code
    public static boolean validateCargoCode(String cargoCode) {
        if (cargoCode == null || cargoCode.isEmpty()) return false;

        Pattern pattern = Pattern.compile(CARGO_CODE_REGEX);
        Matcher matcher = pattern.matcher(cargoCode);

        return matcher.matches();
    }
}