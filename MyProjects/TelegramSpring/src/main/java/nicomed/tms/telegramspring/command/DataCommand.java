package nicomed.tms.telegramspring.command;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import nicomed.tms.telegramspring.enums.Grade;
import nicomed.tms.telegramspring.model.City;
import nicomed.tms.telegramspring.model.Place;
import nicomed.tms.telegramspring.service.IDataService;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.partitioningBy;
import static java.util.stream.Collectors.toList;

@Slf4j
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class DataCommand extends BaseBotCommand {

    private final IDataService service;

    public DataCommand(IDataService service) {
        super("data", "получение информации о городе\n");
        this.service = service;
    }

    public DataCommand(String command, String description, IDataService service) {
        super(command, description);
        this.service = service;
    }

    @Override
    public String getMessageText() {
        return "Не знаю такого города";
    }

    @Override
    public String getMessageText(String text) {
        City city = service.findCityByName(text.toLowerCase());
        log.info("dataCommand city -" + city);
        if (city != null) {
            return "\n" + getString(
                    StringUtils.capitalize(text),
                    service.findAllPlacesByCity(city).stream()
                            .collect(partitioningBy(
                                    v -> v.getGrade() == Grade.GOOD,
                                    toList())));
        }
        return "Не знаю такого города";
    }

    private String getString(String city, Map<Boolean, List<Place>> list) {
        String good = "";
        if (list.get(true).size() != 0) {
            good = " Надо посетить " + getStringByList(list.get(true)) + ".";
        }
        String bad = "";
        if (list.get(false).size() != 0) {
            bad = " Не надо посещать " + getStringByList(list.get(false));
        }
        return city + good + bad + ".\n";
    }

    private String getStringByList(List<Place> list) {
        return list.stream()
                .map(place -> String.join(",", place.getName()))
                .collect(Collectors.joining(","));
    }

}
