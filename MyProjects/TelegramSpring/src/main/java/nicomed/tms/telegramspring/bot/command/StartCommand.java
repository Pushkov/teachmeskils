package nicomed.tms.telegramspring.bot.command;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class StartCommand extends BaseBotCommand {

    public StartCommand() {
        super("start", "приветствие\n");
    }

    @Override
    public String getMessageText() {
        return "Добро пожаловать в наше приложение.\n"
                + "  - для получения списка команд наберите команду:\n"
                + "/help" + "\n"
                + "  - для получения перечня доступных городов наберите команду:\n"
                + "/info";
    }

    @Override
    public String getMessageText(String text) {
        return getMessageText();
    }


}
