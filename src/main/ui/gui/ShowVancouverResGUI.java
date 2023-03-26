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


public class ShowVancouverResGUI extends JFrame implements ActionListener {
    protected JTable table;
    protected JPanel buttonsPanel;
    protected JButton viewPicture;
    protected JButton add;


    public ShowVancouverResGUI() {
        super("Vancouver");
        setSize(550, 650);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ((JPanel) getContentPane()).setBorder(new EmptyBorder(30, 30, 30, 30));

        constructVancouverRestTable();
        constructVancouverButtons();

        setVisible(true);
    }

    public void constructVancouverRestTable() {
        DefaultTableModel vanResTable = new DefaultTableModel(
                new Object[][]{{"Miku", "$$$$"}, {"AnnaLena", "$$$$"}, {"Chop Steakhouse & Bar", "$$$"},
                        {"The Vancouver Fish Company", "$$"}},
                new Object[]{"Restaurant name", "Price"}
        );
        table = new JTable(vanResTable);
        add(new JScrollPane(table), BorderLayout.CENTER);
    }

    public void constructVancouverButtons() {
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
        String vanResName = table.getValueAt(row, 0).toString();

        if (e.getSource() == viewPicture) {
            showPicture(vanResName);
        } else if (e.getSource() == add) {
            addToCollection(vanResName);
        }
    }

    public void addToCollection(String vanResName) {
        if (vanResName == "Miku") {
            Restaurant vr1 = new Restaurant("Miku", "Vancouver",
                    "Popular dishes: Salmon Oshi Roll, Aburi Sushi, Ebi Oshi, Red Wave Roll");
            FeedMeGUI.collection.addRestaurant(vr1);
        } else if (vanResName == "AnnaLena") {
            Restaurant vr2 = new Restaurant("AnnaLena", "Vancouver",
                    "Popular dishes: Wagyu Short Rib, Shaved Foie Gras, Seasonal Bison Short Ribs");
            FeedMeGUI.collection.addRestaurant(vr2);
        } else if (vanResName == "Chop Steakhouse & Bar") {
            Restaurant vr3 = new Restaurant("Chop Steakhouse & Bar", "Vancouver",
                    "Popular dishes: Chili Garlic Shrimp, Prime Rib, Centre Cut New York");
            FeedMeGUI.collection.addRestaurant(vr3);
        } else if (vanResName == "The Vancouver Fish Company") {
            Restaurant vr4 = new Restaurant("The Vancouver Fish Company", "Vancouver",
                    "Popular dishes: Fresh Oysters, Tomahawk, Brant Lake Wagyu, Tuna Poke Bowl");
            FeedMeGUI.collection.addRestaurant(vr4);
        }

        JOptionPane.showMessageDialog(null, vanResName + " is added successfully!",
                "Status", JOptionPane.INFORMATION_MESSAGE);
    }

    public void showPicture(String vanResName) {
        ImageIcon imageIcon = null;

        if (vanResName == "Miku") {
            try {
                URL imageUrl = new URL("https://assets.simpleviewinc.com/simple"
                        + "view/image/upload/crm/vancouverbc/Oshi-Sushi-Salmon-Ebi-Saba-_"
                        + "B2A26C40-A2D9-4EB1-84C72C97249F1A63_df0de4de-24c7-47f7-b4124e73a51698e3.jpg");
                imageIcon = new ImageIcon(imageUrl);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else if (vanResName == "AnnaLena") {
            try {
                URL imageUrl = new URL("https://canadas100best.com/wp-content/uploads/2018/04/"
                        + "AnnaLena-Feature-Photo.jpg");
                imageIcon = new ImageIcon(imageUrl);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else if (vanResName == "Chop Steakhouse & Bar") {
            try {
                URL imageUrl = new URL("https://www.vmcdn.ca/f/files/via/images/food"
                        + "/chop-steakhouse-bar-restaurant-vancouver-bc.jpg;w=1000;h=667;mode=crop");
                imageIcon = new ImageIcon(imageUrl);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else if (vanResName == "The Vancouver Fish Company") {
            try {
                URL imageUrl = new URL("https://media-cdn.tripadvisor.com/media"
                        + "/photo-s/1c/86/d6/e6/the-vancouver-fish-company.jpg");
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

