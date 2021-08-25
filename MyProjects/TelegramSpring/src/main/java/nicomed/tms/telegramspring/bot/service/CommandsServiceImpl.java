package nicomed.tms.telegramspring.bot.service;

import lombok.extern.slf4j.Slf4j;
import nicomed.tms.telegramspring.bot.command.BaseBotCommand;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static nicomed.tms.telegramspring.bot.util.Constants.COMMAND_PREFIX;

@Slf4j
@Component
public class CommandsServiceImpl implements ICommandsService {

    private final Set<BaseBotCommand> commands;
    private final CommandParser parser;
    private BaseBotCommand defaultCommand;

    public CommandsServiceImpl() {
        this.parser = new CommandParser();
        commands = new HashSet<>();
        defaultCommand = null;
    }

    @Override
    public void register(BaseBotCommand command) {
        commands.add(command);
    }

    @Override
    public void remove(BaseBotCommand command) {
        commands.remove(command);
    }

    @Override
    public boolean isCommand(String text) {
        return text.stripLeading().startsWith(COMMAND_PREFIX);
    }

    @Override
    public BaseBotCommand get(String command) {
        String commandString = parser.getCommand(command);
        log.info("parser commandString - " + commandString);
        return commands.stream()
                .filter(c -> c.getCommand().equalsIgnoreCase(commandString))
                .findFirst().orElse(defaultCommand);
    }

    @Override
    public Set<String> info() {
        return commands.stream()
                .map(BotCommand::getCommand)
                .collect(Collectors.toSet());
    }

    @Override
    public void setDefaultCommand(BaseBotCommand command) {
        defaultCommand = command;
    }

    @Override
    public BaseBotCommand getDefaultCommand() {
        return defaultCommand;
    }
}
