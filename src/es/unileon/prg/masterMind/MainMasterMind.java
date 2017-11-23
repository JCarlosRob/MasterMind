/**
 * 
 */
package es.unileon.prg.masterMind;

public class MainMasterMind {

	/**
	 * @param args argumentos a introducir, tamanio de colores, numero de intentos
	 * y si existe repeticion de colores
	 * @throws MasterMindException
	 */
	public static void main(String[] args) throws MasterMindException {
		// TODO Auto-generated method stub
		if (args.length != 3) {
			System.out.println("Error al introducir los argumentos");
		} else {
			Integer intentos = new Integer(args[0]);
			Integer colores = new Integer(args[1]);			
			Boolean repeticion = new Boolean(args[2]);

			MasterMind masterMind= new MasterMind(intentos,colores,repeticion);
			IU iu = new IU(masterMind);
			iu.iniciar();
		}
	}

}
