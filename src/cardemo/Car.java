package cardemo;

	
import org.cove.ape.*;

public class Car extends Group {
	
	private WheelParticle wheelParticleA;
	private WheelParticle wheelParticleB;
	
	
	public Car(long colC, long colE) {
		
		wheelParticleA = new WheelParticle(140,10,14,false,2, 0.3f, 0, 1);
		wheelParticleA.setStyle(0, colC, 1, colE, 1);
		addParticle(wheelParticleA);
		wheelParticleA.getSprite().cacheAsBitmaps = true;
		
		wheelParticleB = new WheelParticle(200,10,14,false,2, 0.3f, 0, 1);
		wheelParticleB.setStyle(0, colC, 1, colE, 1);
		addParticle(wheelParticleB);
		wheelParticleB.getSprite().cacheAsBitmaps = true;
		
		SpringConstraint wheelConnector = new SpringConstraint(wheelParticleA, wheelParticleB,
				0.5f, true, 8, 1, false);
		wheelConnector.setStyle(0, colC, 1, colE, 1);
		addConstraint(wheelConnector);
	}
	
	
	public void setSpeed(float s) {
		wheelParticleA.setAngularVelocity( s );
		wheelParticleB.setAngularVelocity( s );
	}
}
