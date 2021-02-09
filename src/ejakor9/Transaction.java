package ejakor9;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Transaction {
    private Date date;
    private double amount;

    public Transaction(double amount){
       this.date = new Date();
       this.amount = amount;
    }

    public String getInfo(){
        String str = amount < 0 ? "Withdraw" : "Deposit";
        return "\n" + "*****************\n" + convertDate(this.date) + "\n" + str + ": " + this.amount;
    }

    public static String convertDate(Date date){ 
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");  
        String stringDate = df.format(date);  
        return stringDate;
    }
}
