/**
 * 
 */
package es.unileon.prg.masterMind;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;
import junit.framework.AssertionFailedError;

public class CombinacionTest {

	/**
	 * @throws java.lang.Exception
	 */
	Combinacion combinacion;
	int tamanio;
	String color;
	
	@Before
	public void setUp() throws Exception {
	this.tamanio = 4;
	this.color = "PPPP";
	combinacion = new Combinacion(color,tamanio);
	}
	
	@Test
	public void testCombinacionInt(){
		Combinacion combinacion = new Combinacion(4);
		assertEquals(" -  -  -  - ", combinacion.toString());
	}

	/**
	 * Test method for {@link es.unileon.prg.masterMind.Combinacion#Combinacion(Combinacion, int)}.
	 * @throws MasterMindException 
	 */
	@Test
	public void testCombinacionDuplicarTrue() throws MasterMindException {
		Combinacion combinacion = new Combinacion("PRCB", 4);
		Combinacion otherCombinacion = new Combinacion(combinacion);
		
		assertTrue(otherCombinacion.get(0).comparar(combinacion.get(0)));
		assertTrue(otherCombinacion.get(1).comparar(combinacion.get(1)));
		assertTrue(otherCombinacion.get(2).comparar(combinacion.get(2)));
		assertTrue(otherCombinacion.get(3).comparar(combinacion.get(3)));
		
		otherCombinacion.get(0).anular();
		otherCombinacion.get(1).anular();
		otherCombinacion.get(2).anular();
		otherCombinacion.get(3).anular();
		
		assertFalse(otherCombinacion.get(0).comparar(combinacion.get(0)));
		assertFalse(otherCombinacion.get(1).comparar(combinacion.get(1)));
		assertFalse(otherCombinacion.get(2).comparar(combinacion.get(2)));
		assertFalse(otherCombinacion.get(3).comparar(combinacion.get(3)));
	}

	/**
	 * Test method for {@link es.unileon.prg.masterMind.Combinacion#set(java.lang.String, int)}.
	 * @throws MasterMindException 
	 */
	@Test
	public void testSetErrorMenosColores() throws MasterMindException {

		combinacion.set("PPP", 4);
		new AssertionError();
	}
	
	/**
	 * Test method for {@link es.unileon.prg.masterMind.Combinacion#set(java.lang.String, int)}.
	 * @throws MasterMindException 
	 */
	@Test
	public void testSetErrorMasColores() throws MasterMindException {

		combinacion.set("PPP", 2);
		new AssertionError();
	}
	
	/**
	 * Test method for {@link es.unileon.prg.masterMind.Combinacion#set(java.lang.String, int)}.
	 * @throws MasterMindException 
	 */
	@Test
	public void testSetGet() throws MasterMindException {
		//Combinacion otherCombinacion = new Combinacion("PPP", 5);
		combinacion.set("PRC", 3);
		assertEquals("\u001b[35m[P]\u001b[0m", combinacion.get(0).toString());
		assertEquals("\u001b[31m[R]\u001b[0m", combinacion.get(1).toString());
		assertEquals("\u001b[36m[C]\u001b[0m", combinacion.get(2).toString());
		
		combinacion.set("CRP", 3);
		assertEquals("\u001b[36m[C]\u001b[0m", combinacion.get(0).toString());
		assertEquals("\u001b[31m[R]\u001b[0m", combinacion.get(1).toString());
		assertEquals("\u001b[35m[P]\u001b[0m", combinacion.get(2).toString());
		
	}
	
	@Test
	public void testLength(){
		
		assertEquals(4, this.combinacion.length());		
	}
	/**
	 * Test method for {@link es.unileon.prg.masterMind.Combinacion#comparar(es.unileon.prg.masterMind.Combinacion)}.
	 * @throws MasterMindException 
	 */
	@Test
	public void testComparar() throws MasterMindException {
		Combinacion combinacion = new Combinacion("CRP",3);
		Combinacion combinacion2 = new Combinacion("RPR", 3);
		Combinacion otherCombinacion = new Combinacion("PCR",3);
		assertEquals("\u001b[37m[X]\u001b[0m\u001b[37m[X]\u001b[0m\u001b[37m[X]\u001b[0m", combinacion.comparar(otherCombinacion).toString());
	
		Combinacion otherCombinacion2 = new Combinacion("CRP",3);
		assertEquals("\u001b[30m[O]\u001b[0m\u001b[30m[O]\u001b[0m\u001b[30m[O]\u001b[0m", combinacion.comparar(otherCombinacion2).toString());
		
		Combinacion otherCombinacion3 = new Combinacion("RRR",3);
		assertEquals(" - \u001b[30m[O]\u001b[0m - ", combinacion.comparar(otherCombinacion3).toString());
		
		Combinacion otherCombinacion4 = new Combinacion("BBB",3);
		assertEquals(" -  -  - ", combinacion.comparar(otherCombinacion4).toString());
		
		Combinacion otherCombinacion5 = new Combinacion("PPR",3);
		assertEquals(" - \u001b[30m[O]\u001b[0m\u001b[30m[O]\u001b[0m", combinacion2.comparar(otherCombinacion5).toString());
	}

	/**
	 * Test method for {@link es.unileon.prg.masterMind.Combinacion#toString()}.
	 * @throws MasterMindException 
	 */
	@Test
	public void testToString() throws MasterMindException {
		Combinacion other = new Combinacion("PRC",3);
		assertEquals("\u001b[35m[P]\u001b[0m\u001b[31m[R]\u001b[0m\u001b[36m[C]\u001b[0m",other.toString() );
	}

}
