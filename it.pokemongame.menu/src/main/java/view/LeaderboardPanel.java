package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

import javax.swing.*;
import javax.swing.border.BevelBorder;

import interfaces.LeaderboardObserver;
import model.menu.Account;

public class LeaderboardPanel extends JPanel{
	private LeaderboardObserver observer;
	private JScrollPane scrollPane;
	private JPanel leftPanel, rightPanel;
	private List<JTextField> records;
	private JButton back;
	
	public LeaderboardPanel(LeaderboardObserver observer) {
		this.observer = observer;
		this.setLayout(new GridLayout(1,2));
		leftPanel = new JPanel();
		rightPanel = new JPanel();
		records = new LinkedList<>();
		back = new JButton("Indietro");
		leftPanel.add(back);
		this.add(leftPanel);
	}
	
	public void initListeners() {
		this.back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				observer.back();
			}
		});
	}
	
	public void loadRecords(List<Account> accounts) {
		rightPanel.setLayout(new GridLayout(accounts.size(),4));
		for(Account a : accounts) {
			records.add(new JTextField(a.getUsername()));
			records.add(new JTextField(a.getUser().getMatches()));
			records.add(new JTextField(a.getUser().getWins()));
			records.add(new JTextField(a.getUser().getLosses()));
		}
		for(JTextField jt : this.records) {	
			jt.setEditable(false);
			jt.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
			rightPanel.add(jt);
		}
		this.scrollPane = new JScrollPane(rightPanel);
		scrollPane.setLayout(new ScrollPaneLayout());
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setWheelScrollingEnabled(true);
		this.add(scrollPane);
	}
}
