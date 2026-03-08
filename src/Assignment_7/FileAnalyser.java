package Assignment_7;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class FileAnalyser extends JFrame implements ActionListener
{

    JTextField filePath;
    JButton browse, vowels, consonants, punctuations, capitalize;
    File selectedFile;
    java.util.List<String> lines = new ArrayList<>();

    FileAnalyser()
    {
        setTitle("Text File Analyzer");
        setSize(500,300);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        filePath = new JTextField(30);
        browse = new JButton("Browse File");

        vowels = new JButton("Count Vowels");
        consonants = new JButton("Count Consonants");
        punctuations = new JButton("Count Punctuations");
        capitalize = new JButton("Capitalize");

        add(filePath);
        add(browse);
        add(vowels);
        add(consonants);
        add(punctuations);
        add(capitalize);

        browse.addActionListener(this);
        vowels.addActionListener(this);
        consonants.addActionListener(this);
        punctuations.addActionListener(this);
        capitalize.addActionListener(this);

        setVisible(true);
    }

    public void readFile()
    {
        lines.clear();

        try {
            BufferedReader br = new BufferedReader(new FileReader(selectedFile));
            String line;

            while((line = br.readLine()) != null)
            {
                lines.add(line);
            }

            br.close();

        } catch(Exception e) {
            JOptionPane.showMessageDialog(this,"Error reading file");
        }
    }

    public void writeFile()
    {

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(selectedFile));

            for(String s : lines)
            {
                bw.write(s);
                bw.newLine();
            }

            bw.close();

        } catch(Exception e) {
            JOptionPane.showMessageDialog(this,"Error writing file");
        }
    }

    public void actionPerformed(ActionEvent e)
    {

        if(e.getSource() == browse)
        {

            JFileChooser fc = new JFileChooser();
            int result = fc.showOpenDialog(this);

            if(result == JFileChooser.APPROVE_OPTION)
            {
                selectedFile = fc.getSelectedFile();
                filePath.setText(selectedFile.getAbsolutePath());
                readFile();
            }
        }

        if(selectedFile == null)
        {
            JOptionPane.showMessageDialog(this,"Please select a file first");
            return;
        }

        if(e.getSource() == vowels)
        {

            int count = 0;

            for(String line : lines)
            {
                for(char c : line.toLowerCase().toCharArray())
                {
                    if("aeiou".indexOf(c) != -1)
                        count++;
                }
            }

            JOptionPane.showMessageDialog(this,"Vowels: " + count);
        }

        if(e.getSource() == consonants)
        {

            int count = 0;

            for(String line : lines)
            {
                for(char c : line.toLowerCase().toCharArray())
                {
                    if(Character.isLetter(c) && "aeiou".indexOf(c) == -1)
                        count++;
                }
            }

            JOptionPane.showMessageDialog(this,"Consonants: " + count);
        }

        if(e.getSource() == punctuations)
        {

            int count = 0;

            for(String line : lines)
            {
                for(char c : line.toCharArray())
                {
                    if(!Character.isLetterOrDigit(c) && !Character.isWhitespace(c))
                        count++;
                }
            }

            JOptionPane.showMessageDialog(this,"Punctuations: " + count);
        }

        if(e.getSource() == capitalize)
        {

            for(int i=0;i<lines.size();i++)
            {
                lines.set(i, lines.get(i).toUpperCase());
            }

            writeFile();

            JOptionPane.showMessageDialog(this,"File Capitalized Successfully");
        }
    }

    public static void main(String[] args)
    {
        new FileAnalyser();
    }
}
