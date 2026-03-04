package org.example.frames;

import org.example.GameEngine;
import org.example.Dto;

import javax.swing.Timer;
import javax.swing.*;
import java.awt.*;

class Game implements FrameInfrastructure {

    GameEngine gameEngine = new GameEngine();
    CompleteGame complete = new CompleteGame();

    JFrame frame = new JFrame("Міста");
    JButton actionButton = new JButton("Зроби хід");
    JLabel inputText = new JLabel("Введіть назву міста");
    JLabel computerInput = new JLabel("Компютер:");
    JTextField textField = new JTextField(10);
    JPanel panel = new JPanel();


    @Override
    public void frame() {
        frame.setSize(400, 500);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JPanel row1 = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        row1.setAlignmentY(Component.TOP_ALIGNMENT);
        row1.add(textField);
        row1.add(inputText);
        panel.add(row1);

        JPanel row2 = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        row2.setAlignmentY(Component.TOP_ALIGNMENT);
        row2.add(actionButton);
        row2.add(computerInput);
        panel.add(row2);

        frame.add(panel);
        button();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @Override
    public void button() {
        actionButton.addActionListener(_ -> {
            String userCity = textField.getText().trim();
            String surrender = Dto.SURRENDER;

            boolean exist = Dto.getCities().stream()
                    .anyMatch(city -> city.equalsIgnoreCase(userCity));

            if (userCity.equalsIgnoreCase(surrender)) {
                inputText.setText("Ти програв");
                autoCloseMechanism();

            } else if (exist) {
                if (gameEngine.isCityAlreadyUsed(userCity)) {
                    inputText.setText("Це місто вже було!");
                } else if (!gameEngine.isValidMove(userCity)) {
                    char expected = Character.toUpperCase(
                            gameEngine.getExpectedLatter()
                    );
                    inputText.setText("Місто має починатися на '" + expected + "'!");
                } else {
                    inputText.setText(userCity);
                    String computerCity = gameEngine.computerMove(userCity);
                    if (computerCity != null) {
                        computerInput.setText("Компютер: " + computerCity);
                    } else {
                        computerInput.setText("Компютер програв! Ви виграли!");
                        autoCloseMechanism();
                    }
                }
            } else {
                inputText.setText("Такого міста не існуе");
            }
            textField.setText("");
        });
    }

    public void autoCloseMechanism() {
        actionButton.setEnabled(false);
        Timer timer = new Timer(2000, _ -> {
            frame.dispose();
            complete.finalScoreFrame(gameEngine.getUserScore(), gameEngine.getComputerScore());
        });
        timer.setRepeats(false);
        timer.start();
    }
}
