import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class SimpleBot extends TelegramLongPollingBot {

    private final String telegramBotToken = "5507168949:AAGyK-hI8rvd0z3IHlwtJtM5o-pHnQrpHK8";

    private final String telegramBotUsername = "Css100SimpleBot";


    private SendMessage response;

    @Override
    public String getBotUsername() {
        return telegramBotUsername;
    }

    @Override
    public String getBotToken() {
        return telegramBotToken;
    }

    @Override
    public void onUpdateReceived(Update update) {
        System.out.println(update.getMessage().getText());
        System.out.println(update.getMessage().getFrom().getFirstName());


        String command = update.getMessage().getText();
        response = new SendMessage();
        response.setChatId(update.getMessage().getChatId().toString());

        try {
            setResponseMessage(command);

        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            execute(response);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }


    }

    private void setResponseMessage(String message) throws InterruptedException {

        response.setText(message);


        if (message.equals("/run")) {
            setResponseMessage("Run, Forrest Run!");
        } else if (message.equals("/start"))
            setResponseMessage("Start studying");
        else if (message.equals("Tell me joke")) {
            setResponseMessage("What do you call a fish without eyes?");

        } else if (message.equals("?")) {
            setResponseMessage("Fsy");
        }


    }
}
