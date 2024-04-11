package es.codegym.telegrambot;

import java.util.Map;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
 
public class MyFirstTelegramBot extends MultiSessionTelegramBot {

    public static final String NAME = "NewRichardAPBot";
    public static final String TOKEN = "7051660700:AAHAdLXbyT60MU1B2e-YeedfsPxcv0bzgig";
    String STEP_1_TEXT = TelegramBotContent.STEP_1_TEXT;
    String STEP_2_TEXT = TelegramBotContent.STEP_2_TEXT; 
    String STEP_3_TEXT = TelegramBotContent.STEP_3_TEXT;
    String STEP_4_TEXT = TelegramBotContent.STEP_4_TEXT; 
    String STEP_5_TEXT = TelegramBotContent.STEP_5_TEXT; 
    String STEP_6_TEXT = TelegramBotContent.STEP_6_TEXT; 
    String STEP_7_TEXT = TelegramBotContent.STEP_7_TEXT; 
    String STEP_8_TEXT = TelegramBotContent.STEP_8_TEXT; 
    String FINAL_TEXT = TelegramBotContent.FINAL_TEXT; 
    public MyFirstTelegramBot() {
        super(NAME, TOKEN);
    }

    @Override
    public void onUpdateEventReceived(Update update) {

        //inicio nivel 1
        if (getMessageText().equals("/start")){
            setUserGlory(0);
            sendTextMessageAsync(STEP_1_TEXT,Map.of("Hackear la nevera","step_1_btn"));
        }

        //nivel 2
        if (getCallbackQueryButtonKey().equals("step_1_btn")){
            setUserGlory(20);
            sendTextMessageAsync(STEP_2_TEXT,Map.of("¡Tomar una salchicha! +20 de fama","step_2_btn",
            "¡Tomar un pescado! +20 de fama","step_2_btn",
            "¡Tirar una lata de pepinillos! +20 de fama","step_2_btn"
            ));
        }

        //nivel 3
        if (getCallbackQueryButtonKey().equals("step_2_btn")){
            setUserGlory(20);
            sendTextMessageAsync(STEP_3_TEXT,Map.of("¡Hackear al robot aspirador","step_3_btn"));
        }

        //nivel 4
        if (getCallbackQueryButtonKey().equals("step_3_btn")){
            setUserGlory(30);

            sendPhotoMessageAsync();
            sendTextMessageAsync(STEP_4_TEXT,Map.of("¡Enviar al robot aspiradora por comida! +30 de fama","step_4_btn",
            "¡Dar un paseo en el robot aspirador! +30 de fama","step_4_btn",
            "¡Huir del robot aspirador! +30 de fama","step_4_btn"
            ));
        }

        //nivel 5
        if (getCallbackQueryButtonKey().equals("step_4_btn")){
            setUserGlory(30);
            sendTextMessageAsync(STEP_5_TEXT,Map.of("¡Enviar al robot aspiradora por comida! +30 de fama","step_5_btn",
            "¡Dar un paseo en el robot aspirador! +30 de fama","step_5_btn",
            "¡Huir del robot aspirador! +30 de fama","step_5_btn"
            ));
        }

        //nivel 6
        if (getCallbackQueryButtonKey().equals("step_5_btn")){
            setUserGlory(30);
            sendTextMessageAsync(STEP_6_TEXT,Map.of("¡Ponerse la go Pro! +40 de fama","step_6_btn",
            "¡Internet ilimitado! +40 de fama","step_6_btn",
            "¡Memoria ilimitada! +40 de fama","step_6_btn"
            ));
        }

        //nivel 7
        if (getCallbackQueryButtonKey().equals("step_6_btn")){
            setUserGlory(30);
            sendTextMessageAsync(STEP_7_TEXT,Map.of("¡Hackear la computadora!","step_7_btn"));
        }

        //nivel 8
        if (getCallbackQueryButtonKey().equals("step_7_btn")){
            setUserGlory(30);
            sendTextMessageAsync(STEP_8_TEXT,Map.of("¡Subir de Nivel! +50 de fama","step_8_btn"));
        }

        //nivel FINAL
        if (getCallbackQueryButtonKey().equals("step_8_btn")){
            setUserGlory(30);
            sendTextMessageAsync(FINAL_TEXT,Map.of("¡Salir a explorar el Mundo!","step_5_btn"));
        }


    }

    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new MyFirstTelegramBot());
    }
}