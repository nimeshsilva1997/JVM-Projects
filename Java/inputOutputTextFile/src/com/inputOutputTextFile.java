package com;


//program due October 11th, no class on October 4th
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Scanner;

public class inputOutputTextFile {
    // reason declared up here is that it can be used throughout the program
    Scanner inFile;
    PrintWriter outFile;
    private String lastName;
    private String firstName;
    private String letterGrade;
    private double score;

    // created global variables used throughout the program
    public static int count = 0, sumAPlus = 0, sumA = 0, sumAMinus = 0, sumBPlus = 0, sumB = 0, sumBMinus = 0,
            sumCPlus = 0, sumC = 0, sumCMinus = 0, sumDPlus = 0, sumD = 0, sumDMinus = 0, sumF = 0;
    public static double sum = 0; // allows for the average to show the two decimal places

    // create an object of programming
    public static void main(String[] args) {
        @SuppressWarnings("unused")
        inputOutputTextFile SilvaProject2 = new inputOutputTextFile();

    }

    inputOutputTextFile() {
        @SuppressWarnings({ "unused", "resource" })
        Scanner in = new Scanner(System.in);
        try // used to catch something
        {
            inFile = new Scanner(new File("scores.txt")); // program looks for the file in your File Explorer
            outFile = new PrintWriter(new FileWriter("report.txt")); // once program is finish, program the creates
            // the output file in the directory of the
            // File Explorer
            heading();
            readData();
            inFile.close();
            outFile.close();
        } catch (Exception e) // exception e is used as a variable

        {
            if (e instanceof FileNotFoundException) {
                System.out.println("FILENAME NOT FOUND");
                System.exit(1);
            }
        }

    }

    public void readData() throws IOException {

        letterGradeRanges(); // calls method for if else method
        outputArthmetics(); // calls methods for printing in the output file
    }

    // tells that you can spin through your file
    public void record() throws IOException // take the value you have in quality and print it to the output
    // file
    {
        outFile.print(firstName + " " + lastName + "\t\t");
        outFile.print(letterGrade + "\t" + "  ");
        outFile.println(score);
    }

    public void heading() throws IOException {
        // prints title, current date, and time
        Calendar today = Calendar.getInstance();

        outFile.print("\t\t\tExam Results Report \n\n");
        outFile.println("\t\t\t\t" + today.getTime());
        outFile.println();
        outFile.print("Student Name\t Letter Grade\t Score\n");
        outFile.print("=======================================");
        outFile.println();
    }

    public void letterGradeRanges() throws IOException {

        // allows you to parse your data
        inFile.useDelimiter(",|\\n");

        while (inFile.hasNext()) {
            // return a string data type
            score = inFile.nextInt();
            lastName = inFile.next();
            firstName = inFile.next();
            count++; // counter
            sum += score; // increments score by 1

            // if statements for the letter grade ranges, including pluses and minuses
            if (score >= 97.00 && score <= 100.00) {
                letterGrade = "A+";
                sumAPlus++;
            } else if (score >= 93.00 && score <= 96.99) {
                letterGrade = "A";
                sumA++;
            } else if (score >= 90.00 && score <= 92.99) {
                letterGrade = "A-";
                sumAMinus++;
            } else if (score >= 87.00 && score <= 89.99) {
                letterGrade = "B+";
                sumBPlus++;
            } else if (score >= 83.00 && score <= 86.99) {
                letterGrade = "B";
                sumB++;
            } else if (score >= 80.00 && score <= 82.99) {
                letterGrade = "B-";
                sumBMinus++;
            } else if (score >= 77.00 && score <= 79.99) {
                letterGrade = "C+";
                sumCPlus++;
            } else if (score >= 73.00 && score <= 76.99) {
                letterGrade = "C";
                sumC++;
            } else if (score >= 70.00 && score <= 72.99) {
                letterGrade = "C-";
                sumCMinus++;
            } else if (score >= 67.00 && score <= 69.99) {
                letterGrade = "D+";
                sumDPlus++;
            } else if (score >= 63.00 && score <= 66.99) {
                letterGrade = "D";
                sumD++;
            } else if (score >= 60.00 && score <= 62.99) {
                letterGrade = "D-";
                sumDMinus++;
            } else if (score <= 59.99) {
                letterGrade = "F";
                sumF++;
            }

            record(); // prints record method

        } // end while loop
    }

    public void outputArthmetics() {
        // printing to the output file
        outFile.println(" ");
        outFile.println("There's a total of " + count + " students that took the exam, so "
                + "the total number of exams are " + count + ".");
        outFile.println(" ");

        outFile.println("Total number A+ 's are " + sumAPlus + ".");

        outFile.println("Total number of A 's are " + sumA + ".");

        outFile.println("Total number of A- 's are " + sumAMinus + ".");

        outFile.println("Total number of B+ 's are " + sumBPlus + ".");

        outFile.println("Total number of B 's are " + sumB + ".");

        outFile.println("Total number of B- 's are " + sumBMinus + ".");

        outFile.println("Total number of C+ 's are " + sumCPlus + ".");

        outFile.println("Total number of C 's are " + sumC + ".");

        outFile.println("Total number of C- 's are " + sumCMinus + ".");

        outFile.println("Total number of D+ 's are " + sumDPlus + ".");

        outFile.println("Total number of D 's are " + sumD + ".");

        outFile.println("Total number of D- 's are " + sumDMinus + ".");

        outFile.println("Total number of F 's are " + sumF + ".");

        outFile.println(" ");
        double average = (sum / count); // formula for finding the average

        outFile.print("Total Average of Exams are " + String.format("%.2f", average) + "%"); // rounds answer to two
        // decimal places
    }

}

