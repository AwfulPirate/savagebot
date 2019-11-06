package org.alessio29.savagebot.apiActions.bennies;

import org.alessio29.savagebot.bennies.Pocket;
import org.alessio29.savagebot.bennies.Pockets;
import org.alessio29.savagebot.internal.builders.ReplyBuilder;
import org.alessio29.savagebot.internal.commands.CommandExecutionResult;

public class ShowBenniesAction {

    public CommandExecutionResult doAction(String guildId, String channelId, String[] args) {
        if (args.length < 1) {
            return new CommandExecutionResult("No character name provided. Usage: !show/benny <character_name>", 1);
        }
        String charName = ReplyBuilder.createNameFromArgs(args, 0);
        Pocket pocket = Pockets.getPocket(guildId, channelId, charName);

        ReplyBuilder replyBuilder = new ReplyBuilder();
        replyBuilder.attach(ReplyBuilder.capitalize(charName)).
                attach(" has in his pocket").
                attach(pocket.getInfo()).newLine();
        return new CommandExecutionResult(replyBuilder.toString(), 2);
    }
}