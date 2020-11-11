import java.awt.*;


/**
 * A class which models a Saab 95. Extends the Car superclass.
 */
public class Saab95 extends Car{

    /**
     * Represents whether the car has its turbo on or off.
     */
    private boolean turboOn;

    /**
     * Constructor for the Saab 95.
     */
    public Saab95(){
        super(2, Color.RED, 125, "Saab95");

        turboOn = false;
        stopEngine();
    }

    /**
     * Turns the turbo on.
     */
    public void setTurboOn(){
        turboOn = true;
    }

    /**
     * Turns the turbo off.
     */
    public void setTurboOff(){
        turboOn = false;
    }

    /**
     * Method which returns the speed factor of the car.
     * @return the speed factor which determines how the car accelerates or decelerates.
     */
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }

}
