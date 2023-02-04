import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class MyBot extends TelegramLongPollingBot {

    private final String telegramBotToken = "5507168949:AAGyK-hI8rvd0z3IHlwtJtM5o-pHnQrpHK8";

    private final String telegramBotUsername = "Css100SimpleBot";
    private SendMessage response;

    private SendMessage setResponseMessage(String message) {
        response = new SendMessage();

        response.setText(message);
        return response;
    }

    @Override
    public void onUpdateReceived(Update update) {
        System.out.println(update.getMessage().getText());
        System.out.println(update.getMessage().getFrom().getFirstName());


        String command = update.getMessage().getText();
        response.setChatId(update.getMessage().getChatId().toString());
        if (command.equals("/run")) {
            response = setResponseMessage("Run, Forrest Run!");
        } else if (command.equals("/start")){
            response = setResponseMessage("Start studying");
        } else if (command.equals("/ask a question")) {
            setResponseMessage("How old are you?");

        }

        try {
            execute(response);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return telegramBotUsername;
    }

    @Override
    public String getBotToken() {
        return telegramBotToken;
    }

    // Other methods, such as getBotUsername and getBotToken
}