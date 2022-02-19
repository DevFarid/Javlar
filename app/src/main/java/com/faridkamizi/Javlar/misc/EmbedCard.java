package com.faridkamizi.Javlar.misc;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.Role;

import java.awt.*;

/**
 * An object representation of an EmbedBuilder to create unique posts.
 * Created by Farid Kamizi
 */
public class EmbedCard {

    /**
     * Internal representation
     */
    private final EmbedBuilder eb = new EmbedBuilder();

    /**
     * Sets the Title of the embed.
     * <br>You can provide {@code null} as url if no url should be used.
     *
     * <p><b><a href="https://raw.githubusercontent.com/DV8FromTheWorld/JDA/assets/assets/docs/embeds/04-setTitle.png">Example</a></b>
     *
     * @throws java.lang.IllegalArgumentException <ul>
     *                                            <li>If the provided {@code title} is an empty String.</li>
     *                                            <li>If the character limit for {@code title}, defined by {@link net.dv8tion.jda.api.entities.MessageEmbed#TITLE_MAX_LENGTH} as {@value net.dv8tion.jda.api.entities.MessageEmbed#TITLE_MAX_LENGTH},
     *                                            is exceeded.</li>
     *                                            <li>If the character limit for {@code url}, defined by {@link net.dv8tion.jda.api.entities.MessageEmbed#URL_MAX_LENGTH} as {@value net.dv8tion.jda.api.entities.MessageEmbed#URL_MAX_LENGTH},
     *                                            is exceeded.</li>
     *                                            <li>If the provided {@code url} is not a properly formatted http or https url.</li>
     *                                            </ul>
     */
    public EmbedCard() {
        EmbedBuilder eb = new EmbedBuilder();
    }

    /**
     * Sets the raw RGB color value for the embed.
     *
     * <p><b><a href="https://raw.githubusercontent.com/DV8FromTheWorld/JDA/assets/assets/docs/embeds/02-setColor.png" target="_blank">Example</a></b>
     *
     * @param color The raw rgb value, or {@link Role#DEFAULT_COLOR_RAW} to use no color
     * @see #setColor(java.awt.Color)
     */
    public void setColor(Color color) {
        eb.setColor(color);
    }

    /**
     * Sets the Description of the embed. This is where the main chunk of text for an embed is typically placed.
     *
     * <p><b><a href="https://raw.githubusercontent.com/DV8FromTheWorld/JDA/assets/assets/docs/embeds/05-setDescription.png">Example</a></b>
     *
     * @param description the description of the embed, {@code null} to reset
     * @throws java.lang.IllegalArgumentException If {@code description} is longer than {@value net.dv8tion.jda.api.entities.MessageEmbed#DESCRIPTION_MAX_LENGTH} characters,
     *                                            as defined by {@link net.dv8tion.jda.api.entities.MessageEmbed#DESCRIPTION_MAX_LENGTH}
     */
    public void setDescription(CharSequence description) {
        eb.setDescription(description);
    }

    /**
     * Copies the provided Field into a new Field for this builder.
     * <br>For additional documentation, see {@link #addField(String, String, boolean)}
     *
     * @param field the field object to add
     */
    public void addField(MessageEmbed.Field field) {
        eb.addField(field);
    }

    /**
     * Adds a Field to the embed.
     *
     * <p>Note: If a blank string is provided to either {@code name} or {@code value}, the blank string is replaced
     * with {@link net.dv8tion.jda.api.EmbedBuilder#ZERO_WIDTH_SPACE}.
     *
     * <p><b><a href="https://raw.githubusercontent.com/DV8FromTheWorld/JDA/assets/assets/docs/embeds/07-addField.png">Example of Inline</a></b>
     * <p><b><a href="https://raw.githubusercontent.com/DV8FromTheWorld/JDA/assets/assets/docs/embeds/08-addField.png">Example if Non-inline</a></b>
     *
     * @param name   the name of the Field, displayed in bold above the {@code value}.
     * @param value  the contents of the field.
     * @param inline whether or not this field should display inline.
     * @throws java.lang.IllegalArgumentException <ul>
     *                                            <li>If only {@code name} or {@code value} is set. Both must be set.</li>
     *                                            <li>If the character limit for {@code name}, defined by {@link net.dv8tion.jda.api.entities.MessageEmbed#TITLE_MAX_LENGTH} as {@value net.dv8tion.jda.api.entities.MessageEmbed#TITLE_MAX_LENGTH},
     *                                            is exceeded.</li>
     *                                            <li>If the character limit for {@code value}, defined by {@link net.dv8tion.jda.api.entities.MessageEmbed#VALUE_MAX_LENGTH} as {@value net.dv8tion.jda.api.entities.MessageEmbed#VALUE_MAX_LENGTH},
     *                                            is exceeded.</li>
     *                                            </ul>
     */
    public void addField(String name, String value, boolean inline) {
        eb.addField(name, value, inline);
    }

