package cardemo;

	
import org.cove.ape.*;

public class Bridge extends Group {
	
	public Bridge(long colB, long colC, long colD) {	
		
		// just a cut and paste class here. everything should be parameterized 
		// if you want to do it the right way, eg locations, section size, etc
	
		float bx = 170;
		float by = 40;
		float bsize = 51.5f;
		float yslope = 2.4f;
		float particleSize = 4;
		
		CircleParticle bridgePAA = new CircleParticle(bx,by,particleSize,true,1, 0.3f, 0.0f);
		bridgePAA.setStyle(1L, colC, 1L, colB, 1.0f);
		addParticle(bridgePAA);
		
		bx += bsize;
		by += yslope;
		CircleParticle bridgePA = new CircleParticle(bx,by,particleSize);
		bridgePA.setStyle(1, colC, 1, colB, 1.0f);
		addParticle(bridgePA);
		
		bx += bsize;
		by += yslope;
		CircleParticle bridgePB = new CircleParticle(bx,by,particleSize);
		bridgePB.setStyle(1, colC, 1, colB, 1.0f);
		addParticle(bridgePB);
		
		bx += bsize;
		by += yslope;
		CircleParticle bridgePC = new CircleParticle(bx,by,particleSize);
		bridgePC.setStyle(1, colC, 1, colB, 1.0f);
		addParticle(bridgePC);
		
		bx += bsize;
		by += yslope;
		CircleParticle bridgePD = new CircleParticle(bx,by,particleSize);
		bridgePD.setStyle(1, colC, 1, colB, 1.0f);
		addParticle(bridgePD);
		
		bx += bsize;
		by += yslope;
		CircleParticle bridgePDD = new CircleParticle(bx,by,particleSize,true, 1, 0.3f, 0.0f);
		bridgePDD.setStyle(1, colC, 1, colB, 1.0f);
		addParticle(bridgePDD);
		
		
		SpringConstraint bridgeConnA = new SpringConstraint(bridgePAA, bridgePA, 
				0.9f, true, 10, 0.8f, false);
		
		// collision response on the bridgeConnA will be ignored on 
		// on the first 1/4 of the constraint. this avoids blow ups
		// particular to springcontraints that have 1 fixed particle.
		bridgeConnA.setFixedEndLimit(0.25f);
		bridgeConnA.setStyle(1, colC, 1, colB, 1.0f);
		addConstraint(bridgeConnA);
		
		SpringConstraint bridgeConnB = new SpringConstraint(bridgePA, bridgePB, 
				0.9f, true, 10, 0.8f, false);
		bridgeConnB.setStyle(1, colC, 1, colB, 1.0f);
		addConstraint(bridgeConnB);
		
		SpringConstraint bridgeConnC = new SpringConstraint(bridgePB, bridgePC, 
				0.9f, true, 10, 0.8f, false);
		bridgeConnC.setStyle(1, colC, 1, colB, 1.0f);
		addConstraint(bridgeConnC);
		
		SpringConstraint bridgeConnD = new SpringConstraint(bridgePC, bridgePD,
				0.9f, true, 10, 0.8f, false);
		bridgeConnD.setStyle(1, colC, 1, colB, 1.0f);
		addConstraint(bridgeConnD);
		
		SpringConstraint bridgeConnE = new SpringConstraint(bridgePD, bridgePDD, 
				0.9f, true, 10, 0.8f, false);
		bridgeConnE.setFixedEndLimit( 0.25f );
		bridgeConnE.setStyle(1, colC, 1, colB,1.0f);
		addConstraint(bridgeConnE);
	}
}
