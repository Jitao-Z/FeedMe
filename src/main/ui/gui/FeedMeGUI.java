package ui.gui;

import model.Collection;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FeedMeGUI extends JFrame implements ActionListener {
    protected JPanel panel;
    protected JButton chooseRes;
    protected JButton viewCollection;
    protected JButton load;
    protected JButton save;
    protected static Collection collection;


    public FeedMeGUI() {
        super("FeedMe");
        setSize(550, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        ((JPanel) getContentPane()).setBorder(new EmptyBorder(13, 13, 13, 13));

        panel = new JPanel();
        panel.setLocation(250, 10);
        panel.setSize(200, 100);
        panel.setLayout(new GridLayout(0, 1));
//        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        add(panel);

        SetAllOptions();

        collection = new Collection();

        //add cover image
        ImageIcon imageIcon = new ImageIcon("images/foodicon.jpeg");
        JLabel imageLabel = new JLabel(imageIcon);
//        imageLabel.setPreferredSize(new Dimension(50, 50));
        panel.add(imageLabel);


        setVisible(true);
        setResizable(true);
    }


    public void SetAllOptions() {
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

    //TODO: a lot to do here
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == chooseRes) {
            new CitySelectionGUI();
        } else if (e.getSource() == viewCollection) {
            new CollectionGUI();
        } else if (e.getSource() == load) {
            System.out.println("what is up");
        } else if (e.getSource() == save) {
            System.out.println("now what?");
        }
    }
}
