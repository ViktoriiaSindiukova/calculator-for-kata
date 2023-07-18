import java.beans.Introspector;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception {
        System.out.print("Input: ");
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        calculate(str);
    }

    public static String calculate(String input) throws Exception {
        String[] strArray = input.split(" ");
        if (strArray.length != 3){ throw new Exception("Sorry, try again."); }
        String result = null;
        int var1 = 0;
        String action;
        int var2 = 0;

        try {
            RomanNumber num1 = RomanNumber.valueOf(strArray[0]);
            RomanNumber num2 = RomanNumber.valueOf(strArray[2]);
            action = strArray[1];
            var1 = num1.translation();
            var2 = num2.translation();
            int res = calc(var1, action, var2);
            RomanNumber[] volue = RomanNumber.values();
            result = String.valueOf(volue[res - 1]);
            printResult(result);
        } catch (Exception e){

        }
        try {
            var1 = Integer.parseInt(strArray[0]);
            action = strArray[1];
            var2 = Integer.parseInt(strArray[2]);
            result = Integer.toString(calc(var1, action, var2));
            printResult(result);

        } catch (Exception e) {
            System.out.println("Sorry, try again.");
        }

        return result;

    }

    public static int calc(int a, String act, int b) throws Exception{
        int result = 0;
            if (a > 0 && a <= 10 && b > 0 && b <= 10) {
                switch (act) {
                    case "+":
                        result = a + b;
                        break;
                    case "-":
                        result = a - b;
                        break;
                    case "*":
                        result = a * b;
                        break;
                    case "/":
                        result = a / b;
                        break;
                    default:
                        throw new Exception("Sorry, try again.");
                }
            } else {
                throw new Exception("Sorry, try again.");
            }

        return result;
    }

    public static void printResult(String result) {
        System.out.println("Output: " + result);
        System.exit(0);
    }




}