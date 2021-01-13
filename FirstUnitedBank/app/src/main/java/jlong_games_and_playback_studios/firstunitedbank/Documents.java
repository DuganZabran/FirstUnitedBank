package jlong_games_and_playback_studios.firstunitedbank;
import java.util.Random;

public class Documents 
{
    public String firstName, lastName;
    public int bMonth,bDay,bYear;
    public int[] routingNumber,accountNumber;
    private String address;
    private int expirationMonth,expirationYear;
    
    public Documents(String f,String l,int bM,int bD,int bY,int [] routNum,int [] accNum,String add,int eM,int eY){
        firstName = f;
        lastName = l;
        bMonth = bM;
        bDay = bD;
        bYear = bY;
        routingNumber = routNum;
        accountNumber = accNum;
        address = add;
        expirationMonth = eM;
        expirationYear = eY;
    }

    public String[] getFirstName(){
        String[] toReturn = {firstName,"0"};
        return toReturn;
    }

    public String[] getLastName(){
        String[] toReturn = {lastName,"0"};
        return toReturn;
    }

    public String[] getName(){
        String[] toReturn = {firstName + " " + lastName,"0"};
        return toReturn;
    }

    public String[] getBirthDate(){
        String[] toReturn = {"" + bMonth + "/" + bDay + "/" + bYear,"1"};
        return toReturn;
    }

    public String[] getBirthMonth(){
        String[] toReturn = {""+ bMonth,"2"};
        return toReturn;
    }

    public String[] getBirthDay(){
        String[] toReturn = {""+ bDay,"3"};
        return toReturn;
    }

    public String[] getBirthYear(){
        String[] toReturn = {""+ bYear,"4"};
        return toReturn;
    }

    public String[] getRoutingNumber(){
        String[] toReturn = {""+ routingNumber,"5"};
        return toReturn;
    }

    public String[] getAccountNumber(){
        String[] toReturn = {""+ accountNumber,"6"};
        return toReturn;
    }

    public String[] getAddress(){
        String[] toReturn = {address,"7"};
        return toReturn;
    }

    public String[] getExpirationMonth(){
        String[] toReturn = {"" + expirationMonth,"8"};
        return toReturn;
    }

    public String[] getExpirationYear(){
        String[] toReturn = {"" + expirationYear,"9"};
        return toReturn;
    }

    public String[] getExpirationDate(){
        String[] toReturn = {expirationMonth + "/" + expirationYear,"2"};
        return toReturn;
    }

}