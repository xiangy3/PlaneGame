package com.bjsxt.plane;

import java.awt.Image;
import java.awt.Rectangle;

public class GameObject {
	Image img;
	double x, y;

	int width, height;
	double speed;

	public Rectangle getRect() {
		Rectangle r = new Rectangle((int) x, (int) y, width, height);
		return r;
	}

	public GameObject(Image img, double x, double y, int speed, int width, int height) {
		super();
		this.img = img;
		this.x = x;
		this.y = y;

		this.width = width;
		this.height = height;
	}

	public GameObject() {

	}

}
