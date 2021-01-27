package com.froyo;

import org.junit.Assert;
import org.junit.Test;

public class TriviaTest {

	@Test
	public void testTrivia() {
		int result = 4;
		if (result != 4) {   // if 2 + 2 != 4
			Assert.fail();
		}
	}

}
