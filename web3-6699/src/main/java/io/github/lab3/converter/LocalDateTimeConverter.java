package io.github.lab3.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.DateTimeConverter;
import javax.faces.convert.FacesConverter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@FacesConverter("localDateTimeConverter")
public class LocalDateTimeConverter extends DateTimeConverter {

    public LocalDateTimeConverter() {
        setLocale(Locale.US);
        setPattern("dd/MM/yyyy HH:mm:ss");
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null && !value.isEmpty()) {
            DateTimeFormatter formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME;
            return LocalDateTime.parse(value, formatter);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value instanceof LocalDateTime) {
            // Format LocalDateTime as a string using the specified pattern
            LocalDateTime dateTime = (LocalDateTime) value;
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(getPattern());
            return dateTime.format(formatter);
        }
        return null;
    }
}
