package ui.gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// The city selection GUI
public class CitySelectionGUI extends JFrame implements ActionListener {
    protected JTable table;
    protected JButton proceed;

    // EFFECTS: constructs the city selection GUI
    public CitySelectionGUI() {
        super("City");
        setSize(550, 650);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        ((JPanel) getContentPane()).setBorder(new EmptyBorder(30, 30, 30, 30));

        constructCityTable();

        proceed = new JButton("Proceed");
        proceed.addActionListener(this);
        add(proceed, "South");

        setVisible(true);
    }

    // MODIFIES: this
    // EFFECTS: constructs a table listing all selectable cities, and
    //          adds it to the city selection GUI
    public void constructCityTable() {
        DefaultTableModel cityTable = new DefaultTableModel(
                new Object[][]{{"Vancouver"}, {"London"}, {"New York City"}},
                new Object[]{"City name"}
        );
        table = new JTable(cityTable);
        add(new JScrollPane(table));
    }


    // EFFECTS: executes corresponding functionality when user selects a row and clicks on a button
    @Override
    public void actionPerformed(ActionEvent e) {
        int row = table.getSelectedRow();
        String cityName = table.getValueAt(row, 0).toString();

        if (cityName.equals("Vancouver")) {
            new ShowVancouverResGUI();
        } else if (cityName.equals("London")) {
            new ShowLondonResGUI();
        } else if (cityName.equals("New York City")) {
            new ShowNewYorkResGUI();
        }
    }
}
