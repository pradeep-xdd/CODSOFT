import java.util.Scanner;

public class Task_2_GradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter number of subjects");
        int subjects = sc.nextInt();
        
        double totalMarks = 0;
        
        System.out.println("Enter marks for each subject (out of 100)");
        for (int i = 1; i <= subjects; i++) {
            System.out.print("Subject " + i + "=");
            double marks = sc.nextDouble();
            
            if (marks < 0 || marks > 100) {
                System.out.println("Invalid marks! Please enter between 0-100");
                i--;
                continue;
            }
            
            totalMarks += marks;
        }
        
        double average = totalMarks / subjects;
        String grade;
        
       
        if (average >= 90) {
            grade = "A+";
        } else if (average >= 80) {
            grade = "A";
        } else if (average >= 70) {
            grade = "B";
        } else if (average >= 60) {
            grade = "C";
        } else if (average >= 50) {
            grade = "D";
        } else {
            grade = "F";
        }
        
        
        
        System.out.println("Total Marks=" + totalMarks );
        System.out.println("Average Percentage="+ average);
        System.out.println("Grade= " + grade);
        
        
    }
}
