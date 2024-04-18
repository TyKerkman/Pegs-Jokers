package com.example.pegsandjokers.api.controller.model;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class PegSerializer extends JsonSerializer<Peg> {
    @Override
    public void serialize(Peg value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        if (value == null) {
            gen.writeNull();
        } else {
            gen.writeStartObject();
            gen.writeStringField("color", value.getColor());
            gen.writeNumberField("num", value.getNum());
            gen.writeEndObject();
        }
    }
}
