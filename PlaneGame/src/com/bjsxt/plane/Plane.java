package com.bjsxt.plane;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import com.bjsxt.Util.Constant;

public class Plane extends GameObject {

	boolean left, up, right, down;
	private boolean alive = true;

	public Rectangle getRect() {
		return new Rectangle((int) x, (int) y, width, height);
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	public void draw(Graphics g) {
		if (alive) {
			g.drawImage(img, (int) x, (int) y, null);
			move();
		}

	}

	public void move() {

		if (left) {
			x -= speed;
		}
		if (right) {
			x += speed;
		}
		if (up) {
			y -= speed;
		}
		if (down) {
			y += speed;
		}
		alternate();
	}

	public void alternate() {
		if (x < 0 - width) {
			x = Constant.GAME_WIDTH;
		}
		if (x > Constant.GAME_WIDTH) {
			x = 0 - width;
		}
		if (y < 0 - height + 22) {
			y = Constant.GAME_HEIGHT;
		}
		if (y > Constant.GAME_HEIGHT) {
			y = 22 - height;
		}
	}

	public void addDirection(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			left = true;
			break;
		case KeyEvent.VK_RIGHT:
			right = true;
			break;
		case KeyEvent.VK_UP:
			up = true;
			break;
		case KeyEvent.VK_DOWN:
			down = true;
			break;

		default:
			break;
		}
	}

	public void stopMoving(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			left = false;
			break;
		case KeyEvent.VK_RIGHT:
			right = false;
			break;
		case KeyEvent.VK_UP:
			up = false;
			break;
		case KeyEvent.VK_DOWN:
			down = false;
			break;

		default:
			break;
		}
	}

	public Plane(Image img, double x, double y) {
		speed = 1.5;
		this.img = img;
		this.x = x;
		this.y = y;
		this.width = img.getWidth(null);
		this.height = img.getHeight(null);
	}

	public Plane() {

	}
}
