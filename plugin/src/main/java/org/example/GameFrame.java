package org.example;

import javax.swing.*;
import java.awt.*;

class GameFrame implements FrameInfrastructure {

    JFrame gameFrame = new JFrame("Міста");
    JButton button = new JButton("Зроби хід");
    JLabel inputTex = new JLabel("Введіть назву міста");
    JLabel computerInput = new JLabel("Компютер:");
    JTextField textField = new JTextField(10);
    JPanel panel = new JPanel();

    @Override
    public void frame() {
        gameFrame.setSize(350, 200); //закоментувати якщо використовувати "gameFrame.pack();"
        gameFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JPanel row1 = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        row1.setAlignmentY(Component.TOP_ALIGNMENT);
        row1.add(textField);
        row1.add(inputTex);
        panel.add(row1);

        panel.add(Box.createVerticalStrut(2));

        JPanel row2 = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        row2.setAlignmentY(Component.TOP_ALIGNMENT);
        row2.add(button);
        row2.add(computerInput);
        panel.add(row2);

        gameFrame.add(panel);
        //gameFrame.pack(); // компактний вигляд ігрового вікна
        button();
        gameFrame.setVisible(true);
    }

    @Override
    public void button() {
        button.addActionListener(e -> {
            String userCity = textField.getText().trim();
            String surrender = dto.SURRENDER;

            boolean exist = dto.CITIES.stream()
                    .anyMatch(city -> city.equalsIgnoreCase(userCity));

            if (exist) {
                inputTex.setText(userCity);
            }else if (inputTex.setText(surrender)){

            }
            else {
                inputTex.setText("Такого міста не існуе");
            }
            textField.setText("");
        });
    }
}
