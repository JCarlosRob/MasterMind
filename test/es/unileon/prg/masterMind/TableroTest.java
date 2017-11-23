/**
 * 
 */
package es.unileon.prg.masterMind;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TableroTest {

	/**
	 * @throws java.lang.Exception
	 */
	Tablero tablero;
	
	@Before
	public void setUp() throws Exception {
	
		this.tablero = new Tablero();
	}

	/**
	 * Test method for {@link es.unileon.prg.masterMind.Tablero#set(es.unileon.prg.masterMind.Combinacion, es.unileon.prg.masterMind.Combinacion, int)}.
	 * @throws MasterMindException 
	 */
	@Test
	public void testSetGet() throws MasterMindException {
		Tablero tablero = new Tablero(2,3, true);
		tablero.set("RBY", 0);
		assertEquals("\u001b[31m[R]\u001b[0m\u001b[34m[B]\u001b[0m\u001b[33m[Y]\u001b[0m", tablero.getIntentos(0).toString());
		
		tablero.set("BPC", 1);
		assertEquals("\u001b[34m[B]\u001b[0m\u001b[35m[P]\u001b[0m\u001b[36m[C]\u001b[0m", tablero.getIntentos(1).toString());
		
		tablero.set("PYB", 0);
		assertEquals("\u001b[35m[P]\u001b[0m\u001b[33m[Y]\u001b[0m\u001b[34m[B]\u001b[0m", tablero.getIntentos(0).toString());
		
		tablero.set("CCB", 1);
		assertEquals("\u001b[36m[C]\u001b[0m\u001b[36m[C]\u001b[0m\u001b[34m[B]\u001b[0m", tablero.getIntentos(1).toString());
		
		assertNotNull(tablero.getAciertos(0));
		assertNotNull(tablero.getAciertos(0));
	}

	@Test
	public void testComprobarFallos() throws MasterMindException{
		Tablero tablero = new Tablero(2,3,true);
		tablero.set("PKC", 0);
		
		assertTrue(tablero.comprobarFallos(0));
		
		tablero.set("PRP", 0);
		assertFalse(tablero.comprobarFallos(0));
		
	}
	
	@Test
	public void testLength() throws MasterMindException{
		Tablero tablero = new Tablero(2,3,true);
		
		assertEquals(2, tablero.length());
	}
	
	@Test
	public void testIsSameSecreta() throws MasterMindException{
		
		this.tablero.set("PPPP", 0);
		assertFalse(this.tablero.isSameSecreta(0));
		
		this.tablero.set("PRYC", 1);
		assertTrue(this.tablero.isSameSecreta(1));
		
	}

	/**
	 * Test method for {@link es.unileon.prg.masterMind.Tablero#toString()}.
	 * @throws MasterMindException 
	 */
	@Test
	public void testToString() throws MasterMindException {
		this.tablero.set("PRCY", 0);
		this.tablero.set("RPCY", 1);
		this.tablero.set("BBBB", 2);
		this.tablero.set("PRYC", 3);
		
		assertEquals("[35m[P][0m[31m[R][0m[36m[C][0m[33m[Y][0m",
				this.tablero.getIntentos(0).toString());
		assertEquals("[30m[O][0m[30m[O][0m[37m[X][0m[37m[X][0m",
				this.tablero.getAciertos(0).toString());
		
		assertEquals("[31m[R][0m[35m[P][0m[36m[C][0m[33m[Y][0m",
				this.tablero.getIntentos(1).toString());
		assertEquals("[37m[X][0m[37m[X][0m[37m[X][0m[37m[X][0m",
				this.tablero.getAciertos(1).toString());
		
		assertEquals("[34m[B][0m[34m[B][0m[34m[B][0m[34m[B][0m",
				this.tablero.getIntentos(2).toString());
		assertEquals(" -  -  -  - ",
				this.tablero.getAciertos(2).toString());
		
		assertEquals("[35m[P][0m[31m[R][0m[33m[Y][0m[36m[C][0m",
				this.tablero.getIntentos(3).toString());
		assertEquals("[30m[O][0m[30m[O][0m[30m[O][0m[30m[O][0m",
				this.tablero.getAciertos(3).toString());
	}
}
