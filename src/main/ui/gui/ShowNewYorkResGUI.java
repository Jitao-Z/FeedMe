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

// The NYC restaurant selection GUI
public class ShowNewYorkResGUI extends JFrame implements ActionListener {
    protected JTable table;
    protected JPanel buttonsPanel;
    protected JButton viewPicture;
    protected JButton add;
    protected ImageIcon imageIcon = null;

    // EFFECTS: constructs the NYC restaurant selection GUI
    public ShowNewYorkResGUI() {
        super("New York City");
        setSize(550, 650);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ((JPanel) getContentPane()).setBorder(new EmptyBorder(30, 30, 30, 30));

        constructNewYorkRestTable();
        constructNewYorkButtons();

        setVisible(true);
    }

    // MODIFIES: this
    // EFFECTS: constructs a table listing all the selectable NYC restaurants in it, and
    //          adds it to the NYC restaurant selection GUI
    public void constructNewYorkRestTable() {
        DefaultTableModel newYorkResTable = new DefaultTableModel(
                new Object[][]{{"Boucherie West Village", "$$$"}, {"Olio e Piu", "$$$"},
                        {"K Rico Steakhouse", "$$$$"}, {"Royal 35 Steakhouse", "$$$$"}},
                new Object[]{"Restaurant name", "Price"}
        );
        table = new JTable(newYorkResTable);
        add(new JScrollPane(table), BorderLayout.CENTER);
    }

    // MODIFIES: this
    // EFFECTS: displays all the operating options on the NYC restaurant selection GUI
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

    // EFFECTS: executes corresponding functionality when user selects a row and clicks on a button
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

    // EFFECTS: adds the selected restaurants into the collection
    public void addToCollection(String newYorkResName) {
        if (newYorkResName.equals("Boucherie West Village")) {
            Restaurant nr1 = new Restaurant("Boucherie West Village", "New York City",
                    "Popular dishes: Lobster Bisque, Boeuf Bourguignon, Cupid");
            FeedMeGUI.collection.addRestaurant(nr1);
        } else if (newYorkResName.equals("Olio e Piu")) {
            Restaurant nr2 = new Restaurant("Olio e Piu", "New York City",
                    "Popular dishes: Italian Wedding Soup, Tortellini Di Vitello, Tilefish Arrosto");
            FeedMeGUI.collection.addRestaurant(nr2);
        } else if (newYorkResName.equals("K Rico Steakhouse")) {
            Restaurant nr3 = new Restaurant("K Rico Steakhouse", "New York City",
                    "Popular dishes: Roasted Oysters, Fufu de Chorizo, Ceviche de Corvina");
            FeedMeGUI.collection.addRestaurant(nr3);
        } else if (newYorkResName.equals("Royal 35 Steakhouse")) {
            Restaurant nr4 = new Restaurant("Royal 35 Steakhouse", "New York City",
                    "Popular dishes: Dry Aged Porterhouse, Seafood Tower, Chillean Sea Bass Fish");
            FeedMeGUI.collection.addRestaurant(nr4);
        }

        JOptionPane.showMessageDialog(null, newYorkResName + " is added successfully!",
                "Status", JOptionPane.INFORMATION_MESSAGE);
    }

    // EFFECTS: shows the image of the selected restaurant
    public void showPicture(String newYorkResName) {
        if (newYorkResName.equals("Boucherie West Village")) {
            changeToImageIcon("https://s3-media0.fl.yelpcdn.com/bphoto/zMfL8_qwipObZJp6qMLVGg/l.jpg");
        } else if (newYorkResName.equals("Olio e Piu")) {
            changeToImageIcon("https://media-cdn.tripadvisor.com/media/photo-s/1a/1b/15/3a/olio-e-piu.jpg");
        } else if (newYorkResName.equals("K Rico Steakhouse")) {
            changeToImageIcon("https://dynamic-media-cdn.tripadvisor.com/"
                    + "media/photo-o/16/8f/14/c8/pulpo-a-la-parilla-marinated.jpg?w=800&h=600&s=1");
        } else if (newYorkResName.equals("Royal 35 Steakhouse")) {
            changeToImageIcon("https://s3-media0.fl.yelpcdn.com/bphoto/QzhXzd4vxHMuh2vdM0azpw/348s.jpg");
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
