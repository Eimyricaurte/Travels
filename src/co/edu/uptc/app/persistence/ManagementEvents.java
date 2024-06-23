package co.edu.uptc.app.persistence;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import co.edu.uptc.app.model.Travel;
import co.edu.uptc.app.view.PrincipalScreen;
import co.edu.uptc.app.view.SecScreen;

public class ManagementEvents implements ActionListener{

    public static final String CALCULATE = "CALCULATE";

    public static final String LOAD_ROUTE = "LOAD_ROUTE";

    public static final String LOAD_CATEGORY = "LOAD_CATEGORY";

    private ManagementTravel managementTravel;

    private FilePlain filePlain = new FilePlain();
    private PrincipalScreen ps = new PrincipalScreen();
    private String toll;
    private String price;
    private String distance;
    private String duration;

    public ManagementEvents() {
        this.managementTravel = new ManagementTravel();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        SecScreen ss = new SecScreen();
        String origin = ps.getiOrigin().getText();
        String destination = ps.getiDestination().getText();
        String selectedRoute = (String) ps.getiRoute().getSelectedItem(); 
        String selectedCategory = (String) ps.getiCategory().getSelectedItem();
        switch(e.getActionCommand()){
                case CALCULATE:
                
                if (origin.isEmpty() || destination.isEmpty() || selectedRoute == null || selectedCategory == null) {
                    JOptionPane.showMessageDialog(null, "Please fill in the origin, destination, route and category fields");
                } else {
                    managementTravel.loadFile(filePlain.confValue.getPath().concat(filePlain.confValue.getNameFileCSV()));
                    List<Travel> dataFromFile = managementTravel.getListTravel();
                    List<String> tolls = new ArrayList<>();
                    List<String> distances = new ArrayList<>();
                    List<String> prices = new ArrayList<>();
                    List<String> durations = new ArrayList<>();
            
                    for (Travel row : dataFromFile) {
                        if (row.getOrigin().equals(origin) && row.getDestination().equals(destination) && row.getRoute().equals(selectedRoute) && row.getCategory().equals(selectedCategory)) {
                            String toll = row.getToll();
                            if (!tolls.contains(toll)) {
                                tolls.add(toll);
                            }
            
                            String distance = row.getDistance(); 
                            distances.add(distance);
            
                            String price = row.getPrice();
                            prices.add(price);
            
                            String duration = row.getDuration();
                            durations.add(duration);
                        }
                    }
            
                    this.toll = String.valueOf(tolls.size());
            
                    double totalDistance = 0;
                    for (String distance : distances) {
                        totalDistance += Double.parseDouble(distance);
                    }
                    this.distance = String.valueOf(totalDistance);
            
                    double totalPrice = 0;
                    for (String price : prices) {
                        totalPrice += Double.parseDouble(price);
                    }
                    this.price = String.valueOf(totalPrice);
            
                    double totalDuration = 0;
                    for (String duration : durations) {
                        String[] parts = duration.split(" ");
                        int hours = Integer.parseInt(parts[0]);
                        int minutes = Integer.parseInt(parts[2]);
                        double durationInHours = hours + (minutes / 60.0);
                        totalDuration += durationInHours;
                    }
                    this.duration = String.valueOf(totalDuration);
                }
                ss.setVisible(true);
                break;
        }
    }

    public String getToll() {
        return toll;
    }

    public void setToll(String toll) {
        this.toll = toll;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
 