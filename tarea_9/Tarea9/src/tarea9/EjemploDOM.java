package tarea9;

import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;
import java.io.*;
import java.util.*;

public class EjemploDOM {

    public static void main(String[] args) {

        ArrayList<String> animales = new ArrayList<>();

        try {

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder b = dbf.newDocumentBuilder();

            Document d = b.parse("datos1.xml");

            Element raiz = d.getDocumentElement();

            NodeList listaAnimales = raiz.getElementsByTagName("animal");

            for (int i = 0; i < listaAnimales.getLength(); i++) {
                Node n = listaAnimales.item(i);

                if (n.getNodeType() == Node.ELEMENT_NODE) {
                    Element e = (Element) n;
                    String nombre = e.getElementsByTagName("nombre").item(0).getTextContent();
                    String edad = e.getElementsByTagName("edad").item(0).getTextContent();
                    animales.add(nombre + " tiene " + edad + " años.");
                }
            }

            for (String animal : animales) {
                System.out.println(animal);
            }

        } catch (IOException ex) {
            System.err.println("No se ha podido leer el fichero XML.");
        } catch (SAXException ex) {
            System.err.println("No se ha podido parsear el fichero XML.");
        } catch (Exception ex) {
            System.err.println("Ha ocurrido un error.");
        }
    }
}
