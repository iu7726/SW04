package gui.swing;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Test12{
	public static void main(String[] args) throws AWTException, IOException {
		//��ũ����		Robot(�ڵ�ȭ ����)
		Robot r = new Robot();//UI�� ���� �ü������ ���� �� ��� ��� �Ұ�����
		
		Rectangle rect = new Rectangle(0, 0, 1600, 900);
		BufferedImage img = r.createScreenCapture(rect);
		
		//ĸ�� �̹����� ����ڿ��� �����ִ� ���
		//1. ȭ�鿡 ǥ�� 
		
		//2. ���� ���� ImageIO
		ImageIO.write(img, "png", new File("save.png"));
		
		
		//3. Ŭ������***����� �ڵ尡 �� ����
	}
}