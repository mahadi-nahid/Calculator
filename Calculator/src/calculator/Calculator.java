
package calculator;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author MAHADI HASAN NAHID
 */
public class Calculator {

    private JFrame mainFrame;
    //=========Display Field==========//
    private JTextField displayField1;
    private JTextField displayField2;
    //=========Buttons===============//
    private JButton backSpaceButton;
    private JButton clearButton;
    private JButton clearAllButton;
    //==========Numbers=============//
    private JButton one;
    private JButton two;
    private JButton three;
    private JButton four;
    private JButton five;
    private JButton six;
    private JButton seven;
    private JButton eight;
    private JButton nine;
    private JButton zero;
    //===========Opertators===========//
    private JButton plusButton;
    private JButton minusButton;
    private JButton multiplyButton;
    private JButton divisionButton;
    private JButton sqrtButton;
    private JButton inversButton;
    private JButton plusMinusButton;
    private JButton MemoryPlusButton;
    private JButton dotButton;
    private JButton percentButton;
    private JButton equalButton;
    //===============Panels===========//
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;
    private JPanel panel5;
    private JPanel panel6;
    private JPanel panel7;
    //==============Menu===============//
    private JMenuBar menuBar;
    private JMenu veiwMenu;
    private JMenu editMenu;
    private JMenu helpMenu;
    
    private JMenuItem help;
    private JMenuItem about;
    private JMenuItem version;
    
    private JMenuItem veiw4;
    private JMenuItem veiw5;
    private JMenuItem veiw6;
    
    private JMenuItem[] veiws;
    //=============Look And Feel===============//
    private UIManager.LookAndFeelInfo[] looks;
    private String[] lookNames;
    //===============//
    private String displayValue = "";
    private double value1;
    private double value2;
    private char operator;
    private double answer;

