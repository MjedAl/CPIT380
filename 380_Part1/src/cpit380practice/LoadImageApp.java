/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cpit380practice;

/**
 *
 * @author Saim
 */
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;
 
/**
 * This class demonstrates how to load an Image from an external file
 */
public class LoadImageApp extends Component {
           
    BufferedImage img;
 
    public void paint(Graphics g) {
        g.drawImage(img, 0, 0, null);
        
    }
    
 
    public LoadImageApp() {
       try {
           img = ImageIO.read(new File("C:\\Users\\Saim\\Desktop\\cpit380practice\\cpit380practice\\src\\img\\strawberry.jpg"));
       } catch (IOException e) {
       }
 
    }
 
    public Dimension getPreferredSize() {
        if (img == null) {
             return new Dimension(100,100);
        } else {
           return new Dimension(img.getWidth(null), img.getHeight(null));
       }
    }
 
    public static void main(String[] args) {
 
        JFrame f = new JFrame("Load Image Sample");
             
        f.addWindowListener(new WindowAdapter(){
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            });
 
        f.add(new LoadImageApp());
        f.pack();
        f.setVisible(true);
    }
}
