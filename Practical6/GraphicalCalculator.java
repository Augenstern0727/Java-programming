import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GraphicalCalculator {
    private JTextField textField;

    public GraphicalCalculator() {
        JFrame frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(7, 1));

        textField = new JTextField();
        frame.add(textField);

        String[] buttonLabels = {"Clear", "Add", "Subtract", "Multiply", "Divide", "Result"};
        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.addActionListener(new ButtonClickListener());
            frame.add(button);
        }

        frame.pack();
        frame.setVisible(true);
    }

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            switch (command) {
                case "Clear":
                    textField.setText("");
                    break;
                case "Add":
                    // Handle addition logic
                    break;
                case "Subtract":
                    // Handle subtraction logic
                    break;
                case "Multiply":
                    // Handle multiplication logic
                    break;
                case "Divide":
                    // Handle division logic
                    break;
                case "Result":
                    // Handle calculation result logic
                    break;
            }
        }
    }

    public static void main(String[] args) {
        new GraphicalCalculator();
    }
}
