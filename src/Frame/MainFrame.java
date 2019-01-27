package Frame;

import Panels.ColourPicker;
import Panels.MainMenu;
import Panels.MoreColours;
import Panels.NavBar;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private CardLayout layout;
    private JPanel mainPanel;
    private JPanel navBar;
    private JPanel mainMenu;
    private JPanel colourPicker;
    private JPanel moreColours;
    private JPanel catFacts;

    public MainFrame() {
        setTitle("PiCatLamp");
        setResizable(false);
        setSize(320, 240);
        //this.setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        layout = new CardLayout();
        mainPanel = new JPanel(layout);
        mainMenu = new MainMenu(this);
        colourPicker = new ColourPicker(this);
        navBar = new NavBar(this);
        moreColours = new MoreColours(this);

        mainPanel.add(mainMenu, "menu");
        mainPanel.add(colourPicker, "colour");
        mainPanel.add(moreColours, "selector");

        layout.first(mainPanel);
        add(navBar, BorderLayout.NORTH);
        add(mainPanel, BorderLayout.CENTER);

        pack();
        revalidate();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void goToMenu() {
        layout.show(mainPanel, "menu");
    }

    public void goToColours() {
        layout.show(mainPanel, "colour");
    }

    public void goToSelector() {
        layout.show(mainPanel, "selector");
    }
}
