package HW3.model.exceptions;

public class FullNameException extends Exception {

    String inputString;

    public FullNameException(String inputString) {
        this.inputString = inputString;
    }

    @Override
    public String getMessage() {
        return "Incorrect FullName input '" + inputString + "'. should contain only letters.\n";
    }
}