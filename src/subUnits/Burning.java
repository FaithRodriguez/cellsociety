package subUnits;

import cellsociety_team06.Unit;
import javafx.scene.paint.Color;

public class Burning extends Unit{
	private static final Color COLOR = Color.RED;
	public Burning(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
		setFill(COLOR);
		state = 0;
	}
	
	public Burning(double x, double y, double width, double height) {
		this((int) x, (int) y, (int) width, (int) height);
	}

}
