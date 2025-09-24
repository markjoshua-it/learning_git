package learning_git;

import javax.swing.*;

public class Bulb extends JCheckBox {
	public Bulb(){
		setIcon(new ImageIcon("assets/bulb_off.png"));
		setSelectedIcon(new ImageIcon("assets/bulb_on.png"));
		setOpaque(false);
	}
}
