import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import controlP5.ControlP5;
import controlP5.Textfield;
import ddf.minim.AudioPlayer;
import ddf.minim.AudioSample;
import ddf.minim.Minim;
import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;

public class Logica {

	/*
	 * HOLAAAAA, 
	 * Para ocultar los errores, cambiar a false el boolean mostarErrores
	 * el cual se encuentra AQUI ABAJO
	 * 
	 * 
	 * 
	 */
	private boolean mostrarErrores = true;
	
	/*
	 * 
	 * 
	 * 
	 */
	
	//ATENCIÓN: Coloque aquí el número de prueba que va a realizar//
	private String numeroDePrueba = "3";
	
	private String nombreTexto = "texto" + numeroDePrueba + ".txt";
	private String audio1 = "AudioUnoPrueba" + numeroDePrueba + ".mp3";
	private String audio2 = "AudioDosPrueba" + numeroDePrueba + ".mp3";
	
	private PApplet app;
	private Timer t;
	private String tiempo;
	private int millis, segundos, nivel, minutos;
	private boolean tareaTerminada, tareaTerminadaMal, tareaTerminadaPal, tareaTerminadaMalPal, tareaTerminadaOr,
			tareaTerminadaMalOr, tareaTerminadaParr, tareaTerminadaMalParr;
	private AudioSample audioBueno, audioMalo, parr1, parr2;
	private AudioPlayer _parr1, _parr2, parrAudio[];
	private Minim minim;
	private PFont dosisFuente, dosisFuenteReg, dosisCampos;
	private int x, y;
	private PImage imgs[], formulario, planetas[], emoji[], emoji2[], trans[], nivel2[], nivel3[], nivel4[], botonError;
	private int contadorItem, opacidad, imgOpacidad;
	private int contadorPal, contadorInternoPal, contadorInternoOr, contadorInternoParr, contadorGeneral;
	int frame = 0;
	int frame2 = 12;
	int frame3 = 0;
	int frame4 = 0;
	int frame5 = 0;
	int frame6 = 0;

	int imgPuntaje;
	private String[] texto;
	private String datosUsuario, nombre, carrera, ocupacion, edad, genero;
	private boolean[] acerto;
	private String[] resultadosUsuario;
	private String palabraEscrita;
	private String parrafoEscrito;
	private String oracionEscrita;
	private ArrayList<Letra> letras;
	private ArrayList<Palabra> palabras;
	private ArrayList<Oracion> oraciones;
	private ArrayList<Parrafo> parrafos;
	private int errores;

	private char[] letrasTemp;
	private char[] palabraTemp;
	private char[] oracionTemp;
	private char[] parrafoTemp;
	private String letraEscrita;
	private boolean animar, isPlayingSong, tiempoN4;
	
	private int[] puntajeNiveles;
	private PImage puntaje[], soundbtn, formularios[];

	private String mostrarPalabra;

	private ControlP5 cp5;

	private int erroresTempLetra, erroresTempPal, erroresTempOr, erroresTempParr;
	private int erroresLetras, erroresPalabras, erroresOraciones, erroresParrafos;
	private int puntajeFinal;
	private int formularioInt;
	private boolean mostrartexto;

	public Logica(PApplet app) {
		this.app = app;
		t = new Timer(app);
		t.start();
		inicializarVars();
		cargarImgs();
		cargarfuente();
		cargarTexto();
		cargarArrayTexto();
		app.imageMode(app.CENTER);
	}

	private void cargarImgs() {

		soundbtn = app.loadImage("../data/soundbutton.png");
		imgs = new PImage[8];

		for (int i = 0; i < imgs.length; i++) {
			imgs[i] = app.loadImage("../data/n" + i + ".png");
		}

		planetas = new PImage[4];

		for (int i = 0; i < planetas.length; i++) {
			planetas[i] = app.loadImage("../data/planeta" + i + ".png");
		}

		formulario = app.loadImage("../data/formulario.png");

		emoji = new PImage[12];

		for (int i = 0; i < emoji.length; i++) {
			emoji[i] = app.loadImage("../data/Emojis/emoji_" + i + ".png");
		}

		emoji2 = new PImage[13];

		for (int i = 12; i < 25; i++) {
			emoji2[i - 12] = app.loadImage("../data/Emojis/emoji_" + i + ".png");
		}

		trans = new PImage[41];

		for (int i = 6; i < 47; i++) {
			trans[i - 6] = app.loadImage("../data/NivelUno/NivelUno_" + i + ".png");
		}

		nivel2 = new PImage[23];

		for (int i = 1; i < 23; i++) {
			nivel2[i - 1] = app.loadImage("../data/Animacion nivel 2/AnimacionDos_" + i + ".png");
		}

		nivel3 = new PImage[23];

		for (int i = 1; i < 23; i++) {
			nivel3[i - 1] = app.loadImage("../data/Animacion nivel 3/NivelTres_" + i + ".png");
		}

		nivel4 = new PImage[23];

		for (int i = 1; i < 23; i++) {
			nivel4[i - 1] = app.loadImage("../data/Animacion nivel 4/NivelCuatro_" + i + ".png");
		}

		puntaje = new PImage[16];

		for (int i = 1; i < 16; i++) {
			puntaje[i - 1] = app.loadImage("../data/Puntaje/puntaje (" + i + ").png");
		}

		formularios = new PImage[3];

		for (int i = 0; i < formularios.length; i++) {
			formularios[i] = app.loadImage("../data/formulario" + i + ".png");
		}

		botonError = app.loadImage("../data/botonError.png");

	}

