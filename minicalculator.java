import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class minicalculator extends JFrame implements ActionListener {

    JTextField t1, t2, result;
    JButton add, sub, mul, div, clear, exit;

    minicalculator() {
        setTitle("minicalculator 😎");
        setSize(350, 300);
        setLayout(new FlowLayout());

        t1 = new JTextField(10);
        t2 = new JTextField(10);
        result = new JTextField(20);
        result.setEditable(false);

        add = new JButton("+");
        sub = new JButton("-");
        mul = new JButton("*");
        div = new JButton("/");
        clear = new JButton("Clear");
        exit = new JButton("Exit");

        add(new JLabel("Enter Number 1:"));
        add(t1);
        add(new JLabel("Enter Number 2:"));
        add(t2);

        add(add);
        add(sub);
        add(mul);
        add(div);

        add(clear);
        add(exit);

        add(new JLabel("Result:"));
        add(result);

        // Action listeners
        add.addActionListener(this);
        sub.addActionListener(this);
        mul.addActionListener(this);
        div.addActionListener(this);
        clear.addActionListener(this);
        exit.addActionListener(this);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == clear) {
                t1.setText("");
                t2.setText("");
                result.setText("");
                return;
            }

            if (e.getSource() == exit) {
                System.exit(0);
            }

            double a = Double.parseDouble(t1.getText());
            double b = Double.parseDouble(t2.getText());
            double res = 0;

            if (e.getSource() == add)
                res = a + b;
            else if (e.getSource() == sub)
                res = a - b;
            else if (e.getSource() == mul)
                res = a * b;
            else if (e.getSource() == div) {
                if (b == 0) {
                    result.setText("Cannot divide by zero ❌");
                    return;
                }
                res = a / b;
            }

            result.setText("Result: " + res);

        } catch (NumberFormatException ex) {
            result.setText("Invalid Input ❌");
        }
    }

    public static void main(String[] args) {
        new minicalculator();
    }
}
