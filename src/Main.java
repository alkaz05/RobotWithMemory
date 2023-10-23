import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("input.txt"));
        String program = scan.next();

        Robot rob = new Robot(0, 0, 'С');

        int result = rob.runProgram(program);
        System.out.println(result);
        System.out.println(rob.memory);
    }
}