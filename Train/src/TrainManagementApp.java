import java.util.*;

public class TrainManagementApp {

    public static void main(String[] args) {

        List<Bogie> bogies = new ArrayList<>();

        // Sample data
        bogies.add(new PassengerBogie("B1", 80, "Sleeper"));
        bogies.add(new PassengerBogie("B2", 60, "AC Chair"));
        bogies.add(new PassengerBogie("B3", 72, "First Class"));
        bogies.add(new PassengerBogie("B4", 50, "Sleeper"));

        // UC10: Total Seat Calculation using reduce
        int totalSeats = bogies.stream()
                .map(b -> b.getCapacity())   // extract capacity
                .reduce(0, Integer::sum);   // aggregate

        System.out.println("Total Seating Capacity: " + totalSeats);
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
    private String category;

    public PassengerBogie(String id, int capacity, String category) {
        super(id, capacity);
        this.category = category;
    }

    @Override
    public String getType() {
        return category;
    }
}