import java.util.Arrays;

public class TrainManagementApp {

    public static void main(String[] args) {

        String[] bogieIds = {"BG309","BG101","BG550","BG205","BG412"};
        String searchKey = "BG205";

        boolean found = binarySearch(bogieIds, searchKey);

        System.out.println(found ? "Bogie found: " + searchKey
                : "Bogie not found: " + searchKey);
    }

    public static boolean binarySearch(String[] arr, String key) {

        if (arr == null || arr.length == 0) return false;

        Arrays.sort(arr);

        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            int cmp = key.compareTo(arr[mid]);

            if (cmp == 0) return true;
            else if (cmp < 0) high = mid - 1;
            else low = mid + 1;
        }

        return false;
    }
}