import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Calculator implements ActionListener {
    boolean isOperatorClicked = false;
    int operator = 0;
    float oldValueF, newValueF, result;
    String oldValue, newValue;
    JFrame jf;
    JLabel displayLabel;
    JButton sevenButton, eightButton, nineButton, fourButton, fiveButton, sixButton, oneButton;
    JButton twoButton, threeButton, zeroButton, dotButton, clearButton, backButton;
    JButton divButton, multiButton, addButton, subButton, equaltoButton;

    // Setting up the frame for the calculator
    public Calculator() {
        jf = new JFrame("Calculator");
        jf.setLayout(null);
        jf.setSize(400, 630);
        // Visibility will be false by default
        jf.setLocation(450, 80);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.getContentPane().setBackground(Color.BLACK);

        // Displaying the label field for in the calculator
        displayLabel = new JLabel();
        displayLabel.setBounds(25, 20, 340, 40);
        displayLabel.setBackground(Color.WHITE);
        // Have set opaque to true in order for the label to be visible
        displayLabel.setOpaque(true);
        // Rounding the corners for the JLabel
        // displayLabel.setBorder(new RoundedBorder(Color.black, 10));
        displayLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        displayLabel.setForeground(Color.black);
        // Adding padding to the displayText
        displayLabel.setBorder(new EmptyBorder(0, 10, 0, 10));// top,left,bottom,right
        // Correcting the fontSize of the displayText
        displayLabel.setFont(new Font("Calibri", Font.BOLD, 20));
        // Label should be added into the JFrame
        jf.add(displayLabel);

        // Displaying button in the frame
        // Clear Button
        clearButton = new JButton("C");
        clearButton.setBounds(25, 90, 60, 60);
        clearButton.setFont(new Font("Arial", Font.BOLD, 25));
        clearButton.addActionListener(this);
        clearButton.setBackground(Color.red);
        jf.add(clearButton);
        // Backspace button
        backButton = new JButton("\u2190");
        backButton.setBounds(110, 90, 60, 60);
        backButton.setFont(new Font("Arial", Font.BOLD, 25));
        backButton.addActionListener(this);
        backButton.setBackground(Color.gray);
        backButton.setForeground(Color.white);
        jf.add(backButton);
        // Button 7
        sevenButton = new JButton("7");
        sevenButton.setBounds(25, 190, 60, 60);
        sevenButton.setFont(new Font("Arial", Font.PLAIN, 25));
        sevenButton.addActionListener(this);
        jf.add(sevenButton);
        // Button 8
        eightButton = new JButton("8");
        eightButton.setBounds(110, 190, 60, 60);
        eightButton.setFont(new Font("Arial", Font.PLAIN, 25));
        eightButton.addActionListener(this);
        jf.add(eightButton);
        // Button 9
        nineButton = new JButton("9");
        nineButton.setBounds(195, 190, 60, 60);
        nineButton.setFont(new Font("Arial", Font.PLAIN, 25));
        nineButton.addActionListener(this);
        jf.add(nineButton);
        // Button division
        divButton = new JButton("/");
        divButton.setBounds(280, 190, 60, 60);
        divButton.setFont(new Font("Arial", Font.PLAIN, 25));
        divButton.addActionListener(this);
        jf.add(divButton);
        // Button 4
        fourButton = new JButton("4");
        fourButton.setBounds(25, 290, 60, 60);
        fourButton.setFont(new Font("Arial", Font.PLAIN, 25));
        fourButton.addActionListener(this);
        jf.add(fourButton);
        // Button 5
        fiveButton = new JButton("5");
        fiveButton.setBounds(110, 290, 60, 60);
        fiveButton.setFont(new Font("Arial", Font.PLAIN, 25));
        fiveButton.addActionListener(this);
        jf.add(fiveButton);
        // Button 6
        sixButton = new JButton("6");
        sixButton.setBounds(195, 290, 60, 60);
        sixButton.setFont(new Font("Arial", Font.PLAIN, 25));
        sixButton.addActionListener(this);
        jf.add(sixButton);
        // Button multiplication
        multiButton = new JButton("x");
        multiButton.setBounds(280, 290, 60, 60);
        multiButton.setFont(new Font("Arial", Font.PLAIN, 25));
        multiButton.addActionListener(this);
        jf.add(multiButton);
        // Button 1
        oneButton = new JButton("1");
        oneButton.setBounds(25, 390, 60, 60);
        oneButton.setFont(new Font("Arial", Font.PLAIN, 25));
        oneButton.addActionListener(this);
        jf.add(oneButton);
        // Button 2
        twoButton = new JButton("2");
        twoButton.setBounds(110, 390, 60, 60);
        twoButton.setFont(new Font("Arial", Font.PLAIN, 25));
        twoButton.addActionListener(this);
        jf.add(twoButton);
        // Button 3
        threeButton = new JButton("3");
        threeButton.setBounds(195, 390, 60, 60);
        threeButton.setFont(new Font("Arial", Font.PLAIN, 25));
        threeButton.addActionListener(this);
        jf.add(threeButton);
        // Button addition
        addButton = new JButton("+");
        addButton.setBounds(280, 390, 60, 60);
        addButton.setFont(new Font("Arial", Font.PLAIN, 25));
        addButton.addActionListener(this);
        jf.add(addButton);
        // Button dot
        dotButton = new JButton(".");
        dotButton.setBounds(25, 490, 60, 60);
        dotButton.setFont(new Font("Arial", Font.PLAIN, 25));
        dotButton.addActionListener(this);
        jf.add(dotButton);
        // Button zero
        zeroButton = new JButton("0");
        zeroButton.setBounds(110, 490, 60, 60);
        zeroButton.setFont(new Font("Arial", Font.PLAIN, 25));
        zeroButton.addActionListener(this);
        jf.add(zeroButton);
        // Button equalto
        equaltoButton = new JButton("=");
        equaltoButton.setBounds(195, 490, 60, 60);
        equaltoButton.setFont(new Font("Arial", Font.PLAIN, 25));
        equaltoButton.addActionListener(this);
        jf.add(equaltoButton);
        // Button subtraction
        subButton = new JButton("-");
        subButton.setBounds(280, 490, 60, 60);
        subButton.setFont(new Font("Arial", Font.PLAIN, 25));
        subButton.addActionListener(this);
        jf.add(subButton);

    }

    public static void main(String args[]) {
        new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == sevenButton) {
            if (isOperatorClicked == true) {
                displayLabel.setText("7");
                isOperatorClicked = false;
            } else if (displayLabel.getText().equals(Float.toString(result))
                    || displayLabel.getText().equals("Division not possible")) {
                displayLabel.setText("7");
            } else {
                displayLabel.setText(displayLabel.getText() + "7");
            }

        } else if (e.getSource() == eightButton) {
            if (isOperatorClicked) {
                displayLabel.setText("8");
                isOperatorClicked = false;
            } else if (displayLabel.getText().equals(Float.toString(result))
                    || displayLabel.getText().equals("Division not possible")) {
                displayLabel.setText("8");
            } else {
            }
            displayLabel.setText(displayLabel.getText() + "8");
        } else if (e.getSource() == nineButton) {
            if (isOperatorClicked == true) {
                displayLabel.setText("9");
                isOperatorClicked = false;
            } else if (displayLabel.getText().equals(Float.toString(result))
                    || displayLabel.getText().equals("Division not possible")) {
                displayLabel.setText("9");
            } else {
                displayLabel.setText(displayLabel.getText() + "9");
            }

        } else if (e.getSource() == fourButton) {
            if (isOperatorClicked == true) {
                displayLabel.setText("4");
                isOperatorClicked = false;
            } else if (displayLabel.getText().equals(Float.toString(result))
                    || displayLabel.getText().equals("Division not possible")) {
                displayLabel.setText("4");
            } else {
                displayLabel.setText(displayLabel.getText() + "4");
            }

        } else if (e.getSource() == fiveButton) {
            if (isOperatorClicked) {
                displayLabel.setText("5");
                isOperatorClicked = false;
            } else if (displayLabel.getText().equals(Float.toString(result))
                    || displayLabel.getText().equals("Division not possible")) {
                displayLabel.setText("5");
            } else {
                displayLabel.setText(displayLabel.getText() + "5");
            }

        } else if (e.getSource() == sixButton) {
            if (isOperatorClicked) {
                displayLabel.setText("6");
                isOperatorClicked = false;
            } else if (displayLabel.getText().equals(Float.toString(result))
                    || displayLabel.getText().equals("Division not possible")) {
                displayLabel.setText("6");
            } else {
                displayLabel.setText(displayLabel.getText() + "6");
            }

        } else if (e.getSource() == oneButton) {
            if (isOperatorClicked) {
                displayLabel.setText("1");
                isOperatorClicked = false;
            } else if (displayLabel.getText().equals(Float.toString(result))
                    || displayLabel.getText().equals("Division not possible")) {
                displayLabel.setText("1");
            } else {
                displayLabel.setText(displayLabel.getText() + "1");
            }

        } else if (e.getSource() == twoButton) {
            if (isOperatorClicked) {
                displayLabel.setText("2");
                isOperatorClicked = false;
            } else if (displayLabel.getText().equals(Float.toString(result))
                    || displayLabel.getText().equals("Division not possible")) {
                displayLabel.setText("2");
            } else {
                displayLabel.setText(displayLabel.getText() + "2");
            }

        } else if (e.getSource() == threeButton) {
            if (isOperatorClicked) {
                displayLabel.setText("3");
                isOperatorClicked = false;
            } else if (displayLabel.getText().equals(Float.toString(result))
                    || displayLabel.getText().equals("Division not possible")) {
                displayLabel.setText("3");
            } else {
                displayLabel.setText(displayLabel.getText() + "3");
            }

        } else if (e.getSource() == zeroButton) {
            if (isOperatorClicked) {
                displayLabel.setText("0");
                isOperatorClicked = false;
            } else if (displayLabel.getText().equals(Float.toString(result))
                    || displayLabel.getText().equals("Division not possible")) {
                displayLabel.setText("0");
            } else {
                displayLabel.setText(displayLabel.getText() + "0");
            }

        } else if (e.getSource() == dotButton) {
            if (isOperatorClicked) {
                displayLabel.setText(".");
                isOperatorClicked = false;
            } else if (displayLabel.getText().equals(Float.toString(result))
                    || displayLabel.getText().equals("Division not possible")) {
                displayLabel.setText(".");
            } else if (!displayLabel.getText().contains(".")) {
                displayLabel.setText(displayLabel.getText() + ".");
            }
        } else if (e.getSource() == clearButton) {
            operator = 0;
            result = 0;
            displayLabel.setText("");
            isOperatorClicked = true;
        } else if (e.getSource() == backButton) {
            if (!displayLabel.getText().equals("")) {
                if (displayLabel.getText().equals("Division not possible")) {
                    displayLabel.setText("");
                    result = 0;
                } else {
                    displayLabel.setText(displayLabel.getText().substring(0, displayLabel.getText().length() - 1));
                }
            } else {
                displayLabel.setText("");
            }
        } else if (e.getSource() == divButton) {
            isOperatorClicked = true;
            oldValue = displayLabel.getText();
            operator = 1;
        } else if (e.getSource() == multiButton) {
            isOperatorClicked = true;
            oldValue = displayLabel.getText();
            operator = 2;
        } else if (e.getSource() == addButton) {
            isOperatorClicked = true;
            oldValue = displayLabel.getText();
            operator = 3;
        } else if (e.getSource() == subButton) {
            isOperatorClicked = true;
            oldValue = displayLabel.getText();
            operator = 4;
        } else if (e.getSource() == equaltoButton) {
            switch (operator) {
                case 1:
                    newValue = displayLabel.getText();
                    oldValueF = Float.parseFloat(oldValue);
                    newValueF = Float.parseFloat(newValue);
                    if (newValueF == 0) {
                        displayLabel.setText("Division not possible");
                    } else {
                        result = oldValueF / newValueF;
                        displayLabel.setText(result + "");
                    }
                    operator = 0;
                    break;
                case 2:
                    newValue = displayLabel.getText();
                    oldValueF = Float.parseFloat(oldValue);
                    newValueF = Float.parseFloat(newValue);
                    result = oldValueF * newValueF;
                    displayLabel.setText(result + "");
                    operator = 0;
                    break;
                case 3:
                    newValue = displayLabel.getText();
                    oldValueF = Float.parseFloat(oldValue);
                    newValueF = Float.parseFloat(newValue);
                    result = oldValueF + newValueF;
                    displayLabel.setText(result + "");
                    operator = 0;
                    break;
                case 4:
                    newValue = displayLabel.getText();
                    oldValueF = Float.parseFloat(oldValue);
                    newValueF = Float.parseFloat(newValue);
                    result = oldValueF - newValueF;
                    displayLabel.setText(result + "");
                    operator = 0;
                    break;
            }

        }

    }
}
