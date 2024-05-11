package view;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ConsolePanel extends JPanel{
	private JTextArea log;
	
	public ConsolePanel() {
		this.log = new JTextArea();
		this.log.setText("CONSOLE");
		this.log.setEditable(false);
		this.setLayout(new GridLayout());
		this.add(log);
	}
	
	public void print(String text) {
		String previous = this.log.getText();
		String newText = previous+"\n"+text;
		this.log.setText(newText);
	}
	
	public void clear() {
		this.log.setText("");
	}
}
