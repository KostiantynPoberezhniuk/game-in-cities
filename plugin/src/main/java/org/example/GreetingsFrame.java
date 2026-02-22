package org.example;


import javax.swing.*;

public class GreetingsFrame implements FrameInfrastructure {
    GameFrame gameFrame = new GameFrame();
    JFrame greetingsFrame = new JFrame("Вітаємо");
    JButton okButton = new JButton("Ok");
    JLabel text = new JLabel("Вітаємо Вас у грі дитинства і всіх розумників!");
    JPanel panel = new JPanel();

    @Override
    public void frame() {
        greetingsFrame.setSize(400, 100);
        greetingsFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        panel.add(text);
        button();

        greetingsFrame.add(panel);

        greetingsFrame.setVisible(true);
    }

    @Override
    public void button() {
        panel.add(okButton);
        okButton.addActionListener(e -> {
            gameFrame.frame();
            greetingsFrame.dispose();
        });
    }
}
