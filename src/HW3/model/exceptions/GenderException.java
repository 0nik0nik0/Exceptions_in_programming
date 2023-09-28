package HW3.model.exceptions;

public class GenderException extends Exception {
    String inputString;

    public GenderException(String inputString) {
        this.inputString = inputString;
    }

    @Override
    public String getMessage() {
        return "Incorrect Gender input (possible to use only 'f' (female) and 'm' (male)), please correct: '" + inputString + "'\n";
    }
}
