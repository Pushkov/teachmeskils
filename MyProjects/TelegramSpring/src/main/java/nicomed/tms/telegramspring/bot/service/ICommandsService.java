package nicomed.tms.telegramspring.bot.service;

import nicomed.tms.telegramspring.bot.command.BaseBotCommand;

import java.util.Set;

public interface ICommandsService {
    void register(BaseBotCommand command);

    void remove(BaseBotCommand command);

    boolean isCommand(String text);

    BaseBotCommand get(String command);

    Set<String> info();

    void setDefaultCommand(BaseBotCommand command);

    BaseBotCommand getDefaultCommand();
}
