package HW3.model.exceptions;

public class PhoneException extends Exception {
    String inputString;

    public PhoneException(String inputString) {
        this.inputString = inputString;
    }

    @Override
    public String getMessage() {
        return "Incorrect Phone input " + inputString + ". Should contain only 11 digits without additional characters, please check  input\n";
    }
}