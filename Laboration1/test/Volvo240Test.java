import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class Volvo240Test {
    Volvo240 volvo = new Volvo240(Color.YELLOW, 20, 4, "240", Car.Direction.NORTH, 100, 100);

    @Test
    public void getColor() {
        assertEquals(Color.YELLOW, volvo.getColor());

    }

    @Test
    public void turnLeft() {
        volvo.turnLeft();
        assertEquals(Car.Direction.WEST, volvo.getDir());

    }

    @Test
    public void gas(){
        volvo.startEngine();
        volvo.gas(0.5);

        assertEquals(0.225, volvo.getCurrentSpeed());

        volvo.brake(0.5);
        assertEquals(0.1,volvo.getCurrentSpeed());
    }
}