	private void inicializarVars() {
		isPlayingSong = false;
		mostrartexto = true;
		tiempoN4 = false;
		animar = false;
		tareaTerminada = false;
		tareaTerminadaMal = false;
		tareaTerminadaPal = false;
		tareaTerminadaMalPal = false;
		tareaTerminadaOr = false;
		tareaTerminadaMalOr = false;
		tareaTerminadaParr = false;
		tareaTerminadaMalParr = false;
		contadorInternoPal = 0;
		contadorInternoParr = 0;
		contadorGeneral = 1;
		cp5 = new ControlP5(app);
		nivel = 0;
		y = app.height / 2;
		x = app.width / 2;
		contadorItem = 1;
		letras = new ArrayList<Letra>();
		palabras = new ArrayList<Palabra>();
		oraciones = new ArrayList<Oracion>();
		parrafos = new ArrayList<Parrafo>();
		opacidad = 255;
		imgOpacidad = 0;
		palabraEscrita = "";
		oracionEscrita = "";
		parrafoEscrito = "";
		mostrarPalabra = "";
		resultadosUsuario = new String[52];
		acerto = new boolean[52];
		minim = new Minim(app);
		audioBueno = minim.loadSample("../data/Bueno.mp3", 512);
		audioMalo = minim.loadSample("../data/Malo.mp3", 512);
		parr1 = minim.loadSample("../data/" + audio1,512);
		parr2 = minim.loadSample("../data/" + audio2, 512);
		errores = 0;
		erroresTempLetra = 0;
		erroresTempOr = 0;
		erroresTempParr = 0;
		erroresLetras = 0;
		erroresOraciones = 0;
		erroresPalabras = 0;
		erroresParrafos = 0;
		puntajeFinal = 1000;

		parrAudio = new AudioPlayer[2];
		puntajeNiveles = new int[4];
		formularioInt = 0;

		for (int i = 0; i < 2; i++) {
			parrAudio[i] = minim.loadFile("../data/Audio " + i + 1 + " Lento.mp3", 512);
		}
	}

	private void cargarTexto() {
		texto = app.loadStrings(nombreTexto);
		for (int i = 0; i < texto.length; i++) {
			System.out.println(texto[i]);
		}
	}

	public void cargarArrayTexto() {
		for (int i = 0; i < 25; i++) {
			letras.add(new Letra(texto[i]));
		}
		for (int i = 25; i < 45; i++) {
			palabras.add(new Palabra(texto[i]));
		}
		for (int i = 45; i < 49; i++) {
			oraciones.add(new Oracion(texto[i]));
		}
		for (int i = 49; i < 51; i++) {
			parrafos.add(new Parrafo(texto[i]));
		}
		// IMPRIMIR
		System.out.println("----ARRAYLIST DE LETRAS-----");
		for (int i = 0; i < letras.size(); i++) {
			System.out.println("posicion: " + i + " contiene: " + letras.get(i).getLetra());
		}
		System.out.println("----ARRAYLIST DE PALABRAS-----");
		for (int i = 0; i < palabras.size(); i++) {
			System.out.println("posicion: " + i + " contiene: " + palabras.get(i).getPalabra());
		}
		System.out.println("----ARRAYLIST DE ORACIONES-----");
		for (int i = 0; i < oraciones.size(); i++) {
			System.out.println("posicion: " + i + " contiene: " + oraciones.get(i).getOracion());
		}
		System.out.println("----ARRAYLIST DE PARRAFOS-----");
		for (int i = 0; i < parrafos.size(); i++) {
			System.out.println("posicion: " + i + " contiene: " + parrafos.get(i).getParrafo());
		}

	}

	private void cargarfuente() {
		dosisFuente = app.loadFont("Dosis-Bold-48.vlw");
		dosisFuenteReg = app.loadFont("Dosis-Regular-48.vlw");
		dosisCampos = app.createFont("Dosis-SemiBold-27.vlw", 18);
	}

