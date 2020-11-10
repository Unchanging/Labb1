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
        super();

        nrDoors = 4;
        color = Color.black;
        enginePower = 100;
        modelName = "Volvo240";
        stopEngine();
    }

    /**
     * Method which returns the speed factor of the car.
     * @return the speed factor which determines how the car accelerates or decelerates.
     */
    public double speedFactor() {
        return enginePower * 0.01 * trimFactor;
    }
}
