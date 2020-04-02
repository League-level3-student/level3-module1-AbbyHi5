package _03_IntroToStacks;

import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class _02_TextUndoRedo implements KeyListener {
	/*
	 * Create a JFrame with a JPanel and a JLabel.
	 * 
	 * Every time a key is pressed, add that character to the JLabel. It should look
	 * like a basic text editor.
	 * 
	 * Make it so that every time the BACKSPACE key is pressed, the last character
	 * is erased from the JLabel. Save that deleted character onto a Stack of
	 * Characters.
	 * 
	 * Choose a key to be the Undo key. Make it so that when that key is pressed,
	 * the top Character is popped off the Stack and added back to the JLabel.
	 * 
	 */
	static _02_TextUndoRedo text = new _02_TextUndoRedo();
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel();

	public static void main(String[] args) {
		text.run();
	}

	public void run() {
		frame.setSize(500, 500);
		frame.setVisible(true);
		frame.add(panel);
		panel.add(label);
		label.addKeyListener(this);
	}

	public void keyPressed(KeyEvent e) {
		System.out.println("pressed " + e);
	if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			
		}
		else if (e.getKeyCode() == KeyEvent.VK_TAB) {
			
		}
		else {
			label.setText(label.getText()+e.getKeyChar());
		}
	}

	public void keyReleased(KeyEvent arg0) {
		
	}

	public void keyTyped(KeyEvent e) {
	
		
	}
}




















