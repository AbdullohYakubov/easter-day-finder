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

    // Return type is Day since we are returning an object of type Day
    public Day findEasterDay(int _year){
        // Start of the algorithm
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
        // End of the algorithm

        // Returning a new object of type Day that takes three arguments: _year which is the param of this method which in turn takes the year that the user inputs as an argument; easterMonth and easterDate which are the values calculated in this method.
        return new Day(_year, easterMonth, easterDate); 
    }

    // Overriding the default toString() method so that when we call an intance of Day class, we will get a human readable string instead of the memory location of that object in RAM.
    public String toString(){
        // Using simple ternary operator to store the name of the month
        String easterMonthName = month == 3 ? "March" : "April";
        return "Easter in " + this.year + " falls on the " + this.day + "th of " + easterMonthName;
    }

    public static void main(String[] args){
        Scanner src = new Scanner(System.in);
        System.out.print("Enter the year: ");
        int year = src.nextInt();

        // Creating an object of type Day. We only need this object so that we can call the findEasterDay() method. We need an object to be able to call this method. It's arguments do not matter at all which is why we simply pass on 0's.
        Day easterDay = new Day(0, 0, 0);
        // Since the findEasterDay() method returns a new object of type Day and we need to store it in a variable to be able to use it later somewhere in the code, we create a variable of type Day.
        Day easter = easterDay.findEasterDay(year);
        // Printing the object to the user. There are two ways to print the result. We can either make the findEasterDay() method static and call it through the class directly without creating objects off of that class or we can keep the method non-static and call the method on an object.
        // System.out.println(Day.findEasterDay(year));
        System.out.println(easter);
    }
}