package Assignment_8;

import java.io.*;
import java.util.*;
import java.util.regex.*;
import javax.swing.*;

public class link extends JFrame
{
    public static void main(String[] args)
    {

        JFrame frame = new JFrame();
        JFileChooser chooser = new JFileChooser();

        int result = chooser.showOpenDialog(frame);

        if (result == JFileChooser.APPROVE_OPTION)
        {

            File file = chooser.getSelectedFile();

            try
            {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String line;

                Pattern pattern = Pattern.compile("(?i)href\\s*=\\s*['\"]?([^'\" >]+)");

                System.out.println("Links found in HTML file:\n");

                while ((line = reader.readLine()) != null)
                {

                    Matcher matcher = pattern.matcher(line);

                    while (matcher.find())
                    {
                        System.out.println(matcher.group(1));
                    }
                }

                reader.close();

            } catch (Exception e) {
                System.out.println("Error reading file: " + e.getMessage());
            }
        }
    }
}
