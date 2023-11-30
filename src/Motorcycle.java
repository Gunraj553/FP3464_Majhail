public class Motorcycle extends Vehicle {
    private boolean hasSidecar;

    public Motorcycle(String make, String plate, String color, VehicleType category, boolean hasSidecar) {
        super(make, plate, color, category);
        this.hasSidecar = hasSidecar;
    }

    public boolean hasSidecar() {
        return hasSidecar;
    }

    public String toString() {
        return super.toString() + String.format(" \n Has Sidecar: %s", hasSidecar);
    }
}
