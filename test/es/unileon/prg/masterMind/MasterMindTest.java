/**
 * 
 */
package es.unileon.prg.masterMind;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MasterMindTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Test method for {@link es.unileon.prg.masterMind.MasterMind#set(java.lang.String, int)}.
	 * @throws MasterMindException 
	 */
	@Test
	public void testSetGet() throws MasterMindException {
		MasterMind mm = new MasterMind(3,2,false);	
		
		mm.set("PRC", 0);
		assertEquals("\u001b[35m[P]\u001b[0m\u001b[31m[R]\u001b[0m\u001b[36m[C]\u001b[0m", mm.get().getIntentos(0).toString());
		
	}

	/**
	 * Test method for {@link es.unileon.prg.masterMind.MasterMind#comprobarErrores(int)}.
	 * @throws MasterMindException 
	 */
	@Test
	public void testComprobarErrores() throws MasterMindException {
		MasterMind mm = new MasterMind(3,2,false);
		mm.set("ORP", 0);
		mm.set("RCP", 1);
		
		assertTrue(mm.comprobarErrores(0));
		assertFalse(mm.comprobarErrores(1));
	}

	/**
	 * Test method for {@link es.unileon.prg.masterMind.MasterMind#finalizarPorAciertos(int)}.
	 * @throws MasterMindException 
	 */
	@Test
	public void testFinalizarPorAciertos() throws MasterMindException {
		MasterMind mm = new MasterMind(3,2,false);
		mm.set("PRC", 0);
		if(mm.get().isSameSecreta(0)){
			
			assertTrue(mm.finalizarPorAciertos(0));
		}else{
			
			assertFalse(mm.finalizarPorAciertos(0));
		}
	}

	/**
	 * Test method for {@link es.unileon.prg.masterMind.MasterMind#finalizarPorMaximosIntentos(int)}.
	 * @throws MasterMindException 
	 */
	@Test
	public void testFinalizarPorMaximosIntentos() throws MasterMindException {
		MasterMind mm = new MasterMind(3,2,false);
		
		mm.set("PRC", 0);
		assertFalse(mm.finalizarPorMaximosIntentos(0));
		mm.set("RCP", 1);
		assertFalse(mm.finalizarPorMaximosIntentos(1));
		assertTrue(mm.finalizarPorMaximosIntentos(2));
	}

	/**
	 * Test method for {@link es.unileon.prg.masterMind.MasterMind#toString()}.
	 * @throws MasterMindException 
	 */
	@Test
	public void testToString() throws MasterMindException {
		MasterMind mm = new MasterMind(3,2,false);
		assertTrue(mm.toString().equals(mm.get().toString()));
	}

}
