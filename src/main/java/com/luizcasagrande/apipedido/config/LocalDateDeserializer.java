package com.luizcasagrande.apipedido.config;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateDeserializer extends JsonDeserializer<LocalDate> {

    @Override
    public LocalDate deserialize(JsonParser parser, DeserializationContext context) throws IOException {
        var pattern = parser.getValueAsString().endsWith("Z") ? "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'" : "dd/MM/yyyy";
        return LocalDate.parse(parser.getValueAsString(), DateTimeFormatter.ofPattern(pattern));
    }
}
