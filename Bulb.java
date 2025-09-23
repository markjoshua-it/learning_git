package testArea;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;

public class Bulb extends JCheckBox {
	public Bulb(){
		setIcon(new ImageIcon("src/assets/bulb_off.png"));
		setSelectedIcon(new ImageIcon("src/assets/bulb_on.png"));
		setOpaque(false);
	}
}
