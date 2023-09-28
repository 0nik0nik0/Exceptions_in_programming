package HW3.model.exceptions;

public class DateOfBirthException extends Exception {

    String inputString;

    public DateOfBirthException(String inputString) {
        this.inputString = inputString;
    }

    @Override
    public String getMessage() {
        return "Incorrect input of DateOfBirth '" + inputString + "', correct from is: 'dd.mm.yyyy'.\n";
    }
}
