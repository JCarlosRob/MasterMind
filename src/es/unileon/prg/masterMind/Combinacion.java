/**
 * 
 */
package es.unileon.prg.masterMind;

public class Combinacion {
	
	/**
	 * contiene un array de fichas
	 */
	private Ficha[] fichas;

	/**
	 * crea una combinacion de 4 colores predeterminada para comprobar en los test
	 * @throws MasterMindException 
	 */
	public Combinacion() throws MasterMindException{
				
		this.fichas = new Ficha[4];
		this.fichas[0] = new Ficha('P');
		this.fichas[1] = new Ficha('R');
		this.fichas[2] = new Ficha('Y');
		this.fichas[3] = new Ficha('C');
	}	
	
	/**
	 * contructor inicializa el array
	 * 
	 * @param tamanio
	 *            tamanio del array
	 */
	public Combinacion(int tamanio) {
		this.fichas = new Ficha[tamanio];
		for (int i = 0; i < tamanio; i++) {
			this.fichas[i] = new Ficha();
			this.fichas[i].anular();
		}
	}

	/**
	 * Constructor crea la combionacion secreta
	 * 
	 * @param repeticion
	 *            si se permite repeticion de colores true si esta permitido
	 *            false si no lo esta
	 * @param tamanio tamanio de la combinacion
	 * @throws MasterMindException
	 */
	public Combinacion(boolean repeticion, int tamanio) throws MasterMindException {

		this.fichas = new Ficha[tamanio];
		Ficha fichaAleatoria;
		int posicion = 0;
		int contador;
		boolean asignar;

		do {
			fichaAleatoria = new Ficha();
			asignar = true;
			contador = 0;

			if (repeticion == false) {

				while (this.fichas[contador] != null) {
					if (this.fichas[contador].getColor() == fichaAleatoria.getColor()) {
						asignar = false;
					}
					contador++;
				}

				if (asignar == true) {
					this.fichas[posicion] = fichaAleatoria;
					posicion++;
				}
			} else {
				this.fichas[posicion] = fichaAleatoria;
				posicion++;
			}

		} while (posicion < tamanio);
	}

	/**
	 * Constructor crea una nueva combinacion
	 * 
	 * @param colores
	 *            colores introducidos por teclado
	 * @param tamanio
	 *            tamanio de la combinacion
	 * @throws MasterMindException
	 */
	public Combinacion(String colores, int tamanio) throws MasterMindException {
		this.fichas = new Ficha[tamanio];
		set(colores, tamanio);
	}

	/**
	 * Contructor copia las fichas de otra combinacion
	 * 
	 * @param otherCombinacion
	 *            combinacion introducida
	 * @throws MasterMindException
	 */
	public Combinacion(Combinacion otherCombinacion) throws MasterMindException {
		this.fichas = new Ficha[otherCombinacion.length()];

		for (int i = 0; i < otherCombinacion.length(); i++) {

			this.fichas[i] = new Ficha(otherCombinacion.get(i).getColor());
		}
	}

	/**
	 * crea una combinacion de colores introducida por teclado
	 * 
	 * @param colores
	 *            colores intrudicidos
	 * @param tamanio
	 *            tamanio de la combinacion
	 * @throws MasterMindException
	 */
	public void set(String colores, int tamanio) throws MasterMindException {
		StringBuffer error = new StringBuffer();

		try {
			if (tamanio > colores.length()) {

				error.append("Error. El numero de colores debe ser " + tamanio + "\n");
			} else if (tamanio < colores.length()) {

				error.append("Error. El numero de colores debe ser " + tamanio + "\n");
			}

			if (error.length() != 0) {

				throw new MasterMindException(error.toString());
			} else {

				this.fichas = new Ficha[tamanio];

				for (int i = 0; i < tamanio; i++) {
					this.fichas[i] = new Ficha(colores.charAt(i));
				}
			}
		} catch (MasterMindException e) {
			System.err.println(e.getMessage());

		}
	}

	/**
	 * devuelve una ficha del array
	 * 
	 * @param posicion
	 *            posicion que ocupa la ficha
	 * @return la ficha se leccionada
	 */
	public Ficha get(int posicion) {

		return this.fichas[posicion];
	}

	/**
	 * 
	 * @return el tamanio de la combinacion
	 */
	public int length() {
		return this.fichas.length;
	}

	/**
	 * Compara una combinacion introducida con la combinacion secreta
	 * 
	 * @param otherCombinacion
	 *            combinacion introducida
	 * @return combinacion con los aciertos
	 * @throws MasterMindException
	 */
	public Combinacion comparar(Combinacion otherCombinacion) throws MasterMindException {

		Combinacion duplicado = new Combinacion(otherCombinacion);
		Combinacion resultado = new Combinacion(this.fichas.length);
		try {
			for (int i = 0; i < this.fichas.length; i++) {

				if (this.fichas[i].comparar(duplicado.get(i))) {
					resultado.get(i).asignarAcierto();
					duplicado.get(i).anular();
				}
			}

			for (int i = 0; i < this.fichas.length; i++) {
				for (int j = 0; j < this.fichas.length; j++) {

					if (this.fichas[i].comparar(duplicado.get(j)) && !resultado.get(i).comprobarAcierto()) {
						resultado.get(i).asignarContiene();
					}
				}
			}
		} catch (Exception ex) {
			resultado = null;
		}

		return resultado;
	}

	/**
	 * comprueba si se ha producido un fallo al asignar color de las fichas
	 * 
	 * @return true si hay fallo, false si no hay fallo
	 */
	public boolean comprobarFallos() {
		boolean fallos = false;
		try {
			for (int i = 0; i < this.fichas.length; i++) {
				if (this.fichas[i].comprobarFallo() == true) {
					fallos = true;
				}
			}

		} catch (Exception ex) {
			fallos = true;
		}

		return fallos;
	}

	/**
	 * contiene una cadena con los colores de la combinacion
	 */
	public String toString() {
		StringBuffer imprimir = new StringBuffer();

		for (int i = 0; i < fichas.length; i++) {
			if ((this.fichas[i] != null)) {
				imprimir.append(this.fichas[i].toString());
			}
		}

		return imprimir.toString();
	}
}
