/**
 * Interface for vehicles with the ability to load cars.
 */

public interface ILoadable {
    void extendFlak();

    void retractFlak();

    void loadCar(Car c);

    void unloadCar();

}