	public void pantallas() {
		app.image(imgs[0], x, y);
		switch (nivel) {
		// Inicio
		case 0:
			//
			fadeInImg();
			app.image(imgs[5], x, y);

			break;

		// Instrucciones
		case 1:
			//
			fadeInImg();
			app.image(imgs[7], x, y);
			//

			break;

		// Animacion a nivel 1
		case 2:
			app.image(trans[frame3], x, y);
			if (app.frameCount % 5 == 0) {
				frame3++;
				if (frame3 == 41) {
					reiniciarTiempo();
					frame3 = 0;
					nivel = 3;
				}

			}

			break;

		///////////////////////////////////////////////////////////////////////////////////////////////////
		// --------------- NIVEL 1 -----------
		case 3:

			app.image(planetas[0], x, y + 40);
			validarTiempo();
			fadeIn();

			if (mostrartexto) {
				setFuenteBold(48, 255);
				app.textAlign(app.CENTER, app.CENTER);
				app.text("Nivel 1", x, y - 250);

				setFuenteBold(80, 255);
				app.textAlign(app.CENTER, app.CENTER);
				app.text(letras.get(contadorItem - 1).getLetra(), x, y);

				setFuenteBold(35, 255);
				app.textAlign(app.CENTER, app.CENTER);
				app.text(contadorItem + "/25", x + 500, y - 250);

				if(mostrarErrores) {
				setFuenteBold(35, 255);
				app.textAlign(app.CENTER, app.CENTER);
				app.image(botonError, 81, 98);
				app.text(erroresLetras, 120, 98);
				// app.text("PUNTAJE: " + puntajeFinal, x - 430, y - 250);
				}
			}

			if (tareaTerminada) {
				mostrartexto = false;
				sigLetra();
				mostrartexto = true;
			}

			if (tareaTerminadaMal) {
			}

			break;

		// feedback nivel 1
		case 4:
			//
			fadeInImg();
			//

			app.image(imgs[1], x, y);
			imgPuntaje = 12;
			// app.image(puntaje[imgPuntaje], x, y - 130);

			if (!animar) {
				float tamArreglo = letras.size();
				float puntajeNivel1 = puntajeNiveles[0];
				int calcularPuntaje = (int) (app.map(puntajeNivel1, 0, tamArreglo, 1, 4));

				System.out.println("El puntaje real es : " + puntajeNiveles[0] + " El puntaje es: " + calcularPuntaje);

				switch (calcularPuntaje) {
				case 1:
					app.image(puntaje[0], x, y - 130);
					break;
				case 2:
					app.image(puntaje[1], x, y - 130);
					break;
				case 3:
					app.image(puntaje[2], x, y - 130);
					break;
				case 4:
					app.image(puntaje[3], x, y - 130);
					break;
				}
			}

			break;

		///////////////////////////////////////////////////////////////////////////////////////////////////
		// ---------------NIVEL 2 ---------------

		case 5:
			app.image(planetas[1], x, y + 40);
			validarTiempo();
			fadeIn();
			if (mostrartexto) {

				setFuenteBold(48, 255);
				app.textAlign(app.CENTER, app.CENTER);
				app.text("Nivel 2", x, y - 250);

				setFuenteBold(48, 255);
				app.textAlign(app.LEFT, app.LEFT);
				app.text(palabras.get(contadorItem - 1).getPalabra(), x - 100, y);

				app.textFont(dosisFuente, 48);
				app.fill(255, 132, 61);
				app.textAlign(app.LEFT, app.LEFT);
				app.text(palabraEscrita  + "_", x - 100, y);

				app.textFont(dosisFuente, 35);
				app.fill(255);
				app.textAlign(app.LEFT, app.LEFT);
				app.text(contadorItem + "/20", x + 500, y - 250);

				if(mostrarErrores) {
				setFuenteBold(35, 255);
				app.textAlign(app.CENTER, app.CENTER);
				app.image(botonError, 81, 98);
				app.text(erroresPalabras, 120, 98);
				}
			}

			if (tareaTerminadaPal) {
				mostrartexto = false;
				sigPalabra();
				mostrartexto = true;
			}

			break;

		// feedback nivel 2
		case 6:
			//
			fadeInImg();
			//
			if (!animar) {
				app.image(imgs[2], x, y);
				float tamArreglo = palabras.size();
				float puntajeNivel2 = puntajeNiveles[1];
				int calcularPuntaje = (int) (app.map(puntajeNivel2, 0, tamArreglo, 1, 4));

				System.out.println("El puntaje real es : " + puntajeNiveles[1] + " El puntaje es: " + calcularPuntaje);

				switch (calcularPuntaje) {
				case 1:
					app.image(puntaje[4], x, y - 130);
					break;
				case 2:
					app.image(puntaje[5], x, y - 130);
					break;
				case 3:
					app.image(puntaje[6], x, y - 130);
					break;
				case 4:
					app.image(puntaje[7], x, y - 130);
					break;
				}
			}

			break;

		///////////////////////////////////////////////////////////////////////////////////////////////////
		// ---------------NIVEL 3 ---------------

		case 7:
			app.image(planetas[2], x - 10, y + 45);
			validarTiempo();
			fadeIn();

			if (mostrartexto) {
				setFuenteBold(48, 255);
				app.textAlign(app.CENTER, app.CENTER);
				app.text("Nivel 3", x, y - 250);

				
				setFuenteBold(48, 150);
				app.textAlign(app.LEFT, app.LEFT);
				app.text(oraciones.get(contadorItem - 1).getOracion(), x - 30, y + 70, 1000, 300);

				app.textFont(dosisFuente, 48);
				app.fill(45, 164, 255);
				app.textAlign(app.LEFT, app.LEFT);
				app.text(oracionEscrita  + "_", x - 30 , y + 70, 1000, 300);

				app.textFont(dosisFuente, 35);
				app.fill(255);
				app.textAlign(app.LEFT, app.LEFT);
				app.text(contadorItem + "/4", x + 500, y - 250);

				if(mostrarErrores) {
				setFuenteBold(35, 255);
				app.textAlign(app.CENTER, app.CENTER);
				app.image(botonError, 81, 98);
				app.text(erroresOraciones, 120, 98);
				}
			}

			if (tareaTerminadaOr) {
				mostrartexto = false;
				sigOracion();
				mostrartexto = true;
			}

			break;

		// feedback nivel 3
		case 8:
			//
			fadeInImg();
			//
			app.image(imgs[3], x, y);
			if (!animar) {
				float tamArregloOr = oraciones.size();
				float puntajeNivel3 = puntajeNiveles[2];
				int calcularPuntajeOr = (int) (app.map(puntajeNivel3, 0, tamArregloOr, 1, 4));

				System.out
						.println("El puntaje real es : " + puntajeNiveles[2] + " El puntaje es: " + calcularPuntajeOr);

				switch (calcularPuntajeOr) {
				case 1:
					app.image(puntaje[8], x, y - 130);
					break;
				case 2:
					app.image(puntaje[9], x, y - 130);
					break;
				case 3:
					app.image(puntaje[10], x, y - 130);
					break;
				case 4:
					app.image(puntaje[11], x, y - 130);
					break;
				}
			}

			break;

		///////////////////////////////////////////////////////////////////////////////////////////////////
		// ---------------NIVEL 4 ---------------

		case 9:
			app.image(planetas[3], x, y + 35);
			validarTiempo();
			fadeIn();

			if (mostrartexto) {
				setFuenteBold(48, 255);
				app.textAlign(app.CENTER, app.CENTER);
				app.text("Nivel 4", x, y - 250);

				setFuenteBold(31, 255);
				app.textAlign(app.CENTER, app.CENTER);
				app.text("Para escuchar el audio, da click sobre el icono de parlante", x, y - 180);
				
				setFuenteBold(35, 255);
				app.textAlign(app.CENTER, app.CENTER);
				app.text(contadorItem + "/2", x + 500, y - 250);

				app.textFont(dosisFuente, 48);
				app.fill(255, 61, 99);
				app.textAlign(app.LEFT, app.LEFT);
				app.text(parrafoEscrito + "_", x + 200, y + 45, 600, 300);

				if(mostrarErrores) {
				setFuenteBold(35, 255);
				app.textAlign(app.CENTER, app.CENTER);
				app.image(botonError, 81, 98);
				app.text(erroresParrafos, 120, 98);
				}
				
				app.image(soundbtn, 176+100, y);
			}

			if (tareaTerminadaParr) {
				mostrartexto = false;
				sigParrafo();
				mostrartexto = true;

			}

			break;

		// feedback final
		case 10:
			//
			fadeInImg();
			//
			app.image(imgs[4], x, y);

			app.textFont(dosisFuente, 35);
			app.fill(255);
			app.textAlign(app.CENTER, app.CENTER);
			app.text("PUNTAJE FINAL: " + puntajeFinal, x, 211);
			System.out.println("FINAAAAAAAAAAAAAAAAL");
			break;
		// formulario inicial
		case 11:

			switch (formularioInt) {
			case 0:
				app.image(formularios[0], x, y);
				break;
			case 1:
				app.image(formularios[1], x, y);
				break;
			case 2:
				app.image(formularios[2], x, y);
				break;
			}

			break;

		case 12:
			break;
		case 13:
			app.image(nivel2[frame4], x, y);
			if (app.frameCount % 5 == 0) {
				frame4++;
				if (frame4 == 22) {
					reiniciarTiempo();
					nivel = 5;
					animar = false;

				}
			}
			break;
		case 14:
			app.image(nivel3[frame5], x, y);
			if (app.frameCount % 5 == 0) {
				frame5++;
				if (frame5 == 22) {

					reiniciarTiempo();
					nivel = 7;
				}
			}
			break;
		case 15:

			app.image(nivel4[frame6], x, y);
			if (app.frameCount % 5 == 0) {
				frame6++;
				if (frame6 == 22) {
					reiniciarTiempo();
					nivel = 9;
				}
			}
			break;

		case 16:

			break;

		}
		if (nivel != 11 && nivel != 0) {
			cp5.get("").hide();
			cp5.get(" ").hide();
			cp5.get("  ").hide();
			cp5.get("   ").hide();
		}

		generarBaseDeDatos();

	}

