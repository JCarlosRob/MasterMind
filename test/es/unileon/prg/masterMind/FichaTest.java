/**
 * 
 */
package es.unileon.prg.masterMind;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FichaTest {

	/**
	 * @throws java.lang.Exception
	 */
	Ficha ficha;
	Ficha otherFicha;
	Colors color;
	
	@Before
	public void setUp() throws Exception {
	this.ficha = new Ficha('R');
	this.otherFicha = new Ficha('P');
	}

	/**
	 * Test method for {@link es.unileon.prg.masterMind.Ficha#setColor(char)}.
	 * Test method for {@link es.unileon.prg.masterMind.Ficha#getColor(char)}.
	 * @throws MasterMindException 
	 */
	@Test
	public void testSetGetColor() throws MasterMindException {
		color=Colors.PURPLE;
		this.ficha.setColor('P');
		assertEquals(this.color,ficha.getColor());
		color=Colors.RED;
		this.ficha.setColor('R');
		assertEquals(this.color, this.ficha.getColor());
	}
	/**
	 * Test method for {@link es.unileon.prg.masterMind.Ficha#comparar(Ficha)}.
	 * @throws MasterMindException
	 */
	@Test
	public void testCompararTrue() throws MasterMindException{
		otherFicha.setColor('R');
		this.ficha.setColor('R');
		assertTrue(ficha.comparar(otherFicha));
	}
	
	/**
	 * Test method for {@link es.unileon.prg.masterMind.Ficha#comparar(Ficha)}.
	 * @throws MasterMindException
	 */
	@Test
	public void testCompararFalse() throws MasterMindException{
		otherFicha.setColor('R');
		this.ficha.setColor('P');
		assertFalse(ficha.comparar(otherFicha));
	}
	
	@Test
	public void testAsignarAcierto(){
		
		Ficha ficha = new Ficha();
		ficha.asignarAcierto();
		color=Colors.BLACK;
		assertEquals(this.color, ficha.getColor());
	}
	
	@Test
	public void testAsignarContiene(){
		Ficha ficha = new Ficha();
		ficha.asignarContiene();
		color=Colors.WHITE;
		assertEquals(this.color, ficha.getColor());
	}
	
	@Test(expected = MasterMindException.class)
	public void testComprobarFalloTrue() throws MasterMindException{
		Ficha ficha = new Ficha();
		ficha.setColor('M');
		
		assertTrue(ficha.comprobarFallo());
	}
	
	@Test
	public void testComprobarFalloFalse() throws MasterMindException{
		Ficha ficha = new Ficha();
		ficha.setColor('P');
		assertFalse(ficha.comprobarFallo());
		
		ficha.setColor('R');
		assertFalse(ficha.comprobarFallo());
		
		ficha.setColor('C');
		assertFalse(ficha.comprobarFallo());
		
		ficha.setColor('B');
		assertFalse(ficha.comprobarFallo());
		
		ficha.setColor('G');
		assertFalse(ficha.comprobarFallo());
		
		ficha.setColor('Y');
		assertFalse(ficha.comprobarFallo());
	}
	
	/**
	 * Test method for {@link es.unileon.prg.masterMind.Ficha#anular()}.
	 */
	@Test
	public void testAnular() throws MasterMindException{
		this.ficha.setColor('C');
		color=Colors.CYAN;
		assertEquals(this.color, ficha.getColor());
		this.ficha.anular();
		color=Colors.NONE;
		assertEquals(this.color, ficha.getColor());
	}

	/**
	 * Test method for {@link es.unileon.prg.masterMind.Ficha#toString()}.
	 */
	@Test
	public void testToString() {
		color=Colors.RED;
		assertEquals("\u001b[31m[R]\u001b[0m", this.ficha.toString());
	}

}
