import java.awt.*;

public class CarFerry implements IMovable, ILoadable {

    private final CarTransport parent;

    public CarFerry(Color color, int enginePower, String modelName, Car.Direction dir, int x, int y, int maxCars) {
        parent = new CarTransport(color, enginePower, 0, modelName, dir, x, y, maxCars);
    }


    @Override
    public void extendFlak() {
        parent.extendFlak();
    }

    @Override
    public void retractFlak() {
        parent.retractFlak();
    }

    @Override
    public void loadCar(Car c) {
        if (!parent.isMoving() && parent.isFlakExtended() && parent.isClose(c) && parent.isRoomForCar() && c.getSize() == Car.Size.SMALL) {
            parent.getLoadedCars().add(c);
            c.setX(parent.getX());
            c.setY(parent.getY());
        }
    }

    @Override
    public void unloadCar() {
        if (!parent.isMoving() && parent.isFlakExtended()) {
            Car c = parent.getLoadedCars().get(0);
            c.setX(parent.getX() + 10);
            c.setY(parent.getY() + 10);
            parent.getLoadedCars().remove(0);
        }

    }

    @Override
    public void move() {
        parent.move();

    }

    @Override
    public void turnLeft() {
        parent.move();

    }

    @Override
    public void turnRight() {
        parent.move();
    }
}
