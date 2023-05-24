package tarea9;

import java.io.*;
import java.util.*;

public class EjemploXML {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        
        FileWriter fw = null;
        String texto1 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
        
        System.out.println("Introduce el tipo de animal:");
        
        String raiz = teclado.nextLine();
        
        System.out.println("Introduce la cantidad de animales:");
        
        int n = teclado.nextInt();
        teclado.nextLine();
        
        String texto2 = "\n<" + raiz + ">\n";
        
        for (int i = 0; i < n; i++) {
            System.out.println("Introduce el nombre del animal:");
            String nombre = teclado.nextLine();
            System.out.println("Introduce la edad del animal:");
            String edad = teclado.nextLine();

            texto2 += "  <animal>\n";
            texto2 += "    <nombre>" + nombre + "</nombre>\n";
            texto2 += "    <edad>" + edad + "</edad>\n";
            texto2 += "  </animal>\n";
        }
        
        texto2 += "</" + raiz + ">";
        
        try {
            fw = new FileWriter("datos1.xml");
            fw.write(texto1);
            fw.write(texto2);
            System.out.println("Fichero XML generado.");
        } catch (IOException e) {
            System.out.println("Ha ocurrido una IOException.");
        } finally {
            try {
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException e) {
                System.err.println("Ha ocurrido una IOException.");
            }
        }
    }
}