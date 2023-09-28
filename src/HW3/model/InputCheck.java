package HW3.model;

import HW3.model.exceptions.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class InputCheck {
    public static int dataCount = 6;

    private String firstName;
    private String lastName;
    private String patronymicName;
    private LocalDate dateOfBirth;
    private Long phone;
    private Gender gender;

    public InputCheck() {
    }

    public void InputCheck(String[] splitedString) throws ParsingDataStringException {
        if (splitedString == null) {
            throw new NullPointerException("Incorrect input. No data.");
        }

        StringBuilder fullErrorsMessages = new StringBuilder();
        for (String string : splitedString) {
            if (Character.isLetter(string.charAt(0))) {
                if (string.length() == 1) {
                    if (this.gender == null) {
                        try {
                            this.gender = checkGender(string);
                        } catch (GenderException e) {
                            fullErrorsMessages.append(e.getMessage());
                        }
                    } else {
                        fullErrorsMessages.append("Gender is specified more than needed, please check the input\n");
                    }
                } else {
                    if (this.lastName == null) {
                        try {
                            this.lastName = checkFullName(string);
                        } catch (FullNameException e) {
                            fullErrorsMessages.append(e.getMessage());
                        }
                    } else if (this.firstName == null) {
                        try {
                            this.firstName = checkFullName(string);
                        } catch (FullNameException e) {
                            fullErrorsMessages.append(e.getMessage());
                        }
                    } else if (this.patronymicName == null) {
                        try {
                            this.patronymicName = checkFullName(string);
                        } catch (FullNameException e) {
                            fullErrorsMessages.append(e.getMessage());
                        }
                    } else {
                        fullErrorsMessages.append("Too many elements are recognized as Full Name. Please check the input\n");
                    }
                }
            } else {

                if (string.matches("[0-9]{2}\\.[0-9]{2}\\.[0-9]{4}")) {
                    if (this.dateOfBirth == null) {
                        try {
                            this.dateOfBirth = checkBirthDate(string);
                        } catch (DateOfBirthException e) {
                            fullErrorsMessages.append(e.getMessage());
                        }
                    } else {
                        fullErrorsMessages.append("Should be only one date of birth, please check the input: '"
                                + this.dateOfBirth + "','" + string + "'\n");
                    }
                } else {
                    if (this.phone == null) {
                        try {
                            this.phone = checkPhone(string);
                        } catch (PhoneException e) {
                            fullErrorsMessages.append(e.getMessage());
                        }
                    } else {
                        fullErrorsMessages.append("Should be only one phone number, please check the input: '"
                                + this.phone + "','" + string + "'\n");
                    }
                }

            }
        }
        if (!fullErrorsMessages.isEmpty()) {
            throw new ParsingDataStringException(fullErrorsMessages.toString());
        }
    }

    public String getLastName() {
        return lastName;
    }

    private String checkFullName(String inputString) throws FullNameException {
        if (inputString.toLowerCase().matches("^[a-zа-яё]*$")) {
            return inputString;
        } else {
            throw new FullNameException(inputString);
        }
    }

    private long checkPhone(String inpuString) throws PhoneException {
        if (inpuString.length() == 11) {
            try {
                return Long.parseLong(inpuString);
            } catch (NumberFormatException e) {
                throw new PhoneException(inpuString);
            }
        } else {
            throw new PhoneException(inpuString);
        }
    }

    private Gender checkGender(String inputString) throws GenderException {
        try {
            return Gender.valueOf(inputString);
        } catch (IllegalArgumentException e) {
            throw new GenderException(inputString);
        }
    }

    private LocalDate checkBirthDate(String inputString) throws DateOfBirthException {
        try {
            return LocalDate.parse(inputString,
                    DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        } catch (DateTimeParseException e) {
            throw new DateOfBirthException(inputString);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<").append(lastName).append(">")
                .append("<").append(firstName).append(">")
                .append("<").append(patronymicName).append(">")
                .append("<").append(dateOfBirth.toString()).append(">")
                .append("<").append(phone).append(">")
                .append("<").append(gender).append(">");
        return sb.toString();
    }

}