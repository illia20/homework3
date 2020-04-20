package homework3;

import java.io.*;
import java.util.Scanner;

public class FileStudents {
    final static String filePath = "Students.txt";
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            File f = new File(filePath);
            if(!f.exists()){
                f.createNewFile();
            }
            String student;
            System.out.println("Enter ФИО of student: ");
            while (!(student = scanner.nextLine()).isEmpty()){
                student = student.trim();
                if(!findStudent(f, student)){
                    writeStudent(f, student);
                }
                System.out.println("Enter ФИО of student: ");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public static boolean findStudent(File file, String student) {
        try(BufferedReader bf = new BufferedReader(new FileReader(file))){
            String line, surname;
            String input = student.substring(0, student.indexOf(' '));
            while ((line = bf.readLine()) != null){
                surname = line.substring(0, line.indexOf(' '));
                if(surname.equals(input)){
                    return true;
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public static void writeStudent(File file, String student){
        try (PrintWriter pw = new PrintWriter(new FileWriter(filePath, true))){
            pw.println(student);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
