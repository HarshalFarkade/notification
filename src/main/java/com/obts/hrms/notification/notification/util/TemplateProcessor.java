package com.obts.hrms.notification.notification.util;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class TemplateProcessor {

    public String process(String template, Map<String, Object> data) {

        if (template == null) return null;
        if (data == null || data.isEmpty()) return template;

        StringBuilder result = new StringBuilder(template);

        for (Map.Entry<String, Object> entry : data.entrySet()) {

            String key = "${" + entry.getKey() + "}";
            String value = entry.getValue() != null ? entry.getValue().toString() : "";

            int index;
            while ((index = result.indexOf(key)) != -1) {
                result.replace(index, index + key.length(), value);
            }
        }

        // 🔥 remove unreplaced placeholders
        return result.toString().replaceAll("\\$\\{[^}]+}", "");
    }
}
