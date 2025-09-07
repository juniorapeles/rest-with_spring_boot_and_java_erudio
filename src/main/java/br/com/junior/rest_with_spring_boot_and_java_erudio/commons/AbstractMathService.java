package br.com.junior.rest_with_spring_boot_and_java_erudio.commons;

import br.com.junior.rest_with_spring_boot_and_java_erudio.services.IMathService;

public abstract class AbstractMathService implements IMathService {

    protected final IValidatorMath validatorMath;

    protected AbstractMathService(IValidatorMath validatorMath) {
        this.validatorMath = validatorMath;
    }

    protected Double toDouble(String number) {
        validatorMath.validated(number);
        return validatorMath.convertToDouble(number);
    }

    protected Double toDouble(String first, String second) {
        validatorMath.validated(first, second);
        return null; // placeholder, cada operação usa os dois números separados
    }
}
