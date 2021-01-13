package jlong_games_and_playback_studios.firstunitedbank;

import android.content.res.Resources;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.text.DecimalFormat;

/**
 * Write a description of class Check here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Check {
    public String firstName, lastName;
    public int bMonth, bDay, bYear, amountTotal;
    public int[] routingNumber, accountNumber;
    private String payOrderTo, writtenAmount;
    private static Resources resources;
    private EnglishNumberToWords e = new EnglishNumberToWords();

    public Check(String f, String l, int bM, int bD, int bY, int[] routNum, int[] accNum, Resources re) {
        firstName = f;
        lastName = l;
        bMonth = bM;
        bDay = bD;
        bYear = bY;
        routingNumber = routNum;
        accountNumber = accNum;
        resources = re;
        setPayOrderTo();
        setAmountTotal();
    }


    //The system.out.prints are going to be changed to a random value which it requires JACOB!!!!!!!
    public void errorCheck() {
        int n = (int) Math.random() * 2;
        if (n == 0) {
            ArrayList<String> nameList = new ArrayList<>();
            try {
               boolean isMale = false;
                if ((int)(Math.random()*2) > 0){
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
        if (n == 1) {
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
    }

    public String[] getName() {
        String[] toReturn = {firstName + " " + lastName, "0"};
        return toReturn;
    } //0

    public String[] getBirthDate() {
        String[] toReturn = {"" + bMonth + "/" + bDay + "/" + bYear, "1"};
        return toReturn;
    }//1

    public String[] getPayOrderTo() {
        String[] toReturn = {payOrderTo, "3"};
        return toReturn;
    }//3

    public String[] getAmountTotal() {
        String[] toReturn = {"" + amountTotal, "4"};
        return toReturn;
    }//4

    public String[] getWrittenTotal() {
        String[] toReturn = {writtenAmount, "5"};
        return toReturn;
    }//5

    public void setPayOrderTo() {
        String tempFirstName, tempLastName;

        ArrayList<String> nameList = new ArrayList<>();
        InputStream in = null;
        boolean isMale;
        if ((int) (Math.random()) == 0) {
            isMale = true;
        } else {
            isMale = false;
        }
        //Open the file
        if (isMale) {
            in = resources.openRawResource(R.raw.male_first_name_list);
        } else if (isMale == false) {
            in = resources.openRawResource(R.raw.female_first_names);
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                nameList.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        tempFirstName = nameList.get(((int) (Math.random()) * nameList.size()));


        ArrayList<String> nameListLast = new ArrayList<>();
        try {

            //Open the file
            in = resources.openRawResource(R.raw.last_named_list);

            BufferedReader readerLast = new BufferedReader(new InputStreamReader(in));
            String lineLast;

            while ((lineLast = readerLast.readLine()) != null) {
                nameListLast.add(lineLast);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        tempLastName = nameListLast.get(((int) (Math.random()) * nameListLast.size()));
        payOrderTo = tempFirstName + " " + tempLastName;

    }

    public void setAmountTotal() {
        amountTotal = (int) (Math.random() * 999) + 1;
        writtenAmount = setMoneyWord();
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

    public String[] getRoutingNumber() {
        String[] toReturn = {"" + routingNumber, "5"};
        return toReturn;
    }

    public String[] getAccountNumber() {
        String[] toReturn = {"" + accountNumber, "6"};
        return toReturn;
    }

    public String setMoneyWord() {
        String toReturn = e.convert((long) amountTotal);
        return toReturn;
    }

    public class EnglishNumberToWords {

        private final String[] tensNames = {
                "",
                " ten",
                " twenty",
                " thirty",
                " forty",
                " fifty",
                " sixty",
                " seventy",
                " eighty",
                " ninety"
        };

        private final String[] numNames = {
                "",
                " one",
                " two",
                " three",
                " four",
                " five",
                " six",
                " seven",
                " eight",
                " nine",
                " ten",
                " eleven",
                " twelve",
                " thirteen",
                " fourteen",
                " fifteen",
                " sixteen",
                " seventeen",
                " eighteen",
                " nineteen"
        };

        private EnglishNumberToWords() {
        }

        private String convertLessThanOneThousand(int number) {
            String soFar;

            if (number % 100 < 20) {
                soFar = numNames[number % 100];
                number /= 100;
            } else {
                soFar = numNames[number % 10];
                number /= 10;

                soFar = tensNames[number % 10] + soFar;
                number /= 10;
            }
            if (number == 0) return soFar;
            return numNames[number] + " hundred" + soFar;
        }


        public String convert(long number) {
            // 0 to 999 999 999 999
            if (number == 0) {
                return "zero";
            }

            String snumber = Long.toString(number);

            // pad with "0"
            String mask = "000000000000";
            DecimalFormat df = new DecimalFormat(mask);
            snumber = df.format(number);

            // XXXnnnnnnnnn
            int billions = Integer.parseInt(snumber.substring(0, 3));
            // nnnXXXnnnnnn
            int millions = Integer.parseInt(snumber.substring(3, 6));
            // nnnnnnXXXnnn
            int hundredThousands = Integer.parseInt(snumber.substring(6, 9));
            // nnnnnnnnnXXX
            int thousands = Integer.parseInt(snumber.substring(9, 12));

            String tradBillions;
            switch (billions) {
                case 0:
                    tradBillions = "";
                    break;
                case 1:
                    tradBillions = convertLessThanOneThousand(billions)
                            + " billion ";
                    break;
                default:
                    tradBillions = convertLessThanOneThousand(billions)
                            + " billion ";
            }
            String result = tradBillions;

            String tradMillions;
            switch (millions) {
                case 0:
                    tradMillions = "";
                    break;
                case 1:
                    tradMillions = convertLessThanOneThousand(millions)
                            + " million ";
                    break;
                default:
                    tradMillions = convertLessThanOneThousand(millions)
                            + " million ";
            }
            result = result + tradMillions;

            String tradHundredThousands;
            switch (hundredThousands) {
                case 0:
                    tradHundredThousands = "";
                    break;
                case 1:
                    tradHundredThousands = "one thousand ";
                    break;
                default:
                    tradHundredThousands = convertLessThanOneThousand(hundredThousands)
                            + " thousand ";
            }
            result = result + tradHundredThousands;

            String tradThousand;
            tradThousand = convertLessThanOneThousand(thousands);
            result = result + tradThousand;

            // remove extra spaces!
            return result.replaceAll("^\\s+", "").replaceAll("\\b\\s{2,}\\b", " ");
        }
    }

}



