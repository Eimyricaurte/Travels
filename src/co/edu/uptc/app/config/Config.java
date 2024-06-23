package co.edu.uptc.app.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {
        
        private static Config config;
        
        private Properties propiedades;
        
        private String path;
        
        private String nameFileCSV;
        
        private String principalColorR;
        
        private String principalColorG;
        
        private String principalColorB;
        
        private Config() {
            this.propiedades= new Properties();
            try (FileInputStream entrada = new FileInputStream("source/conf/appconfig.properties")) {
                propiedades.load(entrada);
                this.nameFileCSV = propiedades.getProperty("app.file.name.csv");
                this.principalColorR = propiedades.getProperty("gui.principal.color.r");
                this.principalColorG = propiedades.getProperty("gui.principal.color.g");
                this.principalColorB = propiedades.getProperty("gui.principal.color.b");
            } catch (IOException ex) {
                System.err.println("Error al cargar el archivo properties de configuración: " + ex.getMessage());
            }
        }
        
        public static Config getInstance() {
            if(config == null) {
                config = new Config();
            }
            return config;
        }
    
        public Properties getPropiedades() {
            return propiedades;
        }
    
        public void setPropiedades(Properties propiedades) {
            this.propiedades = propiedades;
        }
    
        public String getPath() {
            return path;
        }
    
        public void setPath(String path) {
            this.path = path;
        }
    
        public String getNameFileCSV() {
            return nameFileCSV;
        }
    
        public void setNameFileCSV(String nameFileCSV) {
            this.nameFileCSV = nameFileCSV;
        }
    
        public String getPrincipalColorR() {
            return principalColorR;
        }
    
        public void setPrincipalColorR(String principalColorR) {
            this.principalColorR = principalColorR;
        }
    
        public String getPrincipalColorG() {
            return principalColorG;
        }
    
        public void setPrincipalColorG(String principalColorG) {
            this.principalColorG = principalColorG;
        }
    
        public String getPrincipalColorB() {
            return principalColorB;
        }
    
        public void setPrincipalColorB(String principalColorB) {
            this.principalColorB = principalColorB;
        }
        
    }
    
    

