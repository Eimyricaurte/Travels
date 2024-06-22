package co.edu.uptc.app.persistence;

    import java.util.ArrayList;
    import java.util.List;
    import java.util.StringTokenizer;
    
    import co.edu.uptc.app.constants.Constants;
import co.edu.uptc.app.model.Travel;

public class ManagementTravel extends FilePlain{

        private List<Travel> listTravel;
        
        public ManagementTravel() {
            this.listTravel = new ArrayList<>();
        }
        

        public Travel findTravel(String origin, String destiny, String route, String category) {
            for(Travel travel: this.listTravel) {
                if(travel.getOrigin().equals(origin) && travel.getDestination().equals(destiny) && travel.getRoute().equals(route) && travel.getCategory().equals(category)) {
                    return travel;
                }
            }
            return null;
        }
        
        public void dumpFile(String filePath) {
            List<String> records = new ArrayList<>();
            for (Travel travel : listTravel) {
                StringBuilder content = new StringBuilder();
                content.append(travel.getOrigin()).append(Constants.SEMI_COLON);
                content.append(travel.getDestination()).append(Constants.SEMI_COLON);
                content.append(travel.getRoute()).append(Constants.SEMI_COLON);
                content.append(travel.getConcesion()).append(Constants.SEMI_COLON);
                content.append(travel.getToll()).append(Constants.SEMI_COLON);
                content.append(travel.getCategory()).append(Constants.SEMI_COLON);
                content.append(travel.getPrice()).append(Constants.SEMI_COLON);
                content.append(travel.getDuration()).append(Constants.SEMI_COLON);
                content.append(travel.getEasy()).append(Constants.SEMI_COLON);
                content.append(travel.getDistance());
                records.add(content.toString());
            }
            this.writer(filePath, records);
        }
        
        public void loadFile(String filePath) {
            List<String> contentInLine = this.reader(filePath);
            contentInLine.forEach(row -> {
                StringTokenizer tokens = new StringTokenizer(row, Constants.SEMI_COLON);
                while (tokens.hasMoreElements()) {
                    String origin = tokens.nextToken();
                    String destiny = tokens.nextToken();
                    String route = tokens.nextToken();
                    String concesion = tokens.nextToken();
                    String toll = tokens.nextToken();
                    String category = tokens.nextToken();
                    String price = tokens.nextToken();
                    String duration = tokens.nextToken();
                    String distance = tokens.nextToken();
                    String easy = tokens.nextToken();
                    listTravel.add(new Travel(origin, destiny, route, concesion, toll, category, price, duration, distance, easy));
                }
            });
        }

        public List<Travel> getListTravel() {
            return listTravel;
        }  
    }
