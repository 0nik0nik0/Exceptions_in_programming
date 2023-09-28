package HW3.presenter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import HW3.model.exceptions.ParsingDataStringException;
import HW3.model.InputCheck;
import HW3.view.View;

public class Presenter< V extends View> {

    private InputCheck model;
    private V view;

    public Presenter(V v) {
        view = v;
    }

    public void start() {
        boolean process = true;
        do {
            String input = view.getInput(
                    "Enter the data according to the example: 'LastName FirstName Patronymic DateOfBirth Phone Gender', or 'q' to exit:");
            if (input.equals("q")) {
                break;
            } else {
                String[] splitedInput = input.replaceAll("\\s+", " ").split(" ");

                int inputCount = checkInputCount(splitedInput.length);
                if (inputCount == -1) {
                    view.printOutput("Incorrect input (should be " + InputCheck.dataCount
                            + " fields, separated by a space ' ': LastName FirstName Patronymic DateOfBirth Phone Gender)\n");
                } else if (inputCount == 0) {
                    view.printOutput("Incorrect input (should be " + InputCheck.dataCount
                            + " fields, separated by a space ' ': LastName FirstName Patronymic DateOfBirth Phone Gender)\n");
                } else {
                    try {
                        model = new InputCheck();
                        model.InputCheck(splitedInput);
                        addPerson(model);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (ParsingDataStringException e) {
                        view.printOutput(e.getMessage());
                    }
                }
            }
        } while (process);
    }

    // проверяем кол-во введённых данных и выдаем код ошибки при несоответствии
    private int checkInputCount(int inputCount) {
        if (inputCount < InputCheck.dataCount) {
            return -1;
        } else if (inputCount > InputCheck.dataCount) {
            return 0;
        } else {
            return inputCount;
        }
    }

    //делаем новый файл или добавляем в существующий при совпадении фамилии
    private void addPerson(InputCheck data) throws IOException {
        File filepath = new File(data.getLastName());
        try (FileWriter fw = new FileWriter(filepath, true)) {
            fw.append(data.toString() + "\n");
        } catch (IOException e) {
            throw e;
        }
    }
}
