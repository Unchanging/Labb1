import java.awt.*;

public abstract class Car implements Movable{

	protected int nrDoors; // Number of doors on the car
	protected double enginePower; // Engine power of the car
	protected double currentSpeed; // The current speed of the car
	protected Color color; // Color of the car
	protected Point position; // current position
	protected double heading; // current heading in radians

	public String modelName; // The car model name

	protected Car() {
		position = new Point();
		heading = 0;
	}

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

	public double speedFactor() {
		// implemented in subclasses
		return 0;
	}

	public void incrementSpeed(double amount) {
		// implemented in subclasses
	}

	public void decrementSpeed(double amount) {
		// implemented in subclasses
	}

	// TODO fix this method according to lab pm
	public void gas(double amount){
		incrementSpeed(amount);
	}

	// TODO fix this method according to lab pm
	public void brake(double amount){
		decrementSpeed(amount);
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
