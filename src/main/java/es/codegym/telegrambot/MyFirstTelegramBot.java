package es.codegym.telegrambot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class MyFirstTelegramBot extends MultiSessionTelegramBot {

    public static final String NAME = "NewRichardAPBot";
    public static final String TOKEN = "7051660700:AAHAdLXbyT60MU1B2e-YeedfsPxcv0bzgig";

    public MyFirstTelegramBot() {
        super(NAME, TOKEN);
    }

    @Override
    public void onUpdateEventReceived(Update update) {

        if (getMessageText().equals("/start")){
            sendTextMessageAsync("*Hola* _Monstruo_");
        }else{
            if (getMessageText().contains("hope")) {
                sendTextMessageAsync("*Coqueta*");
            }if(getMessageText().contains("niklaus"))
                sendTextMessageAsync("*Coqueto* _solo con mujeres_");
            }
        }

    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new MyFirstTelegramBot());
    }
}