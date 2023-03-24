package ui.gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CitySelectionGUI extends JFrame implements ActionListener {
    protected JTable table;
    protected JButton proceed;

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

    public void constructCityTable() {
        DefaultTableModel cityTable = new DefaultTableModel(
                new Object[][]{{"Vancouver"}, {"London"}, {"New York City"}},
                new Object[]{"City name"}
        );
        table = new JTable(cityTable);
        add(new JScrollPane(table));
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        int row = table.getSelectedRow();
        String cityName = table.getValueAt(row, 0).toString();

        if (cityName == "Vancouver") {
            new ShowVancouverResGUI();
        } else if (cityName == "London") {
            new ShowLondonResGUI();
        } else if (cityName == "New York City") {
            new ShowNYCResGUI();
        }
    }
}
