package com.hlaing.ehcache;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CacheTest {
	
	private CacheHelper cacheHelper;
	private SquaredCalculator squaredCalc;
	
	@BeforeMethod
	public void init() {
		cacheHelper = new CacheHelper();
		squaredCalc = new SquaredCalculator();
		squaredCalc.setCacheHelper(cacheHelper);
	}
	
	@Test
	public void whenCalculatingSquareValueAgain_thenCacheHasAlValues() {
		for(int i= 10; i < 15; i++) {
			assertFalse(cacheHelper.getSquareNumberCache().containsKey(i));
			System.out.println("Square value of "+ i + " is: "
					+ squaredCalc.getSquaredValueofNumber(i) + "\n");
		}
		
		for(int i = 10; i < 15; i++) {
			assertTrue(cacheHelper.getSquareNumberCache().containsKey(i));
			System.out.println("Square value of "+ i +" is: "
					+ squaredCalc.getSquaredValueofNumber(i)+ "\n");
		}
	}

}
