package com.faridkamizi.Javlar.commands;

import com.faridkamizi.Javlar.musicComponents.GuildMusicManager;
import com.faridkamizi.Javlar.musicComponents.MusicMain;
import components.set.Set;
import components.set.Set1L;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

/**
 * ChatCommands adds on a list of of commands with their respective implementation.
 *
 * @Author Farid Kamizi & Rishi Patel.
 */
public class ChatCommands extends ListenerAdapter {
    private static final MusicMain mainMusicMngmt = new MusicMain();

    /*
     * PREFIX COMMANDS
     */
    public void onMessageReceived(MessageReceivedEvent event) {
        String[] command = event.getMessage().getContentRaw().split(" ", 8);
        GuildMusicManager musicManager = mainMusicMngmt.getGuildAudioPlayer(event.getGuild(), event.getChannel());

        if (!event.getAuthor().isBot()) {
            /*
             * !play command.
             */
            if ("!play".equals(command[0])) {
                if (event.getMessage().getAttachments().size() > 0) {
                    for (Message.Attachment attachment : event.getMessage().getAttachments()) {
                        String fileExtension = event.getMessage().getAttachments().get(0).getFileExtension();
                        if (acceptedFiles().contains(fileExtension)) {
                            mainMusicMngmt.loadAndPlay((TextChannel) event.getChannel(), attachment.getUrl(), event.getMember());
                        }
                    }
                    event.getMessage().delete().queue();
                } else {
                    if (command.length == 2) {
                        mainMusicMngmt.loadAndPlay((TextChannel) event.getChannel(), command[1], event.getMember());
                    }
                }
            }
            /*
             * !skip command.
             */
            else if ("!skip".equals(command[0])) {
                mainMusicMngmt.skipTrack((TextChannel) event.getChannel());
            }
            /*
             * !queue command.
             */
            else if ("!queue".equals(command[0])) {
                //musicManager.scheduler.printQueue((TextChannel) event.getChannel());
                musicManager.scheduler.printQueue();
            }
            /*
             * !move int int command.
             */
            else if ("!move".equals(command[0]) && command.length == 3) {
                if (musicManager.scheduler.getTracks().length() >= 2) {
                    int c = Integer.parseInt(command[1]);
                    int f = Integer.parseInt(command[2]);
                    musicManager.scheduler.move(c, f);
                }
            } else if ("!remove".equals(command[0]) && command.length == 2) {
                int i = Integer.parseInt(command[1]);
                musicManager.scheduler.remove(i - 1);
            }
            /*
             * !play command.
             */
            else if ("!ping".equals(command[0])) {
                if (event.isFromGuild()) {
                    MessageChannel channel = event.getChannel();
                    long time = System.currentTimeMillis();
                    channel.sendMessage("Pong!").queue(response -> response.editMessageFormat("Pong: **%d** ms", System.currentTimeMillis() - time).queue());
                }
            }
            /*
             * !nuke command.
             */
            else if ("!nuke".equals(command[0]) && command.length == 2) {
                assert (Character.isDigit(command[1].charAt(0))) : "Violation of: Character.isDigit(command[1])";
                int amt = Integer.parseInt(command[1]); // This is configured to be optional so check for null
                event.getChannel().getIterableHistory().skipTo(event.getMessageIdLong()).takeAsync(amt).thenAccept(event.getChannel()::purgeMessages);
                event.getMessage().delete().queue();
            }
            /*
             * !createRolesGames command.
             */
            else if ("!createRolesGames".equals(command[0])) {
                event.getChannel().sendMessage("""
                        ```
                        Click on the games you want a role for.

                          |\t  |\t  |\t  |
                          |\t  |\t  |\t  |
                          |\t  |\t  |\t  |
                          V\t  V\t  V\t  V```""").queue(response -> {
                    response.addReaction("APE:939392731816542238").queue();
                    response.addReaction("CSGO:939392436952772609").queue();
                    response.addReaction("F_:939392259097509948").queue();
                    response.addReaction("RL:939392028750540840").queue();
                    response.addReaction("pepe_Cross:927405565645307974").queue();
                });
            }
            super.onMessageReceived(event);
        }
    }

    private Set<String> acceptedFiles() {
        Set<String> acceptedFiles = new Set1L<>();
        acceptedFiles.add("mp3");
        acceptedFiles.add("m4a");
        acceptedFiles.add("wav");
        return acceptedFiles;
    }
}
