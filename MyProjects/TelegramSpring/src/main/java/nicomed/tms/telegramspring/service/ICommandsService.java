package nicomed.tms.telegramspring.service;

import nicomed.tms.telegramspring.command.BaseBotCommand;

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
