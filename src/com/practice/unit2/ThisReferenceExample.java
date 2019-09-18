package com.practice.unit2;

public class ThisReferenceExample {

	public static void main(String[] args) {
		ThisReferenceExample thisReferenceExample = new ThisReferenceExample();
		thisReferenceExample.execute();

	}

	public void doProcess(int i, Process p) {
		p.process(i);
	}

	public void execute() {
		doProcess(10, i -> {
			System.out.println(i);
			System.out.println(this);
		});
	}

	public String toString() {
		return "this is the main ThisreferenceExample class";
	}

}
