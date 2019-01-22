package cardemo;

import java.util.ArrayList;
import java.util.List;

import org.cove.ape.*;

import flash.display.Sprite;
//import flash.events.Event;
//import flash.events.KeyboardEvent;

/**
 * This is an example showing use of the WheelParticles and collidable
 * SpringConstraints used as surfaces in the 'bridge' area. The bouncy
 * area has a high elasticity setting to push the car back up to the top.
 */
/*
[SWF(width="650", height="350", backgroundColor="#334433")] 
public class CarDemo extends Sprite {
	
	private static long colA = 0x334433L;
	private static long colB = 0x3366aaL;
	private static long colC = 0xaabbbbL;
	private static long colD = 0x6699aaL;
	private static long colE = 0x778877L;

	private Car car;
	private Rotator rotator;
	
	public CarDemo() {
	
		// set up the events, main loop handler, and the engine. you don't have to use
		// enterframe. you just need to call the ApeEngine.step() and ApeEngine.paint() 
		// wherever and however you're handling your program cycle.
		stage.frameRate = 55;
		stage.addEventListener(KeyboardEvent.KEY_DOWN, keyDownHandler);
        stage.addEventListener(KeyboardEvent.KEY_UP, keyUpHandler);
		addEventListener(Event.ENTER_FRAME, run);
		
		// Initialize the engine. The argument here is the time step value. 
		// Higher values scale the forces in the sim, making it appear to run
		// faster or slower. Lower values result in more accurate simulations.
		APEngine.init(1/4);
		
		// set up the default diplay container
		APEngine.container = this;
		
		// gravity -- particles of varying masses are affected the same
		APEngine.addMasslessForce(new Vector2D(0, 3));
		
		// groups - all these classes extend group
		Surfaces surfaces = new Surfaces(colA, colB, colC, colD, colE);
		APEngine.addGroup(surfaces);
		
		Bridge bridge = new Bridge(colB, colC, colD);
		APEngine.addGroup(bridge);
		
		Capsule capsule = new Capsule(colC);
		APEngine.addGroup(capsule);
		
		rotator = new Rotator(colB, colE);
		APEngine.addGroup(rotator);

		SwingDoor swingDoor = new SwingDoor(colC);
		APEngine.addGroup(swingDoor);
		
		car = new Car(colC, colE);
		APEngine.addGroup(car);
		
		// determine what collides with what.
		List<Group> groupList = new ArrayList<Group>(){{ add(surfaces); add(bridge); add(rotator);  add(swingDoor); add(capsule);}};
		car.addCollidableList( groupList );
		
		List<Group> groupList2 = new ArrayList<Group>(){ { add(surfaces); add(bridge); add(rotator); add(swingDoor); } };
		capsule.addCollidableList(groupList2);
		
	}
	
	
	private void run(Event evt) {
		APEngine.step();
		APEngine.paint();
		rotator.rotateByRadian(.02f);
	}
	
			
	private void keyDownHandler(KeyboardEvent keyEvt) {
	
		float keySpeed = 0.2f;

		if (keyEvt.keyCode == 65) {
			car.speed = -keySpeed;
		} else if (keyEvt.keyCode == 68) {
			car.speed = keySpeed;
		}
	}
	
	
	private void keyUpHandler(KeyboardEvent keyEvt) {
		car.speed = 0;
	}
}
*/
