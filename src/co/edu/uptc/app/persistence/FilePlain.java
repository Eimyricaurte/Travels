package co.edu.uptc.app.persistence;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import co.edu.uptc.app.config.Config;
import co.edu.uptc.app.constants.Constants;

public class FilePlain {

        protected Config confValue;
        
        public FilePlain() {
            confValue = Config.getInstance();
        }
    
        public String readFile(String namePath) {
            StringBuilder contenido = new StringBuilder();
            try {
                BufferedReader br = new BufferedReader(new FileReader(namePath));
                String linea;
                while ((linea = br.readLine()) != null) {
                    contenido.append(linea).append(Constants.NEXT_LINE);
                }
                br.close();
            } catch (IOException e) {
                System.out.println("Se presentó un error al leer el archivo específicado");
            }
            return contenido.toString();
        }
        
    
        public void writeFile(String nameFilePath, String content) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(nameFilePath))) {
                writer.write(content);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    
        protected List<String> reader(String namePath){
            List<String> output = new ArrayList<>();
            StringTokenizer tokens = new StringTokenizer(this.readFile(namePath), 
                    Constants.NEXT_LINE);
            while (tokens.hasMoreElements()) {
                output.add(tokens.nextToken());	
            }
            return output;
        }
        
    
        protected void writer(String namePath, List<String> file){
            StringBuilder strContent = new StringBuilder();
            file.forEach(record -> strContent.append(record)
                    .append(Constants.NEXT_LINE));
            writeFile(namePath, strContent.toString());
        }

        public Config getConfValue() {
            return confValue;
        }

        public void setConfValue(Config confValue) {
            this.confValue = confValue;
        }
    }

