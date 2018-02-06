package com.triangle.test;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.triangle.model.Triangle;
import com.triangle.model.TriangleType;
import com.triangle.util.TriangleUtil;

/**
 * Java app to retrieve the type of a triangle where 
 * the input is the length of each side of the triangle. 
 *
 */
public class App 
{
	public static void main( String[] args ) {
		Scanner sc = new Scanner(System.in);
		
		try {
			/*
			 * Calling `nextInt` would throw an exception (NoSuchElementException, IllegalStateException) 
			 * if we don't have the correct input or the input is missing, which should be fine 
			 * since its a clear and easy to understand reply to the calling user.
			 *
			 */
			Integer a = sc.nextInt();
			Integer b = sc.nextInt();
			Integer c = sc.nextInt();
			
			// Create a triangle model which also validates the input
			Triangle triangle = new Triangle(a, b, c);
			
			// Classify the triangle
			TriangleType triangleType = TriangleUtil.classify(triangle);
			System.out.println("For the given input "
				+ "{" + a + ", " + b + ", " + c + "} "
				+ "we have a triangle of type " + triangleType);
		}
		catch (InputMismatchException e) {
			System.err.println("The input needs to be an integer.");
		}
		finally {
			sc.close();
		}
	}
	
}
