package br.com.junior.rest_with_spring_boot_and_java_erudio.services;

public interface IMathService {
    Double sum(String first, String second);
    Double sub(String first, String second);
    Double mul(String first, String second);
    Double div(String first, String second);
    Double sqrt(String number);
    Double avg(String first, String second);
}

