package exercise_6_6;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class HIndexTest {

	/**
	 * Testing Strategy: 
	 * 按输入的长度进行划分：0,1,2,n(>2) 
	 * 按值划分：正整数或0、负值、小数、包含其他字符
	 * 按排序后数值大小：第1个<1，第2个<2，第n个<n 
	 * 按相对值大小：数字都一样、一个大其他都小、一个小其他都大
	 * 
	 * 按“笛卡尔积全覆盖”策略设计测试用例
	 * 或按“每个取值至少覆盖一次”策略
	 */

	@Test
	public void testSameCitationNumbers() {
		assertEquals(0, HIndex.calcHIndex("0,0,0,0,0,0,0"));
		assertEquals(4, HIndex.calcHIndex("5,5,5,5"));
		assertEquals(5, HIndex.calcHIndex("5,5,5,5,5"));
		assertEquals(5, HIndex.calcHIndex("5,5,5,5,5,5"));
	}
	
	@Test
	public void testOneBigCitationNumbers() {
		assertEquals(5, HIndex.calcHIndex("5,5,5,5,5,500"));
	}
	
	@Test
	public void testOneSmallCitationNumbers() {
		assertEquals(5, HIndex.calcHIndex("5,500,500,500,500,500"));
	}
	
	@Rule
	public ExpectedException expectedEx = ExpectedException.none();

	// covers 输入长度=0
	//@Test(expected = IllegalArgumentException.class)
	@Test
	public void testEmptyInput() throws IllegalArgumentException {
		expectedEx.expect(IllegalArgumentException.class);
		expectedEx.expectMessage("Empty input");
		HIndex.calcHIndex("");
	}

	// covers 输入长度=1，正整数/0
	@Test
	public void testOneInput() {
		assertEquals(0, HIndex.calcHIndex("0"));
		assertEquals(1, HIndex.calcHIndex("10"));
	}

	// covers 输入长度=2，正整数/0
	@Test
	public void testTwoInput() {
		assertEquals(0, HIndex.calcHIndex("0,0"));
		assertEquals(1, HIndex.calcHIndex("1,4"));
		assertEquals(2, HIndex.calcHIndex("2,4"));
	}

	// covers 输入长度>2，正整数/0
	@Test
	public void testMultipleInput() {
		assertEquals(0, HIndex.calcHIndex("0,0,0"));
		assertEquals(1, HIndex.calcHIndex("1,4,1"));
		assertEquals(2, HIndex.calcHIndex("2,4,4"));
		assertEquals(3, HIndex.calcHIndex("3,4,4"));
	}

	// covers 输入包含负值
	@Test(expected = IllegalArgumentException.class)
	public void testNegativeInput() throws IllegalArgumentException {
		HIndex.calcHIndex("0,-2,0");
	}

	// covers 输入包含小数
	//@Test(expected = IllegalArgumentException.class)
	@Test
	public void testNumberWithDigitalInput() throws IllegalArgumentException {
		expectedEx.expect(IllegalArgumentException.class);
		expectedEx.expectMessage("2.3 is illegal");
		HIndex.calcHIndex("1,2.3,0");
	}

	// covers 输入包含其他字符
	//@Test(expected = IllegalArgumentException.class)
	@Test
	public void testIllegalCharacterInput() throws IllegalArgumentException {
		expectedEx.expect(IllegalArgumentException.class);
		expectedEx.expectMessage("6e8 is illegal");
		HIndex.calcHIndex("1,6e8,3#*");
	}
}
