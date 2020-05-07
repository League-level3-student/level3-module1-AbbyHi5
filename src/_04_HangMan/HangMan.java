package _04_HangMan;

import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HangMan implements KeyListener{
	
	JFrame frame = new JFrame("Hang Man");
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	Font font = new Font("Arial", Font.PLAIN, 40);
	String current;
	
	public static void main(String[] args) {
		HangMan hM = new HangMan();
		hM.setup();
		
	}
	
	void setup() {
		label.setFont(font);
		frame.addKeyListener(this);
		
		String ans = JOptionPane.showInputDialog("Welcome to hang man!\nHow many words would you like to guess?\n(number not word, up to "
													+ Utilities.getTotalWordsInFile("dictionary.txt") + ")");
		int ansInt = Integer.parseInt(ans);
		Stack<String> words = new Stack<String>();
		frame.setVisible(true);
		frame.setSize(500, 500);
		panel.add(label);
		frame.add(panel);
		
		for(int i = 0; i < ansInt; i++) {
			String temp = Utilities.readRandomLineFromFile("dictionary.txt");
			words.push(temp);
		}
		
		current = words.pop();
		System.out.println(current);
		for (int i = 0; i < current.length(); i++) {
			label.setText(label.getText() + "_");
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

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		char key = e.getKeyChar();
		System.out.println(key);
		for (int i = 0; i < current.length(); i++) {
			if(current.charAt(i) == key) {
				
				if(i == 0) {
					
					label.setText(key + label.getText().substring(i + 1));
					
				}
				
				else if (i == current.length() - 1) {
					
					label.setText(label.getText().substring(0, label.getText().length() - 1) + key);
					
				}
				
				else
				
				{
					
					label.setText(label.getText().substring(0, i - 1) + key + label.getText().substring(i + 1, label.getText().length() - 1));
					
				}
			}
		}
	}
	
}





