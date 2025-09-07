package br.com.junior.rest_with_spring_boot_and_java_erudio.services;

import org.springframework.stereotype.Service;

@Service
public class MathService implements IMathService {

    private static final int AVERAGE_NUMBER = 2;


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
        return first / second;
    }

    @Override
    public Double sqrt(Double number) {
        return Math.sqrt(number);
    }

    @Override
    public Double avg(Double first, Double second) {
        return sum(first, second) / AVERAGE_NUMBER;
    }
}
