package br.com.junior.rest_with_spring_boot_and_java_erudio.services;

public interface IMathService {
    Double sum(Double first, Double second);
    Double sub(Double first, Double second);
    Double mul(Double first, Double second);
    Double div(Double first, Double second);
    Double sqrt(Double number);
    Double avg(Double first, Double second);
}
