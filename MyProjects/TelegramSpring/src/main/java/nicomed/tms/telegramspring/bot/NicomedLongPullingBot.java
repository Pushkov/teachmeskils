package nicomed.tms.telegramspring.bot;

import nicomed.tms.telegramspring.Grade;
import nicomed.tms.telegramspring.model.City;
import nicomed.tms.telegramspring.model.Place;
import nicomed.tms.telegramspring.service.CityService;
import nicomed.tms.telegramspring.service.PlaceService;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.partitioningBy;
import static java.util.stream.Collectors.toList;
import static nicomed.tms.telegramspring.bot.NicBotConfig.TOKEN;
import static nicomed.tms.telegramspring.bot.NicBotConfig.USER_NAME;

@Component
public class NicomedLongPullingBot extends TelegramLongPollingBot {
    private final CityService cityService;
    private final PlaceService placeService;

    public NicomedLongPullingBot(CityService cityService, PlaceService placeService) {
        this.cityService = cityService;
        this.placeService = placeService;
    }

    @Override
    public String getBotUsername() {
        return USER_NAME;
    }

    @Override
    public String getBotToken() {
        return TOKEN;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.getMessage() != null && update.getMessage().hasText()) {
            String chatId = update.getMessage().getChatId().toString();
            System.out.println("");
            try {
                String cityName = update.getMessage().getText();
                String s = "*";
                if (cityService.findCityByName(cityName) != null) {
                    City city = cityService.findCityByName(cityName);
                    s = "\n" + getString(
                            cityName,
                            placeService.findAllByCity(city).stream()
                                    .collect(partitioningBy(
                                            v -> v.getGrade() == Grade.GOOD,
                                            toList()))
                    );
                } else {
                    s = "Не знаю такого города";
                }
                execute(new SendMessage(chatId, s));
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
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
