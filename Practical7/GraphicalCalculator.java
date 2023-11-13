import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GraphicalCalculator {
    private int status = 0;
    private String storedText = null;
    private float storedValue = 0.0f;
    
    public GraphicalCalculator() {
        JFrame frame = new JFrame("Calculator");
        frame.setLayout(new BorderLayout());

        JTextField textField = new JTextField();
        frame.add(textField, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(5, 4));
        frame.add(buttonPanel, BorderLayout.CENTER);

        String[] buttonLabels = {"7", "8", "9", "Clear", "4", "5", "6", "Add", "1", "2", "3", "Subtract", "0", ".", "=", "Multiply", "Divide", "Result"};
        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            buttonPanel.add(button);
            button.addActionListener(new ButtonClickListener(textField, this));
        }

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new GraphicalCalculator();
        });
    }

    private class ButtonClickListener implements ActionListener {
        private final JTextField textField;
        private final GraphicalCalculator calculator;

        public ButtonClickListener(JTextField textField, GraphicalCalculator calculator) {
            this.textField = textField;
            this.calculator = calculator;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String buttonText = ((JButton) e.getSource()).getText();

            switch (buttonText) {
                case "Clear":
                    textField.setText("");
                    status = 0;
                    storedText = null;
                    return;
                case "Add":
                    storedText = textField.getText();
                    storedValue = parseFloatWithExceptionHandling(storedText);
                    textField.setText("");
                    status = 1;
                    return;
                case "Subtract":
                    storedText = textField.getText();
                    storedValue = parseFloatWithExceptionHandling(storedText);
                    textField.setText("");
                    status = 2;
                    return;
                case "Multiply":
                    storedText = textField.getText();
                    storedValue = parseFloatWithExceptionHandling(storedText);
                    textField.setText("");
                    status = 3;
                    return;
                case "Divide":
                    storedText = textField.getText();
                    storedValue = parseFloatWithExceptionHandling(storedText);
                    textField.setText("");
                    status = 4;
                    return;
                case "Result":
                    if (status == 0) {
                        return;
                    }

                    float firstValue = parseFloatWithExceptionHandling(storedText);
                    float secondValue = parseFloatWithExceptionHandling(textField.getText());

                    if (Float.isNaN(firstValue) || Float.isNaN(secondValue)) {
                        // Handle illegal input
                        handleIllegalInput();
                        return;
                    }

                    float resultValue = 0.0f;

                    if (status == 1) {
                        resultValue = firstValue + secondValue;
                    } 
                    else if (status == 2) {
                        resultValue = firstValue - secondValue;
                    } 
                    else if (status == 3) {
                        resultValue = firstValue * secondValue;
                    } 
                    else if (status == 4) {
                        if (secondValue != 0) {
                            resultValue = firstValue / secondValue;
                        } 
                        else {
                            textField.setText("Error: Division by zero");
                            return;
                        }
                    }

                    textField.setText(String.valueOf(resultValue));
                    status = 0;
                    break;
                default:
                    textField.setText(textField.getText() + buttonText);
            }
        }

        private float parseFloatWithExceptionHandling(String input) {
            try {
                return Float.parseFloat(input);
            } 
            catch (NumberFormatException e) {
                handleIllegalInput();
                return Float.NaN;
            }
        }

        private void handleIllegalInput() {
            JOptionPane.showMessageDialog(null, "Illegal input! Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
            status = 0;
            storedText = null;
            textField.setText("");
        }
    }
}