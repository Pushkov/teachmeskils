package nicomed.tms.telegramspring.bot.command;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import nicomed.tms.telegramspring.data.model.City;
import nicomed.tms.telegramspring.data.service.IDataService;
import org.apache.commons.lang3.StringUtils;

import java.util.stream.Collectors;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class InfoCommand extends BaseBotCommand {

    private final IDataService service;

    public InfoCommand(IDataService service) {
        super("info", "информация о приложении\n");
        this.service = service;
    }

    @Override
    public String getMessageText() {
        return "Список доступных городов\n"
                + service.findAllCities().stream()
                .map(City::getName)
                .map(StringUtils::capitalize)
                .collect(Collectors.joining(",\n"));
    }

    @Override
    public String getMessageText(String text) {
        return getMessageText();
    }


}
