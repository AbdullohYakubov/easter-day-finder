import java.util.Scanner;

public class Day{
    public static void main(String[] args){
        Scanner src = new Scanner(System.in);
        System.out.println("Enter the year: ");
        int year = src.nextInt();

        int a = year % 19;
        int b = year / 100;
        int c = year % 100;
        int d = b / 4;
        int e = b % 4;
        int f = (b + 8) / 25;
        int g = (b - f + 1) / 3;
        int h = (19 * a + b - d - g + 15) % 30;
        int i = c / 4;
        int k = c % 4;
        int l = (32 + 2 * e + 2 * i - h - k) % 7;
        int m = (a + 11 * h + 22 * l) / 451;
        int easterMonth = (h + l - 7 * m + 114) / 31; // [3=March, 4=April]
        String month = null;
        switch(easterMonth){
            case 1: month = "January"; break;
            case 2: month = "February"; break;
            case 3: month = "March"; break;
            case 4: month = "April"; break;
            case 5: month = "May"; break;
            case 6: month = "June"; break;
            case 7: month = "July"; break;
            case 8: month = "August"; break;
            case 9: month = "September"; break;
            case 10: month = "October"; break;
            case 11: month = "November"; break;
            case 12: month = "December"; break;
        }
        int p = (h + l - 7 * m + 114) % 31;
        int easterDate = p + 1;    // (date in Easter Month)
        System.out.println("Easter on this year falls on the " + easterDate + "th of " + month);
    }
}