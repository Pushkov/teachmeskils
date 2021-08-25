package nicomed.tms.telegramspring.command;

import lombok.NonNull;
import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;

public abstract class BaseBotCommand extends BotCommand {

    public BaseBotCommand(@NonNull String command, @NonNull String description) {
        super(command, description);
    }

    public abstract String getMessageText();

    public abstract String getMessageText(String text);
}
