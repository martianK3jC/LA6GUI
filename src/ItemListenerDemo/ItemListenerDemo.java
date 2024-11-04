package ItemListenerDemo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ItemListenerDemo extends JFrame {
    private JCheckBox cCheckBox, cppCheckBox, csharpCheckBox, javaCheckBox, pythonCheckBox;
    private JComboBox<String> proficiencyComboBox;
    private JLabel languageLabel, proficiencyLabel;

    public ItemListenerDemo() {
        setTitle("Item Listener");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);  // Padding between components

        // Language label
        JLabel lblLanguage = new JLabel("Languages");
        lblLanguage.setName("lblLanguage");

        // Positioning the label in the layout (above checkboxes)
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        add(lblLanguage, gbc);  // Adding the label at the top

        // Language checkboxes
        cCheckBox = new JCheckBox("C");
        cppCheckBox = new JCheckBox("C++");
        csharpCheckBox = new JCheckBox("C#");
        javaCheckBox = new JCheckBox("Java");
        pythonCheckBox = new JCheckBox("Python");

        // Set names (as per instructions)
        cCheckBox.setName("cCheckBox");
        cppCheckBox.setName("cppCheckBox");
        csharpCheckBox.setName("csharpCheckBox");
        javaCheckBox.setName("javaCheckBox");
        pythonCheckBox.setName("pythonCheckBox");

        // Proficiency combo box
        String[] proficiencyLevels = { "Low", "Medium", "High" };
        proficiencyComboBox = new JComboBox<>(proficiencyLevels);
        proficiencyComboBox.setName("proficiencyComboBox");

        // Labels to display selected values
        languageLabel = new JLabel("My Favorite Languages: ");
        proficiencyLabel = new JLabel("Proficiency: ");

        // Panel for checkboxes (left side of GUI)
        JPanel languagePanel = new JPanel();
        languagePanel.setLayout(new BoxLayout(languagePanel, BoxLayout.Y_AXIS));  // Vertically aligned
        languagePanel.add(cCheckBox);
        languagePanel.add(cppCheckBox);
        languagePanel.add(csharpCheckBox);
        languagePanel.add(javaCheckBox);
        languagePanel.add(pythonCheckBox);

        // Positioning the language panel in the layout (below label)
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(languagePanel, gbc);

        // Proficiency label
        gbc.gridy = 2;
        add(new JLabel("Proficiency"), gbc);

        // Proficiency combo box
        gbc.gridx = 1;
        add(proficiencyComboBox, gbc);

        // Language and proficiency display (at the bottom)
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.WEST;
        add(languageLabel, gbc);

        gbc.gridy = 4;
        add(proficiencyLabel, gbc);

        // Set up item listeners
        ItemListener itemListener = new ItemChangeListener();
        cCheckBox.addItemListener(itemListener);
        cppCheckBox.addItemListener(itemListener);
        csharpCheckBox.addItemListener(itemListener);
        javaCheckBox.addItemListener(itemListener);
        pythonCheckBox.addItemListener(itemListener);
        proficiencyComboBox.addItemListener(itemListener);

        setSize(400, 300);
        setVisible(true);
    }

    private class ItemChangeListener implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent e) {
            // Update the language label
            StringBuilder selectedLanguages = new StringBuilder();
            if (cCheckBox.isSelected()) selectedLanguages.append("C, ");
            if (cppCheckBox.isSelected()) selectedLanguages.append("C++, ");
            if (csharpCheckBox.isSelected()) selectedLanguages.append("C#, ");
            if (javaCheckBox.isSelected()) selectedLanguages.append("Java, ");
            if (pythonCheckBox.isSelected()) selectedLanguages.append("Python, ");

            if (selectedLanguages.length() > 0) {
                selectedLanguages.setLength(selectedLanguages.length() - 2); // Remove last comma and space
            }

            languageLabel.setText("My Favorite Languages: " + selectedLanguages);

            // Update the proficiency label
            proficiencyLabel.setText("Proficiency: " + proficiencyComboBox.getSelectedItem());
        }
    }

    public static void main(String[] args) {
        // Run the GUI application
        SwingUtilities.invokeLater(() -> new ItemListenerDemo());
    }
}
