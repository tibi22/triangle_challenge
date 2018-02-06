package com.triangle.model;

/**
 * Enum containing the types of triangles that we're looking for.
 * 
 * NOTE: This can be extended with other triangle types for which
 * we can add different conditions by extending the {@link Triangle} model.
 * 
 * f.ex.: We can add `RIGHT_TRIANGLE` to the enum for which we would need to
 * have added angles to the Triangle model, and in the `isOfType` method then
 * check if any of the angles is of 90 degrees.
 * 
 * 
 * @author tiberiuionescu
 *
 */
public enum TriangleType {

	EQUILATERAL {

		@Override
		public boolean checkType(Triangle tr) {
			return tr.getA() == tr.getB() && 
				tr.getB() == tr.getC();
		}
		
	},
	ISOSCELES {

		@Override
		public boolean checkType(Triangle tr) {
			/* 
			 * NOTE:An optimization can be to exclude the second part (b != c part) 
			 * by first checking if a triangle is EQUILATERAL (since its not, 
			 * then we know that b is not equal to c if a is equal to b).
			 * But I decided to keep it here so that the check is more generic
			 * and doesn't depend on checking for other triangle types.
			 */
			if ((tr.getA() == tr.getB() && tr.getB() != tr.getC()) ||
				(tr.getA() == tr.getC() && tr.getA() != tr.getB()) ||
				(tr.getB() == tr.getC() && tr.getA() != tr.getC())
			) {
				return true;
			}
			else {
				return false;
			}
		}
		
	},
	SCALENE {

		@Override
		public boolean checkType(Triangle tr) {
			return tr.getA() != tr.getB() 
				&& tr.getB() != tr.getC()
				&& tr.getC() != tr.getA();
		}
		
	};
	
	/**
	 * Checks that the given Triangle is of a certain type.
	 * 
	 * @param tr triangle POJO
	 * @return true if its of this type
	 */
	public abstract boolean checkType(Triangle tr);
}
