package homework3.ts;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class TestPrintPrimes {
	@Test
	public void printOut() {

		int [] final_list = PrintPrimes.main(new String[] {"3"});
		assertArrayEquals(new int[] {2, 3, 5}, final_list);
		
		
	}
}
