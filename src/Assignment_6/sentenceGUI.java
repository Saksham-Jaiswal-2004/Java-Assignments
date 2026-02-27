package Assignment_6;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Image;
import javax.swing.*;
import java.util.regex.*;

public class sentenceGUI extends JFrame implements ActionListener
{
    JFrame sentenceFrame;
    JButton b1,b2,b3,b4,b5;
    JLabel oldColorLabel ,newColorLabel;
    JTextArea inputText, outputText;
    JCheckBox c1,c2,c3,c4,c5,c6;
    String oldColor = "None", currentColor = "Default";

    public static void main(String[] args)
    {
        new sentenceGUI();
    }

    public sentenceGUI()
    {
        sentenceFrame = new JFrame("String GUI");

        JLabel inputLabel = new JLabel("Input String");
        inputLabel.setBounds(85, 15, 430, 25);
        sentenceFrame.add(inputLabel);

        inputText = new JTextArea(10, 30);
        inputText.setBounds(85, 40, 430, 150);
        inputText.setLineWrap(true);
        inputText.setWrapStyleWord(true);
        sentenceFrame.add(inputText);

        JLabel outputLabel = new JLabel("Output");
        outputLabel.setBounds(85, 200, 430, 25);
        sentenceFrame.add(outputLabel);

        outputText = new JTextArea(10, 30);
        outputText.setBounds(85, 225, 430, 150);
        outputText.setLineWrap(true);
        outputText.setWrapStyleWord(true);
        sentenceFrame.add(outputText);

        b1 = new JButton("Count Vowels");
        b1.setBounds(85, 400, 200, 50);
        sentenceFrame.add(b1);
        b1.addActionListener(this);

        b2 = new JButton("Count Consonants");
        b2.setBounds(315, 400, 200, 50);
        sentenceFrame.add(b2);
        b2.addActionListener(this);

        b3 = new JButton("Count Punctuations");
        b3.setBounds(85, 461, 200, 50);
        sentenceFrame.add(b3);
        b3.addActionListener(this);

        b4 = new JButton("Capitalise String");
        b4.setBounds(315, 461, 200, 50);
        sentenceFrame.add(b4);
        b4.addActionListener(this);

        b5 = new JButton("Color History");
        b5.setBounds(85, 521, 200, 50);
        ImageIcon originalIcon = new ImageIcon("src/Assignment_6/Color Hist.png");
        Image scaledImage = originalIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        b5.setIconTextGap(10);
        b5.setIcon(new ImageIcon(scaledImage));
        sentenceFrame.add(b5);
        b5.addActionListener(this);

        oldColorLabel = new JLabel("Previous Bg Color: "+oldColor);
        oldColorLabel.setBounds(315, 521, 200, 25);
        sentenceFrame.add(oldColorLabel);
        oldColorLabel.setVisible(false);

        newColorLabel = new JLabel("Current Bg Color: "+currentColor);
        newColorLabel.setBounds(315, 550, 200, 25);
        sentenceFrame.add(newColorLabel);
        newColorLabel.setVisible(false);

        c1 = new JCheckBox("Green");
        c1.setBounds(85, 620, 150, 20);
        sentenceFrame.add(c1);
        c1.addActionListener(this);

        c2 = new JCheckBox("Magenta");
        c2.setBounds(250, 620, 150, 20);
        sentenceFrame.add(c2);
        c2.addActionListener(this);

        c3 = new JCheckBox("Orange");
        c3.setBounds(415, 620, 150, 20);
        sentenceFrame.add(c3);
        c3.addActionListener(this);

        c4 = new JCheckBox("Pink");
        c4.setBounds(85, 660, 150, 20);
        sentenceFrame.add(c4);
        c4.addActionListener(this);

        c5 = new JCheckBox("Red");
        c5.setBounds(250, 660, 150, 20);
        sentenceFrame.add(c5);
        c5.addActionListener(this);

        c6 = new JCheckBox("Yellow");
        c6.setBounds(415, 660, 150, 20);
        sentenceFrame.add(c6);
        c6.addActionListener(this);

        ButtonGroup group = new ButtonGroup();
        group.add(c1);
        group.add(c2);
        group.add(c3);
        group.add(c4);
        group.add(c5);
        group.add(c6);

        sentenceFrame.setSize(600, 800);
        sentenceFrame.setLayout(null);
        sentenceFrame.setVisible(true);
        sentenceFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String input = inputText.getText();

        if (e.getSource() == b1)
        {
            int count=0;
            Pattern pattern = Pattern.compile("[aeiou]", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(input);

            while (matcher.find())
                count++;

            outputText.setText("Vowels: "+count);
        }
        else if (e.getSource() == b2)
        {
            int count=0;
            Pattern pattern = Pattern.compile("(?i)[b-df-hj-np-tv-z]", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(input);

            while (matcher.find())
                count++;

            outputText.setText("Consonants: "+count);
        }
        else if (e.getSource() ==  b3)
        {
            int count=0;
            Pattern pattern = Pattern.compile("\\p{Punct}", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(input);

            while (matcher.find())
                count++;

            outputText.setText("Punctuations: "+count);
        }
        else if (e.getSource() ==  b4)
        {
            outputText.setText("Capitalised: "+input.toUpperCase());
        }
        else if (e.getSource() ==  b5)
        {
            oldColorLabel.setVisible(!oldColorLabel.isVisible());
            newColorLabel.setVisible(!newColorLabel.isVisible());
        }
        else if (e.getSource() ==  c1)
        {
            sentenceFrame.getContentPane().setBackground(Color.GREEN);

            oldColor = currentColor;
            currentColor = "Green";

            oldColorLabel.setText("Previous Bg Color: "+oldColor);
            newColorLabel.setText("Current Bg Color: "+currentColor);
        }
        else if (e.getSource() ==  c2)
        {
            sentenceFrame.getContentPane().setBackground(Color.MAGENTA);

            oldColor = currentColor;
            currentColor = "Magenta";

            oldColorLabel.setText("Previous Bg Color: "+oldColor);
            newColorLabel.setText("Current Bg Color: "+currentColor);
        }
        else if (e.getSource() ==  c3)
        {
            sentenceFrame.getContentPane().setBackground(Color.ORANGE);

            oldColor = currentColor;
            currentColor = "Orange";

            oldColorLabel.setText("Previous Bg Color: "+oldColor);
            newColorLabel.setText("Current Bg Color: "+currentColor);
        }
        else if (e.getSource() ==  c4)
        {
            sentenceFrame.getContentPane().setBackground(Color.PINK);

            oldColor = currentColor;
            currentColor = "Pink";

            oldColorLabel.setText("Previous Bg Color: "+oldColor);
            newColorLabel.setText("Current Bg Color: "+currentColor);
        }
        else if (e.getSource() ==  c5)
        {
            sentenceFrame.getContentPane().setBackground(Color.RED);

            oldColor = currentColor;
            currentColor = "Red";

            oldColorLabel.setText("Previous Bg Color: "+oldColor);
            newColorLabel.setText("Current Bg Color: "+currentColor);
        }
        else if (e.getSource() ==  c6)
        {
            sentenceFrame.getContentPane().setBackground(Color.YELLOW);

            oldColor = currentColor;
            currentColor = "Yellow";

            oldColorLabel.setText("Previous Bg Color: "+oldColor);
            newColorLabel.setText("Current Bg Color: "+currentColor);
        }
    }
}
