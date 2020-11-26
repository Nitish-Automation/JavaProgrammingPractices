package appdriver;
import java.math.BigDecimal;
import java.util.Scanner;

public class Validator
{
	/**
	 * To read the whole line
	 * @param sc Scanner
	 * @param prompt message string
	 * @return entererd string in one line
	 */
    public static String getLine(Scanner sc, String prompt)
    {
        System.out.print(prompt);
        String s = sc.nextLine();  
        return s;
    }

    /**
     * To read the first string on the line and discard the rest of the line
     * @param sc Scanner
     * @param prompt message string
     * @return entered string
     */
    public static String getString(Scanner sc, String prompt)
    {
        System.out.print(prompt);
        String s = sc.next();      
        sc.nextLine();           
        return s;
    }
    
    /**
     * To Get a valid email id string
     * @param sc Scanner
     * @param prompt message string
     * @return emailid
     */
    public static String getEmailString(Scanner sc, String prompt)
    {
        System.out.print(prompt);        
    	String email = sc.next();
    	if(isValid(email))
    		return email;
    	else {
    		return null;
    	}
    }

    private static boolean isValid(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
     }
    
    /**
     * To Get input value for int within a specified range
     * @param sc Scanner
     * @param prompt message string
     * @return int value
     */
    public static int getInt(Scanner sc, String prompt)
    {
        boolean isValid = false;
        int i = 0;
        while (isValid == false)
        {
            System.out.print(prompt);
            if (sc.hasNextInt())
            {
                i = sc.nextInt();
                isValid = true;
            }
            else
            {
                System.out.println("Error! Invalid integer value. Try again.");
            }
            sc.nextLine();
        }
        return i;
    }

    /**
     * To Get input value for int
     * @param sc Scanner
     * @param prompt message string
     * @param min int value
     * @param max int value
     * @return int value in range
     */
    public static int getInt(Scanner sc, String prompt, int min, int max)
    {
        int i = 0;
        boolean isValid = false;
        while (isValid == false)
        {
            i = getInt(sc, prompt);
            if (i < min)
                System.out.println("Error! Number must be greater than " + min);
            else if (i > max)
                System.out.println("Error! Number must be less than " + max);
            else
                isValid = true;
        }
        return i;
    }

    /**
     * To get input value as double
     * @param sc Scanner
     * @param prompt string message
     * @return double value
     */
    public static double getDouble(Scanner sc, String prompt)
    {
        boolean isValid = false;
        double d = 0;
        while (isValid == false)
        {
            System.out.print(prompt);
            if (sc.hasNextDouble())
            {
                d = sc.nextDouble();
                isValid = true;
            }
            else
            {
                System.out.println("Error! Invalid decimal value. Try again.");
            }
            sc.nextLine();  // discard any other data entered on the line
        }
        return d;
    }

    /**
     * To get input value as BigDecimal
     * @param sc Scanner
     * @param prompt string message
     * @return big decimal value
     */
    public static BigDecimal getBigDecimal(Scanner sc, String prompt)
    {
        boolean isValid = false;
        double d = 0;
        while (isValid == false)
        {
            System.out.print(prompt);
            if (sc.hasNextDouble())
            {
                d = sc.nextDouble();
                isValid = true;
            }
            else
            {
                System.out.println("Error! Invalid decimal value. Try again.");
            }
            sc.nextLine(); 
        }
        return new BigDecimal(d);
    }

}