	//
	private void fadeInImg() {

		app.tint(255, imgOpacidad);
		if (app.frameCount % 5 == 0 && imgOpacidad <= 255) {
			imgOpacidad += 50;
		}
	}

	//
	private void fadeIn() {
		if (app.frameCount % 8 == 0 && opacidad <= 100) {
			opacidad += 50;
		}
	}

	private void setFuenteBold(int i, int j) {
		app.textFont(dosisFuente, i);
		app.fill(j, j, j, opacidad);
	}

	private void setFuenteRegular(int i, int j) {
		app.textFont(dosisFuenteReg, i);
		app.fill(j, j, j, opacidad);
	}

	public void validarTiempo() {
		millis = t.millis();
		segundos = t.second();
		minutos = t.minute();
		tiempo = segundos + "," + millis;
		setFuenteRegular(21, 255);
		app.textAlign(app.LEFT, app.LEFT);
		app.text(tiempo, 1100, 650);
	}

	public void reiniciarTiempo() {
		t.empezar();
	}

	public void mouse() {

		// Cambiar pantalla
		System.out.println("NIIIIIIIIIIIIIIIIIIIIIVAEEEEEEEEEEEEEL" + nivel);
		if (nivel == 0) {
			nivel = 11;

			if (app.mouseX >= 521 && app.mouseX <= 683 && app.mouseY >= 389 && app.mouseY < 440) {
				imgOpacidad = 0;

				// Campo de Texto
				int blanco = app.color(255);
				int negro = app.color(60, 60, 59);

				cp5.addTextfield("").setPosition(335, 208).setSize(400, 24).setFont(dosisCampos).setColor(negro)
						.setColorForeground(blanco).setColorBackground(blanco).setColorActive(blanco)
						.setColorLabel(blanco);

				cp5.addTextfield(" ").setPosition(335, 297).setSize(400, 24).setFont(dosisCampos).setColor(negro)
						.setColorForeground(blanco).setColorBackground(blanco).setColorActive(blanco)
						.setColorLabel(blanco);

				cp5.addTextfield("  ").setPosition(335, 387).setSize(426, 24).setFont(dosisCampos).setColor(negro)
						.setColorForeground(blanco).setColorBackground(blanco).setColorActive(blanco)
						.setColorLabel(blanco);
				cp5.addTextfield("   ").setPosition(334, 476).setSize(140, 24).setFont(dosisCampos).setColor(negro)
						.setColorForeground(blanco).setColorBackground(blanco).setColorActive(blanco)
						.setColorLabel(blanco);

			}
		} else if (nivel == 11) {
			if (app.mouseX > 501 && app.mouseX < 707 && app.mouseY > 554 && app.mouseY < 604) {
				imgOpacidad = 0;
				nivel = 1;

				nombre = cp5.get(Textfield.class, "").getText();
				ocupacion = cp5.get(Textfield.class, " ").getText();
				carrera = cp5.get(Textfield.class, "  ").getText();
				edad = cp5.get(Textfield.class, "   ").getText();

				datosUsuario = "Usuario: " + nombre + "\nOcupacion: " + ocupacion + "\nCarrera: " + carrera + "\nEdad: "
						+ edad + "\nGenero: " + genero + "\n\n";
				resultadosUsuario[0] = datosUsuario;
			}

			switch (formularioInt) {
			case 0:
				if (app.mouseX > 508 && app.mouseX < 683 && app.mouseY > 472 && app.mouseY < 505) {
					genero = "Masculino";
					formularioInt = 1;
					System.out.println("FORMULARIO 1");
				}
				if (app.mouseX > 697 && app.mouseX < 880 && app.mouseY > 472 && app.mouseY < 505) {
					genero = "Femenino";
					formularioInt = 2;
					System.out.println("FORMULARIO 2");
				}
				break;
			case 1:
				if (app.mouseX > 508 && app.mouseX < 683 && app.mouseY > 472 && app.mouseY < 505) {
					genero = "";
					formularioInt = 0;
				}
				if (app.mouseX > 697 && app.mouseX < 880 && app.mouseY > 472 && app.mouseY < 505) {
					genero = "Femenino";
					formularioInt = 2;

				}
				break;
			case 2:
				if (app.mouseX > 508 && app.mouseX < 683 && app.mouseY > 472 && app.mouseY < 505) {
					genero = "Masculino";
					formularioInt = 1;
				}
				if (app.mouseX > 697 && app.mouseX < 880 && app.mouseY > 472 && app.mouseY < 505) {
					formularioInt = 0;
					genero = "";
				}
				break;
			}

			// --------HERE------------
		} else if (nivel == 1) {
			if (app.mouseX > 508 && app.mouseX < 700 && app.mouseY > 585 && app.mouseY < 637) {
				nivel = 2;
				imgOpacidad = 0;
			}
		} else if (nivel == 2) {
			imgOpacidad = 0;
			opacidad = 0;
			contadorItem = 1;
			reiniciarTiempo();

		} else if (nivel == 4) {
			if (app.mouseX > 499 && app.mouseX < 705 & app.mouseY > 514 && app.mouseY < 566) {
				opacidad = 0;
				imgOpacidad = 0;
				contadorItem = 1;
				reiniciarTiempo();
				nivel = 13;

			}
		} else if (nivel == 6) {
			if (app.mouseX > 511 && app.mouseX < 720 & app.mouseY > 514 && app.mouseY < 568) {
				imgOpacidad = 0;
				opacidad = 0;
				contadorItem = 1;
				reiniciarTiempo();
				nivel = 14;

			}
		} else if (nivel == 8) {
			if (app.mouseX > 499 && app.mouseX < 705 & app.mouseY > 515 && app.mouseY < 567) {
				opacidad = 0;
				contadorItem = 1;
				imgOpacidad = 0;
				reiniciarTiempo();
				nivel = 15;
			}
		} else if (nivel == 9) {
			if (contadorItem == 1) {

				if (!tiempoN4) {
					reiniciarTiempo();
				}
				if(!isPlayingSong) {
					parr1.trigger();
					tiempoN4 = true;
					comenzarTiempo();
				}
				

			} else if (contadorItem == 2){

				if (!tiempoN4) {
					reiniciarTiempo();
				}
				if(!isPlayingSong) {
					parr2.trigger();
					comenzarTiempo();
					tiempoN4 = true;
				}
		
			
			}
		} else if (nivel==10) {
			app.exit();
		}
	}

