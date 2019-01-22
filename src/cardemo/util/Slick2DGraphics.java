package cardemo.util;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.Color;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Transform;

import flash.display.Graphics;
import flash.display.Sprite;

import org.cove.ape.MathUtil;

public class Slick2DGraphics extends Graphics {
	private static List<Slick2DGraphics> allList = new ArrayList<Slick2DGraphics>();
	
	private org.newdawn.slick.Graphics g;
	
	// start postion for draw line
	float startX, startY;
	
	boolean isFillDraw;
	
	public Slick2DGraphics(Sprite sprite)
	{
		super(sprite);
		
		allList.add(this);
	}
	
	void setGraphics(org.newdawn.slick.Graphics g)
	{
		this.g = g;
	}
	
	public static void SetGraphics(org.newdawn.slick.Graphics g)
	{
		for (Slick2DGraphics sg : allList)
			sg.setGraphics(g);
	}
	
	public void clear()
	{
		isFillDraw = false;
	}
	
	public void lineStyle(float lineThickness, long lineColor, float lineAlpha)
	{
		if ( g != null && sprite.visible )
		{
			g.setLineWidth(lineThickness);
			
			Color color = convertColor(lineColor, lineAlpha);			
			g.setColor( color );
		}
	}
	
	public void beginFill(long fillColor, float fillAlpha)
	{
		isFillDraw = true;
		
		if ( g != null && sprite.visible )
		{
			Color color = convertColor(fillColor, fillAlpha);			
			g.setColor( color );
		}
	}
	
	public void drawCircle(float x, float y, float radius)
	{
		if ( g != null && sprite.visible ) 
		{
			float _x = this.sprite.getX() + x;
			float _y = this.sprite.getY() + y;
			
			if ( isFillDraw )
				g.fill(new Circle(_x, _y, radius));
			else
				g.draw(new Circle(_x, _y, radius));
		}
	}
	
	public void drawRect(float x, float y, float w, float h)
	{
		if ( g != null && sprite.visible )
		{
			
			Shape rect = new Rectangle( -w / 2, -h / 2, w, h);
			
			float angle =  this.sprite.getRotation();			
			Transform trans = Transform.createRotateTransform(angle * MathUtil.PI_OVER_ONE_EIGHTY, 0, 0);
			
			rect = rect.transform(trans);
			
			float _x = sprite.getX();
			float _y = sprite.getY();
			
			Transform translate = Transform.createTranslateTransform(_x, _y);
			rect = rect.transform(translate);
		
			
			if ( isFillDraw )
				g.fill( rect );
			else
				g.draw( rect );
		}
	}
	
	
	public void moveTo(float x, float y)
	{
		startX = x + sprite.getX();
		startY = y + sprite.getY();
	}
	
	public void lineTo(float endX, float endY)
	{
		if ( g != null && sprite.visible ) 
		{
			g.drawLine(startX, startY, endX + sprite.getX(), endY + sprite.getY() );
		}
	}
	
	public void endFill()
	{
		isFillDraw = false;
	}
	
	Color convertColor(long fillColor, float fillAlpha)
	{
		int _r = (int) (( fillColor >> 16 ) & 0xFFL);
		int _g = (int) (( fillColor >> 8 ) & 0xFFL);
		int _b = (int) (( fillColor >> 0 ) & 0xFFL);
		int _a = (int)(fillAlpha * 255.0f);
		
		return new Color( _r, _g, _b,  _a);
	}
}
