import java.awt.*;

/*  an abstract class of of cars, that has shared objects, the class includes the objects for a car class to be created
 */

public abstract class Car implements Movable {
    //variables
    private Color color;
    private double enginePower;
    private int nrDoors;
    private double currentSpeed;
    private String modelName;
    private double x, y;
    private Direction dir;

    public abstract double speedFactor();

    // direction is an enum that determines what values shoud go into x,y
    enum Direction {
        NORTH, WEST, SOUTH, EAST;
    }

    public String getModelName() {
        return modelName;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Direction getDir() {
        return dir;
    }

    //constructor
    public Car(Color color, double enginePower, int nrDoors, String modelName, Direction dir, double x, double y) {
        this.color = color;
        this.enginePower = enginePower;
        this.nrDoors = nrDoors;
        this.currentSpeed = 0;
        this.modelName = modelName;
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public void startEngine() {

        currentSpeed = 0.1;
    }

    // stop engine
    public void stopEngine() {
        currentSpeed = 0;
    }

    //  gets getcolor
    public Color getColor() {
        return color;
    }

    //  sets color
    public void setColor(Color clr) {
        color = clr;
    }

    // gets enginePower
    public double getEnginePower() {
        return enginePower;
    }

    //  gets nrDoors
    public int getNrDoors() {
        return nrDoors;
    }

    //  gets Currentspeed
    public double getCurrentSpeed() {
        return currentSpeed;
    }

    /**
     * Increases currentsSpeed based on the objects currentSpeed, speedfactor and input.
      * @param amount
     */
    public void incrementSpeed(double amount) {

        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
        if (currentSpeed > enginePower) {
            currentSpeed = enginePower;
        }
    }

    /**
     * Decreases currentsSpeed based on the objects currentSpeed and speedfactor.
     * @param amount
     */
    public void decrementSpeed(double amount) {
        currentSpeed = getCurrentSpeed() - speedFactor() * amount;
        if (currentSpeed < 0) {
            currentSpeed = 0;
        }
    }
    //  how the car change speed

    /**
     * Increases the speed based on the amount.
     * @param amount between 0 and 1.
     */
    public void gas(double amount) {
        if (amount <= 1 && amount >= 0) {
            incrementSpeed(amount);
        }
    }

    /**
     * Decreases the speed based on the amount
     * @param amount between 0 and 1.
     */
    public void brake(double amount) {
        if (amount <= 1 && amount >= 0) {
            decrementSpeed(amount);
        }
    }



    /**
     * Updates the cars position based on direction and currentSpeed.
     */
    public void move() {

        if (dir == Direction.NORTH) {
            this.y += currentSpeed;
        } else if (dir == Direction.WEST) {
            this.x -= currentSpeed;
        } else if (dir == Direction.SOUTH) {
            this.y -= currentSpeed;
        } else if (dir == Direction.EAST) {
            this.x += currentSpeed;
        }


    }


    public void turnLeft() {

        if (dir == Direction.NORTH) {
            dir = Direction.WEST;
        } else if (dir == Direction.WEST) {
            dir = Direction.SOUTH;
        } else if (dir == Direction.SOUTH) {
            dir = Direction.EAST;
        } else if (dir == Direction.EAST) {
            dir = Direction.NORTH;
        }


    }

    public void turnRight() {

        if (dir == Direction.NORTH) {
            dir = Direction.EAST;
        } else if (dir == Direction.EAST) {
            dir = Direction.SOUTH;
        } else if (dir == Direction.SOUTH) {
            dir = Direction.WEST;
        } else if (dir == Direction.WEST) {
            dir = Direction.NORTH;
        }


    }


}
