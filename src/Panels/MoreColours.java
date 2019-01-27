package Panels;

import Frame.MainFrame;

import javax.swing.*;
import javax.swing.colorchooser.AbstractColorChooserPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;


/*
Used to pick a specific colour.
 */
public class MoreColours extends JPanel {
    MainFrame window;
    JColorChooser chooser;

    public MoreColours(MainFrame window) {
        this.window = window;
        this.setLayout(new BorderLayout());
        setBackground(Color.BLACK);
        JButton setButton = new JButton("SET");
        setButton.setBackground(Color.BLACK);
        setButton.setFocusPainted(false);
        setButton.setBorderPainted(false);
        setButton.setOpaque(true);
        setButton.setContentAreaFilled(false);

        UIManager.put("Panel.background", new ColorUIResource(0, 0, 0));
        chooser = new JColorChooser();
        chooser.setPreviewPanel(new JPanel());
        chooser.remove(0);
        chooser.getPreviewPanel().setBackground(Color.BLACK);

        AbstractColorChooserPanel[] panels = chooser.getChooserPanels();
        for (AbstractColorChooserPanel accp : panels) {
            if (!accp.getDisplayName().equals("HSV")) {
                chooser.removeChooserPanel(accp);
            } else {
                accp.setBackground(Color.BLACK);
            }
        }
        chooser.getSelectionModel().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                Color newColor = chooser.getColor();
                setButton.setBackground(newColor);
            }
        });

        this.add(chooser, BorderLayout.WEST);
        this.add(setButton, BorderLayout.EAST);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(window.getWidth(), window.getHeight());
    }
}
