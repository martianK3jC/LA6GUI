package LeapYearChecker;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LeapYearChecker extends JFrame {

    private JTextField yearTextField;
    private JButton checkYearButton;

    public LeapYearChecker() {
        setTitle("Leap Year Checker");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        yearTextField = new JTextField();
        yearTextField.setBounds(50, 20, 200, 30);
        yearTextField.setName("yearTextField");  // Set name for testing purposes
        add(yearTextField);

        checkYearButton = new JButton("Check Year");
        checkYearButton.setBounds(90, 60, 120, 30);
        checkYearButton.setName("checkYearButton");  // Set name for testing purposes
        add(checkYearButton);

        checkYearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkLeapYear();
            }
        });
    }

    private void checkLeapYear() {
        try {
            int year = Integer.parseInt(yearTextField.getText().trim());
            boolean isLeapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);

            String message = isLeapYear ? "Leap year" : "Not a leap year";
            JOptionPane.showMessageDialog(null, message, "Message", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Please enter a valid year.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LeapYearChecker frame = new LeapYearChecker();
            frame.setVisible(true);
        });
    }
}

