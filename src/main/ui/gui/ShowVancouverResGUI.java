package ui.gui;

import model.Restaurant;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

// The Vancouver restaurant selection GUI
public class ShowVancouverResGUI extends JFrame implements ActionListener {
    protected JTable table;
    protected JPanel buttonsPanel;
    protected JButton viewPicture;
    protected JButton add;
    protected ImageIcon imageIcon = null;


    // EFFECTS: constructs the Vancouver restaurant selection GUI
    public ShowVancouverResGUI() {
        super("Vancouver");
        setSize(550, 650);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ((JPanel) getContentPane()).setBorder(new EmptyBorder(30, 30, 30, 30));

        constructVancouverRestTable();
        constructVancouverButtons();

        setVisible(true);
    }

    // MODIFIES: this
    // EFFECTS: constructs a table listing all the selectable Vancouver restaurants in it, and
    //          adds it to the Vancouver restaurant selection GUI
    public void constructVancouverRestTable() {
        DefaultTableModel vanResTable = new DefaultTableModel(
                new Object[][]{{"Miku", "$$$$"}, {"AnnaLena", "$$$$"}, {"Chop Steakhouse & Bar", "$$$"},
                        {"The Vancouver Fish Company", "$$"}},
                new Object[]{"Restaurant name", "Price"}
        );
        table = new JTable(vanResTable);
        add(new JScrollPane(table), BorderLayout.CENTER);
    }

    // MODIFIES: this
    // EFFECTS: displays all the operating options on the Vancouver restaurant selection GUI
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


    // EFFECTS: executes corresponding functionality when user selects a row and clicks on a button
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

    // EFFECTS: adds the selected restaurants into the collection
    public void addToCollection(String vanResName) {
        if (vanResName.equals("Miku")) {
            Restaurant vr1 = new Restaurant("Miku", "Vancouver",
                    "Popular dishes: Salmon Oshi Roll, Aburi Sushi, Ebi Oshi, Red Wave Roll");
            FeedMeGUI.collection.addRestaurant(vr1);
        } else if (vanResName.equals("AnnaLena")) {
            Restaurant vr2 = new Restaurant("AnnaLena", "Vancouver",
                    "Popular dishes: Wagyu Short Rib, Shaved Foie Gras, Seasonal Bison Short Ribs");
            FeedMeGUI.collection.addRestaurant(vr2);
        } else if (vanResName.equals("Chop Steakhouse & Bar")) {
            Restaurant vr3 = new Restaurant("Chop Steakhouse & Bar", "Vancouver",
                    "Popular dishes: Chili Garlic Shrimp, Prime Rib, Centre Cut New York");
            FeedMeGUI.collection.addRestaurant(vr3);
        } else if (vanResName.equals("The Vancouver Fish Company")) {
            Restaurant vr4 = new Restaurant("The Vancouver Fish Company", "Vancouver",
                    "Popular dishes: Fresh Oysters, Tomahawk, Brant Lake Wagyu, Tuna Poke Bowl");
            FeedMeGUI.collection.addRestaurant(vr4);
        }

        JOptionPane.showMessageDialog(null, vanResName + " is added successfully!",
                "Status", JOptionPane.INFORMATION_MESSAGE);
    }

    // EFFECTS: shows the image of the selected restaurant
    public void showPicture(String vanResName) {
        if (vanResName.equals("Miku")) {
            changeToImageIcon("https://assets.simpleviewinc.com/simpleview/image/upload/crm/vancouverbc"
                    + "/Oshi-Sushi-Salmon-Ebi-Saba-_B2A26C40-A2D9-4EB1-"
                    + "84C72C97249F1A63_df0de4de-24c7-47f7-b4124e73a51698e3.jpg");
        } else if (vanResName.equals("AnnaLena")) {
            changeToImageIcon("https://canadas100best.com/wp-content/uploads/2018/04/AnnaLena-Feature-Photo.jpg");
        } else if (vanResName.equals("Chop Steakhouse & Bar")) {
            changeToImageIcon("https://www.vmcdn.ca/f/files/via/images/food/chop-ste"
                    + "akhouse-bar-restaurant-vancouver-bc.jpg;w=1000;h=667;mode=crop");
        } else if (vanResName.equals("The Vancouver Fish Company")) {
            changeToImageIcon("https://static.wixstatic.com/media/41dd26_36fb5db3b8514daaae86447a08b9"
                    + "471d~mv2.jpeg/v1/fit/w_1019,h_679,q_88/41dd26_36fb5db3b8514daaae86447a08b9471d~mv2.jpeg");
        }

        JFrame imageFrame = new JFrame("Image Preview");   // create a new JFrame to display the image
        imageFrame.setLayout(new BorderLayout());
        JLabel imageLabel = new JLabel(imageIcon);
        imageFrame.add(imageLabel, BorderLayout.CENTER);

        imageFrame.setSize(500, 400);
        imageFrame.setVisible(true);
    }

    // EFFECTS: puts a url embedded into a ImageIcon
    private ImageIcon changeToImageIcon(String url) {
        URL imageUrl = null;
        try {
            imageUrl = new URL(url);
            return imageIcon = new ImageIcon(imageUrl);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

}

