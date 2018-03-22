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
		//스크린샷		Robot(자동화 도구)
		Robot r = new Robot();//UI가 없는 운영체제에서 실행 할 경우 어떻게 할것인지
		
		Rectangle rect = new Rectangle(0, 0, 1600, 900);
		BufferedImage img = r.createScreenCapture(rect);
		
		//캡쳐 이미지를 사용자에게 보여주는 방법
		//1. 화면에 표시 
		
		//2. 파일 저장 ImageIO
		ImageIO.write(img, "png", new File("save.png"));
		
		
		//3. 클립보드***어려움 코드가 좀 길음
	}
}