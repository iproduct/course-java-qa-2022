package course.qa.hello;

import course.qa.formatter.HelloFormatter;
import course.qa.model.Person;

import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class HelloJava {
    public static void main(String[] args) {
//        System.out.println("Commnd line args: " + Arrays.toString(args));
//        Scanner sc= new Scanner(System.in);
//        System.out.println("Enter your name:");
//        String name = sc.nextLine();
//        HelloFormatter hf = new HelloFormatter();
//        System.out.println(hf.format(name));
//        System.out.println(new Date());

        Person p1 = new Person("John Doe");
        p1.setName("John Smith Doe");
        System.out.println(p1.getName());
    }
}
