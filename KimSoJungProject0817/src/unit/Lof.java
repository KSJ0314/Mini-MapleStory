package unit;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.border.LineBorder;

public class Lof extends JLabel {

	public int x = 25;
	public int y;
	public int xStart;
	public int yStart;
	public String tag = "lof";

	public Lof(int xStart, int yStart, int y) {
		this.y = y;
		this.xStart = xStart;
		this.yStart = yStart;
		setBounds(xStart, yStart, x, y);
		setOpaque(false);
	}

}
