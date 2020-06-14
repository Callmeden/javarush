package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.ResourceBundle;


public class LoginCommand implements Command {
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH+"login");
    private ResourceBundle validCreditCards = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + ".verifiedCards");

    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("before"));
        boolean validAccount=false;
        while(!validAccount){
            ConsoleHelper.writeMessage(res.getString("specify.data"));
            String cardNumber="";
            String pin="";
            cardNumber = ConsoleHelper.readString();
            if(cardNumber.length()!=12)
                ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
            else {
                if (!validCreditCards.containsKey(cardNumber))
                    ConsoleHelper.writeMessage(String.format(res.getString("not.verified.format"),cardNumber));
                else {
                    pin = ConsoleHelper.readString();
                    if(pin.length()!=4)
                        ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
                    else {
                        if (pin.equals(validCreditCards.getString(cardNumber))) {
                            validAccount = true;
                            ConsoleHelper.writeMessage(String.format(res.getString("success.format"), cardNumber));
                        } else {
                            ConsoleHelper.writeMessage(String.format(res.getString("not.verified.format"),cardNumber));
                        }
                    }
                }
            }
            if(!validAccount)
                ConsoleHelper.writeMessage(res.getString("try.again.or.exit"));
        }
    }
}
