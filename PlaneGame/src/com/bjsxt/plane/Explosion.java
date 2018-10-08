package com.bjsxt.plane;

import java.awt.Graphics;
import java.awt.Image;

import com.bjsxt.Util.GameUtil;

public class Explosion {
	double x, y;
	static Image[] imgs = new Image[18];
	int count;
	static {
		for (int i = 0; i < 18; i++) {
			imgs[i] = GameUtil.getImage("explosion/e"+(i+1)+".png");
			imgs[i].getWidth(null);
		}

	}

	public void draw(Graphics g) {
		if (count < imgs.length) {
			g.drawImage(imgs[count], (int) x, (int) y, null);
			count++;
		}
	}

	public Explosion(double x, double y) {
		this.x = x;
		this.y = y;

	}

}
