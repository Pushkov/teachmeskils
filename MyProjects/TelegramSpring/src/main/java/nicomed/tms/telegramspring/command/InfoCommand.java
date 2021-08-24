package nicomed.tms.telegramspring.command;

import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;

public class InfoCommand extends BotCommand implements MyBotCommand {

    public InfoCommand() {
        super("info", "информация о приложении\n");
    }


    @Override
    public String getMessageText() {
        return null;
    }
}
