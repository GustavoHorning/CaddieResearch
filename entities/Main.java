package entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        String path = "C:/Users/gusta/OneDrive - Empresarial/Downloads/projeto.txt";


        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();

            while (line != null) {
                String[] result = line.split(";");
                for (int i = 0; i < result.length ; i++) {
                    System.out.print(result[i] + " ");
                }
                line = br.readLine();
            }

        }
        catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
