package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class BotClient extends Client {
    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected String getUserName() throws IOException {
        int x = (int) (Math.random()*100);
        return String.format("date_bot_%d",x);
    }

    public static void main(String[] args) {
        BotClient botClient = new BotClient();
        botClient.run();
    }

    public class BotSocketThread extends SocketThread{
        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
            if (!message.contains(": ")) return;
            String userName = message.split(": ")[0];
            String command = message.replaceFirst(userName + ": ", "");
            SimpleDateFormat simpleDateFormat=null;
            switch (command){
                case "дата": simpleDateFormat=new SimpleDateFormat("d.MM.YYYY");break;
                case "день": simpleDateFormat=new SimpleDateFormat("d");break;
                case "месяц": simpleDateFormat= new SimpleDateFormat("MMMM");break;
                case "год": simpleDateFormat = new SimpleDateFormat("YYYY");break;
                case "время": simpleDateFormat= new SimpleDateFormat("H:mm:ss");break;
                case "час": simpleDateFormat = new SimpleDateFormat("H");break;
                case "минуты": simpleDateFormat = new SimpleDateFormat("m");break;
                case "секунды": simpleDateFormat = new SimpleDateFormat("s");break;
                default:return;
            }
           sendTextMessage("Информация для "+userName+": "+simpleDateFormat.format(new GregorianCalendar().getTime()));
        }

        @Override
        public void run() {
            super.run();
        }
    }
}
