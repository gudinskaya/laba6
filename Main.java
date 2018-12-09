package org.anngudin.laba6;

import org.anngudin.laba6.LibraryWindow.LibraryWindow;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException; 
 
public class Main { 
 public static void main(String[] args){ 
 LibraryWindow myWindow = new LibraryWindow (); 
 myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
 myWindow.setSize(500,650); 
 myWindow.setVisible(true); 
 myWindow.setLocationRelativeTo(null);
 } 
}
