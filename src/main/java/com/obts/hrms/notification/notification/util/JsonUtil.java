package com.obts.hrms.notification.notification.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class JsonUtil {

    private final ObjectMapper mapper = new ObjectMapper();

    public String toJson(Map<String, Object> map) {
        try {
            return mapper.writeValueAsString(map);
        } catch (Exception e) {
            throw new RuntimeException("JSON conversion failed");
        }
    }
}
