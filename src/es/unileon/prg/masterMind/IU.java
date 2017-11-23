/**
 * 
 */
package es.unileon.prg.masterMind;

public class IU {

	private MasterMind masterMind;

	/**
	 * constructor
	 * 
	 * @param masterMind MasterMind
	 * @throws MasterMindException
	 */
	public IU(MasterMind masterMind) throws MasterMindException {
		
		this.masterMind =masterMind;
	}

	/**
	 * inicia el juego
	 * 
	 * @throws MasterMindException
	 */
	public void iniciar() throws MasterMindException {
		
		String teclado = "";
		int intento = 0;

		do {
			try {
				do {
					
					System.out.println("MASTERMIND:");
					System.out.println(masterMind.toString());
					System.out.println("Introduzca una combinacion:");
					System.out.println(Colors.RED+"/"+Colors.YELLOW+"/"+
					Colors.GREEN+"/"+Colors.PURPLE+"/"+Colors.CYAN+"/"+Colors.BLUE+"/Salir");
					
					teclado = Teclado.readString();
					teclado = teclado.toUpperCase();
					
					if (masterMind.finalizarPorTeclado(teclado) == false) {

						masterMind.set(teclado, intento);
					}
					
				} while ((masterMind.comprobarErrores(intento) == true) && (teclado.equals("SALIR") == false));
			} catch (MasterMindException ex) {

			}
			
		} while ((masterMind.finalizarPorTeclado(teclado) == false) 
				&& (masterMind.finalizarPorAciertos(intento++) == false)
				&& (masterMind.finalizarPorMaximosIntentos(intento) == false));

		System.out.println(masterMind.toString());

		if (masterMind.finalizarPorAciertos(--intento)) {

			System.out.println("Has ganado. Has acertado la combinacion");
		} else if ((teclado.equals("SALIR") == false)) {

			System.out.println("Has perdido. Has alcanzado el numero maximo de intentos");
		}
		
		System.out.println("Hasta la proxima!");
	}
}
