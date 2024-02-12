import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;


public class Sorter {

    public static void main(String[] args) {
        ArrayList<String> Students = new ArrayList<>();
        try {
            File myObj = new File("C:\\Users\\mohmm\\Desktop\\SWE206\\Lab3\\src\\Lab1-data.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                Students.add(myReader.nextLine());
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        Scanner scanner = new Scanner(System.in);

        System.out.print("what method you want to use: ");
        int methodNum = scanner.nextInt();


        while(methodNum != 1 && methodNum != 2){
            System.out.println("invalid input, choose 1 or 2 ");

            System.out.print("what method you want to use: ");
            methodNum = scanner.nextInt();

        }

        if(methodNum == 1){
            System.out.println("enter the number of groups: ");
            int groupsNum = scanner.nextInt();
            method1(groupsNum,Students);
        }

        else {
            System.out.println("enter the maximum number of students in each group: ");
            int maxNum = scanner.nextInt();
            method2(maxNum,Students);
        }

    }

    public static void method1 (int GroupsNum, ArrayList<String> Students){
        ArrayList<ArrayList<String>> Groups = new ArrayList<>();
        int NumberOfStudents = Students.size();
        int maxInGroup = NumberOfStudents/GroupsNum;
        int overflow = NumberOfStudents%GroupsNum;
        int MaxRan = NumberOfStudents;
        Random random = new Random();
        int randomInt;

        for(int i = 0; i<GroupsNum; i++){
            ArrayList<String> Group = new ArrayList<>();
            if(i < GroupsNum-overflow){
                for(int j = 0; j<maxInGroup; j++){
                    randomInt = random.nextInt(NumberOfStudents);
                    NumberOfStudents = NumberOfStudents - 1;
                    Group.add(Students.get(randomInt));
                    Students.remove(randomInt);
                }
            }
            else{
                for(int j = 0; j<=maxInGroup; j++){

                    randomInt = random.nextInt(NumberOfStudents);
                    NumberOfStudents = NumberOfStudents - 1;
                    Group.add(Students.get(randomInt));
                    Students.remove(randomInt);
                }
            }
            Groups.add(Group);
        }
        for (ArrayList<String> group : Groups) {
            System.out.println(group);
        }
    }
    public static void method2(int maxNum, ArrayList<String> students){
        ArrayList<ArrayList<String>> Groups = new ArrayList<>();
        int numOfGroups = Math.ceilDiv(students.size(), maxNum);
        int randomInt;
        int NumberOfStudents = students.size();
        int overflow = NumberOfStudents%numOfGroups;
        Random random = new Random();

        for(int i = 0; i<numOfGroups; i++) {
            ArrayList<String> Group = new ArrayList<>();
            if(i < numOfGroups-overflow){
                for(int j = 0; j<maxNum-1; j++){

                    randomInt = random.nextInt(NumberOfStudents);
                    NumberOfStudents = NumberOfStudents - 1;
                    Group.add(students.get(randomInt));
                    students.remove(randomInt);
                }
            }
            else{
                for(int j = 0; j<maxNum; j++){

                    randomInt = random.nextInt(NumberOfStudents);
                    NumberOfStudents = NumberOfStudents - 1;
                    Group.add(students.get(randomInt));
                    students.remove(randomInt);
                }
            }
            Groups.add(Group);
        }
        for (ArrayList<String> group : Groups) {
            System.out.println(group);
        }
    }
}