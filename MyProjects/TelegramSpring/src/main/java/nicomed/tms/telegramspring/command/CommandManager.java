package nicomed.tms.telegramspring.command;

import nicomed.tms.telegramspring.enums.Command;
import nicomed.tms.telegramspring.enums.Grade;
import nicomed.tms.telegramspring.model.City;
import nicomed.tms.telegramspring.model.Place;
import nicomed.tms.telegramspring.service.DataService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.partitioningBy;
import static java.util.stream.Collectors.toList;

@Component
public class CommandManager {
    private final DataService service;

    public CommandManager(DataService service) {
        this.service = service;
    }

    public String getStringByReceivedText(String text) {
        City city = service.findCityByName(text.toLowerCase());
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

    public String getStringByCommand(Command command) {
        String result;
        switch (command) {
            case NONE:
                result = "None";
                break;
            case HELP:
                result = "Список доступных команд:\n"
                        + "/info\n"
                        + "/add_city\n"
                        + "/remove_city\n"
                        + "/add_place\n"
                        + "/remove_place\n";
                break;
            case INFO:
                result = getString_INFO();
                break;
            case START:
                result = "Добро пожаловать в приложение:";
                break;
            case ADD_CITY:
                result = "add city";
                break;
            case REMOVE_CITY:
                result = "remove city";
                break;
            case ADD_PLACE:
                result = "add place to city";
                break;
            case REMOVE_PLACE:
                result = "remove place";
                break;
            case NON_COMMAND:
            default:
                result = "Команда не распознана";
                break;
        }

        return result;
    }

    private String getString_INFO() {
        String result;
        result = "Список доступных городов\n"
                + service.findAllCities().stream()
                .map(City::getName)
                .map(StringUtils::capitalize)
                .collect(Collectors.joining(",\n"));
        return result;
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
