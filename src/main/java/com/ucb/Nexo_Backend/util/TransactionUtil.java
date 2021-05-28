package com.ucb.Nexo_Backend.util;

import com.ucb.Nexo_Backend.models.Transaction;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

public class TransactionUtil {
    public Transaction createTransaction(HttpServletRequest request) {
        Transaction transaction = new Transaction();
        transaction.setTxDate(new Date());
        transaction.setTxUpdate(new Date());
        transaction.setTxHost(request.getRemoteHost());
        transaction.setTxIdAdmi(1);
        return transaction;
    }
}
