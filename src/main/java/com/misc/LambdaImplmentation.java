public class LambdaImplmentation {
    public static void main(String[] args) {
        new Thread(() -> System.out.println("Running Lambda")).start();
    }
}