    /**
     * Adds a blank (empty) Field to the embed.
     *
     * <p><b><a href="https://raw.githubusercontent.com/DV8FromTheWorld/JDA/assets/assets/docs/embeds/07-addField.png">Example of Inline</a></b>
     * <p><b><a href="https://raw.githubusercontent.com/DV8FromTheWorld/JDA/assets/assets/docs/embeds/08-addField.png">Example if Non-inline</a></b>
     *
     * @param inline whether or not this field should display inline
     */
    public void addBlankField(boolean inline) {
        eb.addBlankField(inline);
    }

    /**
     * Clears all fields from the embed, such as those created with the
     * {@link net.dv8tion.jda.api.EmbedBuilder#EmbedBuilder(net.dv8tion.jda.api.entities.MessageEmbed) EmbedBuilder(MessageEmbed)}
     * constructor or via the
     * {@link net.dv8tion.jda.api.EmbedBuilder#addField(net.dv8tion.jda.api.entities.MessageEmbed.Field) addField} methods.
     */
    public void clearFields() {
        eb.clearFields();
    }


    /**
     * Sets the Author of the embed. The author appears in the top left of the embed and can have a small
     * image beside it along with the author's name being made clickable by way of providing a url.
     * This convenience method just sets the name.
     *
     * <p><b><a href="https://raw.githubusercontent.com/DV8FromTheWorld/JDA/assets/assets/docs/embeds/03-setAuthor.png">Example</a></b>
     *
     * @param name the name of the author of the embed. If this is not set, the author will not appear in the embed
     * @throws java.lang.IllegalArgumentException If {@code name} is longer than {@value net.dv8tion.jda.api.entities.MessageEmbed#AUTHOR_MAX_LENGTH} characters,
     *                                            as defined by {@link net.dv8tion.jda.api.entities.MessageEmbed#AUTHOR_MAX_LENGTH}
     */
    public void setAuthor(String name) {
        eb.setAuthor(name, null, null);
    }

    /**
     * Sets the Author of the embed. The author appears in the top left of the embed and can have a small
     * image beside it along with the author's name being made clickable by way of providing a url.
     * This convenience method just sets the name and the url.
     *
     * <p><b><a href="https://raw.githubusercontent.com/DV8FromTheWorld/JDA/assets/assets/docs/embeds/03-setAuthor.png">Example</a></b>
     *
     * @param name the name of the author of the embed. If this is not set, the author will not appear in the embed
     * @param url  the url of the author of the embed
     * @throws java.lang.IllegalArgumentException <ul>
     *                                            <li>If the character limit for {@code name}, defined by {@link net.dv8tion.jda.api.entities.MessageEmbed#AUTHOR_MAX_LENGTH} as {@value net.dv8tion.jda.api.entities.MessageEmbed#AUTHOR_MAX_LENGTH},
     *                                            is exceeded.</li>
     *                                            <li>If the character limit for {@code url}, defined by {@link net.dv8tion.jda.api.entities.MessageEmbed#URL_MAX_LENGTH} as {@value net.dv8tion.jda.api.entities.MessageEmbed#URL_MAX_LENGTH},
     *                                            is exceeded.</li>
     *                                            <li>If the provided {@code url} is not a properly formatted http or https url.</li>
     *                                            </ul>
     */
    public void setAuthor(String name, String url) {
        eb.setAuthor(name, url, null);
    }

