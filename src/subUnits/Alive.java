package subUnits;

import cellsociety_team06.Unit;
import javafx.scene.paint.Color;

public class Alive extends Unit{
	private static final Color COLOR = Color.CHARTREUSE;
	public Alive(int x, int y, int width, int height) {
		super(x, y, width, height);
		setFill(COLOR);
		state = 5;
	}
	
	public Alive(double x, double y, double width, double height) {
		this((int) x, (int) y, (int) width, (int) height);
	}
}
