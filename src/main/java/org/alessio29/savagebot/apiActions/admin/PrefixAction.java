package org.alessio29.savagebot.apiActions.admin;

import org.alessio29.savagebot.internal.Prefixes;
import org.alessio29.savagebot.internal.commands.CommandExecutionResult;

public class PrefixAction {

    public CommandExecutionResult doAction(String userId, String[] args) {
        CommandExecutionResult result;
        if (args.length>0) {
            String newPrefix = args[0].trim();
            if (newPrefix.length()>1) {
                result = new CommandExecutionResult("Prefix must be one-character long!", 1);
            } else {

                if (newPrefix.equals("?") || newPrefix.equals("*") || newPrefix.equals("^") || newPrefix.equals("\\")  ) {
                    result = new CommandExecutionResult("Prefix must not be question sign, asterisk, backslash or circumflex!", 1);
                } else {
                    Prefixes.setPrefix(userId, newPrefix);
                    result = new CommandExecutionResult("Prefix is set to "+newPrefix, 2);
                }
            }
        } else {
            String prfx = Prefixes.getPrefix(userId);
            if (prfx == null) {
                result = new CommandExecutionResult("Custom prefix is not set! Default prefix is "+Prefixes.DEFAULT_BOT_PREFIX, 1);
            } else {
                result = new CommandExecutionResult("Prefix is '"+prfx+"'", 1);
            }
        }
        return result;
    }
}