package br.com.junior.rest_with_spring_boot_and_java_erudio.serialization.converter;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;

public class YAmlJackson2HttpMesageConverter extends AbstractJackson2HttpMessageConverter {

    public YAmlJackson2HttpMesageConverter() {
        super(new YAMLMapper()
                        .setSerializationInclusion(JsonInclude.Include.NON_NULL),
                MediaType.parseMediaType("application/vnd.yaml+json")
        );
    }
}
