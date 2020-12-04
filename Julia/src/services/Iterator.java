package services;

import objects.CX;

public class Iterator {

	public static CX iterate(CX z, CX C, int n) {
		CX result = new CX();
		CX zn = z.clone();
		for (int i = 0; i < n; i++) {
			result = CX.add(CX.multiply(zn, zn), C);
			zn = result;
		}
		return result;
	}
}
