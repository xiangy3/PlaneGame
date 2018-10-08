package com.bjsxt.Util;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Constant {
	public static final int GAME_WIDTH = 400;
	public static final int GAME_HEIGHT = 600;

	public static final Image SELFPLANE = GameUtil.getImage("images/my_1.png").getScaledInstance(30, 30, 1);
	
	
	public static final Image SELFBOMB = GameUtil.getImage("images/SelfBomb_2.png").getScaledInstance(40, 40, 1);
	
	public static final ImageIcon EXPLOSION = new ImageIcon("images/selfExplosion.gif");
}