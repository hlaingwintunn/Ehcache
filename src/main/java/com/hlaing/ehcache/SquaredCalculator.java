package com.hlaing.ehcache;

public class SquaredCalculator {

	private CacheHelper cacheHelper = new CacheHelper();

	public int getSquaredValueofNumber(final int input) {
		if (cacheHelper.getSquareNumberCache().containsKey(input)) {
			return cacheHelper.getSquareNumberCache().get(input);
		}

		System.out.println("Calculating square value of " + input + " and caching result.");

		int squaredValue = (int) Math.pow(input, 2);
		cacheHelper.getSquareNumberCache().put(input, squaredValue);

		return squaredValue;
	}

	public CacheHelper getCacheHelper() {
		return cacheHelper;
	}

	public void setCacheHelper(CacheHelper cacheHelper) {
		this.cacheHelper = cacheHelper;
	}

}
