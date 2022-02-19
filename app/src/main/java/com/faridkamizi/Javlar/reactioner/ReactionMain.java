package com.faridkamizi.Javlar.reactioner;

import com.faridkamizi.Javlar.musicComponents.GuildMusicManager;
import com.faridkamizi.Javlar.musicComponents.MusicMain;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionRemoveEvent;

/**
 * Reaction Listener Event Handler: Processes events when a user adds a reactions or removes it.
 *
 * @author Rishi Patel & Farid Kamizi
 */
public class ReactionMain extends MusicMain {
    /**
     * Handles what occurs when a reaction is added.
     *
     * @param event Event for someone adding a reaction
     */
    public void onMessageReactionAdd(MessageReactionAddEvent event) {
        if (!event.getUser().isBot()) {
            if (event.getChannel().getId().equals("939416664049594378")) {
                String reId = event.getReaction().getReactionEmote().getId();
                switch (reId) {
                    /*  APEX */
                    case "939392731816542238": {
                        event.getGuild().addRoleToMember(event.getMember(), event.getGuild().getRoleById("939394810110959636")).queue();
                    }
                    /*  CSGO */
                    case "939392436952772609": {
                        event.getGuild().addRoleToMember(event.getMember(), event.getGuild().getRoleById("931334667091730473")).queue();
                    }
                    /*  FORK */
                    case "939392259097509948": {
                        event.getGuild().addRoleToMember(event.getMember(), event.getGuild().getRoleById("933493305537335386")).queue();
                    }
                    /*  ROCK */
                    case "939392028750540840": {
                        event.getGuild().addRoleToMember(event.getMember(), event.getGuild().getRoleById("939395023684911115")).queue();
                    }
                    /* VACUOUSLY TRUE. */
                    default: {
                    }
                }
            } else if (event.getChannel().getId().equals("935650494452477973")) {
                String reId = event.getReaction().getReactionEmote().getId();
                if (reId.equals("939778831160594453")) {
                    GuildMusicManager musicManager = getGuildAudioPlayer(event.getGuild(), event.getChannel());
                    musicManager.scheduler.pause(musicManager.player, true);

                }
            }
        }
        super.onMessageReactionAdd(event);
    }

    /**
     * Handles what occurs when a reaction is removed.
     *
     * @param event Event for someone adding a reaction
     */
    public void onMessageReactionRemove(MessageReactionRemoveEvent event) {
        if (!event.getUser().isBot()) {
            if (event.getChannel().getId().equals("939416664049594378")) {
                String reId = event.getReaction().getReactionEmote().getId();
                switch (reId) {
                    /*  APEX */
                    case "939392731816542238": {
                        event.getGuild().removeRoleFromMember(event.getMember(), event.getGuild().getRoleById("939394810110959636")).queue();
                    }
                    /*  CSGO */
                    case "939392436952772609": {
                        event.getGuild().removeRoleFromMember(event.getMember(), event.getGuild().getRoleById("931334667091730473")).queue();
                    }
                    /*  FORK */
                    case "939392259097509948": {
                        event.getGuild().removeRoleFromMember(event.getMember(), event.getGuild().getRoleById("933493305537335386")).queue();
                    }
                    /*  ROCK */
                    case "939392028750540840": {
                        event.getGuild().removeRoleFromMember(event.getMember(), event.getGuild().getRoleById("939395023684911115")).queue();
                    }
                    /* VACUOUSLY TRUE. */
                    default: {
                    }
                }
            }
//            else if (event.getChannel().getId().equals("935650494452477973")) {
//                String reId = event.getReaction().getReactionEmote().getId();
//                if (reId.equals("939778831160594453")) {
//                    //mainMusicMngmt.getGuildAudioPlayer(event.getGuild(), event.getChannel());
//                    //GuildMusicManager musicManager = mainMusicMngmt.getGuildAudioPlayer(event.getGuild(), event.getChannel());
//                    //musicManager.scheduler.pause(musicManager.player, false);
//
//                }
//            }
        }
        super.onMessageReactionRemove(event);
    }

}
