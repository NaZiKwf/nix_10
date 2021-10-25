package ua.com.alevel;

public class Main {

    public static void main(String[] args) {

        System.out.println("Enter string with numbers");
        SumOfNumbers Task1 = new SumOfNumbers();
        Task1.SumOfNumbers();

        System.out.println("Enter string");
        SortedSymbols Task2 = new SortedSymbols();
        Task2.SortedSymbols();

        System.out.println("Enter number of lesson");
        SchoolSchedule Task3 = new SchoolSchedule();
        Task3.SchoolSchedule();
    }
}
