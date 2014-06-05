package com.gui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;

import javax.swing.JPanel;

public class CustomImaPanel extends JPanel{

	private int width = 0;
	private int height =0;
	private String imgPath="";
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	
	public CustomImaPanel(int width,int height,String imgPath){
		this.width = width;
		this.height = height;
		this.imgPath = imgPath;
		setSize(width,height);
		setVisible(true);
	}
	@Override
	public void paintComponent(Graphics gs){
		Graphics2D g = (Graphics2D)gs;
		super.paintComponent(g);
		Image image = Toolkit.getDefaultToolkit().getImage(getClass().getResource(imgPath));
		//ImageIcon icon = new ImageIcon(imgPath);
		//Image image = icon.getImage();
		
		g.drawImage(image, 0, 0, width, height, this);
	}
}