	private void comenzarTiempo() {
		
		Thread t = new Thread(new Runnable() {

            @Override
            public void run() {
            		
                try {
                	
                isPlayingSong = true;        
                Thread.sleep(12000);
                isPlayingSong = false;
                
                } catch (Exception e) {

                    e.printStackTrace();
                }

            }

        });
        t.start();
    }
		
	

	public void teclas() {
		
		if (app.key == 8) {
			return;
		}
		if (nivel == 3) {

			if (app.key == app.ENTER) {
				// sigLetra();
			} else {
				System.out.println(tiempo);
				validarLetra();
				if (tareaTerminada) {
					reiniciarTiempo();
				}
			}
		} else if (nivel == 5) {
			validarPalabra();
		} else if (nivel == 7) {
			validarOracion();
		} else if (nivel == 9) {
			validarParrafo();
		}

	}

	private void sigParrafo() {
		System.out.println(tiempo);
		opacidad = 0;
		app.image(imgs[0], x, y);
		app.image(planetas[3], x, y + 35);

		app.image(emoji[frame], x, y);

		if (app.frameCount % 4 == 0) {

			frame++;

			if (frame == 11) {
				opacidad = 0;

				if (contadorItem != 2) {
					contadorItem++;
					tiempoN4 = false;

				} else {
					nivel++;
					//
					imgOpacidad = 0;
					//
				}

				reiniciarTiempo();
				frame = 0;
				contadorGeneral++;
				puntajeNiveles[3]++;
				opacidad = 0;

				tareaTerminadaParr = false;
			}
		}
	}

