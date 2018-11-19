import java.awt.*;

public abstract class Truck extends Car {

    private boolean isFlakExtended;


    public Truck(Color color, double enginePower, int nrDoors, String modelName, Car.Direction dir, double x, double y) {
        super(color, enginePower, nrDoors, modelName, dir, x, y, Car.Size.LARGE);
        this.setFlakExtended(false);
    }


    public double speedFactor() {
        return this.getEnginePower() * 0.01;
    }

    public abstract void extendFlak();

    public abstract void retractFlak();

    public boolean isFlakExtended() {
        return isFlakExtended;
    }

    public void setFlakExtended(boolean flakExtended) {
        isFlakExtended = flakExtended;
    }

    /**
     * Increments the speed if the flak is retracted.
     *
     * @param amount
     */
    public void incrementSpeed(double amount) {
        if (!this.isFlakExtended) {
            this.setCurrentSpeed(this.getCurrentSpeed() + speedFactor() * amount);
            if (this.getCurrentSpeed() > this.getEnginePower()) {
                this.setCurrentSpeed(this.getEnginePower());
            }
        }
    }


    /**
     * Starts the engine if the flak is retracted.
     */
    public void startEngine() {
        if (!this.isFlakExtended) {
            this.setCurrentSpeed(0.1);
        }

    }
}
