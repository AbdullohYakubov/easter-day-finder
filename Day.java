import java.util.Scanner;

public class Day{
    private int year;
    private int month;
    private int day;

    public Day(int _year, int _month, int _day){
        this.year = _year;
        this.month = _month;
        this.day = _day;
    }

    public Day findEasterDay(int _year){
        // start of the algorithm
        int a = _year % 19;
        int b = _year / 100;
        int c = _year % 100;
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
        int p = (h + l - 7 * m + 114) % 31;
        int easterDate = p + 1; // (date in Easter Month)
        // end of the algorithm

        // Returning a new object of Type Day
        return new Day(_year, easterMonth, easterDate); 
    }

    public String toString(){
        String easterMonthName = month == 3 ? "March" : "April";
        return "Easter in " + this.year + " falls on the " + this.day + "th of " + easterMonthName;
    }

    public static void main(String[] args){
        Scanner src = new Scanner(System.in);
        System.out.print("Enter the year: ");
        int year = src.nextInt();

        Day easterDay = new Day(0, 0, 0);
        Day easter = easterDay.findEasterDay(year);
        
        System.out.println(easter);
    }
}