package com.obts.hrms.notification.notification.util;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class TemplateProcessor {
    public String process(String template, Map<String, Object> data) {

        if (template == null || data == null) return template;

        String result = template;

        for (Map.Entry<String, Object> entry : data.entrySet()) {

            String key = "${" + entry.getKey() + "}";
            String value = entry.getValue() != null ? entry.getValue().toString() : "";

            result = result.replace(key, value);
        }

        return result;
    }
}
