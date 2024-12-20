
package controller;

import java.io.File;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Node;


public class AppConfig {
    
    //informações da aplicação serão estaticas
    private static String url;
    private static String user;
    private static String password;
    
    private AppConfig(){}

    public static String getUrl() {
        
        if(url == null){
            readConfig();
        }
        
        return url;
    }

    public static String getUser() {
        
        if(user == null){
            readConfig();
        }
        
        return user;
    }

    public static String getPassword() {
        
        if(password == null){
            readConfig();
        }
        
        return password;
    }
    
    public static void readConfig() {
    
            try {
                
               // load file
               DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
               DocumentBuilder docBuilder = docFactory.newDocumentBuilder();        
               Document doc = docBuilder.parse( new File("app-config.xml") );
               doc.getDocumentElement().normalize();

               // fetch root
               Element root = doc.getDocumentElement();
               Node node  = root.getElementsByTagName("database").item(0);
               
               url = node.getAttributes().getNamedItem("url").getNodeValue();
               user = node.getAttributes().getNamedItem("user").getNodeValue();
               password = node.getAttributes().getNamedItem("password").getNodeValue();
                
            } catch (Exception ex) {
                
                LogTrack.getInstance().adicionarLog( ex, false, null );
                
            }
        
    }
 
}
