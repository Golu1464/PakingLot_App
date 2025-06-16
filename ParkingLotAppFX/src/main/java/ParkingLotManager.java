public class ParkingLotManager {
    private final int FLOORS = 5;
    private final int SLOTS = 5;
    private Vehicle[][] parkingLot = new Vehicle[FLOORS][SLOTS];

    public Vehicle getVehicle(int floor, int slot) {
        return parkingLot[floor][slot];
    }

    public boolean parkVehicle(int floor, int slot, Vehicle vehicle) {
        if (parkingLot[floor][slot] == null) {
            parkingLot[floor][slot] = vehicle;
            return true;
        }
        return false;
    }

    public String searchVehicle(String number) {
        for (int i = 0; i < FLOORS; i++) {
            for (int j = 0; j < SLOTS; j++) {
                if (parkingLot[i][j] != null && parkingLot[i][j].getVehicleNumber().equals(number)) {
                    return "Found at Floor " + (i + 1) + ", Slot " + (j + 1);
                }
            }
        }
        return "Vehicle not found.";
    }
}
