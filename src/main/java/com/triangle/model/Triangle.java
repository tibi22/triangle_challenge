package com.triangle.model;

import com.triangle.util.TriangleUtil;

/**
 * POJO modeling a triangle.
 * 
 * NOTE: We could extended to include extra data such as the
 * triangle's angles.
 * 
 * @author tiberiuionescu
 *
 */
public class Triangle {

	private int a, b, c;

	/**
	 * Create an instance of a triangle.
	 * 
	 * @param a length of one of the triangle's sides
	 * @param b length of one of the triangle's sides
	 * @param c length of one of the triangle's sides
	 */
	public Triangle(int a, int b, int c) {
		super();
		// Validate that the input can form a triangle
		TriangleUtil.validateInput(a, b, c);
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	public int getC() {
		return c;
	}

	public void setC(int c) {
		this.c = c;
	}
	
}
