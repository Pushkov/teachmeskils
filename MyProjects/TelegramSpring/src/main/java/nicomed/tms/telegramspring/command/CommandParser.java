package nicomed.tms.telegramspring.command;

import lombok.extern.slf4j.Slf4j;
import nicomed.tms.telegramspring.enums.Command;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import static nicomed.tms.telegramspring.util.Constants.COMMAND_DELIMETR;
import static nicomed.tms.telegramspring.util.Constants.COMMAND_PREFIX;

@Slf4j
@Component
public class CommandParser {

    @Value("${bot.name}")
    private String NAME;

    public boolean isCommand(String text) {
        return text.strip().startsWith(COMMAND_PREFIX);
    }

    private String getCommandFullText(String text) {
        return text.strip().split(" ")[0].substring(1);
    }

    public boolean isCommandForMe(String text, String chatType) {
        String commandText = getCommandFullText(text);
        if (commandText.contains(COMMAND_DELIMETR)) {
            String nameFromCommand = commandText.substring(commandText.indexOf(COMMAND_DELIMETR) + 1);
            return NAME.equalsIgnoreCase(nameFromCommand);
        } else {
            return "private".equalsIgnoreCase(chatType);
        }
    }

    public Command getCommand(String text) {
        String commandText = getCommandFullText(text).split(COMMAND_DELIMETR)[0].toUpperCase();
        Command command = Command.NONE;
        try {
            command = Command.valueOf(commandText);
        } catch (IllegalArgumentException e) {
            command = Command.NON_COMMAND;
            log.error("Команда не распознана: " + commandText);
        }
        return command;
    }


}
