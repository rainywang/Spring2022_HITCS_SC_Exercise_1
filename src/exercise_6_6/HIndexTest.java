package exercise_6_6;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class HIndexTest {

	@Rule
	public ExpectedException expectedEx = ExpectedException.none();
	
	//test exception type only
	@Test(expected = IllegalArgumentException.class)
	public void testEmptyInput1() throws IllegalArgumentException {
		HIndex.calcHIndex("");
	}
	
	//test exception type and message
	@Test
	public void testEmptyInput2() throws IllegalArgumentException {
		expectedEx.expect(IllegalArgumentException.class);
		expectedEx.expectMessage("Empty input");
		HIndex.calcHIndex("");
	}

	@Test
	public void testValidInput() {
		assertEquals(1, HIndex.calcHIndex("0,0,1"));
		assertEquals(4, HIndex.calcHIndex("1,4,8,10,20"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNegativeInput() throws IllegalArgumentException {
		HIndex.calcHIndex("0,-2,0");
	}

	//@Test(expected = IllegalArgumentException.class)
	@Test
	public void testIllegalCharacterInput() throws IllegalArgumentException {
		expectedEx.expect(IllegalArgumentException.class);
		expectedEx.expectMessage("6e8 is illegal");
		HIndex.calcHIndex("1,6e8,3#*");
	}
}
