package view;

import javax.swing.*;
import interfaces.ViewObserver;
import interfaces.Pokemon;

public class MyFrame extends JFrame{
	private ViewObserver observer;
	private FirstMenu firstMenu;
	private LoginPanel loginPanel;
	private TeamPanel teamPanel;
	private InfoPanel infoPanel;
	private MainMenu mmPanel;
	private LeaderboardPanel leadPanel;
	private BattlePanel battlePanel;
	
	public MyFrame(ViewObserver observer) {
		this.observer = observer;
		this.setSize(800,600);
		this.setTitle("Pokemon Battle Mania");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		this.setVisible(true);
	}
	
	public void firstMenu() {
		if(this.teamPanel != null) {
			this.remove(teamPanel);
			this.teamPanel = null;
		}
		this.firstMenu = new FirstMenu(observer);
		this.add(firstMenu);
		this.revalidate();
	}

	// metodo per inserire il panel di login
	public void loginMenu() {
		if(this.firstMenu != null) {
			this.remove(firstMenu);
			this.firstMenu = null;
		}
		if(this.mmPanel != null) {
			this.remove(mmPanel);
			this.mmPanel = null;
		}
		this.loginPanel = new LoginPanel(observer.getLoginObserver());
		this.loginPanel.initListeners();
		this.add(loginPanel);
//		this.setSize(800,600);
		this.setResizable(true);
		this.revalidate();
	}
	
	public void mainMenu() {
		if(this.loginPanel != null) {
			this.remove(loginPanel);
			this.loginPanel = null;
		}
		if(this.teamPanel != null) {
			this.remove(teamPanel);
			this.teamPanel = null;
		}
		if(this.leadPanel != null) {
			this.remove(leadPanel);
			this.leadPanel = null;
		}
		this.mmPanel = new MainMenu(this.observer.getMenuObserver());
		this.mmPanel.initListeners();
		this.add(mmPanel);
		this.revalidate();
	}
	
	public void leaderboard() {
		if(this.mmPanel != null) {
			this.remove(mmPanel);
			this.mmPanel = null;
		}
		if(this.teamPanel != null) {
			this.remove(teamPanel);
			this.teamPanel = null;
		}
		this.leadPanel = new LeaderboardPanel(this.observer.getLeadObserver());
		this.leadPanel.initListeners();
		this.add(leadPanel);
//		this.setSize(802,601);
		this.revalidate();
	}
	
	// metodo per inserire il panel di scelta team
	public void teamMenu() {
		if(this.firstMenu != null) {
			this.remove(firstMenu);
			this.firstMenu = null;
		}
		if(this.loginPanel != null) {
			this.remove(loginPanel);
			this.loginPanel = null;
		}
		if(this.teamPanel == null) {
			this.teamPanel = new TeamPanel(observer.getTeamObserver());
		}
		if(this.mmPanel != null) {
			this.remove(mmPanel);
			this.mmPanel = null;
		}
		if(this.infoPanel != null) {
			this.remove(infoPanel);
			this.infoPanel = null;
		}
		this.add(teamPanel);
		this.setResizable(true);
		this.validate();
	}
	
	public void infoScreen(Pokemon pokemon) {
		this.remove(this.teamPanel);
		this.infoPanel = new InfoPanel(observer);
		this.infoPanel.loadInfo(pokemon);
		this.add(infoPanel);
		this.validate();
	}
	
	public void battleMenu() {
	    if (this.teamPanel != null) {
	        this.remove(teamPanel);
	        this.teamPanel = null; 
	    }
	    if (this.battlePanel == null) {  
	        this.battlePanel = new BattlePanel(); 
	    }
	    this.add(battlePanel);
	    this.setSize(1200,700);
		this.setLocationRelativeTo(null);
		this.validate();
	}
	
	public BattlePanel getBattlePanel() {	
		return this.battlePanel;
	}
	
	public LoginPanel getLoginPanel() {
		return this.loginPanel;
	}
	
	public TeamPanel getTeamPanel() {
		return this.teamPanel;
	}
	
	public LeaderboardPanel getLeaderboardPanel() {
		return this.leadPanel;
	}
}
