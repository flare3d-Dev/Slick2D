package cardemo;

	
import org.cove.ape.*;

public class Surfaces extends Group {
	
	public Surfaces(long colA, long colB, long colC, long colD, long colE) {
		
		RectangleParticle floor = new RectangleParticle(340,327,550,50,0,true, 1.0f, 0.3f, 0.0f);
		floor.setStyle(0, colD, 1, colD, 1.0f);
		addParticle(floor);
		
		RectangleParticle ceil = new RectangleParticle(325,-33,649,80,0,true, 1.0f, 0.3f, 0.0f);
		ceil.setStyle(0, colD, 1, colD, 1.0f);
		addParticle(ceil);

		RectangleParticle rampRight = new RectangleParticle(375,220,390,20,0.405f,true, 1.0f, 0.3f, 0.0f);
		rampRight.setStyle(0, colD, 1, colD, 1.0f);
		addParticle(rampRight);
		
		RectangleParticle rampLeft = new RectangleParticle(90,200,102,20,-.7f,true, 1.0f, 0.3f, 0.0f);
		rampLeft.setStyle(0, colD, 1, colD, 1.0f);
		addParticle(rampLeft);
		
		RectangleParticle rampLeft2 = new RectangleParticle(96,129,102,20,-.7f,true, 1.0f, 0.3f, 0.0f);
		rampLeft2.setStyle(0, colD, 1, colD, 1.0f);
		addParticle(rampLeft2);
		
		CircleParticle rampCircle = new CircleParticle(175,190,60,true, 1, 0.3f, 0.0f);
		rampCircle.setStyle(1, colD, 1, colB, 1.0f);
		addParticle(rampCircle);
		
		CircleParticle floorBump = new CircleParticle(600,660,400,true, 1, 0.3f, 0.0f);
		floorBump.setStyle(1, colD, 1, colB, 1.0f);
		addParticle(floorBump);
		
		RectangleParticle bouncePad = new RectangleParticle(35,370,40,60,0,true, 1.0f, 0.3f, 0.0f);
		bouncePad.setStyle(0, colD, 1, 0x996633, 1.f);
		bouncePad.setElasticity(4);
		addParticle(bouncePad);
		
		RectangleParticle leftWall = new RectangleParticle(1,99,30,500,0,true, 1.0f, 0.3f, 0.0f);
		leftWall.setStyle(0, colD, 1, colD, 1.f);
		addParticle(leftWall);
		
		RectangleParticle leftWallChannelInner = new RectangleParticle(54,300,20,150,0,true, 1.0f, 0.3f, 0.0f);
		leftWallChannelInner.setStyle(0, colD, 1, colD, 1.f);
		addParticle(leftWallChannelInner);
		
		RectangleParticle leftWallChannel = new RectangleParticle(54,122,20,94,0,true, 1.0f, 0.3f, 0.0f);
		leftWallChannel.setStyle(0, colD, 1, colD, 1.f);
		addParticle(leftWallChannel);
		
		RectangleParticle leftWallChannelAng = new RectangleParticle(75,65,60,25,- 0.7f,true, 1.0f, 0.3f, 0.0f);
		leftWallChannelAng.setStyle(0, colD, 1, colD, 1.f);
		addParticle(leftWallChannelAng);
		
		RectangleParticle topLeftAng = new RectangleParticle(23,11,65,40,-0.7f,true, 1.0f, 0.3f, 0.0f);
		topLeftAng.setStyle(0, colD, 1, colD, 1.f);
		addParticle(topLeftAng);
		
		RectangleParticle rightWall = new RectangleParticle(654,230,50,500,0,true, 1.0f, 0.3f, 0.0f);
		rightWall.setStyle(0, colD, 1, colD, 1.f);
		addParticle(rightWall);

		RectangleParticle bridgeStart = new RectangleParticle(127,49,75,25,0,true, 1.0f, 0.3f, 0.0f);
		bridgeStart.setStyle(0, colD, 1, colD, 1.f);
		addParticle(bridgeStart);
		
		RectangleParticle bridgeEnd = new RectangleParticle(483,55,100,15,0,true, 1.0f, 0.3f, 0.0f);
		bridgeEnd.setStyle(0, colD, 1, colD, 1.f);
		addParticle(bridgeEnd);
	}
}
