package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import interfaces.MenuObserver;

public class MainMenuPanel extends JPanel{
	private MenuObserver observer;
	private JButton play, leaderboard, back;
	private JPanel panel1, panel2, panel3;
	
	public MainMenuPanel(MenuObserver observer) {
		this.observer = observer;
		this.setLayout(new GridLayout(1,3));
		
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		play = new JButton("Gioca");
		leaderboard = new JButton("Classifica");
		back = new JButton("Indietro");
		panel1.add(back);
		panel2.add(play);
		panel3.add(leaderboard);
		this.add(panel1);
		this.add(panel2);
		this.add(panel3);
	}
	
	public void initListeners() {
		this.play.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				observer.teamScreen();
			}
			
		});
		
		this.leaderboard.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				observer.leaderboardScreen();
			}
		});
		
		this.back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				observer.back();
			}
			
		});
	}
}
