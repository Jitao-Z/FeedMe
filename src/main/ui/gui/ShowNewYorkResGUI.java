package ui.gui;

import model.Restaurant;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

public class ShowNewYorkResGUI extends JFrame implements ActionListener {
    protected JTable table;
    protected JPanel buttonsPanel;
    protected JButton viewPicture;
    protected JButton add;

    public ShowNewYorkResGUI() {
        super("New York City");
        setSize(550, 650);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ((JPanel) getContentPane()).setBorder(new EmptyBorder(30, 30, 30, 30));

        constructNewYorkRestTable();
        constructNewYorkButtons();

        setVisible(true);
    }

    public void constructNewYorkRestTable() {
        DefaultTableModel newYorkResTable = new DefaultTableModel(
                new Object[][]{{"Boucherie West Village", "$$$"}, {"Olio e Piu", "$$$"},
                        {"K Rico Steakhouse", "$$$$"}, {"Royal 35 Steakhouse", "$$$$"}},
                new Object[]{"Restaurant name", "Price"}
        );
        table = new JTable(newYorkResTable);
        add(new JScrollPane(table), BorderLayout.CENTER);
    }

    public void constructNewYorkButtons() {
        buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        viewPicture = new JButton("Show picture");
        viewPicture.addActionListener(this);
        buttonsPanel.add(viewPicture);

        add = new JButton("Add to my collection");
        add.addActionListener(this);
        buttonsPanel.add(add);

        add(buttonsPanel, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int row = table.getSelectedRow();
        String newYorkResName = table.getValueAt(row, 0).toString();

        if (e.getSource() == viewPicture) {
            showPicture(newYorkResName);
        } else if (e.getSource() == add) {
            addToCollection(newYorkResName);
        }
    }

    public void addToCollection(String newYorkResName) {
        if (newYorkResName == "Boucherie West Village") {
            Restaurant nr1 = new Restaurant("Boucherie West Village", "New York City",
                    "Popular dishes: Lobster Bisque, Boeuf Bourguignon, Cupid");
            FeedMeGUI.collection.addRestaurant(nr1);
        } else if (newYorkResName == "Olio e Piu") {
            Restaurant nr2 = new Restaurant("Olio e Piu", "New York City",
                    "Popular dishes: Italian Wedding Soup, Tortellini Di Vitello, Tilefish Arrosto");
            FeedMeGUI.collection.addRestaurant(nr2);
        } else if (newYorkResName == "K Rico Steakhouse") {
            Restaurant nr3 = new Restaurant("K Rico Steakhouse", "New York City",
                    "Popular dishes: Roasted Oysters, Fufu de Chorizo, Ceviche de Corvina");
            FeedMeGUI.collection.addRestaurant(nr3);
        } else if (newYorkResName == "Royal 35 Steakhouse") {
            Restaurant nr4 = new Restaurant("Royal 35 Steakhouse", "New York City",
                    "Popular dishes: Dry Aged Porterhouse, Seafood Tower, Chillean Sea Bass Fish");
            FeedMeGUI.collection.addRestaurant(nr4);
        }

        JOptionPane.showMessageDialog(null, newYorkResName + " is added successfully!",
                "Status", JOptionPane.INFORMATION_MESSAGE);
    }

    public void showPicture(String newYorkResName) {
        ImageIcon imageIcon = null;

        if (newYorkResName == "Boucherie West Village") {
            try {
                URL imageUrl = new URL("https://s3-media0.fl.yelpcdn.com/bphoto/zMfL8_qwipObZJp6qMLVGg/l.jpg");
                imageIcon = new ImageIcon(imageUrl);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else if (newYorkResName == "Olio e Piu") {
            try {
                URL imageUrl = new URL("https://media-cdn.tripadv"
                        + "isor.com/media/photo-s/1a/1b/15/3a/olio-e-piu.jpg");
                imageIcon = new ImageIcon(imageUrl);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else if (newYorkResName == "K Rico Steakhouse") {
            try {
                URL imageUrl = new URL("https://dynamic-media-cdn.tripadvisor.com/media/photo-o/16/8f/"
                        + "14/c8/pulpo-a-la-parilla-marinated.jpg?w=800&h=600&s=1");
                imageIcon = new ImageIcon(imageUrl);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else if (newYorkResName == "Royal 35 Steakhouse") {
            try {
                URL imageUrl = new URL("https://s3-media0.fl.yelpcdn.com/bph"
                        + "oto/QzhXzd4vxHMuh2vdM0azpw/348s.jpg");
                imageIcon = new ImageIcon(imageUrl);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        JFrame imageFrame = new JFrame("Image Preview");   // create a new JFrame to display the image
        imageFrame.setLayout(new BorderLayout());
        JLabel imageLabel = new JLabel(imageIcon);
        imageFrame.add(imageLabel, BorderLayout.CENTER);

        imageFrame.setSize(500, 400);
        imageFrame.setVisible(true);
    }
}
