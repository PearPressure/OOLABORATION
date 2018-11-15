import java.awt.*;

/**
 * A subclass of Car. Also has a turbo which increases speedfactor when on.
 */
public class Saab95 extends Car {
    /**
     * If turned on, increases speedfactor.
     */
    private boolean turboOn;


    public Saab95(Color color, double enginePower, int nrDoors, String modelName, Direction dir, double x, double y, boolean turboOn) {
        super(color, enginePower, nrDoors, modelName, dir, x, y);
        this.turboOn = turboOn;
    }

    public boolean isTurboOn() {
        return turboOn;
    }

    public void setTurboOn() {
        turboOn = true;
    }

    public void setTurboOff() {
        turboOn = false;
    }
    /*
     * Decides the speedfactor. If turbo is on, higher speedfactor.
     * @return The cars speedFactor, how fast it accelerates
     */
    public double speedFactor() {
        double turbo = 1;
        if (turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }
}
