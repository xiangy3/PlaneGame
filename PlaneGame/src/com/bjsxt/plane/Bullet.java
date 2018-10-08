package com.bjsxt.plane;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.bjsxt.Util.Constant;

public class Bullet extends GameObject{
	double x, y;
	
	double degree;
	
	
	public Bullet(){
		degree=Math.random()*Math.PI*2;
		x=Constant.GAME_WIDTH/2;
		y=Constant.GAME_HEIGHT/2;
		width=5;
		height=5;
		speed=0.6;
	}
	
	public Rectangle getRect() {
		Rectangle r = new Rectangle((int) x, (int) y, width, height);
		return r;
	}

	public void draw(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.white);
		g.fillOval((int)x, (int)y, width, height);
		
		x+=speed*Math.cos(degree);
		y+=speed*Math.sin(degree);
		
		if (y < 22 || y > Constant.GAME_HEIGHT-height) {
			degree = -degree;

		}

		if (x < 0 || x > Constant.GAME_WIDTH - width) {
			degree = Math.PI - degree;
		}
		g.setColor(c);
	}
}
