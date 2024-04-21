package com.example.pegsandjokers.api.controller.model;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class HoleSerializer extends JsonSerializer<Hole> {
    @Override
    public void serialize(Hole hole, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        if (hole == null) {
            gen.writeNull();
        } else {
            gen.writeStartObject();
            gen.writeStringField("id", hole.getId().toString());
            gen.writeObjectField("peg", hole.getPeg());
            gen.writeEndObject();
        }
    }
}
