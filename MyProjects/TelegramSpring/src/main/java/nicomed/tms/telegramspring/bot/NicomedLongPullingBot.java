package nicomed.tms.telegramspring.bot;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import static nicomed.tms.telegramspring.bot.NicBotConfig.TOKEN;
import static nicomed.tms.telegramspring.bot.NicBotConfig.USER_NAME;

@Component
public class NicomedLongPullingBot extends TelegramLongPollingBot {
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
                execute(new SendMessage(chatId, "test message"));
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }


}
