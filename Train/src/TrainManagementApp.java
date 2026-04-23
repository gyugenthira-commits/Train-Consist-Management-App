public class TrainManagementApp {

    public static void main(String[] args) {

        GoodsBogie b1 = new GoodsBogie("G1", "Cylindrical");
        GoodsBogie b2 = new GoodsBogie("G2", "Rectangular");

        b1.assignCargo("Petroleum"); // valid
        b2.assignCargo("Petroleum"); // invalid

        b2.assignCargo("Coal"); // valid after failure

        System.out.println(b1);
        System.out.println(b2);
    }
}

/* ========================= */
class CargoSafetyException extends RuntimeException {
    public CargoSafetyException(String message) {
        super(message);
    }
}

/* ========================= */
class GoodsBogie {
    private String id;
    private String type;
    private String cargo;

    public GoodsBogie(String id, String type) {
        this.id = id;
        this.type = type;
    }

    public void assignCargo(String cargo) {
        try {
            if (type.equalsIgnoreCase("Rectangular") &&
                    cargo.equalsIgnoreCase("Petroleum")) {
                throw new CargoSafetyException("Unsafe cargo for rectangular bogie");
            }

            this.cargo = cargo;
            System.out.println("Cargo assigned: " + cargo + " to " + id);

        } catch (CargoSafetyException e) {
            System.out.println("Error: " + e.getMessage());

        } finally {
            System.out.println("Assignment attempt completed for " + id);
        }
    }

    public String getCargo() {
        return cargo;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "GoodsBogie [ID=" + id + ", Type=" + type + ", Cargo=" + cargo + "]";
    }
}