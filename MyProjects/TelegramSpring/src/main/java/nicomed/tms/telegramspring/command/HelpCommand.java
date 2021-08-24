package nicomed.tms.telegramspring.command;

import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;

public class HelpCommand extends BotCommand {


    public HelpCommand() {
        super("help", "список всех доступных команд\n");
    }

}
