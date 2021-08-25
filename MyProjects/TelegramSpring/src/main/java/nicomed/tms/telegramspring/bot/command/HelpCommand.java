package nicomed.tms.telegramspring.bot.command;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import nicomed.tms.telegramspring.bot.service.ICommandsService;

import java.util.stream.Collectors;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class HelpCommand extends BaseBotCommand {

    private final ICommandsService service;

    public HelpCommand(ICommandsService service) {
        super("help", "информация о доступных командах\n");
        this.service = service;
    }

    @Override
    public String getMessageText() {
        return "Список доступных команд\n"
                + service.info().stream()
                .map(s -> "/" + s)
                .collect(Collectors.joining("\n"));
    }

    @Override
    public String getMessageText(String text) {
        return getMessageText();
    }


}
