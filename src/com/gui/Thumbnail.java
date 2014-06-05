package com.gui;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class Thumbnail {
	private String srcFile;
	private String destFile;
	private int width;
	private int height;
	private Image img;
	
	public Thumbnail(String fileName) throws IOException{
		File _file = new File(fileName);
		this.srcFile = _file.getName();
		this.destFile = this.srcFile.substring(0,this.srcFile.lastIndexOf("."))+"_s.jpg";
		img = ImageIO.read(_file);
		width = img.getHeight(null);
		height = img.getHeight(null);
	}
	
	public void resize(int w,int h) throws IOException{
		BufferedImage _image = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
		_image.getGraphics().drawImage(img, 0, 0, w, h, null);
		FileOutputStream out = new FileOutputStream(destFile);
		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
		encoder.encode(_image);
		out.close();
	}
	public void resize(double t) throws IOException{
		int w =(int)(width*t);
		int h = (int)(height*t);
		resize(w,h);
	}

	public String getSrcFile() {
		return srcFile;
	}

	public void setSrcFile(String srcFile) {
		this.srcFile = srcFile;
	}

	public String getDestFile() {
		return destFile;
	}

	public void setDestFile(String destFile) {
		this.destFile = destFile;
	}

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

	public Image getImg() {
		return img;
	}

	public void setImg(Image img) {
		this.img = img;
	}
	public static void main(String arges[]){
		try {
		Thumbnail tn  = new Thumbnail("D:/2.jpg");
		tn.resize(300,600);
		System.out.println("success");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}
