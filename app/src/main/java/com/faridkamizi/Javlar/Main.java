package com.faridkamizi.Javlar;

import com.faridkamizi.Javlar.commands.ChatCommands;
import com.faridkamizi.Javlar.musicComponents.MusicMain;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.ChunkingFilter;
import net.dv8tion.jda.api.utils.MemberCachePolicy;
import net.dv8tion.jda.api.utils.cache.CacheFlag;

public class Main {

    public static void main(String[] args) {
        JDABuilder builder = JDABuilder.createDefault("OTUwMDI0NzEwMzY2ODI2NTk2.GSmPVX.o7sJ15xfSJU8nrNd97-7QuyPV5mbPvrZlMwtPk")
                .enableIntents(GatewayIntent.MESSAGE_CONTENT)
                .disableCache(CacheFlag.ACTIVITY)
                .setMemberCachePolicy(MemberCachePolicy.VOICE.or(MemberCachePolicy.OWNER))
                .setChunkingFilter(ChunkingFilter.NONE)
                .setLargeThreshold(50)
                .setBulkDeleteSplittingEnabled(false)
                .setActivity(Activity.watching("This server"));
        builder.addEventListeners(new ChatCommands());
        builder.addEventListeners(new MusicMain());

        builder.build();
    }



}
