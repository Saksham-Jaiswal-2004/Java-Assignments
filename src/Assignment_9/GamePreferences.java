package Assignment_9;

import java.io.*;
import java.util.Scanner;

class UserPreferences implements Serializable
{
    private static final long serialVersionUID = 1L;

    String fontStyle;
    int fontSize;
    String foregroundColor;
    String backgroundColor;

    public UserPreferences(String fontStyle, int fontSize, String fg, String bg)
    {
        this.fontStyle = fontStyle;
        this.fontSize = fontSize;
        this.foregroundColor = fg;
        this.backgroundColor = bg;
    }

    public void display()
    {
        System.out.println("\n********    Saved Preferences    ********");
        System.out.println("Font Style: " + fontStyle);
        System.out.println("Font Size: " + fontSize);
        System.out.println("Foreground Color: " + foregroundColor);
        System.out.println("Background Color: " + backgroundColor);
    }
}

public class GamePreferences
{
    private static final String FILE_NAME = "preferences.ser";

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        while (true)
        {
            System.out.println("\n********    Game Preferences    ********");
            System.out.println("1. Set Preferences");
            System.out.println("2. Load Preferences");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice)
            {
                case 1:
                    System.out.print("Enter Font Style: ");
                    String fontStyle = sc.nextLine();

                    System.out.print("Enter Font Size: ");
                    int fontSize = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Foreground Color: ");
                    String fg = sc.nextLine();

                    System.out.print("Enter Background Color: ");
                    String bg = sc.nextLine();

                    UserPreferences prefs = new UserPreferences(fontStyle, fontSize, fg, bg);

                    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME)))
                    {
                        oos.writeObject(prefs);
                        System.out.println("Preferences saved successfully!");
                    } catch (IOException e) {
                        System.out.println("Error saving preferences: " + e.getMessage());
                    }
                    break;

                case 2:
                    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME)))
                    {
                        UserPreferences loadedPrefs = (UserPreferences) ois.readObject();
                        loadedPrefs.display();
                    } catch (IOException | ClassNotFoundException e) {
                        System.out.println("Error loading preferences: " + e.getMessage());
                    }
                    break;

                case 3:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
