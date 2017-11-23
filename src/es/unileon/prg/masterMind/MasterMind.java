/**
 * 
 */
package es.unileon.prg.masterMind;

public class MasterMind {

	/**
	 * contiene el tablero
	 */
	private Tablero tablero;

	/**
	 * contrusctor
	 * 
	 * @param numeroColores
	 *            numero de colores a introducir
	 * @param numeroIntentos
	 *            numero de intentos disponibles
	 * @param repeticion
	 *            si exite repeticion
	 * @throws MasterMindException
	 */
	public MasterMind(int numeroColores, int numeroIntentos, boolean repeticion) throws MasterMindException {
		tablero = new Tablero(numeroIntentos, numeroColores, repeticion);
	}

	/**
	 * 
	 * @param intento
	 *            combinacion de colores introducida
	 * @param posicion
	 *            posicion donde se va a introducir el intento
	 * @throws MasterMindException
	 */
	public void set(String intento, int posicion) throws MasterMindException {

		tablero.set(intento, posicion);
	}

	/**
	 * 
	 * @return tablero
	 */
	public Tablero get() {

		return tablero;
	}

	
	/**
	 * 
	 * @param posicion posicion a comprobar
	 * @return true si hay un error, false si no lo hay
	 */
	public boolean comprobarErrores(int posicion) {
		boolean errores = false;

		if (tablero.comprobarFallos(posicion)) {
			errores = true;
		}

		return errores;
	}

	/**
	 * si has acertado la combinacion secreta finaliza
	 * 
	 * @param intento
	 *            intento actual
	 * @return true si has acertado, false si no has acertado
	 */
	public boolean finalizarPorAciertos(int intento) {
		boolean finalizar = false;
		if ((intento >= 0) && tablero.isSameSecreta(intento)) {
			finalizar = true;
		}
		return finalizar;
	}

	/**
	 * si has alcandazo el numero maximo de intentos finaliza
	 * 
	 * @param intento
	 *            intento actual
	 * @return true si se ha alcanzado, false si no se ha alcanzado
	 */
	public boolean finalizarPorMaximosIntentos(int intento) {
		boolean finalizar = false;
		if ((intento) == tablero.length()) {
			finalizar = true;
		}
		return finalizar;
	}
	
	/**
	 * finaliza al introducir "salir" por el teclado
	 * @param salir string introducido por teclado
	 * @return true si se ha introducido, false si no se ha introducido
	 */
	public boolean finalizarPorTeclado(String salir){
		boolean finalizar = false;
		if(salir.equals("SALIR")){
			finalizar = true;
		}
		return finalizar;
	}

	/**
	 * contiene una cadena con el tablero
	 */
	public String toString() {
		StringBuffer imprimir = new StringBuffer();

		imprimir.append(tablero.toString());

		return imprimir.toString();
	}
}
