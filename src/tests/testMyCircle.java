package tests;
import exacutable.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class testMyCircle {

	@Test
	public void testGet() {
		myCircle circ = new myCircle(1,1,1,1);
		assertTrue(circ.getMoveSpeed() == 1);
	}

}
