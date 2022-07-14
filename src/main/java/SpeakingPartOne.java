import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.Random;

public class SpeakingPartOne extends ListenerAdapter {
    final String[] COMMANDS = {"tp!S1"};
    final String[] TOPICS = TextReader.readResourcesDirectory("speaking/part 1/");

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) {
            return;
        }

        if (event.isFromType(ChannelType.PRIVATE)) {
            return;
        }

        Message message = event.getMessage();
        String rawContent = message.getContentRaw();

        if (ArrayUtilities.containsIgnoreCase(COMMANDS, rawContent)) {
            MessageChannel channel = event.getChannel();

            int random = new Random()
                    .nextInt(TOPICS.length);

            channel.sendMessage(TOPICS[random]).queue();
        }
    }
}
