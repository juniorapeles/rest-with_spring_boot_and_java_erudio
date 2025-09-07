package br.com.junior.rest_with_spring_boot_and_java_erudio.services;

import br.com.junior.rest_with_spring_boot_and_java_erudio.commons.IMathValidator;
import org.springframework.stereotype.Service;

@Service
public class MathService implements IMathService {

    private static final int AVERAGE_NUMBER = 2;
    private static final String MSG_DIVIDE_BY_ZERO = "Cannot divide by zero";

    private final IMathValidator validator;

    public MathService(IMathValidator validator) {
        this.validator = validator;
    }

    @Override
    public Double sum(Double first, Double second) {
        return first + second;
    }

    @Override
    public Double sub(Double first, Double second) {
        return first - second;
    }

    @Override
    public Double mul(Double first, Double second) {
        return first * second;
    }

    @Override
    public Double div(Double first, Double second) {
        validator.validateNonZero(second);
        return first / second;
    }

    @Override
    public Double sqrt(Double number) {
        validator.validateNonNegative(number);
        return Math.sqrt(number);
    }

    @Override
    public Double avg(Double first, Double second) {
        return sum(first, second) / AVERAGE_NUMBER;
    }
}
