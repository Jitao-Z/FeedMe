package ui;

import ui.gui.FeedMeGUI;

import javax.swing.*;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        try {
            new FeedMeGUI();
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null,
                    "Unable to run the application: file not found",
                    "Status", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}

//        try {
//            new FeedMeApp();
//        } catch (FileNotFoundException e) {
//            System.out.println("Unable to run the application: file not found");
//        }
//    }
