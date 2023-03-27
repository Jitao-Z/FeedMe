package ui.gui;

import model.Collection;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

// FeedMe application
public class FeedMeGUI extends JFrame implements ActionListener {
    protected JPanel panel;
    protected JPanel panel2;
    protected JButton chooseRes;
    protected JButton viewCollection;
    protected JButton load;
    protected JButton save;
    protected static Collection collection;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private static final String JSON_STORE = "./data/collection.json";


    // EFFECTS: runs the FeedMe application
    public FeedMeGUI() throws FileNotFoundException {
        super("FeedMe");
        setSize(550, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        ((JPanel) getContentPane()).setBorder(new EmptyBorder(13, 13, 13, 13));

        collection = new Collection();

        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        add(panel);

        setAllOptions();

        // adds cover image
        panel2 = new JPanel();
        ImageIcon imageIcon = new ImageIcon("images/foodicon.jpeg");
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setPreferredSize(new Dimension(480, 450));
        panel2.add(imageLabel);
        panel.add(panel2);

        setVisible(true);
        setResizable(true);

        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
    }


    // MODIFIES: this
    // EFFECTS: displays all the operating options on the main user interface
    public void setAllOptions() {
        chooseRes = new JButton("Browse restaurants around me");
        chooseRes.setAlignmentX(Component.CENTER_ALIGNMENT);
        chooseRes.addActionListener(this);
        panel.add(chooseRes);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        viewCollection = new JButton("View my current collection");
        viewCollection.setAlignmentX(Component.CENTER_ALIGNMENT);
        viewCollection.addActionListener(this);
        panel.add(viewCollection);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        load = new JButton("Load my previously saved collection");
        load.setAlignmentX(Component.CENTER_ALIGNMENT);
        load.addActionListener(this);
        panel.add(load);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        save = new JButton("Save my current collection");
        save.setAlignmentX(Component.CENTER_ALIGNMENT);
        save.addActionListener(this);
        panel.add(save);
    }


    // EFFECTS: executes corresponding functionality when user clicks on a button
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == chooseRes) {
            new CitySelectionGUI();
        } else if (e.getSource() == viewCollection) {
            new CollectionGUI();
        } else if (e.getSource() == load) {
            loadFromFile();
        } else if (e.getSource() == save) {
            saveToFile();
        }
    }


    // EFFECTS: saves the collection to file
    public void saveToFile() {
        try {
            jsonWriter.open();
            jsonWriter.write(collection);
            jsonWriter.close();
            JOptionPane.showMessageDialog(null, "Successfully saved your collection!",
                    "Status", JOptionPane.INFORMATION_MESSAGE);
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null,
                    "Oops! Something went wrong when trying to save your collection!",
                    "Status", JOptionPane.INFORMATION_MESSAGE);
        }
    }


    // EFFECTS: loads collection from file
    public void loadFromFile() {
        try {
            collection = jsonReader.read();
            JOptionPane.showMessageDialog(null,
                    "Successfully loaded your previously saved collection!",
                    "Status", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "Oops! Failed to load your previously saved collection!",
                    "Status", JOptionPane.INFORMATION_MESSAGE);
        }
    }


}

