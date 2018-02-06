package com.triangle.util;

import java.util.stream.Stream;

import com.triangle.model.Triangle;
import com.triangle.model.TriangleType;

/**
 * Utility class that can be used to work with the input 
 * 
 * @author tiberiuionescu
 *
 */
public class TriangleUtil {

	/**
	 * Checks that the given values are valid as the length for each side of a triangle.
	 * 
	 * @param a length of side a
	 * @param b length of side b
	 * @param c length of side c
	 */
	public static void validateInput(Integer a, Integer b, Integer c) {
		// Check that we have the input
		if (a == null || b == null || c == null) {
			throw new IllegalArgumentException("Missing at least one of the inputs");
		}
		
		// Check that the input can be used to create an actual triangle.
		if (a > (b + c) ||
			c >= (b + a) ||
			b >= (a + c)
		) {
			throw new IllegalArgumentException("The given values can not form a triangle");
		}
	}
	
	/**
	 * Classify the triangle as one of the triangles we are looking for.
	 * 
	 * @param triangle to look at
	 * @return type of triangle
	 */
	public static TriangleType classify(Triangle triangle) {
		// It would check, in order, for EQUILATERAL, ISOSCELES and then SCALENE
		return Stream.of(TriangleType.values())
			.filter(type -> type.checkType(triangle))
			.findFirst()
			.orElseThrow(() -> new RuntimeException("Could not identify this type of triangle"));
	}
}
