package nicomed.tms.telegramspring.bot;

import lombok.extern.slf4j.Slf4j;
import nicomed.tms.telegramspring.bot.command.*;
import nicomed.tms.telegramspring.bot.service.CommandsServiceImpl;
import nicomed.tms.telegramspring.bot.service.ICommandsService;
import nicomed.tms.telegramspring.data.service.IDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
@Slf4j
public class NicomedLongPullingBot extends TelegramLongPollingBot {

    @Value("${bot.token}")
    private String TOKEN;
    @Value("${bot.username}")
    private String USER_NAME;
    @Value("${bot.name}")
    private String NAME;

    private final ICommandsService commandsService;
    private final IDataService dataService;

    public NicomedLongPullingBot(IDataService dataService) {
        this.dataService = dataService;
        commandsService = new CommandsServiceImpl();
        initCommands();
    }

    private void initCommands() {
        commandsService.setDefaultCommand(new DataCommand(dataService));
        commandsService.register(new StartCommand());
        commandsService.register(new InfoCommand(dataService));
        commandsService.register(new HelpCommand(commandsService));
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
                Message receivedMessage = update.getMessage();
                String receivedText = receivedMessage.getText();
                String chatId = receivedMessage.getChatId().toString();
                BaseBotCommand command = commandsService.getDefaultCommand();
                if (commandsService.isCommand(receivedText)) {
                    command = commandsService.get(receivedText);
                }
                log.info("command - " + command.getCommand());
                sendMessage(new SendMessage(
                        chatId,
                        command.getMessageText(receivedText)));
            }
        } else if (update.hasCallbackQuery()) {

        }
    }

    private void sendMessage(SendMessage message) {
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
