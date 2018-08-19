import processing.core.PApplet;

public class MainAppExpUno extends PApplet {

	private Logica l;

	public static void main(String[] args) {
		PApplet.main("MainAppExpUno");
	}

	public void settings() {
		size(1200, 700);
	}

	public void setup() {
		l = new Logica(this);
	}

	public void draw() {
		rectMode(CENTER);
		background(30, 28, 76);
		l.pantallas();
		frameRate(56);
	}
	
	public void mouseClicked() {
		l.mouse();
		System.out.println("mouse X: " + mouseX + " mouseY: " + mouseY);
	}
	
	public void keyReleased() {
		l.teclas();
	}
}