package com.SpringCOurse.Bank.exceptions;

public class NoEnoughBalanceToWithdrawal extends Exception{
    public NoEnoughBalanceToWithdrawal(String message) {
        super(message);
    }
}
