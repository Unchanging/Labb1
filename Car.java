import java.awt.*;

/**
 *
 */
public abstract class Car implements Movable{


	/**
	 * Represents the number of doors of the current car
	 */
	protected int nrDoors; // Number of doors on the car
	protected double enginePower; // Engine power of the car
	protected double currentSpeed; // The current speed of the car
	protected Color color; // Color of the car
	protected Point position; // current position
	protected double heading; // current heading in radians

	public String modelName; // The car model name

	/**
	 * An abstract constructor used by specifik car models
	 */
	protected Car() {
		position = new Point();
		heading = 0;
	}

	/**
	 * @return The number of doors of the car
	 */
	public int getNrDoors(){
		return nrDoors;
	}

	public double getEnginePower(){
		return enginePower;
	}

	public double getCurrentSpeed(){
		return currentSpeed;
	}

	public Color getColor(){
		return color;
	}

	public void setColor(Color clr){
		color = clr;
	}

	public void startEngine(){
		currentSpeed = 0.1;
	}

	public void stopEngine(){
		currentSpeed = 0;
	}

	public abstract double speedFactor();

	public void incrementSpeed(double amount) {
		currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
	}

	public void decrementSpeed(double amount) {
		currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
	}

	public void gas(double amount) throws RuntimeException{
		if (amount <= 1 && amount >= 0)
			incrementSpeed(amount);
		else
			throw new RuntimeException("input was not in interval [0, 1]");
	}

	public void brake(double amount) throws RuntimeException{
		if (amount <= 1 && amount >= 0)
			decrementSpeed(amount);
		else
			throw new RuntimeException("input was not in interval [0, 1]");
	}

	public Point getPosition(){
		return position;
	}

	public double getHeading() {
		return heading;
	}

	@Override
	public void move() {
		position.translate((int)(Math.cos(heading)*getCurrentSpeed()), (int)(Math.sin(heading)*getCurrentSpeed()));
	}

	@Override
	public void turnLeft() {
		heading += 0.5;
	}

	@Override
	public void turnRight() {
		heading -= 0.5;
	}
}
