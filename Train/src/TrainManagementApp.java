import java.util.*;

public class TrainManagementApp {

    public static void main(String[] args) {

        List<GoodsBogie> goodsBogies = new ArrayList<>();

        // Sample data
        goodsBogies.add(new GoodsBogie("G1", "Cylindrical", "Petroleum"));
        goodsBogies.add(new GoodsBogie("G2", "Open", "Coal"));
        goodsBogies.add(new GoodsBogie("G3", "Box", "Grain"));

        // UC12: Safety Validation using Streams
        boolean isSafe = goodsBogies.stream()
                .allMatch(b ->
                        !b.getType().equalsIgnoreCase("Cylindrical") ||
                                b.getCargo().equalsIgnoreCase("Petroleum")
                );

        System.out.println("Train Safety Compliance: " + (isSafe ? "SAFE" : "UNSAFE"));
    }
}

/* =========================
   Goods Bogie Class
   ========================= */
class GoodsBogie {
    private String id;
    private String type;   // Cylindrical, Open, Box
    private String cargo;  // Petroleum, Coal, Grain

    public GoodsBogie(String id, String type, String cargo) {
        this.id = id;
        this.type = type;
        this.cargo = cargo;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getCargo() {
        return cargo;
    }

    @Override
    public String toString() {
        return "GoodsBogie [ID=" + id + ", Type=" + type + ", Cargo=" + cargo + "]";
    }
}