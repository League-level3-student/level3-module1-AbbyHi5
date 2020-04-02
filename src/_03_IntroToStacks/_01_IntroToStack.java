package _03_IntroToStacks;

import java.util.Random;
import java.util.Stack;

import javax.swing.JOptionPane;

public class _01_IntroToStack {
	public static void main(String[] args) {
		// 1. Create a Stack of Doubles
		// Don't forget to import the Stack class
		Stack<Double> db = new Stack<Double>();
		Random rand = new Random();
		// 2. Use a loop to push 100 random doubles between 0 and 100 to the Stack.
		for (int i = 0; i < 100; i++) {
			db.push(rand.nextDouble() * 100);
		}
		// 3. Ask the user to enter in two numbers between 0 and 100, inclusive.
		JOptionPane.showMessageDialog(null, "Pick two number between 0 and 100 (0 and 100 included)");
		String fNum = JOptionPane.showInputDialog("First Number");
		String sNum = JOptionPane.showInputDialog("Second Number");
		// 4. Pop all the elements off of the Stack. Every time a double is popped that
		// is
		// between the two numbers entered by the user, print it to the screen.
		int fInt = Integer.parseInt(fNum);
		int sInt = Integer.parseInt(sNum);
		System.out.println("First number: " + fInt);
		System.out.println("Second number: " + sInt);
		System.out.println("Popping elements off stack...");
		System.out.println("Elements between " + fInt + " and " + sInt + ":");
		// EXAMPLE:
		// NUM 1: 65
		// NUM 2: 75
		for (int i = 0; i < db.size();) {
			Double d = db.pop();
			if (d <= fInt && d >= sInt) {
				System.out.println(d);
			} else if (d >= fInt && d <= sInt) {
				System.out.println(d);
			}
		}
		// Popping elements off stack...
		// Elements between 65 and 75:
		// 66.66876846
		// 74.51651681
		// 70.05110654
		// 69.21350456
		// 71.54506465
		// 66.47984807
		// 74.12121224
	}

}
