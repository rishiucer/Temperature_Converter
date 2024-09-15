import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class TempConverter extends JFrame {
    private JTextField tempinput, tempoutput;
    private JComboBox<String> comboBox1, comboBox2;

    public TempConverter() {
        Container c = getContentPane();
        c.setLayout(null);
        c.setBackground(Color.white);
        setTitle("TEMPERATURE CONVERTER");
        setSize(400, 500);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        JLabel label = new JLabel("TEMPERATURE CONVERTER");
        label.setBounds(25, 0, 400, 100);
        label.setFont(new Font("Algerian", Font.BOLD, 25));
        panel.add(label);
        panel.setBackground(Color.cyan);
        panel.setBounds(0, 0, 500, 100);
        c.add(panel);

        JLabel inputlabel = new JLabel("Degrees");
        inputlabel.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        inputlabel.setSize(270, 20);
        inputlabel.setLocation(32, 120);

        JLabel Type = new JLabel("Type");
        Type.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        Type.setSize(270, 20);
        Type.setLocation(210, 120);

        String[] s1 = {"Celsius", "Fahrenheit", "Kelvin"};
        comboBox1 = new JComboBox<>(s1);
        comboBox1.setFont(new Font("Book Antiqua", Font.BOLD, 15));
        comboBox1.setBounds(210, 155, 150, 30);
        add(comboBox1);

        tempinput = new JTextField(10);
        tempinput.setSize(100, 30);
        tempinput.setLocation(30, 155);
        tempinput.setFont(new Font("Book Antiqua", Font.BOLD, 15));

        String[] s2 = {"Celsius", "Fahrenheit", "Kelvin"};
        comboBox2 = new JComboBox<>(s2);
        comboBox2.setFont(new Font("Book Antiqua", Font.BOLD, 15));
        comboBox2.setBounds(210, 210, 150, 30);
        add(comboBox2);

        JLabel convertlabel = new JLabel("Convert To");
        convertlabel.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        convertlabel.setSize(270, 20);
        convertlabel.setLocation(30, 210);

        tempoutput = new JTextField(10);
        tempoutput.setSize(150, 30);
        tempoutput.setLocation(210, 270);
        tempoutput.setBackground(Color.white);
        tempoutput.setFont(new Font("Book Antiqua", Font.BOLD, 15));

        JLabel outputlabel = new JLabel("Result");
        outputlabel.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        outputlabel.setSize(270, 20);
        outputlabel.setLocation(40, 270);

        JButton button = new JButton("Convert");
        button.setSize(335, 40);
        button.setLocation(25, 320);
        button.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        button.setBackground(Color.lightGray);
        button.addActionListener(new ButtonListener());

        c.add(outputlabel);
        c.add(Type);
        c.add(convertlabel);
        c.add(inputlabel);
        c.add(tempinput);
        c.add(tempoutput);
        c.add(button);
        c.add(comboBox1);
        c.add(comboBox2);
        tempoutput.setEditable(false);

        setVisible(true); // Set visible at the end
    }

    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                String temp = (String) comboBox1.getSelectedItem();
                String tempConvert = (String) comboBox2.getSelectedItem();
                double input = Double.parseDouble(tempinput.getText());

                if (temp.equals("Celsius") && tempConvert.equals("Fahrenheit")) {
                    double c = input;
                    double f = (c * 1.8 + 32);
                    tempoutput.setText(String.valueOf(f));
                } else if (temp.equals("Celsius") && tempConvert.equals("Kelvin")) {
                    double c = input;
                    double k = (c + 273);
                    tempoutput.setText(String.valueOf(k));
                } else if (temp.equals("Celsius") && tempConvert.equals("Celsius")) {
                    tempoutput.setText(String.valueOf(input));
                }

                if (temp.equals("Fahrenheit") && tempConvert.equals("Celsius")) {
                    double f = input;
                    double c = ((f - 32) * 5 / 9);
                    tempoutput.setText(String.valueOf(c));
                } else if (temp.equals("Fahrenheit") && tempConvert.equals("Kelvin")) {
                    double f = input;
                    double k = ((f - 32) * 5 / 9 + 273.15);
                    tempoutput.setText(String.valueOf(k));
                } else if (temp.equals("Fahrenheit") && tempConvert.equals("Fahrenheit")) {
                    tempoutput.setText(String.valueOf(input));
                }

                if (temp.equals("Kelvin") && tempConvert.equals("Fahrenheit")) {
                    double k = input;
                    double f = ((k * (9.0 / 5)) - 459.67);
                    tempoutput.setText(String.valueOf(f));
                } else if (temp.equals("Kelvin") && tempConvert.equals("Kelvin")) {
                    tempoutput.setText(String.valueOf(input));
                } else if (temp.equals("Kelvin") && tempConvert.equals("Celsius")) {
                    double k = input;
                    double c = (k - 273);
                    tempoutput.setText(String.valueOf(c));
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(TempConverter.this, "Please enter a valid number");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TempConverter().setLocationRelativeTo(null); // Center the frame
        });
    }
}
