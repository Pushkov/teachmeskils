package nicomed.tms.telegramspring.bot;

import nicomed.tms.telegramspring.command.CommandManager;
import nicomed.tms.telegramspring.command.CommandParser;
import nicomed.tms.telegramspring.enums.Command;
import nicomed.tms.telegramspring.model.Place;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class NicomedLongPullingBot extends TelegramLongPollingBot {
    private final CommandParser commandParser;
    private final CommandManager commandManager;

    @Value("${bot.token}")
    private String TOKEN;
    @Value("${bot.username}")
    private String USER_NAME;
    @Value("${bot.name}")
    private String NAME;

    public NicomedLongPullingBot(CommandParser commandParser, CommandManager commandManager) {
        this.commandParser = commandParser;
        this.commandManager = commandManager;
    }

    @Override
    public String getBotToken() {
        return TOKEN;
    }

    @Override
    public String getBotUsername() {
        return USER_NAME;
    }


    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {
            if (update.getMessage() != null && update.getMessage().hasText()) {
                String receivedText = update.getMessage().getText();
                String chatType = update.getMessage().getChat().getType();
                String chatId = update.getMessage().getChatId().toString();

                String message;
                if (commandParser.isCommand(receivedText)) {
                    if (commandParser.isCommandForMe(receivedText, chatType)) {
                        Command command = commandParser.getCommand(receivedText);
                        message = commandManager.getStringByCommand(command);
                        sendMessage(new SendMessage(chatId, message));
                    }
                } else {
                    message = commandManager.getStringByReceivedText(receivedText);
                    sendMessage(new SendMessage(chatId, message));
                }
            }
        } else if (update.hasCallbackQuery()) {

        }
    }

//    private String getStringByCity(String receivedText, City city) {
//        return "\n" + getString(
//                StringUtils.capitalize(receivedText),
//                placeService.findAllByCity(city).stream()
//                        .collect(partitioningBy(
//                                v -> v.getGrade() == Grade.GOOD,
//                                toList())));
//    }

    private void sendMessage(SendMessage message) {
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
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
