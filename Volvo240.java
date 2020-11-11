import java.awt.*;

/**
 * A class which models a Volvo 240. Extends the Car superclass.
 */
public class Volvo240 extends Car{

    /**
     * Represents the trim factor of the car. This factor is used to determine the speed factor for a volvo.
     */
    public final static double trimFactor = 1.25;

    /**
     * Constructor for a Volvo 240.
     */
    public Volvo240() {
        super(4, Color.BLACK, 100, "Volvo240");
        stopEngine();
    }

    /**
     * Method which returns the speed factor of the car.
     * @return the speed factor which determines how the car accelerates or decelerates.
     */
    public double speedFactor() {
        return getEnginePower() * 0.01 * trimFactor;
    }
}
