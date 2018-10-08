package com.bjsxt.Util;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyFrame extends Frame {
	/*private Image iBuffer = null;

	public void update(Graphics g) {
		if (iBuffer == null)
			iBuffer = this.createImage(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);

		Graphics gOff = iBuffer.getGraphics();
		paint(gOff);
		g.drawImage(iBuffer, 0, 0, this);
	}*/

	public void launchFrame() {
		setSize(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);
		setLocation(100, 100);

		setVisible(true);

		new PaintThread().start();

		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {

				System.exit(0);
			}

		});
	}

	class PaintThread extends Thread {
		public void run() {
			while (true) {
				repaint();
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
