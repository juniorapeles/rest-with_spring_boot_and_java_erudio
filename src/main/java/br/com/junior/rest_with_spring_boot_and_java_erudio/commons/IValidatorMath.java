package br.com.junior.rest_with_spring_boot_and_java_erudio.commons;

import br.com.junior.rest_with_spring_boot_and_java_erudio.exception.UnsuportedMathOperationException;

public interface IValidatorMath {
    public static final String MSG_SET_A_NUMERIC_NUMBER = "Please set a numeric value!";
    public static final int AVERAGE_NUMBER = 2;
    public static final String MSG_VALIDATION_GREATER_NUMBER = "Please enter a number greater than 0";

    Double convertToDouble(String number) throws UnsuportedMathOperationException;
    Boolean isNumeric(String number)  throws UnsuportedMathOperationException;
    boolean isZero(String strNumber);
}
