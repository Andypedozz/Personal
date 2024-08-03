/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;

import interfaces.MenuObserver;

import java.awt.Insets;
import java.awt.Color;

/**
 *
 * @author andyp
 */
public class MainMenu extends javax.swing.JPanel {

    private MenuObserver observer;
    private BufferedImage bg;
    private JButton playBtn;
    private JButton leaderboardBtn;
    private JButton profileBtn;
    private JButton instructionsBtn;
    private JButton logoutBtn;

    /**
     * Creates new form MainMenu
     */
    public MainMenu(MenuObserver observer) {
        this.observer = observer;
        try {
    		bg = ImageIO.read(this.getClass().getResource("/resources/main_menu_bg.jpg"));
    	}catch(IOException e) {
    		System.out.println(e);
    	}

        setPreferredSize(new Dimension(800, 600));
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{0, 0, 0};
        gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
        setLayout(gridBagLayout);
        
        playBtn = new JButton("Play");
        playBtn.setForeground(new Color(255, 255, 255));
        playBtn.setBackground(new Color(69, 69, 69));
        GridBagConstraints gbc_playBtn = new GridBagConstraints();
        gbc_playBtn.fill = GridBagConstraints.HORIZONTAL;
        gbc_playBtn.insets = new Insets(0, 20, 5, 20);
        gbc_playBtn.gridx = 1;
        gbc_playBtn.gridy = 2;
        add(playBtn, gbc_playBtn);
        
        leaderboardBtn = new JButton("Leaderboard");
        leaderboardBtn.setForeground(new Color(255, 255, 255));
        leaderboardBtn.setBackground(new Color(69, 69, 69));
        GridBagConstraints gbc_leaderboardBtn = new GridBagConstraints();
        gbc_leaderboardBtn.fill = GridBagConstraints.HORIZONTAL;
        gbc_leaderboardBtn.insets = new Insets(0, 20, 5, 20);
        gbc_leaderboardBtn.gridx = 1;
        gbc_leaderboardBtn.gridy = 4;
        add(leaderboardBtn, gbc_leaderboardBtn);
        
        profileBtn = new JButton("Profile");
        profileBtn.setForeground(new Color(255, 255, 255));
        profileBtn.setBackground(new Color(69, 69, 69));
        GridBagConstraints gbc_profileBtn = new GridBagConstraints();
        gbc_profileBtn.fill = GridBagConstraints.HORIZONTAL;
        gbc_profileBtn.insets = new Insets(0, 20, 5, 20);
        gbc_profileBtn.gridx = 1;
        gbc_profileBtn.gridy = 6;
        add(profileBtn, gbc_profileBtn);
        
        instructionsBtn = new JButton("Instructions");
        instructionsBtn.setForeground(new Color(255, 255, 255));
        instructionsBtn.setBackground(new Color(69, 69, 69));
        GridBagConstraints gbc_instructionsBtn = new GridBagConstraints();
        gbc_instructionsBtn.fill = GridBagConstraints.HORIZONTAL;
        gbc_instructionsBtn.insets = new Insets(0, 20, 5, 20);
        gbc_instructionsBtn.gridx = 1;
        gbc_instructionsBtn.gridy = 8;
        add(instructionsBtn, gbc_instructionsBtn);
        
        logoutBtn = new JButton("Logout");
        logoutBtn.setForeground(new Color(255, 255, 255));
        logoutBtn.setBackground(new Color(69, 69, 69));
        GridBagConstraints gbc_logoutBtn = new GridBagConstraints();
        gbc_logoutBtn.fill = GridBagConstraints.HORIZONTAL;
        gbc_logoutBtn.insets = new Insets(0, 20, 5, 20);
        gbc_logoutBtn.gridx = 1;
        gbc_logoutBtn.gridy = 10;
        add(logoutBtn, gbc_logoutBtn);
    }

    public void initListeners() {
        this.playBtn.addActionListener(e -> {
            observer.teamScreen();
        });

        this.leaderboardBtn.addActionListener(e -> {
            observer.leaderboardScreen();
        });

        this.logoutBtn.addActionListener(e -> {
            observer.back();
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(bg != null) {
            g.drawImage(bg, 0, 0, getWidth(), getHeight(),this);
        }
    }
}
