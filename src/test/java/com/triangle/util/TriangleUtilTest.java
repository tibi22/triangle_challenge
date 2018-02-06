package com.triangle.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.triangle.model.Triangle;
import com.triangle.model.TriangleType;

/**
 * Test class for the {@code TriangleUtil} class.
 *
 * NOTE: Verifies classifying the correct triangle type for a given
 * input, as well as validation of the input data used to create 
 * a triangle.
 * 
 * @author tiberiuionescu
 *
 */
public class TriangleUtilTest {

	@Test
	public void equilateralTest() {
		Triangle triangle = new Triangle(3, 3, 3);
		TriangleType type = TriangleUtil.classify(triangle);
		assertEquals(TriangleType.EQUILATERAL, type);
	}
	
	@Test
	public void isoscelesTest() {
		Triangle triangle = new Triangle(4, 4, 7);
		TriangleType type = TriangleUtil.classify(triangle);
		assertEquals(TriangleType.ISOSCELES, type);
	}
	
	@Test
	public void scaleneTest() {
		Triangle triangle = new Triangle(12, 6 , 14);
		TriangleType type = TriangleUtil.classify(triangle);
		assertEquals(TriangleType.SCALENE, type);
	}
	
	@Test
	public void invalidTest() {
		assertThrows(IllegalArgumentException.class, 
			() -> {
				new Triangle(7, 4, 2);
			});
	}
}
