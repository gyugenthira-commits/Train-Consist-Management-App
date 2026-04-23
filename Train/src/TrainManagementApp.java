import java.util.*;
import java.util.stream.Collectors;

public class TrainManagementApp {

    public static void main(String[] args) {

        List<Bogie> bogies = generateBogies(10000); // large dataset

        // 🔹 Loop-based filtering
        long startLoop = System.nanoTime();

        List<Bogie> loopResult = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.getCapacity() > 60) {
                loopResult.add(b);
            }
        }

        long endLoop = System.nanoTime();
        long loopTime = endLoop - startLoop;

        // 🔹 Stream-based filtering
        long startStream = System.nanoTime();

        List<Bogie> streamResult = bogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());

        long endStream = System.nanoTime();
        long streamTime = endStream - startStream;

        // Output
        System.out.println("Loop Result Size: " + loopResult.size());
        System.out.println("Stream Result Size: " + streamResult.size());

        System.out.println("Loop Execution Time (ns): " + loopTime);
        System.out.println("Stream Execution Time (ns): " + streamTime);
    }

    // Generate sample bogies
    public static List<Bogie> generateBogies(int count) {
        List<Bogie> list = new ArrayList<>();
        Random rand = new Random();

        for (int i = 0; i < count; i++) {
            int capacity = 30 + rand.nextInt(100); // random capacity
            list.add(new PassengerBogie("B" + i, capacity, "Sleeper"));
        }
        return list;
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

    public PassengerBogie(String id, int capacity, String category) {
        super(id, capacity);
        this.category = category;
    }
}