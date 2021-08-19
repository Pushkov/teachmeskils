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
                List<City> list = cityService.findAll();
                String mess = "*";
                if (list.size() > 0) {
                    mess = list.stream()
                            .map(City::getName)
                            .collect(Collectors.joining(",\n", "\n", "\n"));
                    printList(list);


//                    Map<String, Map<Boolean, List<Place>>> map = list.stream()
//                            .collect(Collectors.toMap(City::getName,
//                                    m -> getMapPlaces(placeService.findAllByCity(m))));
//                    System.out.println(map);

//                    List<String> mm = map.entrySet().stream()
//                            .map((k,v) -> "" + k + " " + getStringFromMap(v))
//                            .collect(Collectors.toList());


                }

                execute(new SendMessage(chatId, "test message: " + mess));
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    private List<String> getStringFromMap(Map<Boolean, List<Place>> map) {
        map.values()
                .stream()
                .map(this::getStringByList)
                .collect(toList());

        return null;
    }

    private String getStringByList(List<Place> list) {
        String res = list.stream()
                .map(place -> String.join(",", place.getName()))
                .collect(Collectors.joining(","));
            /*
                    String stringOk = listOk.stream()
                .map(reader -> join(" ", List.of(reader.getFirstName(), reader.getLastName())))
                .collect(joining(",", "{", "}"));
             */

        return "";
    }


    private Map<Boolean, List<Place>> getMapPlaces(List<Place> list) {
        return list.stream()
                .collect(partitioningBy(
                        place -> place.getGrade() == Grade.GOOD,
                        toList()
                ));
    }

    private List<String> getPlacesName(List<Place> list) {
        return list.stream()
                .map(Place::getName)
                .collect(Collectors.toList());
    }

    private void printList(List<City> list) {
        list.forEach(System.out::println);
    }

//    private void printMap(Map<String,Map<Boolean,List<Place>>> map) {
//        map.entrySet().stream()
//                .map((k,v)-> {
//                    String.join()
//                });
//
//    }

}
