package br.com.junior.rest_with_spring_boot_and_java_erudio.services;

import br.com.junior.rest_with_spring_boot_and_java_erudio.commons.AbstractMathService;
import br.com.junior.rest_with_spring_boot_and_java_erudio.commons.IValidatorMath;
import org.springframework.stereotype.Service;

@Service
public class MathService extends AbstractMathService {

    private static final int AVERAGE_NUMBER = 2;
    private static final String MSG_DIVIDE_BY_ZERO = "Cannot divide by zero";

    public MathService(IValidatorMath validatorMath) {
        super(validatorMath);
    }

    @Override
    public Double sum(String first, String second) {
        validatorMath.validated(first, second);
        return toDouble(first) + toDouble(second);
    }

    @Override
    public Double sub(String first, String second) {
        validatorMath.validated(first, second);
        return toDouble(first) - toDouble(second);
    }

    @Override
    public Double mul(String first, String second) {
        validatorMath.validated(first, second);
        return toDouble(first) * toDouble(second);
    }

    @Override
    public Double div(String first, String second) {
        validatorMath.validated(first, second);
        if (validatorMath.isZero(second)) {
            throw new IllegalArgumentException(MSG_DIVIDE_BY_ZERO);
        }
        return toDouble(first) / toDouble(second);
    }

    @Override
    public Double sqrt(String number) {
        return Math.sqrt(toDouble(number));
    }

    @Override
    public Double avg(String first, String second) {
        return sum(first, second) / AVERAGE_NUMBER;
    }
}
