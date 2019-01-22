package cardemo;

	
import org.cove.ape.*;

public class SwingDoor extends Group {
	
	public SwingDoor(long colE) {	
		
		// setting collideInternal allows the arm to hit the hidden stoppers. 
		// you could also make the stoppers its own group and tell it to collide 
		// with the SwingDoor
		setCollideInternal(true);
		
		CircleParticle swingDoorP1 = new CircleParticle(543,55,7);
		swingDoorP1.setMass(0.001f);
		swingDoorP1.setStyle(1, colE, 1, colE, 1.0f);
		addParticle(swingDoorP1);
		
		CircleParticle swingDoorP2 = new CircleParticle(620,55,7,true, 1, 0.3f, 0.0f);
		swingDoorP2.setStyle(1, colE, 1, colE, 1.0f);
		addParticle(swingDoorP2);
		
		SpringConstraint swingDoor = new SpringConstraint(swingDoorP1, swingDoorP2, 1, true, 13, 1.0f, false);
		swingDoor.setStyle(2, colE, 1, colE, 1.0f);
		addConstraint(swingDoor);
		
		CircleParticle swingDoorAnchor = new CircleParticle(543,5,2,true, 1, 0.3f, 0.0f);
		swingDoorAnchor.setVisible(false);
		swingDoorAnchor.setCollidable(false);
		addParticle(swingDoorAnchor);
		
		SpringConstraint swingDoorSpring = new SpringConstraint(swingDoorP1, swingDoorAnchor, 0.02f, false, 1.0f, 1.0f, false);
		swingDoorSpring.setRestLength(40);
		swingDoorSpring.setVisible(false);
		addConstraint(swingDoorSpring);
		
		CircleParticle stopperA = new CircleParticle(550,-60,70,true, 1, 0.3f, 0.0f);
		stopperA.setVisible(false);
		addParticle(stopperA);
		
		RectangleParticle stopperB = new RectangleParticle(650,130,42,70,0,true, 1.0f, 0.3f, 0.0f);
		stopperB.setVisible(false);
		addParticle(stopperB);

	}
}
