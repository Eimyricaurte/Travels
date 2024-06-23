package co.edu.uptc.app.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import co.edu.uptc.app.model.Travel;
import co.edu.uptc.app.persistence.FilePlain;
import co.edu.uptc.app.persistence.ManagementTravel;



public class PrincipalScreen extends JFrame {

	private static final long serialVersionUID = 1L;
	
	
	private ManagementTravel mt;
	private JPanel left;
	private JLabel title;	
	private JLabel origin;
	private JLabel destination;
	private JLabel route;
	private JLabel category;
	
	private JTextField iOrigin;
	private JTextField iDestination;
	
	
	private JComboBox<String> iRoute;
	private JComboBox<String> iCategory;
	
	
	private JButton calculate;
    private FilePlain filePlain;
	
	private SecScreen sc2;

	public PrincipalScreen() {
    this.mt = new ManagementTravel();
    this.filePlain = new FilePlain();
	this.setUpScreen();
	this.buildComponents();
	this.addComponents();
	}
	
	private void setUpScreen() {
		setTitle("Travels");
        setSize(600, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());
        getContentPane().setBackground(Color.white);
      
    }
	
	private void buildComponents() {
		
		this.left= new JPanel();
		
		left.setBackground(Color.cyan);
		
		this.title = new JLabel("Travel route");
		this.origin = new JLabel("Origin");
		this.route = new JLabel("Via");
		this.category= new JLabel("Category");
		this.destination = new JLabel("Destiny");
		this.iOrigin= new JTextField(30);
		this.iDestination= new JTextField(30);
		this.iRoute= new JComboBox<String>();
        loadRoutes();
		this.iCategory= new JComboBox<String>();
		this.iCategory.addItem("Choose");
		this.iRoute.setPreferredSize(new java.awt.Dimension(200, 30));
	    this.iCategory.setPreferredSize(new java.awt.Dimension(200, 30));
		
		this.calculate = new  JButton("Calculate");
		
		 Font boldFont = new Font("Times", Font.BOLD, 24);
	        this.title.setFont(boldFont);
	    Font boldFont2 = new Font("Times", Font.BOLD, 18);   
	        this.origin.setFont(boldFont2);
	        this.destination.setFont(boldFont2);
	        this.route.setFont(boldFont2);
	        this.category.setFont(boldFont2);
		
	}
	
	private void addComponents() {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridheight = GridBagConstraints.REMAINDER; 
		gbc.gridwidth = 1; 

	    gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 4.0; 
		gbc.weighty = 1.0;
		this.add(left, gbc);

		gbc.gridheight = 1; 
		gbc.gridwidth = 2; 
		gbc.weightx = 0.5; 
		gbc.weighty = 0;
		gbc.fill = GridBagConstraints.NONE;
		
		 
        gbc.gridx = 1;
        gbc.gridy = 1;
        
        this.add(title, gbc);

        
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        this.add(origin, gbc);

        gbc.fill =GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 3;

        this.add(iOrigin, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        this.add(destination, gbc);

       
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.EAST;
        this.add(iDestination, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 6;

        this.add(route, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 7;

        this.add(iRoute, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 8;

        this.add(category, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 9;

        this.add(iCategory, gbc);
        
        gbc.fill =GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 10;

        this.add(calculate, gbc);
    }

	private List<String> routes;

    public void loadRoutes() {
        
        String origin = iOrigin.getText().trim();
        String destination = iDestination.getText().trim();

        if (origin.isEmpty() || destination.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter both origin and destination");
            return;
        }

        List<Travel> routesList = mt.getListTravel();
        routes = new ArrayList<>();

        for (Travel route : routesList) {
            if (!routes.contains(route.getRoute())) {
                routes.add(route.getRoute());
            }
        }

        iRoute.removeAllItems();
        iRoute.addItem("Choose");
        for (String route : routes) {
            iRoute.addItem(route);
        }
    }
	

	public SecScreen getSc2() {
		return sc2;
	}

	public void setSc2(SecScreen sc2) {
		this.sc2 = sc2;
	}
	
	
	public static void main(String [] args) {
		PrincipalScreen ps = new PrincipalScreen();
		ps.setVisible(Boolean.TRUE);
	}

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public ManagementTravel getMt() {
        return mt;
    }

    public void setMt(ManagementTravel mt) {
        this.mt = mt;
    }

    public JPanel getLeft() {
        return left;
    }

    public void setLeft(JPanel left) {
        this.left = left;
    }

    public void setTitle(JLabel title) {
        this.title = title;
    }

    public JLabel getOrigin() {
        return origin;
    }

    public void setOrigin(JLabel origin) {
        this.origin = origin;
    }

    public JLabel getDestination() {
        return destination;
    }

    public void setDestination(JLabel destination) {
        this.destination = destination;
    }

    public JLabel getRoute() {
        return route;
    }

    public void setRoute(JLabel route) {
        this.route = route;
    }

    public JLabel getCategory() {
        return category;
    }

    public void setCategory(JLabel category) {
        this.category = category;
    }

    public JTextField getiOrigin() {
        return iOrigin;
    }

    public void setiOrigin(JTextField iOrigin) {
        this.iOrigin = iOrigin;
    }

    public JTextField getiDestination() {
        return iDestination;
    }

    public void setiDestination(JTextField iDestination) {
        this.iDestination = iDestination;
    }

    public JComboBox<String> getiRoute() {
        return iRoute;
    }

    public void setiRoute(JComboBox<String> iRoute) {
        this.iRoute = iRoute;
    }

    public JComboBox<String> getiCategory() {
        return iCategory;
    }

    public void setiCategory(JComboBox<String> iCategory) {
        this.iCategory = iCategory;
    }

    public JButton getCalculate() {
        return calculate;
    }

    public void setCalculate(JButton calculate) {
        this.calculate = calculate;
    }
		
}
