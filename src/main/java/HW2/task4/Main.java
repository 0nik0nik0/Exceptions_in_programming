//Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку.
// Пользователю должно показаться сообщение, что пустые строки вводить нельзя.


package HW2.task4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
        public static void main(String[] args) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Type any text:");
            try {
                String result = reader.readLine();
                if(result.equals("")) throw new RuntimeException("Empty string is not acceptable! Restart program to try again");

                System.out.println("Your text is: " + result);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
