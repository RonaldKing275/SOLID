package solid.lsp;

public class FillingStation {

    public void refuel(Fuelable vehicle) {
        vehicle.fillUpWithFuel();
    }

    public void charge(Chargeable vehicle) {
        vehicle.chargeBattery();
    }
}