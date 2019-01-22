package cardemo;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.cove.ape.APEngine;
import org.cove.ape.Group;
import org.cove.ape.Vector2D;
import org.cove.ape.util.GCreator;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.command.BasicCommand;
import org.newdawn.slick.command.Command;
import org.newdawn.slick.command.InputProvider;
import org.newdawn.slick.command.InputProviderListener;
import org.newdawn.slick.command.KeyControl;

import cardemo.util.Slick2DGraphics;
import flash.display.Sprite;


public class CarDemoGame  extends BasicGame implements InputProviderListener {
	
	private static long colA = 0x334433L;
	private static long colB = 0x3366aaL;
	private static long colC = 0xaabbbbL;
	private static long colD = 0x6699aaL;
	private static long colE = 0x778877L;

	private Car car;
	private Rotator rotator;
	
	/** The command for jump */
	private Command left = new BasicCommand("left");
	private Command right = new BasicCommand("right");
	
	/** The input provider abstracting input */
	private InputProvider provider;
	
	Slick2DGraphics graphics;
	
	public CarDemoGame(String title) {
		super(title);
		
		GCreator.SetCreator( (sprite) ->  new Slick2DGraphics(sprite)  );
		
		// Initialize the engine. The argument here is the time step value. 
		// Higher values scale the forces in the sim, making it appear to run
		// faster or slower. Lower values result in more accurate simulations.
		APEngine.init(1.0f/4.0f);
		
		// set up the default diplay container
		APEngine.setContainer( new Sprite() );
		
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


	@Override
	public void render(GameContainer arg0, Graphics g) throws SlickException {
		
		Slick2DGraphics.SetGraphics(g);
		
		APEngine.paint();		
	}

	@Override
	public void controlPressed(Command cmd) {
		if ( cmd == left || cmd == right )
		{
			float keySpeed = 0.2f;
			if ( cmd == left )
				keySpeed = -0.2f;
			
			car.setSpeed(keySpeed);
		}
	}

	@Override
	public void controlReleased(Command arg0) {
		car.setSpeed(0);
	}

	@Override
	public void init(GameContainer gc) throws SlickException {
		provider = new InputProvider(gc.getInput());
		provider.addListener(this);
		
		provider.bindCommand(new KeyControl(Input.KEY_LEFT), left);
		provider.bindCommand(new KeyControl(Input.KEY_RIGHT), right);
	}

	@Override
	public void update(GameContainer arg0, int arg1) throws SlickException {
		APEngine.step();
		rotator.rotateByRadian(.02f);
	}

	public static void main(String[] args) {
		try
		{
			AppGameContainer appgc;
			appgc = new AppGameContainer(new CarDemoGame("CarDemoGame"));
			int senceWidth = 650 + 10;
			int senceHeight = 350 + 80;
			appgc.setDisplayMode(senceWidth, senceHeight, false);			
			appgc.setTargetFrameRate(30);			
			appgc.start();
		}
		catch (SlickException ex)
		{
			Logger.getLogger(CarDemoGame.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

}
