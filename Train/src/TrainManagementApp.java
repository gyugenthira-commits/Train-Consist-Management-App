import java.util.*;
import java.util.stream.Collectors;

public class TrainManagementApp {

    public static void main(String[] args) {

        List<Bogie> bogies = new ArrayList<>();

        // Sample data (reuse from UC7)
        bogies.add(new PassengerBogie("B1", 80, "Sleeper"));
        bogies.add(new PassengerBogie("B2", 60, "AC Chair"));
        bogies.add(new PassengerBogie("B3", 72, "First Class"));
        bogies.add(new PassengerBogie("B4", 50, "Sleeper"));

        int threshold = 60;

        // UC8: Stream Filtering
        List<Bogie> filteredBogies = bogies.stream()
                .filter(b -> b.getCapacity() > threshold)
                .collect(Collectors.toList());

        System.out.println("Filtered Bogies (Capacity > " + threshold + "):");

        filteredBogies.forEach(System.out::println);
    }
}

/* =========================
   Base Class
   ========================= */
abstract class Bogie {
    protected String id;
    protected int capacity;

    public Bogie(String id, int capacity) {
        this.id = id;
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getId() {
        return id;
    }

    public abstract String getType();

    @Override
    public String toString() {
        return getType() + " Bogie [ID=" + id + ", Capacity=" + capacity + "]";
    }
}

/* =========================
   Passenger Bogie Class
   ========================= */
class PassengerBogie extends Bogie {
    private String category; // Sleeper, AC Chair, First Class

    public PassengerBogie(String id, int capacity, String category) {
        super(id, capacity);
        this.category = category;
    }

    @Override
    public String getType() {
        return "Passenger (" + category + ")";
    }
}