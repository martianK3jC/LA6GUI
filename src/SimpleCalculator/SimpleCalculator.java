package SimpleCalculator;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCalculator extends JFrame {

    private JTextField tfNumber1;
    private JTextField tfNumber2;
    private JComboBox<String> cbOperations;
    private JButton btnCompute;
    private JLabel lblResult;
    private JLabel lblResultText;
    private JLabel lbl1stNum;
    private JLabel lbl2ndNum;
    public SimpleCalculator() {
        setTitle("Simple Calculator");
        setSize(470, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        tfNumber1 = new JTextField();
        tfNumber1.setBounds(30, 30, 100, 30);
        tfNumber1.setName("tfNumber1");
        add(tfNumber1);

        lbl1stNum = new JLabel("1st Number");
        lbl1stNum.setBounds(45, 5, 100, 30);
        lbl1stNum.setName("lbl1stNum");
        add(lbl1stNum);

        tfNumber2 = new JTextField();
        tfNumber2.setBounds(240, 30, 100, 30);
        tfNumber2.setName("tfNumber2");
        add(tfNumber2);

        lbl2ndNum = new JLabel("2nd Number");
        lbl2ndNum.setBounds(255, 5, 100, 30);
        lbl2ndNum.setName("lbl2ndNum");
        add(lbl2ndNum);

        cbOperations = new JComboBox<>(new String[]{"+", "-", "*", "/"});
        cbOperations.setBounds(145, 30, 80, 30);
        cbOperations.setName("cbOperations");
        add(cbOperations);

        btnCompute = new JButton("Compute Result");
        btnCompute.setBounds(140, 90, 125, 30);
        btnCompute.setName("btnCompute");
        add(btnCompute);

        lblResult = new JLabel();
        lblResult.setBounds(385, 30, 100, 30);
        lblResult.setName("lblResult");
        add(lblResult);

        lblResultText = new JLabel("Result");
        lblResultText.setBounds(370, 5, 100, 30);
        lblResultText.setName("lblResultText");
        add(lblResultText);

        btnCompute.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateResult();
            }
        });
    }

    private void calculateResult() {
            int number1 = Integer.parseInt(tfNumber1.getText().trim());
            int number2 = Integer.parseInt(tfNumber2.getText().trim());
            String operation = (String) cbOperations.getSelectedItem();
            int result = 0;

            switch (operation) {
                case "+":
                    result = number1 + number2;
                    break;
                case "-":
                    result = number1 - number2;
                    break;
                case "*":
                    result = number1 * number2;
                    break;
                case "/":
                    if (number2 != 0) {
                        result = number1 / number2;
                    } else {
                        lblResult.setText("Cannot divide by 0");
                        return;
                    }
                    break;
            }

            lblResult.setText(String.valueOf(result));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SimpleCalculator frame = new SimpleCalculator();
            frame.setVisible(true);
        });
    }
}
