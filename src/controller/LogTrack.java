package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

/*
Implementa os padrões de design orientado a objetos Singleton e Facade.
*/
public class LogTrack {
    
    private static LogTrack singleton;
    
    private File arquivo;
    private Document doc;
    private Element root;
    
    private LogTrack() {        
        
        try {
            
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        
            arquivo = new File("log-track.xml");
            
            if( arquivo.exists() ) {
                
                doc = docBuilder.parse( arquivo );
                root = doc.getDocumentElement();
                
            } else {
                
                doc = docBuilder.newDocument();
                root = doc.createElement( "log" );
                doc.appendChild(root);
                salvar();
                
            }        
            
        } catch( Exception ex ) {
            ex.printStackTrace();
        }
        
    }
    
    public static LogTrack getInstance() {
        
        if( singleton == null ) {
            singleton = new LogTrack();
        }
        
        return singleton;
    }
    
    private void salvar() throws Exception {
        
        FileOutputStream output = new FileOutputStream(arquivo);
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource( doc );
        StreamResult result = new StreamResult( output );
        
        transformer.setOutputProperty( OutputKeys.OMIT_XML_DECLARATION, "yes" );
        transformer.setOutputProperty( OutputKeys.INDENT, "yes" );
        transformer.setOutputProperty(OutputKeys.ENCODING,"UTF-8");
        transformer.transform( source, result );
        
    }
    
    public void adicionarLog( Exception ex, boolean showDialog, JFrame frame ) {
        
        try {
        
            ex.printStackTrace();

            Calendar data = Calendar.getInstance();
            String info = data.getTime().toString();

            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            ex.printStackTrace(pw);

            Element log = doc.createElement("erro");
            log.setAttribute("data-horario", info);
            log.setTextContent( sw.toString() );

            root.appendChild(log);

            salvar();
            
        } catch( Exception e ) {
            e.printStackTrace();
        }
        
        if( showDialog ) {
            JOptionPane.showMessageDialog( frame, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE );
        }
        
    }
    
}