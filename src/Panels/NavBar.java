package Panels;

import Frame.MainFrame;

import javax.swing.*;
import java.awt.*;


public class NavBar extends JPanel {
    MainFrame window;
    ColourButton homeButton;

    public NavBar(MainFrame window) {
        this.window = window;
        this.setLayout(new BorderLayout());
        this.setBackground(Color.black);


        try {
            ImageIcon homeIcon = new ImageIcon("resources/img/home.png");
            Image img = homeIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
            homeIcon = new ImageIcon(img);
            homeButton = new ColourButton(homeIcon);
            homeButton.setBorder(BorderFactory.createEmptyBorder(0, 25, 0, 0));
        } catch (Exception e) {
            System.out.println("ERROR: " + e);
            homeButton = new ColourButton(Color.black);
            homeButton.setText("Home");
            homeButton.setForeground(Color.white);
        }

        //back to the menu when button is pressed
        homeButton.addActionListener(e -> window.goToMenu());


        add(homeButton, BorderLayout.WEST);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(60, 60);
    }
}
