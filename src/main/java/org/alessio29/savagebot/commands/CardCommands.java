package org.alessio29.savagebot.commands;

import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.Permission;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import org.alessio29.savagebot.apiActions.cards.DrawCardsAction;
import org.alessio29.savagebot.apiActions.cards.OpenCardsAction;
import org.alessio29.savagebot.apiActions.cards.ShowCardsAction;
import org.alessio29.savagebot.apiActions.cards.ShuffleCardsAction;
import org.alessio29.savagebot.internal.commands.CommandExecutionResult;

import java.util.List;
import java.util.stream.Collectors;

@CommandCategoryOwner(CommandCategory.CARDS)
public class CardCommands {

    @CommandCallback(
            name = "deal",
            description = "openly deals several (1 by default) cards to current channel",
            aliases = {"dl"},
            arguments = { "[<card_count>]"}
    )
    public static CommandExecutionResult open(MessageReceivedEvent event, String[] args) {
        return new OpenCardsAction().doAction(event.getGuild().getId(), event.getChannel().getId(), args);
    }

    @CommandCallback(
            name = "show",
            description = "Shows your cards, previously dealt to you by 'deal' command to current channel",
            aliases = {"sh"},
            arguments = {}
    )
    public static CommandExecutionResult show(MessageReceivedEvent event, String[] args) {
        return new ShowCardsAction().doAction(event.getGuild().getId(), event.getChannel().getId(), args);
    }

    @CommandCallback(
            name = "draw",
            description = "Secretly draws several (1 by default) cards to user (to self by default)",
            aliases = {"dw"},
            arguments = {"[<card_count>]", "[<user>]"}
    )
    public static CommandExecutionResult draw(MessageReceivedEvent event, String[] args) {
        return new DrawCardsAction().doAction(event.getGuild().getId(), event.getChannel().getId(), event.getAuthor().getId(), args);
    }

    @CommandCallback(
            name = "shuffle",
            description = "Shuffles current deck, resets secret cards dealt to all users in this channel",
            aliases = {},
            arguments = {}
    )
    public static CommandExecutionResult shuffle(MessageReceivedEvent event, String[] args) {

        List<String> users = event.getGuild().getMembers().stream().
                filter(m -> m.hasPermission(event.getTextChannel(), Permission.MESSAGE_READ)).
                filter(m->m.getOnlineStatus()== OnlineStatus.ONLINE).map(m -> m.getUser().getId()).collect(Collectors.toList());
        return new ShuffleCardsAction().doAction(users, event.getGuild().getId(), event.getChannel().getId(), args);
    }

}