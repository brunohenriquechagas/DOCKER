package com.mycompany.swing;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ThreadLocalRandom;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.TelegramBot;

public class KeepSwimming_TelegramBot extends TelegramLongPollingBot {

    public KeepSwimming_TelegramBot(Boolean seila) {
        this.seila = seila;
    }

    private String prc = "";

    public String getPrc() {
        return prc;
    }

    public void setPrc(String prc) {
        this.prc = prc;
    }

    private String token = DadosBot.BOT_TOKEN;

    private Boolean seila;

    @Override
    public String getBotUsername() {
        return DadosBot.BOT_USER_NAME;
    }

    @Override
    public String getBotToken() {
        return DadosBot.BOT_TOKEN;
    }

    @Override
    public void onUpdateReceived(Update update) {
        Log log = new Log();
        log.criarLog("====================TelegramBot====================");

        if (update.hasMessage() && update.getMessage().hasText()) {
            var mensagem = responder(update);
            try {
                execute(mensagem);
                log.criarLog("Mensagem recebida do telegram");

            } catch (TelegramApiException e) {
                e.printStackTrace();
                log.criarLog("houve um erro ao receber a mensagem do telegram");
            }
        }
    }

    private SendMessage responder(Update update) {

        Log log = new Log();
        log.criarLog("Interagindo com usuario no Telegram");

        var textoMensagem = update.getMessage().getText().toLowerCase();
        var chatId = update.getMessage().getChatId().toString();

        var resposta = "";
        var resposta2 = "";

        Integer enviaCodigo = ThreadLocalRandom.current().nextInt(1000, 5000);
        String codigoFormatado = enviaCodigo.toString();

        if ("/data".equals(textoMensagem)) {
            resposta = getData();
        } else if (textoMensagem.startsWith("/token")) {
            resposta = codigoFormatado;
        } else if (textoMensagem.startsWith("/hora")) {
            resposta = getHora();
        } else if (textoMensagem.startsWith("ola") || textoMensagem.startsWith("olá") || textoMensagem.startsWith("/oi")) {
            resposta = "Olá, Bem vindo a Keep Swimming!\nComo podemos te ajudar?!😉";
        } else if (textoMensagem.startsWith("quem é você") || textoMensagem.startsWith("quem e voce")) {
            resposta = "\uD83E\uDD16 Somos uma empresa de monitoramento de monitoramento de hardaware e IDES!!\nPara mais informaçoes acesse nosso site!😉\n http://www.localhost:3333/";
        } else if (textoMensagem.startsWith("/status")) {
            alertaParaTelegram alertas = new alertaParaTelegram();
            Long resp = alertas.getMedia();

            resposta = String.format("Aqui esta a media da memoria usada pelos funcionario:%s\nGostaria de ver funcionarios abaixo da media?? \n\tDigite /Funcionario", resp.toString());
        } else if (textoMensagem.startsWith("/funcionario")) {
            alertaParaTelegram alertas = new alertaParaTelegram();
            String resp1 = alertas.getAbaixoDaMedia();
            System.out.println(resp1);
            List<String>retorno = alertas.getTopDezProcessos("spNote");

            resposta = String.format("Funcionario abaixo da media:\n %s\n\n\nPuxando processos mais utilizados:\n\n.\n.\n\n%s", resp1,retorno);
        } 
            
        else {
            resposta = "Não entendi!\nDigite /help para ver os comandos disponíveis.\nOu se preferir entre em contato com nosso suporte!!\nhttps://app.pipefy.com/public/form/w7YSTr_A";
        }

        return SendMessage.builder()
                .text(resposta)
                .chatId(chatId)
                .build();
    }

   
    private String getData() {
        var formatter = new SimpleDateFormat("dd/MM/yyyy");
        return "A data atual é: " + formatter.format(new Date());
    }

    private String getHora() {
        var formatter = new SimpleDateFormat("HH:mm:ss");
        return "A hora atual é: " + formatter.format(new Date());
    }

//    public static void sendToTelegram() {
//        String urlString = "https://api.telegram.org/bot%s/sendMessage?chat_id=%s&text=%s";
//        //Telegram token 
//        String apiToken = "5226424793:AAEqECvlTAc_63u7hl702KBKS5HiF7PHrmE";
//
//        //chatId 
//        String chatId = "-667290625";
//        //Message
//        String text = "Olá, Bem vindo a Keep Swimming!.Logamos com sucesso na plataforma!😉";
//
//        urlString = String.format(urlString, apiToken, chatId, text);
//        System.out.println("\nEnviamos uma mensagem a essa url com sucesso = "+ urlString);
//
//        try {
//            URL url = new URL(urlString);
//            URLConnection conn = url.openConnection();
//            InputStream is = new BufferedInputStream(conn.getInputStream());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
    public static void sendToTelegramToken(String txt) {
        String urlString = "https://api.telegram.org/bot%s/sendMessage?chat_id=%s&text=%s";
        //Telegram token 
        String apiToken = "5226424793:AAEqECvlTAc_63u7hl702KBKS5HiF7PHrmE";

        //chatId 
        String chatId = "-667290625";
        //Message
        String text = String.format("Seu token é: %s .Se você nao solicitou entre em contanto imediantamente conosco!!", txt);

        urlString = String.format(urlString, apiToken, chatId, text);
        System.out.println("\nEnviamos uma mensagem a essa url com sucesso = " + urlString);

        try {
            URL url = new URL(urlString);
            URLConnection conn = url.openConnection();
            InputStream is = new BufferedInputStream(conn.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
