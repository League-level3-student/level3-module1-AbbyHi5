package _04_HangMan;

import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HangMan implements KeyListener {
	JFrame frame = new JFrame("Hang Man");
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	JLabel l2 = new JLabel();
	int lives;
	Font font = new Font("Arial", Font.PLAIN, 40);
	String current;
	int ansInt;
	Stack<String> words;

	public static void main(String[] args) {
		HangMan hM = new HangMan();
		hM.setup();

	}

	void setup() {
		label.setFont(font);
		frame.addKeyListener(this);
		String ans = JOptionPane.showInputDialog(
				"Welcome to hang man!\nHow many words would you like to guess?\n(number not word, up to "
						+ Utilities.getTotalWordsInFile("dictionary.txt") + ")");
		ansInt = Integer.parseInt(ans);
		words = new Stack<String>();
		frame.setVisible(true);
		frame.setSize(500, 500);
		panel.add(label);
		panel.add(l2);
		frame.add(panel);
		for (int i = 0; i < ansInt; i++) {
			String temp = Utilities.readRandomLineFromFile("dictionary.txt");
			words.push(temp);
		}

		next();
	}

	void next() {
		lives = 7;
		l2.setText("Lives: " + lives);
		current = words.pop();
		System.out.println(current);
		label.setText("");
		for (int i = 0; i < current.length(); i++) {
			label.setText(label.getText() + "_");
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		char key = e.getKeyChar();
		System.out.println(key);
		boolean right = false;
		for (int i = 0; i < current.length(); i++) {
			if (current.charAt(i) == key) {
				if (i == 0) {
					label.setText(key + label.getText().substring(i + 1));
					checkWord();
					right = true;
				} else if (i == current.length() - 1) {
					label.setText(label.getText().substring(0, label.getText().length() - 1) + key);
					checkWord();
					right = true;
				} else {
					label.setText(label.getText().substring(0, i) + key
							+ label.getText().substring(i + 1, label.getText().length()));
					checkWord();
					right = true;
				}
			}

		}
		if (right == false) {
			lives--;
			l2.setText("Lives: " + lives);
			if (lives == 0) {
				int yes = JOptionPane.showConfirmDialog(null,
						"Oh no! You ran out of guesses! Would you like to play again?");
				System.out.println(yes);
				if (yes == 0) {
					setup();
				} else if (yes == 1) {
					System.exit(0);
				} else {
					System.exit(0);
				}

			}
		}
	}

	public void checkWord() {
		if (label.getText().contains("_")) {

		} else {
			ansInt--;
			if (ansInt >= 1) {
				JOptionPane.showMessageDialog(null, "You guessed the word! Moving on...");
				next();
			} else {
				int yes = JOptionPane.showConfirmDialog(null,
						"You guessed all the words! Would you like to play again?");
				System.out.println(yes);
				if (yes == 0) {
					setup();
				} else if (yes == 1) {
					System.exit(0);
				} else {
					System.exit(0);
				}
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}
}
