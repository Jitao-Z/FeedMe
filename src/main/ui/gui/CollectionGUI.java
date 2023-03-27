package ui.gui;

import model.Restaurant;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// The collection GUI
public class CollectionGUI extends JFrame implements ActionListener {
    protected DefaultTableModel collectionTableModel;
    protected JTable table;
    protected JPanel buttonsPanel;
    protected JButton detail;
    protected JButton delete;


    // EFFECTS: constructs the collection GUI
    public CollectionGUI() {
        super("My Collection");
        setSize(550, 650);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        ((JPanel) getContentPane()).setBorder(new EmptyBorder(30, 30, 30, 30));

        constructCollectionTale();
        constructCollectionButtons();

        setVisible(true);
    }

    // MODIFIES: this
    // EFFECTS: creates a table for collection, and adds that table to the collection GUI
    public void constructCollectionTale() {
        String[] columnNames = {"Restaurant name", "City"};
        collectionTableModel = new DefaultTableModel(columnNames, 0);
        for (Restaurant res : FeedMeGUI.collection.getListRestaurant()) {
            String[] rowData = {res.getName(), res.getLocation()};
            collectionTableModel.addRow(rowData);
        }
        table = new JTable(collectionTableModel);
        add(new JScrollPane(table), BorderLayout.CENTER);
    }

    // MODIFIES: this
    // EFFECTS： displays all the operating options on the collection GUI
    public void constructCollectionButtons() {
        buttonsPanel = new JPanel(new GridLayout(2, 1));

        detail = new JButton("View more details");
        detail.addActionListener(this);
        buttonsPanel.add(detail);

        delete = new JButton("Delete");
        delete.addActionListener(this);
        buttonsPanel.add(delete);

        add(buttonsPanel, BorderLayout.EAST);
    }


    // EFFECTS: executes corresponding functionality when user selects a row and clicks on a button
    @Override
    public void actionPerformed(ActionEvent e) {
        int row = table.getSelectedRow();

        if (e.getSource() == detail) {
            showMoreDetails(row);
        } else if (e.getSource() == delete) {
            deleteRestaurant(row);
        }
    }

    // MODIFIES: this
    // EFFECTS: removes a restaurant from both the collection and the collection GUI
    public void deleteRestaurant(int row) {
        collectionTableModel.removeRow(row);
        JOptionPane.showMessageDialog(null,
                FeedMeGUI.collection.getListRestaurant().get(row).getName()
                        + " has been removed from your collection!", "Status", JOptionPane.INFORMATION_MESSAGE);
        FeedMeGUI.collection.getListRestaurant().remove(row);
    }

    // EFFECTS: shows more information of the selected restaurant
    public void showMoreDetails(int row) {
        JFrame myFrame = new JFrame("Detail");
        myFrame.setSize(510, 280);
        myFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        myFrame.setLocationRelativeTo(null);

        JLabel label = new JLabel(FeedMeGUI.collection.getListRestaurant().get(row).getInformation());
        myFrame.add(BorderLayout.NORTH, label);

        myFrame.setVisible(true);
    }


}
