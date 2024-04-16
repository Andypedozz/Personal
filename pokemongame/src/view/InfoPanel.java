package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import interfaces.Pokemon;
import interfaces.ViewObserver;

public class InfoPanel extends JPanel{
	private ViewObserver observer;
	
	// pokemon image
	private DefaultTableModel model;
	private Image pokeIcon;
	private JLabel pokeImgLabel;

	// panels
	private JPanel upperPanel, lowerPanel, statsPanel, movesPanel, imagePanel;
	
	// tables
	private JTextField[] fields, moves;
	
	// stats labels
	private JLabel hp, atk, def, speed;
	private JButton back;
	
	public InfoPanel(ViewObserver observer, Icon pokeIcon, Pokemon pokemon) {
		this.observer = observer;
		this.setLayout(new GridLayout(2,1));
		
		// creating components
		Border border1 = BorderFactory.createBevelBorder(BevelBorder.LOWERED);
		Border border2 = BorderFactory.createBevelBorder(BevelBorder.RAISED);
		pokeImgLabel = new JLabel(pokeIcon);
		back = new JButton("Indietro");
		upperPanel = new JPanel();
		upperPanel.setLayout(new GridLayout(1,2));
		lowerPanel = new JPanel();
		lowerPanel.setBorder(border2);
		lowerPanel.setLayout(new GridLayout(4,2));
		upperPanel.setBorder(border2);
		
		// image corner
		imagePanel = new JPanel();
		imagePanel.setBackground(Color.getHSBColor(201,100,80));
		imagePanel.setBorder(border1);
		this.pokeIcon = ((ImageIcon)pokeIcon).getImage();
		this.pokeIcon = this.pokeIcon.getScaledInstance(200,200, Image.SCALE_DEFAULT);
		pokeImgLabel = new JLabel(new ImageIcon(this.pokeIcon));
		imagePanel.add(back);
		imagePanel.add(pokeImgLabel);
		
		// stats corner
		statsPanel = new JPanel();
		statsPanel.setLayout(new GridLayout(4,2));
		statsPanel.setBackground(Color.LIGHT_GRAY);
		statsPanel.setBorder(border1);
		//table
		// table
		fields = new JTextField[8];
		fields[0] = new JTextField("HP");
		fields[1] = new JTextField(String.valueOf(pokemon.getStats().getHp()));
		fields[2] = new JTextField("Attacco");
		fields[3] = new JTextField(String.valueOf(pokemon.getStats().getAttack()));
		fields[4] = new JTextField("Difesa");
		fields[5] = new JTextField(String.valueOf(pokemon.getStats().getDefense()));
		fields[6] = new JTextField("Velocita");
		fields[7] = new JTextField(String.valueOf(pokemon.getStats().getSpeed()));
		for(int i = 0; i < 8; i++) {
			fields[i].setEditable(false);
			statsPanel.add(fields[i]);
		}
		
		
		// moves part
		moves = new JTextField[8];
		moves[0] = new JTextField(pokemon.getMoveSet().getMove1().getName());
		moves[1] = new JTextField(pokemon.getMoveSet().getMove1().getDescription());
		moves[2] = new JTextField(pokemon.getMoveSet().getMove2().getName());
		moves[3] = new JTextField(pokemon.getMoveSet().getMove2().getDescription());
		moves[4] = new JTextField(pokemon.getMoveSet().getMove3().getName());
		moves[5] = new JTextField(pokemon.getMoveSet().getMove3().getDescription());
		moves[6] = new JTextField(pokemon.getMoveSet().getMove4().getName());
		moves[7] = new JTextField(pokemon.getMoveSet().getMove4().getDescription());
		for(int i = 0; i < 8; i++) {
			moves[i].setEditable(false);
			lowerPanel.add(moves[i]);
		}

		upperPanel.add(imagePanel);
		upperPanel.add(statsPanel);
		this.add(upperPanel);
		this.add(lowerPanel);
		this.initListeners();
		this.setVisible(true);
	}
	
	public void initListeners() {
		//back logic
		this.back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				observer.initTeam();
			}	
		});
	}
}