    /**
     * Sets the Author of the embed. The author appears in the top left of the embed and can have a small
     * image beside it along with the author's name being made clickable by way of providing a url.
     *
     * <p><b><a href="https://raw.githubusercontent.com/DV8FromTheWorld/JDA/assets/assets/docs/embeds/03-setAuthor.png">Example</a></b>
     *
     * <p><b>Uploading images with Embeds</b>
     * <br>When uploading an <u>image</u>
     * (using {@link net.dv8tion.jda.api.entities.MessageChannel#sendFile(java.io.File, net.dv8tion.jda.api.utils.AttachmentOption...) MessageChannel.sendFile(...)})
     * you can reference said image using the specified filename as URI {@code attachment://filename.ext}.
     *
     * <p><u>Example</u>
     * <pre><code>
     * MessageChannel channel; // = reference of a MessageChannel
     * EmbedBuilder embed = new EmbedBuilder();
     * InputStream file = new URL("https://http.cat/500").openStream();
     * embed.setAuthor("Minn", null, "attachment://cat.png") // we specify this in sendFile as "cat.png"
     *      .setDescription("This is a cute cat :3");
     * channel.sendFile(file, "cat.png").setEmbeds(embed.build()).queue();
     * </code></pre>
     *
     * @param name    the name of the author of the embed. If this is not set, the author will not appear in the embed
     * @param url     the url of the author of the embed
     * @param iconUrl the url of the icon for the author
     * @throws java.lang.IllegalArgumentException <ul>
     *                                            <li>If the character limit for {@code name}, defined by {@link net.dv8tion.jda.api.entities.MessageEmbed#AUTHOR_MAX_LENGTH} as {@value net.dv8tion.jda.api.entities.MessageEmbed#AUTHOR_MAX_LENGTH},
     *                                            is exceeded.</li>
     *                                            <li>If the character limit for {@code url}, defined by {@link net.dv8tion.jda.api.entities.MessageEmbed#URL_MAX_LENGTH} as {@value net.dv8tion.jda.api.entities.MessageEmbed#URL_MAX_LENGTH},
     *                                            is exceeded.</li>
     *                                            <li>If the provided {@code url} is not a properly formatted http or https url.</li>
     *                                            <li>If the character limit for {@code iconUrl}, defined by {@link net.dv8tion.jda.api.entities.MessageEmbed#URL_MAX_LENGTH} as {@value net.dv8tion.jda.api.entities.MessageEmbed#URL_MAX_LENGTH},
     *                                            is exceeded.</li>
     *                                            <li>If the provided {@code iconUrl} is not a properly formatted http or https url.</li>
     *                                            </ul>
     */
    public void setAuthor(String name, String url, String iconUrl) {
        eb.setAuthor(name, url, iconUrl);
    }

    /**
     * Sets the Footer of the embed without icon.
     *
     * <p><b><a href="https://raw.githubusercontent.com/DV8FromTheWorld/JDA/assets/assets/docs/embeds/12-setFooter.png">Example</a></b>
     *
     * @param text the text of the footer of the embed. If this is not set or set to null, the footer will not appear in the embed.
     * @throws java.lang.IllegalArgumentException If {@code text} is longer than {@value net.dv8tion.jda.api.entities.MessageEmbed#TEXT_MAX_LENGTH} characters,
     *                                            as defined by {@link net.dv8tion.jda.api.entities.MessageEmbed#TEXT_MAX_LENGTH}
     */
    public void setFooter(String text) {
        eb.setFooter(text, null);
    }

