import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Help extends ListenerAdapter {
    final String[] COMMANDS = {"tp!help"};
    final String RESPONSE = """
            **Commands**
            `tp!S1`: Get a random Speaking Part 1 topic
            `tp!S23`: Get a random Speaking Part 2 and Part 3 topic
            """;

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

            channel.sendMessage(RESPONSE).queue();
        }
    }
}
