package optum.concepts.features;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TryWithResources {
    public static void main(String[] args) {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        File file = new File(classLoader.getResource("jobs.txt").getFile());
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            System.out.println(br.readLine());

        } catch (IOException i) {
            System.out.println(i);
        }
    }
}
