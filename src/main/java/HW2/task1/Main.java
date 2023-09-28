//Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float),
// и возвращает введенное значение. Ввод текста вместо числа не должно приводить к падению
// приложения, вместо этого, необходимо повторно запросить у пользователя ввод данных.
package HW2.task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        boolean test = true;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while(test){
            System.out.print("Type a float number: ");
            try{
                float floatNum = Float.parseFloat(reader.readLine());
                System.out.printf("Your entered number is %f\n", floatNum);
                test = false;
            } catch (IOException|NumberFormatException e) {
                System.out.println("Not float number, please try again!");
            }

        }
    }
}