    /**
     * Sets the Footer of the embed.
     *
     * <p><b><a href="https://raw.githubusercontent.com/DV8FromTheWorld/JDA/assets/assets/docs/embeds/12-setFooter.png">Example</a></b>
     *
     * <p><b>Uploading images with Embeds</b>
     * <br>When uploading an <u>image</u>
     * (using {@link net.dv8tion.jda.api.entities.MessageChannel#sendFile(java.io.File, net.dv8tion.jda.api.utils.AttachmentOption...) MessageChannel.sendFile(...)})
     * you can reference said image using the specified filename as URI {@code attachment://filename.ext}.
     *
     * <p><u>Example</u>
     * <pre><code>
     * MessageChannel channel; // = reference of a MessageChannel
     * EmbedBuilder embed = new EmbedBuilder();
     * InputStream file = new URL("https://http.cat/500").openStream();
     * embed.setFooter("Cool footer!", "attachment://cat.png") // we specify this in sendFile as "cat.png"
     *      .setDescription("This is a cute cat :3");
     * channel.sendFile(file, "cat.png").setEmbeds(embed.build()).queue();
     * </code></pre>
     *
     * @param text    the text of the footer of the embed. If this is not set, the footer will not appear in the embed.
     * @param iconUrl the url of the icon for the footer
     * @throws java.lang.IllegalArgumentException <ul>
     *                                            <li>If the character limit for {@code text}, defined by {@link net.dv8tion.jda.api.entities.MessageEmbed#TEXT_MAX_LENGTH} as {@value net.dv8tion.jda.api.entities.MessageEmbed#TEXT_MAX_LENGTH},
     *                                            is exceeded.</li>
     *                                            <li>If the character limit for {@code iconUrl}, defined by {@link net.dv8tion.jda.api.entities.MessageEmbed#URL_MAX_LENGTH} as {@value net.dv8tion.jda.api.entities.MessageEmbed#URL_MAX_LENGTH},
     *                                            is exceeded.</li>
     *                                            <li>If the provided {@code iconUrl} is not a properly formatted http or https url.</li>
     *                                            </ul>
     */
    public void setFooter(String text, String iconUrl) {
        eb.setFooter(text, iconUrl);
    }

    /**
     * Sets the Image of the embed.
     *
     * <p><b><a href="https://raw.githubusercontent.com/DV8FromTheWorld/JDA/assets/assets/docs/embeds/11-setImage.png">Example</a></b>
     *
     * <p><b>Uploading images with Embeds</b>
     * <br>When uploading an <u>image</u>
     * (using {@link net.dv8tion.jda.api.entities.MessageChannel#sendFile(java.io.File, net.dv8tion.jda.api.utils.AttachmentOption...) MessageChannel.sendFile(...)})
     * you can reference said image using the specified filename as URI {@code attachment://filename.ext}.
     *
     * <p><u>Example</u>
     * <pre><code>
     * MessageChannel channel; // = reference of a MessageChannel
     * EmbedBuilder embed = new EmbedBuilder();
     * InputStream file = new URL("https://http.cat/500").openStream();
     * embed.setImage("attachment://cat.png") // we specify this in sendFile as "cat.png"
     *      .setDescription("This is a cute cat :3");
     * channel.sendFile(file, "cat.png").setEmbeds(embed.build()).queue();
     * </code></pre>
     *
     * @param url the url of the image of the embed
     * @throws java.lang.IllegalArgumentException <ul>
     *                                            <li>If the character limit for {@code url}, defined by {@link net.dv8tion.jda.api.entities.MessageEmbed#URL_MAX_LENGTH} as {@value net.dv8tion.jda.api.entities.MessageEmbed#URL_MAX_LENGTH},
     *                                            is exceeded.</li>
     *                                            <li>If the provided {@code url} is not a properly formatted http or https url.</li>
     *                                            </ul>
     * @see net.dv8tion.jda.api.entities.MessageChannel#sendFile(java.io.File, String, net.dv8tion.jda.api.utils.AttachmentOption...) MessageChannel.sendFile(...)
     */
    public void setImage(String url) {
        eb.setImage(url);
    }

