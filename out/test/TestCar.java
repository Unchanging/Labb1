import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestCar {

	private Car volvo;
	private Car saab;

	@Before
	public void init() {
		volvo = new Volvo240();
		saab = new Saab95();
	}

	@Test
	public void testNrDoors() {
		assertTrue(volvo.getNrDoors() == 4 && saab.getNrDoors() == 2);
	}

	@Test
	public void testEnginePower() {
		assertTrue(volvo.getEnginePower() == 100 && saab.getEnginePower() == 125);
	}

	@Test
	public void testMaxPower() {
		for (int i = 0; i < 1000; i++) {
			volvo.gas(1);
			saab.gas(1);
		}
		assertTrue(volvo.getCurrentSpeed() == 100 && saab.getCurrentSpeed() == 125);
	}

	@Test
	public void testMinPower() {
		for (int i = 0; i < 1000; i++) {
			volvo.gas(1);
			saab.gas(1);
		}
		for (int i = 0; i < 1000; i++) {
			volvo.brake(1);
			saab.brake(1);
		}
		assertTrue(volvo.getCurrentSpeed() == 0 && saab.getCurrentSpeed() == 0);
	}

	@Test
	public void testColor() {
		volvo.setColor(Color.YELLOW);
		saab.setColor(Color.YELLOW);
		assertTrue(volvo.getColor().equals(Color.YELLOW) && saab.getColor().equals(Color.YELLOW));
	}

	@Test
	public void testStartCar() {
		volvo.startEngine();
		saab.startEngine();
		assertTrue(volvo.getCurrentSpeed() > 0 && saab.getCurrentSpeed() > 0);
	}

	@Test
	public void testStopCar() {
		volvo.startEngine();
		saab.startEngine();

		volvo.stopEngine();
		saab.stopEngine();
		assertTrue(volvo.getCurrentSpeed() == 0 && saab.getCurrentSpeed() == 0);
	}

	@Test
	public void testMove() {

		Point car1OriginalPosition = volvo.getPosition().getLocation();
		Point car2OriginalPosition = saab.getPosition().getLocation();

		volvo.startEngine();
		volvo.incrementSpeed(10);
		volvo.move();
		saab.move();

		saab.startEngine();
		saab.incrementSpeed(10);
		saab.move();
		saab.move();

		boolean testResult = !car1OriginalPosition.equals(volvo.getPosition()) &&  !car2OriginalPosition.equals(saab.getPosition());
		assertTrue(testResult);
	}


	@Test
	public void testTurningLeft() {
		double car1OriginalHeading = volvo.getHeading();
		double car2OriginalHeading = saab.getHeading();

		volvo.turnLeft();
		saab.turnLeft();

		assertTrue(volvo.getHeading() != car1OriginalHeading && saab.getHeading() != car2OriginalHeading);
	}

	@Test
	public void testTurningRight() {
		double car1OriginalHeading = volvo.getHeading();
		double car2OriginalHeading = saab.getHeading();

		volvo.turnRight();
		saab.turnRight();

		assertTrue(volvo.getHeading() != car1OriginalHeading && saab.getHeading() != car2OriginalHeading);
	}

	@Test
	public void testVolvoSpeedfactor() {
		double volvoFactor = 1.25*0.01*100;
		assertEquals(volvo.speedFactor(), volvoFactor, 0.001);
	}

	@Test
	public void testSaabSpeedFactor() {

		Saab95 saab2 = new Saab95();
		saab2.setTurboOn();
		double initialSpeedFactor = saab2.speedFactor();
		saab2.setTurboOff();
		assertTrue(initialSpeedFactor > saab2.speedFactor());
	}

	@Test
	public void testModelName() {
		assertTrue(volvo.getModelName().equals("Volvo240") && saab.getModelName().equals("Saab95"));
	}
}
