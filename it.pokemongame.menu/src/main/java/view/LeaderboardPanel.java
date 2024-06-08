/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.LinkedList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.ScrollPaneLayout;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

import interfaces.LeaderboardObserver;
import model.menu.Account;

public class LeaderboardPanel extends JPanel {
    private LeaderboardObserver observer;
    private JScrollPane rankingPanel;
    private JPanel centerPanel;
    private List<JTextField> records;
    private JLabel title;
    private JButton back;

    public LeaderboardPanel(LeaderboardObserver observer) {
        this.observer = observer;
        initComponents();
    }

    private void initComponents() {
        records = new LinkedList<>();
        title = new JLabel();
        rankingPanel = new JScrollPane();
        back = new JButton("Back");
        centerPanel = new JPanel();
        setLayout(new BorderLayout());

        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setText("Leaderboard");
        add(title, BorderLayout.NORTH);
        add(back, BorderLayout.SOUTH);
    }

    public void initListeners() {
        back.addActionListener(e -> {
            observer.back();
        });
    }

    public void loadRecords(List<Account> accounts) {
		centerPanel.setLayout(new GridLayout(accounts.size(),4));
		for(Account a : accounts) {
			records.add(new JTextField(a.getUsername()));
			records.add(new JTextField(a.getUser().getMatches()));
			records.add(new JTextField(a.getUser().getWins()));
			records.add(new JTextField(a.getUser().getLosses()));
		}
		for(JTextField jt : this.records) {	
			jt.setEditable(false);
			jt.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
			centerPanel.add(jt);
		}
		this.rankingPanel = new JScrollPane(centerPanel);
		rankingPanel.setLayout(new ScrollPaneLayout());
		rankingPanel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		rankingPanel.setWheelScrollingEnabled(true);
		this.add(rankingPanel);
	} 
}
