/**
 * 
 */
package es.unileon.prg.masterMind;

import java.util.Random;

public class Ficha {
	/**
	 * los colores
	 */
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";
	private Colors color;
	/**
	 * constructor asigna el color introducido
	 * @param color color introducido
	 */
	
	public Ficha(Colors color){
		
		this.color = color;
	}
	
	/**
	 * constructor, crea un color aleatorio
	 */
	
	public Ficha() {
		Random randomNumber = new Random();
		randomNumber.setSeed(System.nanoTime());
		int aleatorio = randomNumber.nextInt(6);
		switch (aleatorio) {
		case 0:
			this.color = Colors.PURPLE;
			break;
		case 1:
			this.color=Colors.RED;
			break;
		case 2:
			this.color=Colors.CYAN;
			break;
		case 3:
			this.color=Colors.BLUE;
			break;
		case 4:
			this.color=Colors.GREEN;
			break;
		case 5:
			this.color=Colors.YELLOW;
			break;
		}
	}

	/**
	 * constructor de Ficha si el color es correcto crea la ficha
	 * 
	 * @param colors
	 *            color de la ficha
	 * @throws MasterMindException
	 */
	public Ficha(char colors) throws MasterMindException {
			setColor(colors);
	}

	/**
	 * si el color introducido es correcto lo cambia si se produce un error
	 * asigna anular
	 * 
	 * 
	 * @param color
	 *            color nuevo de la ficha
	 * @throws MasterMindException
	 */
	public void setColor(char color) throws MasterMindException {
		StringBuffer error = new StringBuffer();
			if (color!= 'P' && color != 'R' && color != 'C' && color != 'B' && color != 'G'
					&& color != 'Y') {

				error.append("Error. El caracter " + color + " no es correcto\n");
				throw new MasterMindException(error.toString());
			}
			
			if(error.length()!=0){
				
				anular();				
			}else {
				switch (color) {
				case 'P':
					this.color = Colors.PURPLE;
					break;
				case 'R':
					this.color= Colors.RED;
					break;
				case 'C':
					this.color =Colors.CYAN;
					break;
				case 'B':
					this.color=Colors.BLUE;
					break;
				case 'G':
					this.color=Colors.GREEN;
					break;
				case 'Y':
					this.color=Colors.YELLOW;
					break;
				}
			}
	}

	/**
	 * consulta el color de la ficha
	 * 
	 * @return el color de la ficha
	 */
	public Colors getColor() {

		return this.color;
	}

	/**
	 * compara los colores de dos fichas
	 * 
	 * @param ficha
	 *            ficha con la que se quiere comparar
	 * @return true si son iguales, false si son diferentes
	 */
	public boolean comparar(Ficha ficha) {

		return getColor() == ficha.getColor();
	}

	/**
	 * asigna el color que muestra que se ha acertad
	 */
	public void asignarAcierto() {
		this.color=Colors.BLACK;
	}

	/**
	 * asigna el color que muestra que contiene el color
	 */
	public void asignarContiene() {
		this.color=Colors.WHITE;
	}

	/**
	 * comprueba si contiene un acierto
	 * 
	 * @return true si contiene acierto y false si no contiene
	 */
	public boolean comprobarAcierto() {

		return this.color == Colors.BLACK;
	}

	/**
	 * comprueba si se a asignado el color a ficha
	 * @return true si no se a asignado, false si se ha asignado
	 */
	public boolean comprobarFallo() {
		boolean fallo = false;
		if (this.color.equals(Colors.NONE)) {
			fallo = true;
		}
		return fallo;
	}

	/**
	 * anula el color de la ficha
	 */
	public void anular() {
		this.color=Colors.NONE;
	}

	/**
	 * @return una cadena con el color
	 */
	public String toString(){
		String result = null;

		switch (this.color){
		case BLACK:
			result = ANSI_BLACK+"[O]"+ANSI_RESET;
			break;
		case RED:
			result = ANSI_RED+"[R]"+ANSI_RESET;
			break;
		case GREEN:
			result = ANSI_GREEN+"[G]"+ANSI_RESET;
			break;
		case YELLOW: 
			result = ANSI_YELLOW+"[Y]"+ANSI_RESET;
			break;
		case BLUE:
			result = ANSI_BLUE+"[B]"+ANSI_RESET;
			break;
		case PURPLE:
			result = ANSI_PURPLE+"[P]"+ANSI_RESET;
			break;
		case CYAN:
			result = ANSI_CYAN+"[C]"+ANSI_RESET;
			break;
		case WHITE: 
			result = ANSI_WHITE+"[X]"+ANSI_RESET;
			break;
		case NONE:
			result = " - ";
			break;
		}
		return result;
	}
	

}