	private void sigOracion() {
		System.out.println(tiempo);
		opacidad = 0;
		app.image(imgs[0], x, y);
		app.image(planetas[2], x - 10, y + 45);


		app.image(emoji[frame], x, y);

		if (app.frameCount % 4 == 0) {

			frame++;

			if (frame == 11) {
				reiniciarTiempo();

				if (contadorItem != 4) {
					contadorItem++;
				} else {
					nivel++;
					//
					imgOpacidad = 0;
					//
				}

				frame = 0;
				contadorGeneral++;
				opacidad = 0;
				tareaTerminadaOr = false;
			}
		}
	}

	private void sigPalabra() {
		app.image(imgs[0], x, y);
		app.image(planetas[1], x, y + 40);

		app.image(emoji[frame], x, y);

		if (app.frameCount % 4 == 0) {

			frame++;
			opacidad = 0;

			if (frame == 11) {
				reiniciarTiempo();

				if (contadorItem != 20) {
					contadorItem++;
				} else {
					nivel++;
					//
					imgOpacidad = 0;
					//
				}

				frame = 0;
				contadorGeneral++;
				puntajeNiveles[1]++;
				opacidad = 0;
				tareaTerminadaPal = false;
			}
		}
	}

	private void sigLetra() {
		app.image(planetas[0], x, y + 40);
		app.image(planetas[0], x, y + 35);

		app.image(emoji[frame], x, y);

		if (app.frameCount % 4 == 0) {

			frame++;
			if (frame == 11) {
				reiniciarTiempo();
				if (contadorItem != 25) {
					contadorItem++;
				} else {
					nivel++;
					imgOpacidad = 0;
				}

				frame = 0;
				contadorGeneral++;
				puntajeNiveles[0]++;
				opacidad = 0;
				tareaTerminada = false;
			}
		}
	}

