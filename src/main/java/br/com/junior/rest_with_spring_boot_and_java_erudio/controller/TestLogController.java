package br.com.junior.rest_with_spring_boot_and_java_erudio.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestLogController {

    public static final String TEST = "/test";
    private final Logger logger = LoggerFactory.getLogger(TestLogController.class);

    @GetMapping(TEST)
    public String testLog() {
        logger.debug("This is DEBUG log");
        logger.info("This is INFO log");
        logger.warn("This is WARN log");
        logger.error("This is ERROR log");
        return "Logs generated successfully";
    }
}
