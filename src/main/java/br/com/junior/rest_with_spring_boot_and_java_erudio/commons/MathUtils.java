package br.com.junior.rest_with_spring_boot_and_java_erudio.commons;

import br.com.junior.rest_with_spring_boot_and_java_erudio.exception.UnsuportedMathOperationException;

public class MathUtils implements IValidatorMath{


    @Override
    public Double convertToDouble(String strNumber) throws UnsuportedMathOperationException {
        if (strNumber == null || strNumber.isEmpty())
            throw new UnsuportedMathOperationException(MSG_SET_A_NUMERIC_NUMBER);
        String number = strNumber.replace(",", ".");
        return Double.parseDouble(number);
    }

    @Override
    public Boolean isNumeric(String strNumber) throws UnsuportedMathOperationException {
        if (strNumber == null || strNumber.isEmpty()) return false;
        String number = strNumber.replace(",", "."); // R$ 5,00 USD 5.0
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

    @Override
    public boolean isZero(String strNumber) {
        return strNumber.equals("0");
    }
}
