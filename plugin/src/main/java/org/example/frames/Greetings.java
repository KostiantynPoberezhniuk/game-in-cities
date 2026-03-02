package org.example.frames;

import org.example.frames.FrameInfrastructure;

import javax.swing.*;

public class Greetings implements FrameInfrastructure {
    Game gameFrame = new Game();
    JFrame frame = new JFrame("Вітаємо");
    JButton okButton = new JButton("Ok");
    JLabel text = new JLabel("Вітаємо Вас у грі дитинства і всіх розумників!");
    JPanel panel = new JPanel();

    @Override
    public void frame() {
        frame.setSize(400, 100);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        panel.add(text);
        button();

        frame.add(panel);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @Override
    public void button() {
        panel.add(okButton);
        okButton.addActionListener(_ -> {
            gameFrame.frame();
            frame.dispose();
        });
    }
}
