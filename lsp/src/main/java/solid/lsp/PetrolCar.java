package solid.lsp;

public class PetrolCar extends Vehicle implements Fuelable {
    private static final int FUEL_TANK_FULL = 100;
    private int fuelTankLevel = 0;

    @Override
    public void fillUpWithFuel() {
        this.fuelTankLevel = FUEL_TANK_FULL;
    }

    @Override
    public int fuelTankLevel() {
        return fuelTankLevel;
    }
}