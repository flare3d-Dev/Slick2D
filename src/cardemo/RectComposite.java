package cardemo;

import org.cove.ape.*;

public class RectComposite extends Composite {
	
	private CircleParticle cpA;
	private CircleParticle cpC;
	
	public RectComposite(Vector2D ctr, long colA, long colB) {
		
		// just hard coding here for the purposes of the demo, you should pass
		// everything in the constructor to do it right.
		float rw = 75;
		float rh = 18;
		float rad = 4;
		
		// going clockwise from left top..
		cpA = new CircleParticle(ctr.x-rw/2, ctr.y-rh/2, rad, true, 1, 0.3f, 0);
		CircleParticle cpB = new CircleParticle(ctr.x+rw/2, ctr.y-rh/2, rad, true, 1, 0.3f, 0);
		cpC = new CircleParticle(ctr.x+rw/2, ctr.y+rh/2, rad, true, 1, 0.3f, 0);
		CircleParticle cpD = new CircleParticle(ctr.x-rw/2, ctr.y+rh/2, rad, true, 1, 0.3f, 0);
		
		cpA.setStyle(0,0,0,colA,1);
		cpB.setStyle(0,0,0,colA,1);
		cpC.setStyle(0,0,0,colA,1);
		cpD.setStyle(0,0,0,colA,1);
		
		// by default all fixed particles are not repainted. this is for efficiency,
		// since it would be a waste to repaint a non moving particle. in this case
		// we are going to be rotating a group of fixed particles, so we'll turn on 
		// always repaint for each one.
		cpA.setAlwaysRepaint( true );
		cpB.setAlwaysRepaint(  true);
		cpC.setAlwaysRepaint(  true);
		cpD.setAlwaysRepaint(  true);	
		
		SpringConstraint sprA = new SpringConstraint(cpA,cpB,0.5f,true,rad * 2, 1, false);
		SpringConstraint sprB = new SpringConstraint(cpB,cpC,0.5f,true,rad * 2, 1, false);
		SpringConstraint sprC = new SpringConstraint(cpC,cpD,0.5f,true,rad * 2, 1, false);
		SpringConstraint sprD = new SpringConstraint(cpD,cpA,0.5f,true,rad * 2, 1, false);
		
		sprA.setStyle(0,0,0,colA,1);
		sprB.setStyle(0,0,0,colA,1);
		sprC.setStyle(0,0,0,colA,1);
		sprD.setStyle(0,0,0,colA,1);
		
		// by default all fixed SpringConstraints are not repainted as well. A
		// SpringConstraint will be fixed if both its attached Particles are
		// fixed.
		sprA.setAlwaysRepaint(  true);
		sprB.setAlwaysRepaint(  true);
		sprC.setAlwaysRepaint(  true);
		sprD.setAlwaysRepaint(  true);	
		
		addParticle(cpA);
		addParticle(cpB);
		addParticle(cpC);
		addParticle(cpD);
		
		addConstraint(sprA);
		addConstraint(sprB);
		addConstraint(sprC);
		addConstraint(sprD);
	}
	
	public CircleParticle pa() {
		return cpA;
	}
	
	public CircleParticle pc() {
		return cpC;
	}
}
