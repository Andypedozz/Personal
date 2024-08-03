package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import interfaces.ViewObserver;

public class FirstMenu extends JPanel {

    private ViewObserver observer;
    private BufferedImage background;
    private JButton guestBtn;
    private JButton loginBtn;
    private JTextArea messageTextArea;
    private JToolBar toolBar;

    public FirstMenu(ViewObserver observer) {
        this.observer = observer;
        initComponents();
        initListeners();
    }

    private void initComponents() {
        GridBagConstraints gridBagConstraints;
        try{
            background = ImageIO.read(getClass().getResource("/resources/dialga_bg.jpg"));
        }catch(IOException e) {
            e.printStackTrace();
        }

        messageTextArea = new JTextArea();
        toolBar = new JToolBar();
        toolBar.setOpaque(false);
        guestBtn = new JButton();
        loginBtn = new JButton();

        setPreferredSize(new Dimension(800, 600));
        setLayout(new GridBagLayout());

        messageTextArea.setEditable(false);
        messageTextArea.setColumns(20);
        messageTextArea.setFont(new Font("Verdana", 0, 12));
        messageTextArea.setRows(5);
        messageTextArea.setOpaque(false);
        messageTextArea.setForeground(Color.white);
        messageTextArea.setText("Welcome to PokemonBattleMania!\nChoose from below if you wanna play\nwith the saving feature or play\na quick game as guests.");
        add(messageTextArea, new GridBagConstraints());

        toolBar.setRollover(true);

        guestBtn.setText("Play as guest");
        guestBtn.setFocusable(false);
        guestBtn.setHorizontalTextPosition(SwingConstants.CENTER);
        guestBtn.setVerticalTextPosition(SwingConstants.BOTTOM);
        toolBar.add(guestBtn);

        loginBtn.setText("Login");
        loginBtn.setFocusable(false);
        loginBtn.setHorizontalTextPosition(SwingConstants.CENTER);
        loginBtn.setVerticalTextPosition(SwingConstants.BOTTOM);
        toolBar.add(loginBtn);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        add(toolBar, gridBagConstraints);
    }

    public void initListeners() {
        this.loginBtn.addActionListener(e -> {
            observer.initLogin();
        });

        this.guestBtn.addActionListener(e -> {
            observer.quickPlay();
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(background != null) {
            g.drawImage(background, 0, 0, getWidth(), getHeight(),this);
        }
    }

}
