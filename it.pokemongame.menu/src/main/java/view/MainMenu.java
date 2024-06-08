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
    private BufferedImage background;
    private BufferedImage bg;
    private JButton playBtn;
    private JButton btnNewButton_1;
    private JButton leaderboardBtn;
    private JButton btnNewButton_3;
    private JButton btnNewButton_4;
    private JButton logoutBtn;

    /**
     * Creates new form MainMenu
     */
    public MainMenu(MenuObserver observer) {
        this.observer = observer;
        try {
    		bg = ImageIO.read(this.getClass().getResource("/main_menu_bg.jpg"));
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
        
        btnNewButton_1 = new JButton("See Pokedex");
        btnNewButton_1.setForeground(new Color(255, 255, 255));
        btnNewButton_1.setBackground(new Color(69, 69, 69));
        GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
        gbc_btnNewButton_1.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnNewButton_1.insets = new Insets(0, 20, 5, 20);
        gbc_btnNewButton_1.gridx = 1;
        gbc_btnNewButton_1.gridy = 4;
        add(btnNewButton_1, gbc_btnNewButton_1);
        
        leaderboardBtn = new JButton("Leaderboard");
        leaderboardBtn.setForeground(new Color(255, 255, 255));
        leaderboardBtn.setBackground(new Color(69, 69, 69));
        GridBagConstraints gbc_leaderboardBtn = new GridBagConstraints();
        gbc_leaderboardBtn.fill = GridBagConstraints.HORIZONTAL;
        gbc_leaderboardBtn.insets = new Insets(0, 20, 5, 20);
        gbc_leaderboardBtn.gridx = 1;
        gbc_leaderboardBtn.gridy = 6;
        add(leaderboardBtn, gbc_leaderboardBtn);
        
        btnNewButton_3 = new JButton("Profile");
        btnNewButton_3.setForeground(new Color(255, 255, 255));
        btnNewButton_3.setBackground(new Color(69, 69, 69));
        GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
        gbc_btnNewButton_3.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnNewButton_3.insets = new Insets(0, 20, 5, 20);
        gbc_btnNewButton_3.gridx = 1;
        gbc_btnNewButton_3.gridy = 8;
        add(btnNewButton_3, gbc_btnNewButton_3);
        
        btnNewButton_4 = new JButton("Instructions");
        btnNewButton_4.setForeground(new Color(255, 255, 255));
        btnNewButton_4.setBackground(new Color(69, 69, 69));
        GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
        gbc_btnNewButton_4.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnNewButton_4.insets = new Insets(0, 20, 5, 20);
        gbc_btnNewButton_4.gridx = 1;
        gbc_btnNewButton_4.gridy = 10;
        add(btnNewButton_4, gbc_btnNewButton_4);
        
        logoutBtn = new JButton("Logout");
        logoutBtn.setForeground(new Color(255, 255, 255));
        logoutBtn.setBackground(new Color(69, 69, 69));
        GridBagConstraints gbc_logoutBtn = new GridBagConstraints();
        gbc_logoutBtn.fill = GridBagConstraints.HORIZONTAL;
        gbc_logoutBtn.insets = new Insets(0, 20, 5, 20);
        gbc_logoutBtn.gridx = 1;
        gbc_logoutBtn.gridy = 12;
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
