package com.faridkamizi.Javlar.musicComponents;

import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import com.sedmelluq.discord.lavaplayer.player.event.AudioEventAdapter;
import com.sedmelluq.discord.lavaplayer.track.AudioTrack;
import com.sedmelluq.discord.lavaplayer.track.AudioTrackEndReason;
import components.sequence.Sequence;
import components.sequence.Sequence1L;
import net.dv8tion.jda.api.entities.TextChannel;


public class TrackScheduler extends AudioEventAdapter {
    private static TextChannel responseFeed;
    private final AudioPlayer player;
    private final Sequence<AudioTrack> sequence;

    /**
     * @param player the audio player that scheduler uses.
     */
    public TrackScheduler(AudioPlayer player, TextChannel sentChannel) {
        this.player = player;
        this.sequence = new Sequence1L<>();
        responseFeed = sentChannel;
    }

    /**
     * Add the next track to the Queue.
     */
    public void queue(AudioTrack track) {
        if (!player.startTrack(track, true)) {
            sequence.add(sequence.length(), track);
            printQueue();
        }
        printQueue();
    }

    public void nextTrack() {
        assert (sequence.length() > 0) : "Violation of: queue.size() > 0";
        player.startTrack(sequence.remove(sequence.length() - 1), false);
    }

    @Override
    public void onTrackEnd(AudioPlayer player, AudioTrack track, AudioTrackEndReason endReason) {
        if (endReason.mayStartNext) {
            nextTrack();
        }
    }

    public void pause(AudioPlayer player, boolean b) {
        player.setPaused(b);
    }

    /**
     * Removes a track from the {@code Sequence} queue from the input integer index.
     *
     * @param i the integer index to remove a track from {@code Sequence} queue.
     * @update sequence
     */
    public void remove(int i) {
        assert (i <= sequence.length()) : "Violation of: i <= sequence.length()";

        responseFeed.sendMessage("Removed **" + sequence.remove(i).getInfo().title + "**").queue();
    }

    /**
     * Swaps two indexes with one another amongst their values.
     *
     * @param c the current position treated as an integer to move the desired track.
     * @param f the future position treated as an integer to swap the unwanted track with desired track.
     * @requires c <= sequence.length() && f <= sequence.length()
     * @ensures sequence{f,c} = #sequence{c,f}
     */
    public void move(int c, int f) {
        c--;
        f--;
        assert (c <= sequence.length()) : "Violation of: c <= sequence.length()";
        assert (f <= sequence.length()) : "Violation of: f <= sequence.length()";

        AudioTrack track = sequence.entry(c);
        track = sequence.replaceEntry(f, track);
        sequence.replaceEntry(c, track);
    }

    /**
     * Send a basic message block of the internal representation {@code Sequence} queue to a specific channel
     */
    public void printQueue() {

//        String text = "";
//        int numTrack = 1;
//
//        Sequence<AudioTrack> tracks = sequence.newInstance();
//        tracks.add(tracks.length(), player.getPlayingTrack());
//        tracks.append(sequence);
//
//        for (AudioTrack track : tracks) {
//            text += "[" + numTrack + "] - " + track.getInfo().title + "\n";
//            numTrack++;
//        }
//        if (text.length() > 0) {
//            String message = "```Current Track Playing: " + player.getPlayingTrack().getInfo().title +
//                    "\nBy: " + player.getPlayingTrack().getInfo().author + "\nDuration: " + (player.getPlayingTrack().getPosition() / 1000) / 60 + ":" +
//                    (player.getPlayingTrack().getPosition() / 1000) % 60 + "------o-----------" +
//                    (player.getPlayingTrack().getDuration() / 1000) / 60 + ":" + (player.getPlayingTrack().getDuration() / 1000) % 60 + "```";
//
//            NodalCard nc = new NodalCard(text + "\n" + message);
//            responseFeed.sendMessage(" ").setEmbeds(nc.build()).complete();
//            responseFeed.addReactionById(responseFeed.getLatestMessageId(), "play:939778831160594453").queue();
//        }

    }

    /**
     * Returns the internal representation {@code Sequence} queue to the client.
     *
     * @return getTracks() = [this.sequence]
     */
    public Sequence<AudioTrack> getTracks() {
        return sequence;
    }
}
