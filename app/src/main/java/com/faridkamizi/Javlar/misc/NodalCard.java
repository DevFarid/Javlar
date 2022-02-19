package com.faridkamizi.Javlar.misc;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;

import java.awt.*;


public class NodalCard {
    EmbedBuilder eb = new EmbedBuilder();

    public NodalCard(String description) {
        eb.setTitle("Queue", null);
        eb.setColor(new Color(0x805084));
        eb.setDescription(description);
    }

    public MessageEmbed build() {
        return eb.build();
    }

}
