import java.awt.*;

/**
 * An abstract class which models a car.
 * Implements the interface Movable.
 */
public abstract class Car implements Movable{


	/**
	 * Represents the number of doors of the current car.
	 */
	protected int nrDoors; // Number of doors on the car
	/**
	 * Represents the engine power of the car.
	 */
	protected double enginePower; // Engine power of the car
	/**
	 * Represents the current speed of the car.
	 */
	protected double currentSpeed; // The current speed of the car
	/**
	 * Represents the color of the car.
	 */
	protected Color color; // Color of the car
	/**
	 * Represents the current position of the car.
	 */
	protected Point position; // current position
	/**
	 * Represents the current heading of the car.
	 */
	protected double heading; // current heading in radians

	/**
	 * Represents the car model name.
	 */
	public String modelName; // The car model name

	/**
	 * An abstract constructor used by specific car models.
	 */
	protected Car() {
		position = new Point();
		heading = 0;
	}

	/**
	 * @return The number of doors of the car.
	 */
	public int getNrDoors(){
		return nrDoors;
	}

	/**
	 * @return The engine power of the car.
	 */
	public double getEnginePower(){
		return enginePower;
	}


	/**
	 * @return The current speed of the car.
	 */
	public double getCurrentSpeed(){
		return currentSpeed;
	}


	/**
	 * @return The color of the car.
	 */
	public Color getColor(){
		return color;
	}

	/**
	 * Sets the color of the car.
	 * @param clr color which is to be set.
	 */
	public void setColor(Color clr){
		color = clr;
	}

	/**
	 * Starts the car by setting the variable currentspeed to a positive value.
	 */
	public void startEngine(){
		currentSpeed = 0.1;
	}

	/**
	 * Stops the car by setting the variable currentspeed to zero.
	 */
	public void stopEngine(){
		currentSpeed = 0;
	}

	/**
	 * Abstract method which returns the speed factor of the car.
	 * @return the speed factor which determines how the car accelerates or decelerates.
	 */
	public abstract double speedFactor();

	/**
	 * Increases the speed of the car up to a maximum limit of the car's engine power.
	 * @param amount The factor by which the car will increase its speed.
	 */
	public void incrementSpeed(double amount) {
		currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
	}

	/**
	 * Decreases the speed of the car down to a minimum of zero.
	 * @param amount The factor by which the car will decrease its speed.
	 */
	public void decrementSpeed(double amount) {
		currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
	}


	/**
	 * Increases the speed of the car.
	 * @param amount The factor of the increase. Must be in the interval [0, 1].
	 * @throws RuntimeException If the input is not within the interval [0, 1].
	 */
	public void gas(double amount) throws RuntimeException{
		if (amount <= 1 && amount >= 0)
			incrementSpeed(amount);
		else
			throw new RuntimeException("input was not in interval [0, 1]");
	}

	/**
	 * Decreases the speed of the car.
	 * @param amount The factor of the decrease. Must be in the interval [0, 1].
	 * @throws RuntimeException If the input is not within the interval [0, 1].
	 */
	public void brake(double amount) throws RuntimeException{
		if (amount <= 1 && amount >= 0)
			decrementSpeed(amount);
		else
			throw new RuntimeException("input was not in interval [0, 1]");
	}

	/**
	 * @return The car's current position as a Point.
	 */
	public Point getPosition(){
		return position;
	}

	/**
	 * @return The car's current heading in radians.
	 */
	public double getHeading() {
		return heading;
	}

	/**
	 * Implements the move method from the Movable interface. Changes the car's position to a position further along the current heading by a distance determined by the car's current speed.
	 */
	public void move() {
		position.translate((int)(Math.cos(heading)*getCurrentSpeed()), (int)(Math.sin(heading)*getCurrentSpeed()));
	}


	/**
	 * Implements the turnLeft method from the Movable interface. Changes the car's heading by half a radian to the left.
	 */
	public void turnLeft() {
		heading += 0.5;
	}


	/**
	 * Implements the turnRight method from the Movable interface. Changes the car's heading by half a radian to the right.
	 */
	public void turnRight() {
		heading -= 0.5;
	}
}
