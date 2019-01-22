package cardemo;

import org.cove.ape.*;

public class Capsule extends Group {
	
	public Capsule(long colC) {

		CircleParticle capsuleP1 = new CircleParticle(300,10,14,false,1.3f,0.4f,0);
		capsuleP1.setStyle(0, colC, 1, colC, 1.0f);
		addParticle(capsuleP1);
		
		CircleParticle capsuleP2 = new CircleParticle(325,35,14,false,1.3f,0.4f,0);
		capsuleP2.setStyle(0, colC, 1, colC, 1.0f);
		addParticle(capsuleP2);
		
		SpringConstraint capsule = new SpringConstraint(capsuleP1, capsuleP2, 1, true, 24, 1, false);
		capsule.setStyle(5, colC, 1, colC, 1);
		addConstraint(capsule);
	}
}
