package br.com.junior.rest_with_spring_boot_and_java_erudio.commons;

import br.com.junior.rest_with_spring_boot_and_java_erudio.exception.UnsuportedMathOperationException;
import org.springframework.stereotype.Component;

@Component
public class MathValidatorImpl implements IMathValidator {

    public static final String MSG_UNSUPORTED = "O valor deve ser numérico: ";
    public static final String MSG_UNSUPORTED_DIVISION_BY_ZERO = "Divisão por zero não é permitida";
    public static final String MSG_NON_NEGTIVE_NUMBER_IN_SQRT = "Número negativo não permitido para raiz quadrada: ";

    @Override
    public void validateNumeric(String value) {
        if (value == null || !value.matches("-?\\d+(\\.\\d+)?")) {
            throw new UnsuportedMathOperationException(MSG_UNSUPORTED + value);
        }
    }

    @Override
    public void validateNonZero(Double value) {
        if (value == 0) {
            throw new UnsuportedMathOperationException(MSG_UNSUPORTED_DIVISION_BY_ZERO);
        }
    }

    @Override
    public void validateNonNegative(Double value) {
        if (value < 0) {
            throw new UnsuportedMathOperationException(MSG_NON_NEGTIVE_NUMBER_IN_SQRT + value);
        }
    }
}
