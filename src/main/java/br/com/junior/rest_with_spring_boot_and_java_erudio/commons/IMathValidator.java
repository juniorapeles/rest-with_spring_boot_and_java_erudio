package br.com.junior.rest_with_spring_boot_and_java_erudio.commons;

public interface IMathValidator {
    void validateNumeric(String value);
    void validateNonZero(Double value);
    void validateNonNegative(Double value);
}

