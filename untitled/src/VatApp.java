import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VatApp {

    private JTextField productPriceField;
    private JLabel vatNumberLabel;
    private JTextField vatNumberField;
    private JButton calculateButton;
    private JLabel resultLabel;

    public VatApp() {
        JFrame mainFrame = new JFrame("VAT Calculator");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(new FlowLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        productPriceField = new JTextField();
        panel.add(new JLabel("Product Price:"));
        panel.add(productPriceField);

        vatNumberLabel = new JLabel("VAT Number:");
        panel.add(vatNumberLabel);
        vatNumberField = new JTextField();
        panel.add(vatNumberField);

        calculateButton = new JButton("Calculate VAT");
        panel.add(calculateButton);

        resultLabel = new JLabel();
        panel.add(resultLabel);

        panel.setBackground(Color.gray);

        mainFrame.add(panel);

        mainFrame.pack();
        mainFrame.setVisible(true);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateVAT();
            }
        });
    }

    private void calculateVAT() {
        try {
            double productPrice = Double.parseDouble(productPriceField.getText());
            double vatRate = Double.parseDouble(vatNumberField.getText());
            Fun fun = new Fun();
            double vatAmount = fun.VatPriceFuncton(productPrice, vatRate);
            resultLabel.setText("VAT Amount: " + String.format("%.2f", vatAmount));
        } catch (NumberFormatException ex) {
            resultLabel.setText("Invalid input. Please enter valid numbers.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new VatApp();
        });
    }
}


