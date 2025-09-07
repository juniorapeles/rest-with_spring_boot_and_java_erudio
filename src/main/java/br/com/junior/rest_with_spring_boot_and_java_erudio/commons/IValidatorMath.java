package br.com.junior.rest_with_spring_boot_and_java_erudio.commons;

import br.com.junior.rest_with_spring_boot_and_java_erudio.exception.UnsuportedMathOperationException;

public interface IValidatorMath {

    void validated(String firstNumber, String secondNumber) throws UnsuportedMathOperationException;

    void validated(String strNumber) throws UnsuportedMathOperationException;

    Double convertToDouble(String number) throws UnsuportedMathOperationException;

    Boolean isNumeric(String number)  throws UnsuportedMathOperationException;

    boolean isZero(String strNumber);
}
