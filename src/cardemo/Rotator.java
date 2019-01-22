package cardemo;

import org.cove.ape.*;

public class Rotator extends Group {
	
	private	Vector2D ctr;
	private RectComposite rectComposite;
	
	/**
	 * This is a Group containing a Composite object for the rectangle shape
	 * and additional contraints and particles for the swinging arms 
	 * 
	 * Because we want the swinging arm to collide with the turning rectangle
	 * collideInternal is set to true for the Group. Since Composites are never
	 * checked internally, this is still efficient. Only the swinging arm is 
	 * checked for collision against the turning rectangle sides, which are
	 * made out of colidable SpringConstraint objects.
	 */
	 	
	public Rotator(long colA, long colB) {
			
		this.setCollideInternal(true);
		
		ctr = new Vector2D(555,175);
		rectComposite = new RectComposite(ctr, colA, colB);
		addComposite(rectComposite);
		
		CircleParticle circA = new CircleParticle(ctr.x,ctr.y,5);
		circA.setStyle(1, colA, 1, colB, 1);
		addParticle(circA);
		
		RectangleParticle rectA = new RectangleParticle(555,160,10,10,0,false,3, 0.3f, 0.0f);
		rectA.setStyle(1, colA, 1, colB, 1);
		addParticle(rectA);
		
		SpringConstraint connectorA = new SpringConstraint(rectComposite.pa(), rectA, 1, false, 1.0f, 1.0f, false);
		connectorA.setStyle(2, colB, 1.0f, 0xffffff, 1.0f);
		addConstraint(connectorA);

		RectangleParticle rectB = new RectangleParticle(555,190,10,10,0,false,3,  0.3f, 0.0f);
		rectB.setStyle(1, colA, 1, colB, 1);
		addParticle(rectB);
				
		SpringConstraint connectorB = new SpringConstraint(rectComposite.pc(), rectB, 1, false, 1.0f, 1.0f, false);
		connectorB.setStyle(2, colB, 1.0f, 0xffffff, 1.0f);
		addConstraint(connectorB);
		
	}
	
	public void rotateByRadian(float a) {
		rectComposite.rotateByRadian(a, ctr);
	}
}
