package com.example.pegsandjokers.api.controller.model;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class PlayerSerializer extends JsonSerializer<Player> {
    @Override
    public void serialize(Player player, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        if (player == null) {
            gen.writeNull();
        } else {
            gen.writeStartObject();
            gen.writeNumberField("id", player.getId());
            gen.writeStringField("color", player.getColor());
            gen.writeNumberField("homePegs", player.getPegsInHome());
            gen.writeEndObject();
        }
    }
}
