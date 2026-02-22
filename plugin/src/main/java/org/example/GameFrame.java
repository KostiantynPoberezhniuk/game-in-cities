package org.example;

import javax.swing.*;

public class GameFrame implements FrameInfrastructure {

    JFrame gameFrame = new JFrame("Міста");
    JPanel panel = new JPanel();

    @Override
    public void frame() {
        gameFrame.setSize(400, 500);
        gameFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        gameFrame.setVisible(true);
    }

    @Override
    public void button() {

    }
}
