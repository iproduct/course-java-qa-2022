package course.qa.hello;

import java.util.Date;
import course.qa.formatter.HelloFormatter;
import java.util.Scanner;

public class HelloJava {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter your name:");
        String name = sc.nextLine();
        HelloFormatter hf = new HelloFormatter();
        System.out.println(hf.format(name));
        System.out.println(new Date());
    }
}
