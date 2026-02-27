package org.example.frames;

import javax.swing.*;
import java.awt.*;

public class CompleteGame {
    JFrame frame = new JFrame("Підсумок гри");
    JLabel computerScore = new JLabel();
    JLabel userScore = new JLabel();
    JPanel panel = new JPanel();

    public void finalScoreFrame(int userPoints, int computerPoints) {
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        userScore.setText("Гравець: " + userPoints);
        computerScore.setText("Компютер: " + computerPoints);

        JPanel row1 = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        row1.setAlignmentY(Component.TOP_ALIGNMENT);
        row1.add(userScore);
        panel.add(row1);

        JPanel row2 = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        row2.setAlignmentY(Component.TOP_ALIGNMENT);
        row2.add(computerScore);
        panel.add(row2);

        frame.add(panel);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
