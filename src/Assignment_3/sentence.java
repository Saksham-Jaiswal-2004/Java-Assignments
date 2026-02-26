package Assignment_3;
import java.util.*;

public class sentence
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String s[] = new String[5];
        String buffer[];
        int a=0, e=0, i=0, o=0, u=0, len=0;
        int n1=0, n2=0, n3=0, n4=0, n5=0;

        for(int k=0 ; k<5 ; k++)
        {
            System.out.print("Enter Sentence "+(k+1)+": ");
            s[k] = sc.nextLine();
            len += s[k].split(" ").length;
        }
        String vowel[][] = new String[5][len];
        String sen[][] = new String[5][len];

        for(int k=0 ; k<5 ; k++)
        {
            buffer = s[k].split(" ");

            for(int j=0 ; j<buffer.length ; j++)
            {
                if (buffer[j].charAt(0) == 'a' || buffer[j].charAt(0) == 'A')
                {
                    vowel[0][a] = buffer[j];
                    a++;
                }
                if (buffer[j].charAt(0) == 'e' || buffer[j].charAt(0) == 'E')
                {
                    vowel[1][e] = buffer[j];
                    e++;
                }
                if (buffer[j].charAt(0) == 'i' || buffer[j].charAt(0) == 'I')
                {
                    vowel[2][i] = buffer[j];
                    i++;
                }
                if (buffer[j].charAt(0) == 'o' || buffer[j].charAt(0) == 'O')
                {
                    vowel[3][o] = buffer[j];
                    o++;
                }
                if (buffer[j].charAt(0) == 'u' || buffer[j].charAt(0) == 'U')
                {
                    vowel[4][u] = buffer[j];
                    u++;
                }

                if(buffer[j].matches(".*\\d.*"))
                {
                    if(k==0)
                    {
                        sen[k][n1] = buffer[j];
                        n1++;
                    }
                    if(k==1)
                    {
                        sen[k][n2] = buffer[j];
                        n2++;
                    }
                    if(k==2)
                    {
                        sen[k][n3] = buffer[j];
                        n3++;
                    }
                    if(k==3)
                    {
                        sen[k][n4] = buffer[j];
                        n4++;
                    }
                    if(k==4)
                    {
                        sen[k][n5] = buffer[j];
                        n5++;
                    }
                }
            }
        }

        System.out.println("\nTotal Words starting with vowel: "+(a+e+i+o+u));

        for(int k=0 ; k<5 ; k++)
        {
            if(k==0)
                System.out.print("A: ");
            if(k==1)
                System.out.print("E: ");
            if(k==2)
                System.out.print("I: ");
            if(k==3)
                System.out.print("O: ");
            if(k==4)
                System.out.print("U: ");

            for(int j=0 ; j<vowel[k].length ; j++)
            {
                if(vowel[k][j] != null)
                    System.out.print(vowel[k][j]+", ");
            }
            System.out.println();
        }

        System.out.println("\nTotal Numbers present: "+(n1+n2+n3+n4+n5));

        for(int k=0 ; k<5 ; k++)
        {
            if(k==0)
                System.out.print("Sentence 1: ");
            if(k==1)
                System.out.print("Sentence 2: ");
            if(k==2)
                System.out.print("Sentence 3: ");
            if(k==3)
                System.out.print("Sentence 4: ");
            if(k==4)
                System.out.print("Sentence 5: ");

            for(int j=0 ; j<sen[k].length ; j++)
            {
                if(sen[k][0] == null)
                {
                    System.out.print("NA");
                    break;
                }

                if(sen[k][j] != null)
                    System.out.print(sen[k][j]+", ");
            }
            System.out.println();
        }
    }
}