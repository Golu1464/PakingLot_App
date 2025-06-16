public class Vehicle {
    private String ownerName;
    private String modelNumber;
    private String vehicleNumber;

    public Vehicle(String ownerName, String modelNumber, String vehicleNumber) {
        this.ownerName = ownerName;
        this.modelNumber = modelNumber;
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    @Override
    public String toString() {
        return "Owner: " + ownerName + ", Model: " + modelNumber + ", Number: " + vehicleNumber;
    }
}
