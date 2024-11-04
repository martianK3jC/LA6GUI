package MostFrequentChar;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.util.HashMap;

public class MostFrequentChar extends JFrame {
    private JTextArea textArea;
    private JLabel frequentCharLabel;

    public MostFrequentChar() {
        setTitle("Most Frequent Char");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel typeTextHereLabel = new JLabel("Type text here");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.WEST;
        add(typeTextHereLabel, gbc);

        textArea = new JTextArea(5, 20);
        textArea.setName("textArea");
        JScrollPane scrollPane = new JScrollPane(textArea);
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.BOTH;
        add(scrollPane, gbc);

        frequentCharLabel = new JLabel("The most frequent character is: ");
        frequentCharLabel.setName("frequentCharLabel");
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        add(frequentCharLabel, gbc);

        textArea.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateMostFrequentCharacter();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateMostFrequentCharacter();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateMostFrequentCharacter();
            }
        });

        setSize(300, 250);
        setVisible(true);
    }

    private void updateMostFrequentCharacter() {
        String text = textArea.getText().toLowerCase();
        HashMap<Character, Integer> frequencyMap = new HashMap<>();
        char mostFrequentChar = ' ';
        int maxCount = 0;

        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
                int currentCount = frequencyMap.get(c);
                if (currentCount > maxCount) {
                    maxCount = currentCount;
                    mostFrequentChar = c;
                }
            }
        }

        if (mostFrequentChar != ' ') {
            frequentCharLabel.setText("The most frequent character is: " + mostFrequentChar);
        } else {
            frequentCharLabel.setText("The most frequent character is: ");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MostFrequentChar());
    }
}
