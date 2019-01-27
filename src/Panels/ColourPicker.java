package Panels;

import Frame.MainFrame;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

/*
Custom button class
 */
class ColourButton extends JButton {

    private Color pressedBackgroundColor;

    //constructor for image buttons
    ColourButton(ImageIcon icon) {
        super(icon);
        setBackground(Color.BLACK);
        setFocusPainted(false);
        setBorderPainted(false);
        setOpaque(true);
        setContentAreaFilled(false);
    }

    ColourButton(Color color) {
        this.setBackground(color);
        this.pressedBackgroundColor = color.darker().darker();
        setFocusPainted(false);
        setBorderPainted(false);
        setContentAreaFilled(false);
        setOpaque(true);

        //bg change on click
        this.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent evt) {
                if (getModel().isPressed()) {
                    setBackground(pressedBackgroundColor);
                } else {
                    setBackground(color);
                }
            }
        });
    }
}


/*
ColourPicker page. Used to pick the colour of the lamp.
 */
public class ColourPicker extends JPanel {
    private MainFrame window;
    private JPanel top;
    private JPanel bottom;

    public ColourPicker(MainFrame window) {
        this.window = window;
        this.setLayout(new GridLayout(2, 1));
        this.setBackground(Color.black);

        top = new JPanel();
        top.setBackground(Color.BLACK);
        top.setOpaque(true);
        top.setLayout(new GridLayout());
        bottom = new JPanel();
        bottom.setOpaque(true);
        bottom.setBackground(Color.BLACK);
        bottom.setLayout(new GridLayout());

        ColourButton blueButton = new ColourButton(Color.blue);
        ColourButton redButton = new ColourButton(Color.red);
        ColourButton whiteButton = new ColourButton(Color.white);

        ColourButton greenButton = new ColourButton(Color.green);
        ColourButton purpleButton = new ColourButton(new Color(106, 90, 205));

        //icon by Google from www.flaticon.com
        ImageIcon moreIcon = new ImageIcon("resources/img/more.png");
        ColourButton moreButton = new ColourButton(moreIcon);
        moreButton.addActionListener(e -> window.goToSelector());


        top.add(blueButton);
        top.add(redButton);
        top.add(whiteButton);
        bottom.add(greenButton);
        bottom.add(purpleButton);
        bottom.add(moreButton);

        this.add(top);
        this.add(bottom);


    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(window.getWidth(), window.getHeight());
    }
}
