package testArea;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyFrame extends JFrame{
	final int width = 800;
	final int height = 600;
	int randomNumber = (int)((Math.random()*1023)+1);
	
	Bulb[] bulb = new Bulb[10];
	JButton submit_button;
	JLabel message;
	
	public MyFrame(){
		// JPANEL WINDOW
		// DON'T TOUCH IT
		JPanel mainWindow = new JPanel();
		mainWindow.setPreferredSize(new Dimension(width, height));
		mainWindow.setLayout(new BorderLayout());
		
		// RAND NUM HERE AND CHECK WIN
		JPanel upper_panel = new JPanel();
		upper_panel.setLayout(new BorderLayout());
		upper_panel.setBackground(Color.gray);
		upper_panel.setPreferredSize(new Dimension(width, height/2));
		
		// BULB AND BUTTON HERE
		JPanel bottom_panel = new JPanel();
		bottom_panel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 35));
		bottom_panel.setBackground(new Color(87, 120, 147));
		bottom_panel.setPreferredSize(new Dimension(width, height/2));
		
		// BULB PANEL
		JPanel bulb_panel = new JPanel();
		bulb_panel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 25));
		bulb_panel.setOpaque(false);
		
		// BUTTON PANEL
		submit_button = new JButton("Submit");
		submit_button.setPreferredSize(new Dimension(150, 60));
		submit_button.setFont(new Font("MV Boli", Font.BOLD, 30));
		submit_button.setFocusable(false);
		submit_button.setBackground(new Color(233,215,0));
		submit_button.setBorder(BorderFactory.createRaisedBevelBorder());
		JPanel button_panel = new JPanel();
		button_panel.setOpaque(false);

		// RAND NUMBER JLABEL
		JLabel number = new JLabel();
		number.setText(randomNumber+"");
		number.setForeground(Color.white);
		number.setFont(new Font("MV Boli", Font.BOLD, 60));
		number.setHorizontalAlignment(JLabel.CENTER);
		message = new JLabel();
		message.setHorizontalAlignment(JLabel.CENTER);
		message.setForeground(Color.darkGray);
		message.setFont(new Font("MV Boli", Font.BOLD, 45));
		
		// ADDING THINGS INTO THE FRAME AND PANEL
		for (int i = 0; i < 10; i++) {
			bulb[i] = new Bulb();
			bulb_panel.add(bulb[i]);
		}
		button_panel.add(submit_button);
		upper_panel.add(message, BorderLayout.NORTH);
		upper_panel.add(number, BorderLayout.CENTER);
		bottom_panel.add(bulb_panel);
		bottom_panel.add(button_panel);
		
		mainWindow.add(upper_panel, BorderLayout.NORTH);
		mainWindow.add(bottom_panel, BorderLayout.SOUTH);
		
		add(mainWindow);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		pack();
		buttonAction();
	}
	
	public void buttonAction(){
		submit_button.addMouseListener(new MouseListener(){
			@Override
			public void mouseClicked(MouseEvent e) {}

			@Override
			public void mousePressed(MouseEvent e) {
				int[] binary_count = {512,256,128,64,32,16,8,4,2,1};
				int count = 0;
				for(int i = 0; i < 10; i++){
					if (bulb[i].isSelected()) {
						count+=binary_count[i];
					}
				}
				if(count==randomNumber)message.setText(String.format("Your answer %d is CORRECT! :)", count));
				else message.setText(String.format("Your answer %d is WRONG! :(", count));
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) { submit_button.setBackground(new Color(248,237,98)); }
			@Override
			public void mouseExited(MouseEvent e) { submit_button.setBackground(new Color(233,215,0)); }
		});
	}
}