    //==============Calculator Constructor============//
    public Calculator() {

        mainFrame = new JFrame("Calculator");

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screanSize = toolkit.getScreenSize();

        int screanHeight = screanSize.height;
        int screanWidth = screanSize.width;
        

        mainFrame.setSize(350, 400);
        mainFrame.setVisible(true);
        mainFrame.setResizable(false);
        mainFrame.setLocation(screanWidth/4, screanHeight/4);
        mainFrame.setLayout(new GridLayout(6, 5, 2, 2));
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //===============Look And Feel=============//
        looks = UIManager.getInstalledLookAndFeels();
        lookNames = new String[looks.length];

        for (int i = 0; i < looks.length; i++) {
            lookNames[i] = looks[i].getName();
        }

        try {
            UIManager.setLookAndFeel(looks[1].getClassName());
            SwingUtilities.updateComponentTreeUI(mainFrame);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //=========panels=========//
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        panel4 = new JPanel();
        panel5 = new JPanel();
        panel6 = new JPanel();
        panel7 = new JPanel();

        panel1.setBackground(Color.RED);
        panel2.setBackground(Color.GREEN);
        panel3.setBackground(Color.BLACK);
        panel4.setBackground(Color.BLACK);
        panel5.setBackground(Color.BLACK);
        panel6.setBackground(Color.BLACK);
        panel7.setBackground(Color.BLACK);

        mainFrame.add(panel1);
        mainFrame.add(panel2);
        mainFrame.add(panel3);
        mainFrame.add(panel4);
        mainFrame.add(panel5);
        mainFrame.add(panel6);
        //mainFrame.add(panel7);

        panel1.setLayout(new GridLayout(1, 5, 2, 2));
        panel2.setLayout(new GridLayout(1, 5, 2, 2));
        panel3.setLayout(new GridLayout(1, 5, 2, 2));
        panel4.setLayout(new GridLayout(1, 5, 2, 2));
        panel5.setLayout(new GridLayout(1, 5, 2, 2));
        panel6.setLayout(new GridLayout(1, 5, 2, 2));

        displayField1 = new JTextField(20);
        displayField1.setEditable(false);
        displayField1.setText("0.");
        panel1.add(displayField1);
        displayField2 = new JTextField(10);
        displayField2.setEditable(false);
        displayField2.setText("0");
        panel1.add(displayField2);

        //==========numbers============//
        one = new JButton("1");
        two = new JButton("2");
        three = new JButton("3");
        four = new JButton("4");
        five = new JButton("5");
        six = new JButton("6");
        seven = new JButton("7");
        eight = new JButton("8");
        nine = new JButton("9");
        zero = new JButton("0");

        backSpaceButton = new JButton("BackSpace");
        clearAllButton = new JButton("CE");
        clearButton = new JButton("C");

        plusButton = new JButton("+");
        minusButton = new JButton("-");
        multiplyButton = new JButton("*");
        divisionButton = new JButton("/");
        equalButton = new JButton("=");
        dotButton = new JButton(".");
        percentButton = new JButton("%");
        plusMinusButton = new JButton("+/-");
        sqrtButton = new JButton("Sqrt");
        inversButton = new JButton("1/x");
        MemoryPlusButton = new JButton("M+");


        panel2.add(backSpaceButton);
        panel2.add(clearAllButton);
        panel2.add(clearButton);
        panel2.add(MemoryPlusButton);

        panel3.add(seven);
        panel3.add(eight);
        panel3.add(nine);
        panel3.add(divisionButton);
        panel3.add(sqrtButton);


        panel4.add(four);
        panel4.add(five);
        panel4.add(six);
        panel4.add(multiplyButton);
        panel4.add(percentButton);


        panel5.add(one);
        panel5.add(two);
        panel5.add(three);
        panel5.add(minusButton);
        panel5.add(inversButton);

        panel6.add(zero);
        panel6.add(plusMinusButton);
        panel6.add(dotButton);
        panel6.add(plusButton);
        panel6.add(equalButton);

        //================Menu================//

        menuBar = new JMenuBar();
        veiwMenu = new JMenu("veiw");

        // veiw1 = new JMenuItem("Nimbuzz");
        // veiw2 = new JMenuItem("Windows");

        //=================================//

        ActionsHandler handler = new ActionsHandler();
        //=============================//

        veiwMenu.addActionListener(handler);
        
        veiws = new JMenuItem[looks.length];

        for (int i = 0; i < looks.length; i++) {
            veiws[i] = new JMenuItem(lookNames[i]);
            veiws[i].addActionListener(handler);
            veiwMenu.add(veiws[i]);
            veiwMenu.addSeparator();
        }


        editMenu = new JMenu("Edit");
        //------------------------
        //--------------
        //------------
        helpMenu = new JMenu("Help");
        
        help = new JMenuItem("User Manual");
        about = new JMenuItem("About");
        version = new JMenuItem("Version");
        
        helpMenu.add(help);
        helpMenu.add(about);
        helpMenu.add(version);
        
        help.addActionListener(handler);
        about.addActionListener(handler);
        version.addActionListener(handler);
        
        
        
        //---------------
        //----------
        //-----



        menuBar.add(veiwMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);

        mainFrame.setJMenuBar(menuBar);

        //============Look And Feel=============//







        one.addActionListener(handler);
        two.addActionListener(handler);
        three.addActionListener(handler);
        four.addActionListener(handler);
        five.addActionListener(handler);
        six.addActionListener(handler);
        seven.addActionListener(handler);
        eight.addActionListener(handler);
        nine.addActionListener(handler);
        zero.addActionListener(handler);
        dotButton.addActionListener(handler);

        //=================//
        backSpaceButton.addActionListener(handler);
        clearAllButton.addActionListener(handler);
        clearButton.addActionListener(handler);
        MemoryPlusButton.addActionListener(handler);

        //=================//
        plusButton.addActionListener(handler);
        minusButton.addActionListener(handler);
        multiplyButton.addActionListener(handler);
        divisionButton.addActionListener(handler);
        plusMinusButton.addActionListener(handler);
        inversButton.addActionListener(handler);
        percentButton.addActionListener(handler);
        sqrtButton.addActionListener(handler);
        equalButton.addActionListener(handler);
        //=========================//


    }

    public void changeLookAndFeel(int value) {
        try {
            UIManager.setLookAndFeel(looks[value].getClassName());
            SwingUtilities.updateComponentTreeUI(mainFrame);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public class ActionsHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {


            try {
                //================Numbers===============//

                if (event.getSource() == one) {
                    displayValue += 1;
                    displayField1.setText(displayValue);
                }
                if (event.getSource() == two) {
                    displayValue += 2;
                    displayField1.setText(displayValue);
                }
                if (event.getSource() == three) {
                    displayValue += 3;
                    displayField1.setText(displayValue);
                }
                if (event.getSource() == four) {
                    displayValue += 4;
                    displayField1.setText(displayValue);
                }
                if (event.getSource() == five) {
                    displayValue += 5;
                    displayField1.setText(displayValue);
                }
                if (event.getSource() == six) {
                    displayValue += 6;
                    displayField1.setText(displayValue);
                }
                if (event.getSource() == seven) {
                    displayValue += 7;
                    displayField1.setText(displayValue);
                }
                if (event.getSource() == eight) {
                    displayValue += 8;
                    displayField1.setText(displayValue);
                }
                if (event.getSource() == nine) {
                    displayValue += 9;
                    displayField1.setText(displayValue);
                }
                if (event.getSource() == zero) {
                    displayValue += 0;
                    displayField1.setText(displayValue);
                }
                if (event.getSource() == dotButton) {
                    displayValue += ".";
                    displayField1.setText(displayValue);
                }

                //=======Opertators================//

                if (event.getSource() == plusButton) {
                    value1 = Double.parseDouble(displayField1.getText());
                    operator = '+';
                    displayField2.setText(displayField1.getText());
                    displayValue = "";
                    displayField1.setText("" + displayValue);

                }
                if (event.getSource() == minusButton) {
                    value1 = Double.parseDouble(displayField1.getText());
                    operator = '-';
                    displayField2.setText(displayField1.getText());
                    displayValue = "";
                    displayField1.setText("" + displayValue);
                }
                if (event.getSource() == multiplyButton) {
                    value1 = Double.parseDouble(displayField1.getText());
                    operator = '*';
                    displayField2.setText(displayField1.getText());
                    displayValue = "";
                    displayField1.setText("" + displayValue);
                }
                if (event.getSource() == divisionButton) {
                    value1 = Double.parseDouble(displayField1.getText());
                    operator = '/';
                    displayField2.setText(displayField1.getText());
                    displayValue = "";
                    displayField1.setText("" + displayValue);
                }
                if (event.getSource() == sqrtButton) {
                    value1 = Double.parseDouble(displayField1.getText());
                    answer = Math.sqrt(value1);
                    displayValue = "";
                    displayField1.setText("" + answer);
                    displayField2.setText("Anser: " + answer);
                }
                if (event.getSource() == plusMinusButton) {

                    value1 = Double.parseDouble(displayField1.getText()) * -1;
                    displayValue = "";
                    displayField1.setText("" + value1);
                    displayField2.setText("" + answer);
                }
                if (event.getSource() == inversButton) {

                    answer = (double) (1 / Double.parseDouble(displayField1.getText()));
                    displayValue = "";
                    displayField1.setText("" + answer);
                }
                //=====================//
                if (event.getSource() == backSpaceButton) {
                    displayValue = displayValue.substring(0, displayValue.length() - 1);
                    displayField1.setText("" + displayValue);
                }
                if (event.getSource() == clearAllButton) {
                    value1 = 0;
                    value2 = 0;
                    displayValue = "";

                    displayField1.setText(displayValue);
                    displayField2.setText("0");
                }
                if (event.getSource() == clearAllButton) {
                    value1 = 0;
                    value2 = 0;
                    displayValue = "";

                    displayField1.setText(displayValue);
                    displayField2.setText("0");
                }
                if (event.getSource() == MemoryPlusButton) {
                }

                //=================//

                if (event.getSource() == equalButton) {

                    value2 = Double.parseDouble(displayField1.getText());
                    displayValue = "";

                    if (operator == '+') {
                        answer = value1 + value2;
                        displayValue = "";
                        displayField1.setText("" + displayValue);
                        displayField2.setText("Answer: " + answer);
                        value1 = 0;
                        value2 = 0;
                        //operator = ' ';
                    }
                    if (operator == '-') {
                        answer = value1 - value2;
                        displayValue = "";
                        displayField1.setText("" + displayValue);
                        displayField2.setText("Answer: " + answer);
                        value1 = 0;
                        value2 = 0;
                    }
                    if (operator == '*') {
                        answer = value1 * value2;
                        displayValue = "";
                        displayField1.setText("" + displayValue);
                        displayField2.setText("Answer: " + answer);
                        value1 = 0;
                        value2 = 0;
                    }
                    if (operator == '/') {
                        answer = value1 / value2;
                        displayValue = "";
                        displayField1.setText("" + displayValue);
                        displayField2.setText("Answer: " + answer);
                        value1 = 0;
                        value2 = 0;
                    }
                    if (operator == '%') {
                        answer = value1 % value2;
                        displayValue = "";
                        displayField1.setText("" + displayValue);
                        displayField2.setText("Answer: " + answer);
                        value1 = 0;
                        value2 = 0;
                    } else {
                        // displayField2.setText("Answer: "+ displayField1.getText());
                    }

                }
                //==============Menu=============//
                for (int i = 0; i < looks.length; i++) {
                    if (event.getSource() == veiws[i]) {
                        changeLookAndFeel(i);
                    }
                }
                
                if(event.getSource() == help) {}
                if(event.getSource() == about) {
                    
                    JOptionPane.showMessageDialog(mainFrame, ""
                            + "Md Mahadi Hasan Nahid\n"
                            + "Dept. of CSE, SUST\n"
                            + "nahid@student.sust.edu\n"
                            + "01738150127\n", "About",
                            JOptionPane.INFORMATION_MESSAGE);
                }
                if(event.getSource() == version) {
                    JOptionPane.showMessageDialog(mainFrame, ""
                            + "CalculatorMini\n"
                            + "Black Edition\n"
                            + "Version-2.7.1");
                }


            } catch (Exception e) {
            }


        }
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
    }
}
