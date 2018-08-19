import java.util.concurrent.TimeUnit;
import processing.core.PApplet;

public class Timer extends Thread {

	private PApplet app;
	private int comenzar;
	private int millis;
	
	public Timer(PApplet app) {
		this.app = app;
		comenzar = 0;
	}
	
	public void empezar() {
		comenzar = app.millis();
	}
	
	public int tiempoReproducido() {
		int tiempo;
		tiempo = app.millis() - comenzar;
		return tiempo;
	}

	//GETTERS Y SETTERS
	public int getMillis() {
		return millis;
	}

	public void setMillis(int millis) {
		this.millis = millis;
	}
	
	/*
	 * Devuelve los milisegundos reproducidos
	 */
	int millis() {
		return tiempoReproducido() - second() * 1000 - minute() * 60000;
	}
	
	/*
	 * Devuelve los segundos reproducidos
	 */
	int second() {
		return (tiempoReproducido() / 1000);
	}

	/*
	 * Devuelve los minutos reproducidos
	 */
	int minute() {
		return (tiempoReproducido() / (1000 * 60)) % 60;
	}

}