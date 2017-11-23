/**
 * 
 */
package es.unileon.prg.masterMind;

public class Tablero {

	/**
	 * contiene un array con las combinaciones de aciertos
	 */
	private Combinacion[] aciertos;

	/**
	 * contiene un array con las combinaciones de los intentos
	 */
	private Combinacion[] intentos;

	/**
	 * contiene la combinacion secreta
	 */
	private Combinacion secreta;

	/**
	 * inicializa los trableros con la combinacion secreta predeterminada 
	 * para comprobar los test
	 * @throws MasterMindException 
	 */
	
	public Tablero() throws MasterMindException{
		
		this.aciertos = new Combinacion[4];
		this.intentos = new Combinacion[4];
		this.secreta = new Combinacion();
	}
	
	/**
	 * constructor inicializa los array aciertos e intento asigna la combinacion
	 * secreta
	 * 
	 * @param tamanioTablero tamanio del tablero
	 * @param tamanioCombinacion tamanio de la combinacion
	 * @param repeticion si hay repeticion
	 * @throws MasterMindException
	 */
	public Tablero(int tamanioTablero, int tamanioCombinacion, boolean repeticion) throws MasterMindException {

		this.aciertos = new Combinacion[tamanioTablero];
		this.intentos = new Combinacion[tamanioTablero];
		this.secreta = new Combinacion(repeticion, tamanioCombinacion);
	}

	/**
	 * introduce las combibaciones en sus arrays
	 *
	 * @param intentos
	 *            los intentos introducidos por teclado
	 * @param posicion
	 *            posicion en la que deben introducirse
	 * @throws MasterMindException
	 */
	public void set(String intentos, int posicion) throws MasterMindException {

		this.intentos[posicion] = new Combinacion(intentos, this.secreta.length());
		this.aciertos[posicion] = this.intentos[posicion].comparar(this.secreta);
	}

	/**
	 * devuelve una combinacion de aciertos
	 * 
	 * @param posicion
	 *            posicion que se quiere consultar
	 * @return la combinacion que representa la posicion introducida
	 */
	public Combinacion getAciertos(int posicion) {

		return this.aciertos[posicion];
	}

	/**
	 * devuelve una combinacion de intentos
	 * 
	 * @param posicion
	 *            posicion que se quiere consultar
	 * @return la combinacion que representa la posicion introducida
	 */
	public Combinacion getIntentos(int posicion) {
		return this.intentos[posicion];
	}

	public boolean comprobarFallos(int posicion) {
		boolean fallos = false;

		if (this.intentos[posicion] == null) {
			fallos = true;
		} else if (this.intentos[posicion].comprobarFallos()) {
			fallos = true;
			this.intentos[posicion] = null;
		}
		return fallos;
	}

	/**
	 * 
	 * @return el tamanio del tablero
	 */
	public int length() {
		return this.intentos.length;
	}

	public boolean isSameSecreta(int posicion) {
		boolean isSame = false;

		if (this.intentos[posicion] != null) {

			if (this.intentos[posicion].toString().equals(this.secreta.toString())) {
				isSame = true;

			}
		}
		return isSame;
	}

	public String toString() {
		StringBuffer imprimir = new StringBuffer();
		Combinacion vacia = new Combinacion(this.secreta.length());

		imprimir.append(this.secreta.toString());
		imprimir.append('\n');

		for (int i = this.intentos.length - 1; i >= 0; i--) {
			if ((this.intentos[i] != null) && (this.aciertos[i] != null)) {

				imprimir.append(this.intentos[i].toString());
				imprimir.append("\t");
				imprimir.append(this.aciertos[i].toString());
				imprimir.append("\n");
			} else {

				imprimir.append(vacia.toString());
				imprimir.append("\t");
				imprimir.append(vacia.toString());
				imprimir.append("\n");
			}
		}

		return imprimir.toString();
	}
}
