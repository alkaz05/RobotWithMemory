public class Main {
    public static void main(String[] args) {
        Robot rob = new Robot(0, 0, 'С');
        rob.stepForward();
        rob.stepForward();
        System.out.println(rob.memory);
    }
}