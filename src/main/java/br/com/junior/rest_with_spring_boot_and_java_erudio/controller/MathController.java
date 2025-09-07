package br.com.junior.rest_with_spring_boot_and_java_erudio.controller;

import br.com.junior.rest_with_spring_boot_and_java_erudio.services.IMathService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {

    private final IMathService mathService;

    private static final String FIRST_SECOND = "/{first}/{second}";
    private static final String SUM_PATH = "/sum" + FIRST_SECOND;
    private static final String SUB_PATH = "/subtract" + FIRST_SECOND;
    private static final String MUL_PATH = "/multiply" + FIRST_SECOND;
    private static final String DIV_PATH = "/divide" + FIRST_SECOND;
    private static final String AVG_PATH = "/average" + FIRST_SECOND;
    private static final String SQRT_PATH = "/square-root/{number}";

    public MathController(IMathService mathService) {
        this.mathService = mathService;
    }

    @GetMapping(SUM_PATH)
    public Double sum(@PathVariable String first, @PathVariable String second) {
        return mathService.sum(first, second);
    }

    @GetMapping(SUB_PATH)
    public Double subtract(@PathVariable String first, @PathVariable String second) {
        return mathService.sub(first, second);
    }

    @GetMapping(MUL_PATH)
    public Double multiply(@PathVariable String first, @PathVariable String second) {
        return mathService.mul(first, second);
    }

    @GetMapping(DIV_PATH)
    public Double divide(@PathVariable String first, @PathVariable String second) {
        return mathService.div(first, second);
    }

    @GetMapping(SQRT_PATH)
    public Double squareRoot(@PathVariable String number) {
        return mathService.sqrt(number);
    }

    @GetMapping(AVG_PATH)
    public Double average(@PathVariable String first, @PathVariable String second) {
        return mathService.avg(first, second);
    }
}
