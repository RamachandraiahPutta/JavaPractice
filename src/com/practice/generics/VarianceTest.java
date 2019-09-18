package com.practice.generics;

import java.util.ArrayList;
import java.util.Arrays;

public class VarianceTest {

	public static void main(String[] args) {
		// arrays are covariant
		Number[] nums = new Number[5];
		nums[0] = new Integer(1); // Ok
		nums[1] = new Double(2.0); // Ok
		printArray(nums);
		
		//an array of type S[] is a subtype of T[] if S is a subtype of T.
		Integer[] intArr = new Integer[5];
		intArr[0]=1;
		intArr[1]=2;
		Number[] numArr = intArr; // Ok
		intArr[2]=3;
//		numArr[3]=4.0; throws java.lang.ArrayStoreException
		numArr[4]=5;
		printArray(numArr);
		
		//generics are invariant.
		ArrayList<Integer> intArrList1 = new ArrayList<>();
		//ArrayList<Number> numArrList = intArrList; // Not ok
		ArrayList<Integer> anotherIntArrList = intArrList1; // Ok
		
		
		//With wildcards, it’s possible for generics to support covariance and contravariance.
		ArrayList<Integer> intArrList = new ArrayList<>();
		ArrayList<? super Integer> numArrList = intArrList; // Ok
		//Covariant types are read-only, while contravariant types are write-only.
	}

	public static <T> void printArray(T[] a) {
		System.out.println(Arrays.deepToString(a));
	}

}
