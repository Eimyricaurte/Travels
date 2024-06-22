package co.edu.uptc.app.model;

public class Travel {

    private String origin;
    private String destination;
    private String route;
    private String concesion;
    private String toll;
    private String category;
    private String price;
    private String duration;
    private String distance;
    private String easy;

    
    public Travel() {
    }


    public Travel(String origin, String destination, String route, String concesion, String toll, String category,
            String price, String duration, String distance, String easy) {
        this.origin = origin;
        this.destination = destination;
        this.route = route;
        this.concesion = concesion;
        this.toll = toll;
        this.category = category;
        this.price = price;
        this.duration = duration;
        this.distance = distance;
        this.easy = easy;
    }

    public String getOrigin() {
        return origin;
    }


    public void setOrigin(String origin) {
        this.origin = origin;
    }


    public String getDestination() {
        return destination;
    }


    public void setDestination(String destination) {
        this.destination = destination;
    }


    public String getRoute() {
        return route;
    }


    public void setRoute(String route) {
        this.route = route;
    }


    public String getCategory() {
        return category;
    }


    public void setCategory(String category) {
        this.category = category;
    }


    public String getPrice() {
        return price;
    }


    public void setPrice(String price) {
        this.price = price;
    }


    public String getDuration() {
        return duration;
    }


    public void setDuration(String duration) {
        this.duration = duration;
    }


    public String getDistance() {
        return distance;
    }


    public void setDistance(String distance) {
        this.distance = distance;
    }


    public String getConcesion() {
        return concesion;
    }


    public void setConcesion(String concesion) {
        this.concesion = concesion;
    }


    public String getToll() {
        return toll;
    }


    public void setToll(String toll) {
        this.toll = toll;
    }


    public String getEasy() {
        return easy;
    }


    public void setEasy(String easy) {
        this.easy = easy;
    }

    
}
