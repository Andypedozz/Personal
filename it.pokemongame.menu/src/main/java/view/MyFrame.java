package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.*;
import interfaces.ViewObserver;
import model.Pokemon;

public class MyFrame extends JFrame{
	private ViewObserver observer;
	private LoginPanel loginPanel;
	private TeamPanel teamPanel;
	private InfoPanel infoPanel;
	private MainMenuPanel mmPanel;
	private LeaderboardPanel leadPanel;
	private SelectMoveView selectMoveView;
	private SwitchView switchView;
	
	public MyFrame(ViewObserver observer) {
		this.observer = observer;
		this.setSize(800,600);
		this.setTitle("Pokemon Battle Mania");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenWidth = (int)screenSize.getWidth();
		int screenHeight = (int)screenSize.getHeight();
		this.setVisible(true);
	}
	
	// metodo per inserire il panel di login
	public void loginMenu() {
		if(this.mmPanel != null) {
			this.remove(mmPanel);
			this.mmPanel = null;
		}
		if(this.teamPanel != null) {
			this.remove(teamPanel);
			this.teamPanel = null;
		}
		this.loginPanel = new LoginPanel(observer.getLoginObserver());
		this.loginPanel.initListeners();
		this.add(loginPanel);
		this.setSize(800,600);
		this.setResizable(false);
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
		this.mmPanel = new MainMenuPanel(this.observer.getMenuObserver());
		this.mmPanel.initListeners();
		this.add(mmPanel);
		this.setSize(801,600);
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
		this.setSize(802,601);
		this.revalidate();
	}
	
	// metodo per inserire il panel di scelta team
	public void teamMenu() {
		if(this.loginPanel != null) {
			this.remove(loginPanel);
			this.loginPanel = null;
		}
		if(this.teamPanel == null) {
			this.teamPanel = new TeamPanel(observer.getTeamObserver());
			this.teamPanel.initListeners();
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
		this.infoPanel = new InfoPanel(observer,this.teamPanel.getSelected().getIcon(),pokemon);
		this.add(infoPanel);
		this.validate();
	}
	
	public LoginPanel getLoginPanel() {
		return this.loginPanel;
	}
	
	public TeamPanel getTeamPanel() {
		return this.teamPanel;
	}
	
	public SelectMoveView getSelectMoveView() {
    	
    	return this.selectMoveView;
    }
	
	public SwitchView getSwitchView() {
    	
    	return this.switchView;
    }
	
	public LeaderboardPanel getLeaderboardPanel() {
		return this.leadPanel;
	}
}