	public void validarLetra() {
		letrasTemp = letras.get(contadorItem - 1).getLetra().toCharArray();
		char letraOprimida = ' ';

		letraOprimida = app.key;
		System.out.println("OPRIMIO: " + app.key);

		if (letrasTemp[0] == letraOprimida) {
			System.out.println(app.key + " es correto!");
			tareaTerminada = true;
			acerto[contadorGeneral] = true;
			audioBueno.trigger();

			letraEscrita = Character.toString(app.key);
			resultadosUsuario[contadorGeneral] = letrasTemp[0] + "\t"
					+ tiempo + "\t" + erroresTempLetra + "\n";

			erroresTempLetra = 0;
		} else if(Character.toUpperCase(letrasTemp[0]) == letraOprimida) {
			System.out.println(app.key + " es correto!");
			tareaTerminada = true;
			acerto[contadorGeneral] = true;
			audioBueno.trigger();

			letraEscrita = Character.toString(app.key);
			resultadosUsuario[contadorGeneral] = letrasTemp[0] + "\t"
					+ tiempo  + "\t" + erroresTempLetra + "\n";

			erroresTempLetra = 0;
		}  else if (letrasTemp[0] != letraOprimida) {
			System.out.println(app.key + " es incorreto!");
			acerto[contadorGeneral] = false;
			audioMalo.trigger();
			erroresTempLetra++;
			erroresLetras++;
			errores++;
			puntajeFinal -= 5;
			letraOprimida = ' ';
		}

	}

	public void validarPalabra() {
		palabraTemp = palabras.get(contadorItem - 1).getPalabra().toCharArray();
		String palabraTempString = palabras.get(contadorItem - 1).getPalabra();

		if (palabraTemp[contadorInternoPal] == app.key) {
			System.out.println(app.key + " es igual a " + palabraTemp[contadorInternoPal]);
			palabraEscrita = palabraEscrita + app.key;
			contadorInternoPal++;
		} else if (Character.toUpperCase(palabraTemp[contadorInternoPal]) == app.key) {
			System.out.println(app.key + " es igual a " + palabraTemp[contadorInternoPal]);
			palabraEscrita = palabraEscrita + Character.toLowerCase(app.key);
			contadorInternoPal++;
		} else {
			errores++;
			erroresTempPal++;
			erroresPalabras++;
			puntajeFinal -= 5;
			System.out.println(app.key + " es diferente a " + palabraTemp[contadorInternoPal]);
			audioMalo.trigger();
		}

		for (int i = 0; i < palabraTemp.length; i++) {
			System.out.println("El contador item es: " + contadorItem + " Palabra temporal: " + palabraTemp[i]
					+ " la escrita es: " + palabraEscrita + ";" + palabraTemp.length);
			System.out.println("Palabra:" + palabras.get(contadorItem - 1).getPalabra() + ".");
		}

		if (contadorInternoPal == palabraTemp.length) {
			if (palabraTempString.equalsIgnoreCase(palabraEscrita)) {
				System.out.println("EQUALS!");
				mostrarPalabra = palabraEscrita;
				audioBueno.trigger();
				resultadosUsuario[contadorGeneral] = palabraTempString + "\t"
						+ tiempo + "\t" +  erroresTempPal + "\n";
				palabraEscrita = "";
				contadorInternoPal = 0;
				erroresTempPal = 0;
				tareaTerminadaPal = true;
			} else {
				System.out.println("WRONG!");
				mostrarPalabra = palabraEscrita;
				tareaTerminadaMalPal = true;

			}

		}

	}

