import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import static java.lang.StringTemplate.STR;

public class Main {
    public static void main(String[] args) {
        // JFrame container
        JFrame frame = new JFrame("NumEx");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setLocationRelativeTo(null);

        // JPanel with a GridLayout
        JPanel panel = new JPanel();
        panel.setBackground(Color.BLACK);
        panel.setLayout(new GridLayout(1, 3, 2, 2)); // 1 rows, 3 columns with gaps

        // Create counters for buttons
        final int[] btn1Counter = {0};
        final int[] btn2Counter = {0};
        final int[] btn3Counter = {0};

        // Creating JButtons
        JButton button1 = new JButton("0");
        JButton button2 = new JButton("0");
        JButton button3 = new JButton("0");
        JButton checkButton = new JButton("Check"); // Renamed and labeled button

        // Set font for buttons
        Font buttonFont = new Font("Arial", Font.BOLD, 30);
        button1.setFont(buttonFont);
        button2.setFont(buttonFont);
        button3.setFont(buttonFont);
        checkButton.setFont(new Font("Arial", Font.BOLD, 20)); // Smaller font for check button

        // Set button colors for better visibility
        button1.setBackground(Color.WHITE);
        button2.setBackground(Color.WHITE);
        button3.setBackground(Color.WHITE);

        // Add the JButtons to the JPanel
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(checkButton);

        // Adjust layout to accommodate feedback label
        frame.setLayout(new BorderLayout());
        frame.add(panel, BorderLayout.CENTER);

        // Initialize random number generator
        Random random = new Random();
        final int[] randomNum1 = {random.nextInt(10)};
        final int[] randomNum2 = {random.nextInt(10)};
        final int[] randomNum3 = {random.nextInt(10)};

        // For debugging purposes: Print initial random numbers
        System.out.println(STR."\{randomNum1[0]} \{randomNum2[0]} \{randomNum3[0]}");

        // Add ActionListener for button1
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btn1Counter[0]++;
                if (btn1Counter[0] > 9){
                    btn1Counter[0] = 0;
                }
                button1.setText(String.valueOf(btn1Counter[0]));
            }
        });

        // Add ActionListener for button2
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btn2Counter[0]++;
                if (btn2Counter[0] > 9){
                    btn2Counter[0] = 0;
                }
                button2.setText(String.valueOf(btn2Counter[0]));
            }
        });

        // Add ActionListener for button3
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btn3Counter[0]++;
                if (btn3Counter[0] > 9){
                    btn3Counter[0] = 0;
                }
                button3.setText(String.valueOf(btn3Counter[0]));
            }
        });

        // Add ActionListener for checkButton
        checkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Parse values from buttons' text
                    int val1 = Integer.parseInt(button1.getText());
                    int val2 = Integer.parseInt(button2.getText());
                    int val3 = Integer.parseInt(button3.getText());

                    // Check if the values match random numbers
                    if (val1 == randomNum1[0] && val2 == randomNum2[0] && val3 == randomNum3[0]) {

                        System.out.println("You are Correct");

                        // Generate new random numbers
                        randomNum1[0] = random.nextInt(10); // Random number between 0 and 9
                        randomNum2[0] = random.nextInt(10);
                        randomNum3[0] = random.nextInt(10);

                        // For debugging: Print new random numbers
                        System.out.println(STR."\{randomNum1[0]} \{randomNum2[0]} \{randomNum3[0]}");


                    } else {

                        System.out.println("Try Again");
                    }
                    // Reset the button counters
                    btn1Counter[0] = 0;
                    btn2Counter[0] = 0;
                    btn3Counter[0] = 0;

                    // Reset the button text to "0"
                    button1.setText("0");
                    button2.setText("0");
                    button3.setText("0");

                } catch (NumberFormatException ex) {

                    System.out.println("Invalid number format.");
                }
            }
        });
        // Make the frame visible
        frame.setVisible(true);
    }
}
