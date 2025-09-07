package br.com.junior.rest_with_spring_boot_and_java_erudio.commons;

import br.com.junior.rest_with_spring_boot_and_java_erudio.exception.UnsuportedMathOperationException;
import org.springframework.stereotype.Service;

@Service
public class MathUtils implements IValidatorMath {

    private static final String MSG_SET_A_NUMERIC_NUMBER = "Please set a numeric value!";

    @Override
    public void validated(String firstNumber, String secondNumber) throws UnsuportedMathOperationException {
        if (!this.isNumeric(firstNumber) || !this.isNumeric(secondNumber)) {
            throw new UnsuportedMathOperationException(MSG_SET_A_NUMERIC_NUMBER);
        }
    }

    @Override
    public void validated(String strNumber) throws UnsuportedMathOperationException {
        if (!this.isNumeric(strNumber)) {
            throw new UnsuportedMathOperationException(MSG_SET_A_NUMERIC_NUMBER);
        }
    }

    @Override
    public Double convertToDouble(String strNumber) throws UnsuportedMathOperationException {
        if (strNumber == null || strNumber.isEmpty())
            throw new UnsuportedMathOperationException(MSG_SET_A_NUMERIC_NUMBER);
        String number = strNumber.replace(",", ".");
        return Double.parseDouble(number);
    }

    @Override
    public Boolean isNumeric(String strNumber) {
        if (strNumber == null || strNumber.isEmpty()) return false;
        String number = strNumber.replace(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

    @Override
    public boolean isZero(String strNumber) {
        return convertToDouble(strNumber) == 0.0;
    }
}