	public void validarOracion() {

		oracionTemp = oraciones.get(contadorItem - 1).getOracion().toCharArray();
		String oracionTempString = oraciones.get(contadorItem - 1).getOracion();

		if (oracionTemp[contadorInternoOr] == app.key) {
			System.out.println(app.key + " es igual a " + oracionTemp[contadorInternoOr]);
			oracionEscrita = oracionEscrita + app.key;
			contadorInternoOr++;
		} else if (Character.toUpperCase(oracionTemp[contadorInternoOr]) == app.key) {
			System.out.println(app.key + " es igual a " + oracionTemp[contadorInternoOr]);
			oracionEscrita = oracionEscrita + Character.toLowerCase(app.key);
			contadorInternoOr++;
		} else {
			System.out.println(app.key + " es diferente a " + oracionTemp[contadorInternoOr]);
			audioMalo.trigger();
			errores++;
			erroresOraciones++;
			erroresTempOr++;
			puntajeFinal -= 5;
		}

		for (int i = 0; i < oracionTemp.length; i++) {
			System.out.println("El contador item es: " + contadorItem + " Oración temporal: " + oracionTemp[i]
					+ " la escrita es: " + oracionEscrita + ";" + oracionTemp.length);
			System.out.println("Oracion:" + oraciones.get(contadorItem - 1).getOracion() + ".");
		}

		if (contadorInternoOr == oracionTemp.length) {
			if (oracionTempString.equalsIgnoreCase(oracionEscrita)) {
				System.out.println("EQUALS!");

				resultadosUsuario[contadorGeneral] = oracionTempString + "\t"
						+ tiempo + "\t" + erroresTempOr + "\n";
				oracionEscrita = "";
				contadorInternoOr = 0;
				erroresTempOr = 0;

				tareaTerminadaOr = true;
				audioBueno.trigger();
			} else {
				System.out.println("WRONG!");

			}

		}

	}

	public void validarParrafo() {

		parrafoTemp = parrafos.get(contadorItem - 1).getParrafo().toCharArray();
		String parrafoTempString = parrafos.get(contadorItem - 1).getParrafo();

		if (parrafoTemp[contadorInternoParr] == app.key) {
			System.out.println(app.key + " es igual a " + parrafoTemp[contadorInternoParr]);
			parrafoEscrito = parrafoEscrito + app.key;
			contadorInternoParr++;
		} else if(Character.toUpperCase(parrafoTemp[contadorInternoParr]) == app.key){
			System.out.println(app.key + " es igual a " + parrafoTemp[contadorInternoParr]);
			parrafoEscrito = parrafoEscrito + Character.toLowerCase(app.key);
			contadorInternoParr++;
		} else {
			System.out.println(app.key + " es diferente a " + parrafoTemp[contadorInternoParr]);
			audioMalo.trigger();
			errores++;
			erroresTempParr++;
			erroresParrafos++;
			puntajeFinal -= 5;
		}

		for (int i = 0; i < parrafoTemp.length; i++) {
			System.out.println("El contador item es: " + contadorItem + " Parrafo temporal: " + parrafoTemp[i]
					+ " la escrita es: " + parrafoEscrito + ";" + parrafoTemp.length);
			System.out.println("Parrafo:" + parrafos.get(contadorItem - 1).getParrafo() + ".");
		}

		if (contadorInternoParr == parrafoTemp.length) {
			if (parrafoTempString.equalsIgnoreCase(parrafoEscrito)) {
				System.out.println("EQUALS!");
				audioBueno.trigger();
				resultadosUsuario[contadorGeneral] = parrafoTempString + "\t"
						+ tiempo + "\t" + erroresTempParr + "\n";
				parrafoEscrito = "";
				contadorInternoParr = 0;
				erroresTempParr = 0;
				tareaTerminadaParr = true;
			} else {
				System.out.println("WRONG!");

			}

		}

	}

	public void generarBaseDeDatos() {
		BufferedWriter salida;
		String textoFinal = app.join(resultadosUsuario, "");
		// String txtNuevo = app.join(datosUsuario, " "); //Se crea el String que recibe
		// el texto con las modificaciones y las une
		try {
			salida = new BufferedWriter(new FileWriter("resultados.txt"));
			salida.write(textoFinal); // Se escribe el String que contiene las modificaciones en el txt nuevo
			salida.flush();
			salida.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
