package jlong_games_and_playback_studios.firstunitedbank;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Person
{
    private String firstName, lastName,address;
    private int bMonth, bDay, bYear,eMonth,eYear;
    private int [] routingNumber = new int[9], accountNumber = new int[9];
    private boolean isMale;
    private static Resources resources;
    private boolean isError;
    private ImageView photo;

    public Check check;
    public ID id;
    public Passport passport;

    public Person(Resources r, ImageView pic){
        photo = pic;
        resources = r;
        if ((int) (Math.random()*2) > 0){
            isMale = true;
        } else{
            isMale = false;
        }
        setRoutingNumber();
        setAccountNumber();
        setFirstName();
        setLastName();
        setAddress();
        setBirthDate();
        setExpirationDate();
        setPhoto();
        isError = true;
        check = new Check(firstName,lastName,bMonth,bDay,bYear,routingNumber,accountNumber,resources);
        id = new ID(firstName,lastName,bMonth,bDay,bYear,address,eMonth,eYear,isMale,resources);
        passport = new Passport(firstName,lastName,bMonth,bDay,bYear,address,eMonth,eYear,isMale,resources);
    }

    public boolean boolError() {
        return isError;
    }

    public void error() {
        int errorPercentage = (int)(Math.random()*100);
        if(errorPercentage < 35) {
            isError = false;
            int errorPerson = (int)(Math.random()*3);
            if(errorPerson == 0) {
                id.errorID();
            }
            else if(errorPerson == 1) {
                passport.errorPassport();
            }
            else if(errorPerson == 2) {
                check.errorCheck();
            }
        }
    }

    public void setRoutingNumber(){
        for (int i = 0; i <= 8; i++) {
            routingNumber[i] = (int) (Math.random()*9)+1;
        }
    }

    public void setAccountNumber(){
        for (int i = 0; i <= 8; i++)
        {
            accountNumber[i] = (int) (Math.random()*9)+1;
        }
    }

    public void setFirstName(){
        ArrayList<String> nameList = new ArrayList<>();
        try {
            InputStream in = null;
            //Open the file
            if (isMale) {
                in = resources.openRawResource(R.raw.male_first_name_list);
            } else if(isMale == false){
                in = resources.openRawResource(R.raw.female_first_names);}

            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String line;

            while ((line = reader.readLine()) != null){
                nameList.add(line);
            }

            firstName = nameList.get((int)(Math.random()*nameList.size()));
        } catch (IOException theseHands) {
            theseHands.printStackTrace();
        }
    }

    public void setLastName(){
        ArrayList<String> nameList = new ArrayList<>();
        try {
            InputStream in = null;
            //Open the file
                in = resources.openRawResource(R.raw.last_named_list);

            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String line;

            while ((line = reader.readLine()) != null){
                nameList.add(line);
            }

            lastName = nameList.get((int)(Math.random()*nameList.size()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setPhoto() {
        if (isMale){
            int rand = (int)(Math.random()*5);
            if (rand == 0){
                photo.setForeground(resources.getDrawable(R.drawable.photo_male_1,null));
            } else if(rand == 1){
                photo.setForeground(resources.getDrawable(R.drawable.photo_male_2,null));
            } else if (rand == 2){
                photo.setForeground(resources.getDrawable(R.drawable.photo_male_3,null));
            } else if (rand == 3){
                photo.setForeground(resources.getDrawable(R.drawable.photo_male_4,null));
            } else if (rand == 4){
                photo.setForeground(resources.getDrawable(R.drawable.photo_male_5,null));
            }
        } else{
            int rand = (int) (Math.random()* 3);
            if (rand == 0) {
                photo.setForeground(resources.getDrawable(R.drawable.photo_female_1, null));
            } else if (rand == 1){
                photo.setForeground(resources.getDrawable(R.drawable.photo_female_2,null));
            } else if (rand == 2){
                photo.setForeground(resources.getDrawable(R.drawable.photo_female_3,null));
            }
        }
    }

    public void setAddress(){
       String add;

       add = "" + ((int) (Math.random()*999));

        ArrayList<String> addressList = new ArrayList<>();
        try {
            InputStream in = null;
            //Open the file
                in = resources.openRawResource(R.raw.street_names_list);
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String line;
            while ((line = reader.readLine()) != null){
                addressList.add(line);
            }
            address = add + " " + addressList.get((int) (Math.random()*addressList.size()));
        } catch (IOException theseHands) {
            theseHands.printStackTrace();
        }


    }

    public void setBirthDate(){
        bMonth = (int) (Math.random()*(12-1))+1;
        bYear = (int) (Math.random()*(2001-1970)) + 1970;
        bDay = (int) (Math.random()*(31-1))+1;
    }

    public void setExpirationDate(){
        eYear = (int) (Math.random()*(2001-1970)) + 1970;
        eMonth = (int) (Math.random()*(12-1))+1;
    }

    public ImageView getPhoto(){
        return photo;
    }
}