import java.util.*;

public class TrainManagementApp {

    public static void main(String[] args) {

        try {
            PassengerBogie b1 = new PassengerBogie("B1", 80, "Sleeper");
            PassengerBogie b2 = new PassengerBogie("B2", -10, "AC Chair"); // invalid

            System.out.println(b1);
            System.out.println(b2);

        } catch (InvalidCapacityException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

/* =========================
   Custom Exception
   ========================= */
class InvalidCapacityException extends Exception {
    public InvalidCapacityException(String message) {
        super(message);
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
}

/* =========================
   Passenger Bogie
   ========================= */
class PassengerBogie extends Bogie {
    private String category;

    public PassengerBogie(String id, int capacity, String category)
            throws InvalidCapacityException {

        super(id, capacity);

        if (capacity <= 0) {
            throw new InvalidCapacityException("Capacity must be greater than zero");
        }

        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "PassengerBogie [ID=" + id + ", Capacity=" + capacity + ", Category=" + category + "]";
    }
}