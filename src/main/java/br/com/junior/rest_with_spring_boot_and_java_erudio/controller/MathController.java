package br.com.junior.rest_with_spring_boot_and_java_erudio.controller;

import br.com.junior.rest_with_spring_boot_and_java_erudio.services.IMathService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {

    IMathService mathService;

    public MathController(IMathService mathService) {
        this.mathService = mathService;
    }

    // http:://localhost:8080/math/sum/3/5
    @RequestMapping("/sum/{first}/{second}")
    public Double sum(
            @PathVariable String first,
            @PathVariable String second
    ) {
        return mathService.sum(first,second);
    }

    // http:://localhost:8080/math/subtraction/3/5
    @RequestMapping("/subtraction/{first}/{second}")
    public Double sub(
            @PathVariable String first,
            @PathVariable String second
    ) {
       return mathService.sub(first,second);
    }
    // http:://localhost:8080/math/multiply/3/5
    @RequestMapping("/multiply/{first}/{second}")
    public Double multiply(
            @PathVariable String first,
            @PathVariable String second
    ) {
        return mathService.mul(first, second);
    }

    // http:://localhost:8080/math/division/3/5
    @RequestMapping("/division/{first}/{second}")
    public Double division(
            @PathVariable String first,
            @PathVariable String second
    ) {
        return mathService.div(first, second);
    }

    // http:://localhost:8080/math/division/3/5
    @RequestMapping("/square-root/{number}")
    public Double squareRoot(
            @PathVariable String number
    ) {
        return mathService.sqrt(number);
    }

    // http:://localhost:8080/math/media/3/5
    @RequestMapping("/average/{number}/{second}")
    public Double average(
            @PathVariable String first,
            @PathVariable String second
    ) {
        return mathService.avg(first,second);
    }



}
