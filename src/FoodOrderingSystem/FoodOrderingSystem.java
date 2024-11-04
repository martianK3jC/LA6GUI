package FoodOrderingSystem;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class FoodOrderingSystem extends JFrame {
    private final double PIZZA_PRICE = 100.0;
    private final double BURGER_PRICE = 80.0;
    private final double FRIES_PRICE = 65.0;
    private final double SOFT_DRINKS_PRICE = 55.0;
    private final double TEA_PRICE = 50.0;
    private final double SUNDAE_PRICE = 40.0;

    private JCheckBox cPizza, cBurger, cFries, cSoftDrinks, cTea, cSundae;
    private JRadioButton rb5, rb10, rb15, rbNone;
    private JButton btnOrder;
    private ButtonGroup discountGroup;
    private DecimalFormat df = new DecimalFormat("0.00");

    public FoodOrderingSystem() {
        setTitle("Food Ordering System");
        setSize(380, 320);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel(new GridLayout(1, 2));

        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 0));

        JPanel foodPanel = new JPanel(new BorderLayout());
        JLabel foodLabel = new JLabel("Foods", JLabel.CENTER); // Add centered title as JLabel
        foodLabel.setFont(new Font("Arial", Font.BOLD, 14)); // Set font style and size
        foodPanel.add(foodLabel, BorderLayout.NORTH);

        JPanel foodItemsPanel = new JPanel(new GridLayout(6, 1));
        foodItemsPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        cPizza = new JCheckBox("Pizza              Php " + PIZZA_PRICE);
        JPanel pizzaPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pizzaPanel.add(cPizza);

        cBurger = new JCheckBox("Burger           Php " + BURGER_PRICE);
        JPanel burgerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        burgerPanel.add(cBurger);

        cFries = new JCheckBox("Fries              Php " + FRIES_PRICE);
        JPanel friesPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        friesPanel.add(cFries);

        cSoftDrinks = new JCheckBox("Soft Drinks   Php " + SOFT_DRINKS_PRICE);
        JPanel softDrinksPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        softDrinksPanel.add(cSoftDrinks);

        cTea = new JCheckBox("Tea                Php " + TEA_PRICE);
        JPanel teaPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        teaPanel.add(cTea);

        cSundae = new JCheckBox("Sundae         Php " + SUNDAE_PRICE);
        JPanel sundaePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        sundaePanel.add(cSundae);

        foodItemsPanel.add(pizzaPanel);
        foodItemsPanel.add(burgerPanel);
        foodItemsPanel.add(friesPanel);
        foodItemsPanel.add(softDrinksPanel);
        foodItemsPanel.add(teaPanel);
        foodItemsPanel.add(sundaePanel);

        foodPanel.add(foodItemsPanel, BorderLayout.CENTER);

        JPanel discountPanel = new JPanel(new BorderLayout());
        JLabel discountLabel = new JLabel("Discounts", JLabel.LEFT); // Add centered title as JLabel
        discountLabel.setFont(new Font("Arial", Font.BOLD, 14)); // Set font style and size
        discountPanel.add(discountLabel, BorderLayout.NORTH);

        JPanel discountOptionsPanel = new JPanel(new GridLayout(4, 1));
        discountOptionsPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        rbNone = new JRadioButton("None", true);
        JPanel rbNonePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        rbNonePanel.add(rbNone);

        rb5 = new JRadioButton("5% off");
        JPanel rb5Panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        rb5Panel.add(rb5);

        rb10 = new JRadioButton("10% off");
        JPanel rb10Panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        rb10Panel.add(rb10);

        rb15 = new JRadioButton("15% off");
        JPanel rb15Panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        rb15Panel.add(rb15);

        discountGroup = new ButtonGroup();
        discountGroup.add(rbNone);
        discountGroup.add(rb5);
        discountGroup.add(rb10);
        discountGroup.add(rb15);


        discountOptionsPanel.add(rb5Panel);
        discountOptionsPanel.add(rb10Panel);
        discountOptionsPanel.add(rb15Panel);
        discountOptionsPanel.add(rbNonePanel);

        discountPanel.add(discountOptionsPanel, BorderLayout.CENTER);

        mainPanel.add(foodPanel);
        mainPanel.add(discountPanel);

        btnOrder = new JButton("Order");
        btnOrder.setPreferredSize(new Dimension(100, 30));
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(btnOrder);
        btnOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateTotal();
            }
        });

        add(mainPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void calculateTotal() {
        double total = 0.0;

        if (cPizza.isSelected()) total += PIZZA_PRICE;
        if (cBurger.isSelected()) total += BURGER_PRICE;
        if (cFries.isSelected()) total += FRIES_PRICE;
        if (cSoftDrinks.isSelected()) total += SOFT_DRINKS_PRICE;
        if (cTea.isSelected()) total += TEA_PRICE;
        if (cSundae.isSelected()) total += SUNDAE_PRICE;

        double discount = 0.0;
        if (rb5.isSelected()) discount = 0.05;
        else if (rb10.isSelected()) discount = 0.10;
        else if (rb15.isSelected()) discount = 0.15;

        double discountedTotal = total - (total * discount);

        JOptionPane.showMessageDialog(this, "The total price is Php " + df.format(discountedTotal),
                "Total Price", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FoodOrderingSystem app = new FoodOrderingSystem();
            app.setVisible(true);
        });
    }
}