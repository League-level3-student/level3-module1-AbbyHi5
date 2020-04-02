package _01_IntroToArrayLists;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

public class _05_LongChipCompetition {
	/**
	 * The Beatles are eating lunch and playing a game to see who has the longest
	 * chip. (In England, french fries are called "chips".) * Find the Beatle with
	 * the longest chip. You may not edit the Chip or Beatle classes. Make sure to
	 * initialize The Beatles before you start your search. *
	 **/
	private ArrayList<Beatle> theBeatles = new ArrayList<Beatle>();
	double temp = 0;
	double tempG = 0;
	double tempJ = 0;
	double tempP = 0;
	double tempR = 0;
	int counter = 0;
	double f = 0;
	
	public static void main(String[] args) {
		_05_LongChipCompetition lcc = new _05_LongChipCompetition();
		lcc.run();

	}

	public void run() {
		initializeBeatles();
		for (Beatle b : theBeatles) {
			temp = 0;
			for (int j = 0; j < b.getChips().size(); j++) {
				
				
				if(b.getChips().get(j).getLength() > temp) {
					temp = b.getChips().get(j).getLength();
					
				}

			}
			if(counter == 0) {
				tempG = temp;
				counter++;
			}
			else if(counter == 1) {
				tempJ = temp;
				counter++;
			}
			else if(counter == 2) {
				tempP = temp;
				counter++;
			}
			else if(counter == 3) {
				tempR = temp;
				counter++;
			}	
			
		}
		if(tempG > tempJ || tempG > tempP || tempG > tempJ) {
			System.out.println("Geroge has the logest chip at " + tempG + " units long!");
		}
		else if(tempJ > tempG || tempJ > tempP || tempJ > tempJ) {
			System.out.println("John has the logest chip at " + tempJ + " units long!");
		}
		else if(tempP > tempR || tempP > tempG || tempP > tempJ) {
			System.out.println("Paul has the logest chip at " + tempP + " units long!");
		}
		else if(tempR > tempJ || tempR > tempP || tempR > tempG) {
			System.out.println("Ringo has the logest chip at " + tempR + " units long!");
		}
	}

	private void initializeBeatles() {
		Beatle george = new Beatle("George");
		Beatle john = new Beatle("John");
		Beatle paul = new Beatle("Paul");
		Beatle ringo = new Beatle("Ringo");
		theBeatles.add(george);
		theBeatles.add(john);
		theBeatles.add(paul);
		theBeatles.add(ringo);
	}

	public ArrayList<Beatle> getTheBand() {
		return theBeatles;
	}
}

class Beatle {
	private String name;
	private ArrayList<Chip> chips = new ArrayList<Chip>();

	public Beatle(String name) {
		this.name = name;
		initializePlateOfChips();
	}

	private void initializePlateOfChips() {
		int numberOfChips = new Random().nextInt(100);
		for (int i = 0; i < numberOfChips; i++) {
			chips.add(new Chip(new Random().nextDouble() * 10));
		}
	}

	public ArrayList<Chip> getChips() {
		return this.chips;
	}

	public String getName() {
		return this.name;
	}
}

class Chip {
	private double length;

	public double getLength() {
		return length;
	}

	Chip(double d) {
		this.length = d;
	}
}
