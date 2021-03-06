package com.luizcasagrande.apipedido.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateSerializer extends JsonSerializer<LocalDate> {

    @Override
    public void serialize(LocalDate localDate, JsonGenerator generator, SerializerProvider serializers) throws IOException {
        generator.writeString(localDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
    }
}
