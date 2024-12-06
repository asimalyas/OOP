/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package calculatorgui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorGUI extends JFrame implements ActionListener {
    private JTextField textField;
    private JButton[] numberButtons = new JButton[10];
    private JButton[] functionButtons = new JButton[8];
    private JButton addButton, subButton, mulButton, divButton;
    private JButton decButton, equButton, delButton, clrButton;
    private JPanel panel;

    Font font = new Font("Arial", Font.BOLD, 20);
    double num1 = 0, num2 = 0, result = 0;
    char operator;

    CalculatorGUI() {
        textField = new JTextField();
        textField.setBounds(30, 40, 340, 30);
        textField.setFont(font);
        textField.setEditable(false);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Delete");
        clrButton = new JButton("Clear");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;

        for (int i = 0; i < 8; i++) {
            functionButtons[i].setFont(font);
            functionButtons[i].addActionListener(this);
            functionButtons[i].setBackground(Color.LIGHT_GRAY);
            functionButtons[i].setFocusable(false);
        }

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].setFont(font);
            numberButtons[i].addActionListener(this);
            numberButtons[i].setBackground(Color.WHITE);
            numberButtons[i].setFocusable(false);
        }

        delButton.setBounds(50, 430, 145, 50);
        clrButton.setBounds(205, 430, 145, 50);

        panel = new JPanel();
        panel.setBounds(30, 100, 340, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));
        
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);

        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);

        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);

        
panel.add(decButton);
panel.add(numberButtons[0]);
panel.add(equButton);
panel.add(divButton);

add(panel);
add(textField);
add(delButton);
add(clrButton);

setLayout(null);
setSize(400, 550);
setVisible(true);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

}

public static void main(String[] args) {
new CalculatorGUI();
}

@Override
public void actionPerformed(ActionEvent e) {
for (int i=0; i<10; i++) {
if (e.getSource() == numberButtons[i]) {
textField.setText(textField.getText().concat(String.valueOf(i)));
}
}

if (e.getSource() == decButton) {
textField.setText(textField.getText().concat("."));
}

if (e.getSource() == addButton) {
num1 = Double.parseDouble(textField.getText());
operator = '+';
textField.setText("");
}

if (e.getSource() == subButton) {
num1 = Double.parseDouble(textField.getText());
operator = '-';
textField.setText("");
}

if (e.getSource() == mulButton) {
num1 = Double.parseDouble(textField.getText());
operator = '*';
textField.setText("");
}

if (e.getSource() == divButton) {
num1 = Double.parseDouble(textField.getText());
operator = '/';
textField.setText("");
}

if (e.getSource() == equButton) {
num2=Double.parseDouble(textField.getText());

switch(operator) {
case '+':
result=num1+num2;
break;

case '-':
result=num1-num2;
break;

case '*':
result=num1*num2;
break;

case '/':
result=num1/num2;
break;
}

textField.setText(String.valueOf(result));
}

if (e.getSource() == clrButton) {
textField.setText("");
}

if (e.getSource() == delButton) {
String string=textField.getText();
textField.setText("");
for(int i=0; i<string.length()-1; i++) {
textField.setText(textField.getText()+string.charAt(i));
}
}
}
}