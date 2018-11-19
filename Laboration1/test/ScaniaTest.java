import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class ScaniaTest {

    Scania scania = new Scania(Color.YELLOW, 30, 4, "Scania", Car.Direction.NORTH, 100, 100);


    @Test
    void raiseFlak() {
        scania.startEngine();
        scania.raiseFlak();
        assertEquals(0, scania.getFlakAngle());
        scania.stopEngine();
    }

    @Test
    void raiseFlak1() {
        scania.raiseFlak();
        assertEquals(70,scania.getFlakAngle());
    }

    @Test
    void lowerFlak() {
        scania.setFlakAngle(20);
        scania.lowerFlak(10);
        assertEquals(10,scania.getFlakAngle());
    }

    @Test
    void lowerFlak1() {
        scania.setFlakAngle(50);
        scania.startEngine();
        assertEquals(0,scania.getCurrentSpeed());
        scania.stopEngine();
        scania.lowerFlak();
        assertEquals(0,scania.getFlakAngle());
    }

}