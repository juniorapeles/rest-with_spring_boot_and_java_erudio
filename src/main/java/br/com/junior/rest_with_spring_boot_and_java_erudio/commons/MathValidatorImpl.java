package br.com.junior.rest_with_spring_boot_and_java_erudio.commons;

import br.com.junior.rest_with_spring_boot_and_java_erudio.exception.UnsuportedMathOperationException;
import org.springframework.stereotype.Component;

@Component
public class MathValidatorImpl implements IMathValidator {

    @Override
    public void validateNumeric(String value) {
        if (value == null || !value.matches("-?\\d+(\\.\\d+)?")) {
            throw new UnsuportedMathOperationException("O valor deve ser numérico: " + value);
        }
    }

    @Override
    public void validateNonZero(Double value) {
        if (value == 0) {
            throw new UnsuportedMathOperationException("Divisão por zero não é permitida");
        }
    }

    @Override
    public void validateNonNegative(Double value) {
        if (value < 0) {
            throw new UnsuportedMathOperationException("Número negativo não permitido para raiz quadrada: " + value);
        }
    }
}
