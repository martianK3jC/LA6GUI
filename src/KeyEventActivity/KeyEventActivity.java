package KeyEventActivity;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyEventActivity extends JFrame {

    private JTextArea editableTextArea;
    private JTextArea nonEditableTextArea;

    public KeyEventActivity() {
        setTitle("Key Event Class");
        setSize(600, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel textPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        textPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        JPanel editablePanel = new JPanel(new BorderLayout());
        editablePanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        JLabel editableLabel = new JLabel("Editable", SwingConstants.CENTER);
        editableLabel.setForeground(Color.BLACK);
        editableTextArea = new JTextArea();
        editableTextArea.setName("editableTextArea");
        editableTextArea.setEnabled(true);
        editableTextArea.setForeground(Color.BLACK);
        editablePanel.add(editableLabel, BorderLayout.NORTH);
        editablePanel.add(new JScrollPane(editableTextArea), BorderLayout.CENTER);

        JPanel nonEditablePanel = new JPanel(new BorderLayout());
        nonEditablePanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        JLabel nonEditableLabel = new JLabel("Non-Editable", SwingConstants.CENTER);
        nonEditableLabel.setForeground(Color.BLACK);
        nonEditableTextArea = new JTextArea();
        nonEditableTextArea.setName("nonEditableTextArea");
        nonEditableTextArea.setEnabled(false);
        nonEditableTextArea.setForeground(Color.BLACK);
        nonEditablePanel.add(nonEditableLabel, BorderLayout.NORTH);
        nonEditablePanel.add(new JScrollPane(nonEditableTextArea), BorderLayout.CENTER);

        textPanel.add(editablePanel);
        textPanel.add(nonEditablePanel);

        add(textPanel, BorderLayout.CENTER);

        editableTextArea.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String inputText = editableTextArea.getText();
                StringBuilder modifiedText = new StringBuilder();
                for (char c : inputText.toCharArray()) {
                    if ("aeiouAEIOU".indexOf(c) >= 0) {
                        modifiedText.append(Character.toUpperCase(c));
                    } else {
                        modifiedText.append(c);
                    }
                }
                nonEditableTextArea.setText(modifiedText.toString());
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(KeyEventActivity::new);
    }
}
