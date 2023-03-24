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

public class ShowLondonResGUI extends JFrame implements ActionListener {
    protected JTable table;
    protected JPanel buttonsPanel;
    protected JButton viewPicture;
    protected JButton add;

    public ShowLondonResGUI() {
        super("London");
        setSize(550, 650);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ((JPanel) getContentPane()).setBorder(new EmptyBorder(30, 30, 30, 30));

        constructLondonRestTable();
        constructLondonButtons();

        setVisible(true);
    }

    public void constructLondonRestTable() {
        DefaultTableModel lonResTable = new DefaultTableModel(
                new Object[][]{{"Launceston Place", "$$$$"}, {"Alexander The Great", "$$$$"},
                        {"Andy’s Greek Taverna", "$$$"}, {"Indian Room", "$$"}},
                new Object[]{"Restaurant name", "Price"}
        );
        table = new JTable(lonResTable);
        add(new JScrollPane(table), BorderLayout.CENTER);
    }

    public void constructLondonButtons() {
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
        String lonResName = table.getValueAt(row, 0).toString();

        if (e.getSource() == viewPicture) {
            showPicture(lonResName);
        } else if (e.getSource() == add) {
            addToCollection(lonResName);
        }
    }

    public void addToCollection(String lonResName) {
        if (lonResName == "Launceston Place") {
            Restaurant lr1 = new Restaurant("Launceston Place", "London",
                    "Popular dishes: Pork, Cheese Cart, Cod");
            FeedMeGUI.collection.addRestaurant(lr1);
        } else if (lonResName == "Alexander The Great") {
            Restaurant lr2 = new Restaurant("Alexander The Great", "London",
                    "Popular dishes: Alexander's Kebab, Sheftalia, House Mixed Grill");
            FeedMeGUI.collection.addRestaurant(lr2);
        } else if (lonResName == "Andy’s Greek Taverna") {
            Restaurant lr3 = new Restaurant("Andy’s Greek Taverna", "London",
                    "Popular dishes: Lamp, Mossaka");
            FeedMeGUI.collection.addRestaurant(lr3);
        } else if (lonResName == "Indian Room") {
            Restaurant lr4 = new Restaurant("Indian Room", "London",
                    "Popular dishes: Goan Seafood Curry, Mumbai Fish Curry, Zinga Methi");
            FeedMeGUI.collection.addRestaurant(lr4);
        }

        JOptionPane.showMessageDialog(null, lonResName + " is added successfully!",
                "Status", JOptionPane.INFORMATION_MESSAGE);
    }

    public void showPicture(String lonResName) {
        ImageIcon imageIcon = null;

        if (lonResName == "Launceston Place") {
            try {
                URL imageUrl = new URL("https://media.timeout.com/images/103140590/image.jpg");
                imageIcon = new ImageIcon(imageUrl);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else if (lonResName == "Alexander The Great") {
            try {
                URL imageUrl = new URL("https://dynamic-media-cdn.tripadvisor." +
                        "com/media/photo-o/1a/13/ac/d1/cold-meze-starters-selection.jpg?w=800&h=600&s=1");
                imageIcon = new ImageIcon(imageUrl);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else if (lonResName == "Andy’s Greek Taverna") {
            try {
                URL imageUrl = new URL("https://res.cloudinary.com/tf-lab/image/upload/restaurant/2dcca421-" +
                        "a20e-4788-ae1c-24471f3e3adb/c07eb343-1848-45a6-bc6d-ce15e62b65e3.jpg");
                imageIcon = new ImageIcon(imageUrl);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else if (lonResName == "Indian Room") {
            try {
                URL imageUrl = new URL("https://media-cdn.tripadvisor.com/media/" +
                        "photo-s/0e/0e/37/d1/lamb-chop-kasundi.jpg");
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
