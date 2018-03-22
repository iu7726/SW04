package gui.swing;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

//윈도우 빌더 사용법
//클래스에 JFrame을 상속시킨 뒤 윈도우빌더 전용 에디터로 파일을 열면  끝
//좌표를 얻는 것이 주 목적
public class Test10 extends JFrame{
	public Test10() {
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(12, 288, 103, 23);
		getContentPane().add(btnNewButton);
		
		JButton button = new JButton("New button");
		button.setBounds(189, 288, 103, 23);
		getContentPane().add(button);
		
		JButton button_1 = new JButton("New button");
		button_1.setBounds(354, 288, 103, 23);
		getContentPane().add(button_1);
		
		JButton button_2 = new JButton("New button");
		button_2.setBounds(189, 331, 103, 23);
		getContentPane().add(button_2);
		
		JButton button_3 = new JButton("New button");
		button_3.setBounds(12, 331, 103, 23);
		getContentPane().add(button_3);
		
		JButton button_4 = new JButton("New button");
		button_4.setBounds(354, 331, 103, 23);
		getContentPane().add(button_4);
		
		JButton button_5 = new JButton("New button");
		button_5.setBounds(189, 376, 103, 23);
		getContentPane().add(button_5);
		
		JButton button_6 = new JButton("New button");
		button_6.setBounds(12, 376, 103, 23);
		getContentPane().add(button_6);
		
		JButton button_7 = new JButton("New button");
		button_7.setBounds(354, 376, 103, 23);
		getContentPane().add(button_7);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(12, 10, 445, 188);
		getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(22, 212, 435, 66);
		getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblGood = new JLabel("good");
		panel.add(lblGood, BorderLayout.CENTER);
		
		JLabel lblRight = new JLabel("right");
		panel.add(lblRight, BorderLayout.EAST);
	}
}
