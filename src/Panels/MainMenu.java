package Panels;

import Frame.MainFrame;

import javax.swing.*;
import java.awt.*;


class AppButton extends JButton {


    ImageIcon iconA;
    ImageIcon iconB;
    boolean toggle = false;
    int width = 75;
    int height = 75;

    AppButton(String text) {
        super(text);
        customiseButton();
    }

    AppButton(String text, ImageIcon icon) {
        super(text, icon);
        this.iconA = icon;
        customiseButton();
    }

    AppButton(String text, ImageIcon iconA, ImageIcon iconB) {
        super(text, iconA);
        this.iconA = iconA;
        this.iconB = iconB;
        customiseButton();
        addActionListener(e -> toggleIcon());
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.darkGray);
        g2d.fillRoundRect(14, 18, width, height, 20, 20);
        super.paintComponent(g2d);
    }

    private void customiseButton() {
        setHorizontalTextPosition(JButton.CENTER);
        setVerticalTextPosition(JButton.BOTTOM);

        setForeground(Color.white);
        setBackground(Color.darkGray);
        setFocusPainted(false);
        setBorderPainted(false);
        setOpaque(false);
        setContentAreaFilled(false);
        Dimension size = getPreferredSize();
        size.width = size.height = Math.max(size.width, size.height);
        setPreferredSize(size);
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

    }

    void toggleIcon() {
        toggle = !toggle;
        if (toggle) {
            this.setIcon(iconB);
        } else {
            this.setIcon(iconA);
        }
    }

}


public class MainMenu extends JPanel {
    MainFrame window;

    public MainMenu(MainFrame window) {
        this.window = window;
        GridLayout gridLayout = new GridLayout(2, 3);
        gridLayout.setHgap(5);
        gridLayout.setVgap(5);
        this.setLayout(gridLayout);
        this.setBackground(Color.black);

        //create app button
        ImageIcon lampOn = new ImageIcon("resources/img/bulb_on.png");
        ImageIcon lampOff = new ImageIcon("resources/img/bulb_off.png");
        AppButton toggleLight = new AppButton("On/Off", lampOn, lampOff);

        ImageIcon colourIcon = new ImageIcon("resources/img/color.png");
        AppButton two = new AppButton("Colour", colourIcon);
        two.addActionListener(e -> window.goToColours());

        ImageIcon catIcon = new ImageIcon("resources/img/pawprint.png");
        AppButton three = new AppButton("Cat Fact", catIcon);
        AppButton four = new AppButton("...");
        AppButton five = new AppButton("...");
        AppButton six = new AppButton("...");
        add(toggleLight);
        add(two);
        add(three);
        add(four);
        add(five);
        add(six);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(window.getWidth(), window.getHeight());
    }
}
