public class TrainManagementApp {

    public static void main(String[] args) {

        String[] bogieIds = {"BG101","BG205","BG309"};
        String searchKey = "BG205";

        boolean found = searchBogie(bogieIds, searchKey);

        System.out.println(found ? "Bogie found" : "Bogie not found");
    }

    public static boolean searchBogie(String[] arr, String key) {

        if (arr == null || arr.length == 0) {
            throw new IllegalStateException("No bogies available for search");
        }

        for (String id : arr) {
            if (id.equals(key)) {
                return true;
            }
        }

        return false;
    }
}