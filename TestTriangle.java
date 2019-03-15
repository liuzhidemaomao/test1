package lab1.ts;


import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestTriangle {
	Triangle tri = null;
	private boolean expected;
	private int input;
	
	public TestTriangle(int input, boolean expected)
	{
		this.expected = expected;
		this.input = input;
	}
	
	@Before
	public void setUp() {
		tri = new Triangle();
//		tri.judge(0);
	}
	
	@Parameters
	public static Collection<Object[]> getData(){
		return Arrays.asList(new Object[][] {
			{0, false},
			{98, false},
			{10, true},
			{67, false},
			{81, true}
		});
	}
	@Test
	public void testTriangle() {
		assertEquals(this.expected, tri.judge(this.input));
	}
}
