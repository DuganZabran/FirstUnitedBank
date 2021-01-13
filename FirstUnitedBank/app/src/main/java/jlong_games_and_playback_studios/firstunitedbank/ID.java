package jlong_games_and_playback_studios.firstunitedbank;

import android.content.res.Resources;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Write a description of class ID here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ID {
    public String firstName, lastName;
    public int bMonth, bDay, bYear;
    private String address;
    private int expirationMonth, expirationYear;
    private boolean isMale;
    private Resources resources;

    public ID(String f, String l, int bM, int bD, int bY, String add, int eM, int eY, boolean male, Resources res) {
        firstName = f;
        lastName = l;
        bMonth = bM;
        bDay = bD;
        bYear = bY;
        address = add;
        expirationMonth = eM;
        expirationYear = eY;
        isMale = male;
        resources = res;
    }

    //for each System.out.print I need you to set it to a random string value that corresponds to the print CREATE THE ERROR
    public void errorID() {
        int error = (int) (Math.random() * 3);
        if (error == 0) {
            int errorID = (int) (Math.random() * 2);
            if (errorID == 0) {
                ArrayList<String> nameList = new ArrayList<>();
                try {
                    boolean isMale = false;
                    if ((int)Math.random()*2 > 1){
                        isMale = true;
                    }
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
            if (errorID == 1) {
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
        } else if (error == 1) {
            bMonth = (int) (Math.random() * (12 - 1)) + 1;
            bYear = (int) (Math.random() * (2001 - 1970)) + 1970;
            bDay = (int) (Math.random() * (31 - 1)) + 1;
        } else if (error == 2) {
            String add;

            add = "" + ((int) (Math.random() * 999));

            ArrayList<String> addressList = new ArrayList<>();
            try {
                InputStream in = null;
                //Open the file
                in = resources.openRawResource(R.raw.street_names_list);
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                String line;
                while ((line = reader.readLine()) != null) {
                    addressList.add(line);
                }
                address = add + " " + addressList.get((int) (Math.random()*addressList.size()));
            } catch (IOException theseHands) {
                theseHands.printStackTrace();
            }
        } else if (error == 3) {
            if ((int)(Math.random()*2) == 1) {
                isMale = true;
            } else {
                isMale = false;
            }
        } /*else if (error == 4) {
            System.out.println("ID, Photo");
        }*/
    }

    public String[] getName() {
        String[] toReturn = {firstName + " " + lastName, "0"};
        return toReturn;
    }

    public String[] getBirthDate() {
        String[] toReturn = {"" + bMonth + "/" + bDay + "/" + bYear, "1"};
        return toReturn;
    }

    public String[] getExpirationDate() {
        String[] toReturn = {"" + expirationMonth + "/" + expirationYear, "2"};
        return toReturn;
    }

    public String[] getSex() {
        String[] toReturn = {"", "6"};
        if (isMale) {
            toReturn[0] = "Male";
        } else {
            toReturn[0] = "Female";
        }
        return toReturn;
    }

    public String[] getFirstName() {
        String[] toReturn = {firstName, "0"};
        return toReturn;
    }

    public String[] getLastName() {
        String[] toReturn = {lastName, "1"};
        return toReturn;
    }

    public String[] getBirthMonth() {
        String[] toReturn = {"" + bMonth, "2"};
        return toReturn;
    }

    public String[] getBirthDay() {
        String[] toReturn = {"" + bDay, "3"};
        return toReturn;
    }

    public String[] getBirthYear() {
        String[] toReturn = {"" + bYear, "4"};
        return toReturn;
    }

    public String[] getAddress() {
        String[] toReturn = {address, "7"};
        return toReturn;
    }

    public String[] getExpirationMonth() {
        String[] toReturn = {"" + expirationMonth, "8"};
        return toReturn;
    }

    public String[] getExpirationYear() {
        String[] toReturn = {"" + expirationYear, "9"};
        return toReturn;
    }

    public String[] getHeight() {
        int feet = (int) (Math.random() * (7 - 5)) + 5;
        int inches = (int) (Math.random() * 11);
        if (isMale == false) {
            feet = 5;
        }
        String[] toReturn = {"" + feet + "\"" + inches + "'", "7"};
        return toReturn;
    }

    public String getWeight() {
        int lbs;
        if (isMale) {
            lbs = (int) (Math.random() * (250 - 170)) + 170;
        } else {
            lbs = (int) (Math.random() * (200 - 100)) + 100;
        }
        return lbs + " lbs.";
    }
}
