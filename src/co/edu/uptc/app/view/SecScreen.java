package co.edu.uptc.app.view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

import co.edu.uptc.app.persistence.ManagementEvents;

public class SecScreen extends JFrame{

    private static final long serialVersionUID = 1L;

    private JLabel tolls;
    private JLabel distance;
    private JLabel price;
    private JLabel duration;
     
    private ManagementEvents me;

    public SecScreen() {
        this.setupScreen();
        this.buildComponents();
        this.addComponents();
    }

    private void setupScreen() {
        setTitle("Calcule");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());
        getContentPane().setBackground(Color.white);
    }

    private void buildComponents() {
        this.me = new ManagementEvents();
        this.tolls = new JLabel("Total de peajes: " + me.getToll());
        this.distance = new JLabel("Total de distancia: " + me.getDistance());
        this.price = new JLabel("Total precio: " + me.getPrice());
        this.duration = new JLabel("Total tiempo: " + me.getDuration());
    }

    private void addComponents() {
        GridBagConstraints gbc = new GridBagConstraints();
		
		
		gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
		gbc.gridy = 0;
		this.add(this.tolls, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		this.add(this.distance, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		this.add(this.price, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		this.add(this.duration, gbc);
		

    }

    public static void main(String [] args) {
		SecScreen ps = new SecScreen();
		ps.setVisible(Boolean.TRUE);
	}

}
