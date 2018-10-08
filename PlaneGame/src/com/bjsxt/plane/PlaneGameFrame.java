package com.bjsxt.plane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;

import com.bjsxt.Util.Constant;
import com.bjsxt.Util.GameUtil;
import com.bjsxt.Util.MyFrame;

public class PlaneGameFrame extends MyFrame {
	Image bg = GameUtil.getImage("images/map.jpg").getScaledInstance(400, 1024, 1);
	Plane p = new Plane(Constant.SELFPLANE, 200, 200);
	ArrayList bulletlist = new ArrayList();

	Date startTime;
	Date endTime;
	Date costTime;

	Explosion bomb;

	public void paint(Graphics g) {
		g.drawImage(bg, 0, 0, null);

		p.draw(g);

		for (int i = 0; i < bulletlist.size(); i++) {
			Bullet b = (Bullet) bulletlist.get(i);
			b.draw(g);
			costTime = new Date();
			int duringTime = (int) (costTime.getTime() - startTime.getTime()) / 1000;
			printInfo(g, "Time:" + duringTime + "s", Color.MAGENTA, 320, 50, 20);
			boolean touch = b.getRect().intersects(p.getRect());
			if (touch) {
				p.setAlive(false);
				
				if (bomb == null) {
					endTime = new Date();
					bomb = new Explosion(p.x, p.y);
				}
				bomb.draw(g);
				break;

			}
		}
		if (!p.isAlive()) {

			// explosion(g, Constant.SELFBOMB, p.x, p.y);
			int period = (int) (endTime.getTime() - startTime.getTime()) / 1000;

			switch (period/10 ) {
			case 0:

			case 1:
				printInfo(g, "菜鸟", Color.MAGENTA, 80, 200, 50);

				break;
			case 2:
				printInfo(g, "小鸟", Color.MAGENTA, 80, 200, 50);
				break;
			case 3:
				printInfo(g, "大鸟", Color.MAGENTA, 80, 200, 50);
				break;
			case 4:
				printInfo(g, "鸟王", Color.MAGENTA, 80, 200, 50);
				break;

			default:
				printInfo(g, "鸟人", Color.MAGENTA, 80, 200, 50);
				break;
			}
			printInfo(g, "Time: " + period + "s", Color.WHITE, 130, 260, 40);
		}
		// printInfo(g,"Score: 100",Color.YELLOW,10,50,20);

	}

	public void printInfo(Graphics g, String str, Color color, int x, int y, int size) {
		Color c = g.getColor();
		g.setColor(color);

		Font f = new Font("Times New Roman", Font.BOLD, size);
		g.setFont(f);
		g.drawString(str, x, y);
		g.setColor(c);
	}

	public void explosion(Graphics g, Image img, double x, double y) {
		g.drawImage(img, (int) x, (int) y, null);
	}

	public static void main(String[] args) {
		new PlaneGameFrame().launchFrame();

	}

	public void launchFrame() {
		super.launchFrame();
		addKeyListener(new KeyMonitor());

		// Create Bullet
		for (int i = 0; i < 60; i++) {
			Bullet b = new Bullet();
			bulletlist.add(b);
		}
		startTime = new Date();
	}

	class KeyMonitor extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {
			p.addDirection(e);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			p.stopMoving(e);
		}

	}
}
