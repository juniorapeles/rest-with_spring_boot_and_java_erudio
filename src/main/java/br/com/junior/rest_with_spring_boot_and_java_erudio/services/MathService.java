package br.com.junior.rest_with_spring_boot_and_java_erudio.services;

import br.com.junior.rest_with_spring_boot_and_java_erudio.commons.AMessageValidator;
import br.com.junior.rest_with_spring_boot_and_java_erudio.commons.IValidatorMath;
import br.com.junior.rest_with_spring_boot_and_java_erudio.exception.UnsuportedMathOperationException;
import org.springframework.stereotype.Service;

@Service
public class MathService extends AMessageValidator implements IMathService{

    IValidatorMath validatorMath;

    @Override
    public Double sum(String first, String second) throws UnsuportedMathOperationException {
        if (!validatorMath.isNumeric(first) || !validatorMath.isNumeric(second))
            throw new UnsuportedMathOperationException(MSG_SET_A_NUMERIC_NUMBER);
        return validatorMath.convertToDouble(first) + validatorMath.convertToDouble(second);
    }

    @Override
    public Double sub(String first, String second) {
        if (!validatorMath.isNumeric(first) || !validatorMath.isNumeric(second))
            throw new UnsuportedMathOperationException(MSG_SET_A_NUMERIC_NUMBER);
        return validatorMath.convertToDouble(first) - validatorMath.convertToDouble(second);
    }

    @Override
    public Double mul(String first, String second) {
        if (!validatorMath.isNumeric(first) || !validatorMath.isNumeric(second))
            throw new UnsuportedMathOperationException(MSG_SET_A_NUMERIC_NUMBER);
        return validatorMath.convertToDouble(first) * validatorMath.convertToDouble(second);
    }

    @Override
    public Double div(String first, String second) {
        if (!validatorMath.isNumeric(first) || !validatorMath.isNumeric(second))
            throw new UnsuportedMathOperationException(MSG_SET_A_NUMERIC_NUMBER);

        if (validatorMath.isZero(first) || validatorMath.isZero(second))
            throw new UnsuportedMathOperationException(MSG_VALIDATION_GREATER_NUMBER);

        return validatorMath.convertToDouble(first) / validatorMath.convertToDouble(second);
    }

    @Override
    public Double sqrt(String number) {
        if (!validatorMath.isNumeric(number))
            throw new UnsuportedMathOperationException(MSG_SET_A_NUMERIC_NUMBER);
        return Math.sqrt(validatorMath.convertToDouble(number));
    }

    @Override
    public Double avg(String first, String second) {
        return this.sum(first, second) / AVERAGE_NUMBER;
    }

}
