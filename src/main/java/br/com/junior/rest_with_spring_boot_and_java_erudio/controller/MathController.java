package br.com.junior.rest_with_spring_boot_and_java_erudio.controller;

import br.com.junior.rest_with_spring_boot_and_java_erudio.commons.IMathValidator;
import br.com.junior.rest_with_spring_boot_and_java_erudio.services.IMathService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/math")
public class MathController {

    private final IMathService mathService;
    private final IMathValidator validator;

    private static final String FIRST_SECOND = "/{first}/{second}";
    private static final String SUM_PATH = "/sum" + FIRST_SECOND;
    private static final String SUB_PATH = "/subtract" + FIRST_SECOND;
    private static final String MUL_PATH = "/multiply" + FIRST_SECOND;
    private static final String DIV_PATH = "/divide" + FIRST_SECOND;
    private static final String AVG_PATH = "/average" + FIRST_SECOND;
    private static final String SQRT_PATH = "/square-root/{number}";

    public MathController(IMathService mathService, IMathValidator validator) {
        this.mathService = mathService;
        this.validator = validator;
    }

    @GetMapping(SUM_PATH)
    public Double sum(@PathVariable String first, @PathVariable String second) {
        validator.validateNumeric(first);
        validator.validateNumeric(second);
        return mathService.sum(Double.parseDouble(first), Double.parseDouble(second));
    }

    @GetMapping(SUB_PATH)
    public Double subtract(@PathVariable String first, @PathVariable String second) {
        validator.validateNumeric(first);
        validator.validateNumeric(second);
        return mathService.sub(Double.parseDouble(first), Double.parseDouble(second));
    }

    @GetMapping(MUL_PATH)
    public Double multiply(@PathVariable String first, @PathVariable String second) {
        validator.validateNumeric(first);
        validator.validateNumeric(second);
        return mathService.mul(Double.parseDouble(first), Double.parseDouble(second));
    }

    @GetMapping(DIV_PATH)
    public Double divide(@PathVariable String first, @PathVariable String second) {
        validator.validateNumeric(first);
        validator.validateNumeric(second);
        Double secondVal = Double.parseDouble(second);
        validator.validateNonZero(secondVal);
        return mathService.div(Double.parseDouble(first), secondVal);
    }

    @GetMapping(SQRT_PATH)
    public Double squareRoot(@PathVariable String number) {
        validator.validateNumeric(number);
        Double num = Double.parseDouble(number);
        validator.validateNonNegative(num);
        return mathService.sqrt(num);
    }

    @GetMapping(AVG_PATH)
    public Double average(@PathVariable String first, @PathVariable String second) {
        validator.validateNumeric(first);
        validator.validateNumeric(second);
        return mathService.avg(Double.parseDouble(first), Double.parseDouble(second));
    }
}