    /**
     * Sets the Thumbnail of the embed.
     *
     * <p><b><a href="https://raw.githubusercontent.com/DV8FromTheWorld/JDA/assets/assets/docs/embeds/06-setThumbnail.png">Example</a></b>
     *
     * <p><b>Uploading images with Embeds</b>
     * <br>When uploading an <u>image</u>
     * (using {@link net.dv8tion.jda.api.entities.MessageChannel#sendFile(java.io.File, net.dv8tion.jda.api.utils.AttachmentOption...) MessageChannel.sendFile(...)})
     * you can reference said image using the specified filename as URI {@code attachment://filename.ext}.
     *
     * <p><u>Example</u>
     * <pre><code>
     * MessageChannel channel; // = reference of a MessageChannel
     * EmbedBuilder embed = new EmbedBuilder();
     * InputStream file = new URL("https://http.cat/500").openStream();
     * embed.setThumbnail("attachment://cat.png") // we specify this in sendFile as "cat.png"
     *      .setDescription("This is a cute cat :3");
     * channel.sendFile(file, "cat.png").setEmbeds(embed.build()).queue();
     * </code></pre>
     *
     * @param url the url of the thumbnail of the embed
     * @throws java.lang.IllegalArgumentException <ul>
     *                                            <li>If the character limit for {@code url}, defined by {@link net.dv8tion.jda.api.entities.MessageEmbed#URL_MAX_LENGTH} as {@value net.dv8tion.jda.api.entities.MessageEmbed#URL_MAX_LENGTH},
     *                                            is exceeded.</li>
     *                                            <li>If the provided {@code url} is not a properly formatted http or https url.</li>
     *                                            </ul>
     */
    public void setThumbnail(String url) {
        eb.setThumbnail(url);
    }

    /**
     * Sets the Title of the embed.
     * <br>Overload for {@link #setTitle(String, String)} without URL parameter.
     *
     * <p><b><a href="https://raw.githubusercontent.com/DV8FromTheWorld/JDA/assets/assets/docs/embeds/04-setTitle.png">Example</a></b>
     *
     * @param title the title of the embed
     * @throws java.lang.IllegalArgumentException <ul>
     *                                            <li>If the provided {@code title} is an empty String.</li>
     *                                            <li>If the character limit for {@code title}, defined by {@link net.dv8tion.jda.api.entities.MessageEmbed#TITLE_MAX_LENGTH} as {@value net.dv8tion.jda.api.entities.MessageEmbed#TITLE_MAX_LENGTH},
     *                                            is exceeded.</li>
     *                                            </ul>
     */
    public void setTitle(String title) {
        eb.setTitle(title, null);
    }

    /**
     * Sets the Title of the embed.
     * <br>You can provide {@code null} as url if no url should be used.
     *
     * <p><b><a href="https://raw.githubusercontent.com/DV8FromTheWorld/JDA/assets/assets/docs/embeds/04-setTitle.png">Example</a></b>
     *
     * @param title the title of the embed
     * @param url   Makes the title into a hyperlink pointed at this url.
     * @throws java.lang.IllegalArgumentException <ul>
     *                                            <li>If the provided {@code title} is an empty String.</li>
     *                                            <li>If the character limit for {@code title}, defined by {@link net.dv8tion.jda.api.entities.MessageEmbed#TITLE_MAX_LENGTH} as {@value net.dv8tion.jda.api.entities.MessageEmbed#TITLE_MAX_LENGTH},
     *                                            is exceeded.</li>
     *                                            <li>If the character limit for {@code url}, defined by {@link net.dv8tion.jda.api.entities.MessageEmbed#URL_MAX_LENGTH} as {@value net.dv8tion.jda.api.entities.MessageEmbed#URL_MAX_LENGTH},
     *                                            is exceeded.</li>
     *                                            <li>If the provided {@code url} is not a properly formatted http or https url.</li>
     *                                            </ul>
     */
    public void setTitle(String title, String url) {
        eb.setTitle(title, url);
    }

    /**
     * Returns a {@link net.dv8tion.jda.api.entities.MessageEmbed MessageEmbed}
     * that has been checked as being valid for sending.
     *
     * @return the built, sendable {@link net.dv8tion.jda.api.entities.MessageEmbed}
     * @throws java.lang.IllegalStateException If the embed is empty. Can be checked with {@link #(net.dv8tion.jda.api.EmbedBuilder).isEmpty()}.
     */
    public MessageEmbed build() {
        return eb.build();
    }
}
