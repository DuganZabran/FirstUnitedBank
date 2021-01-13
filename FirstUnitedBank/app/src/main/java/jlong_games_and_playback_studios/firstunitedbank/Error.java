package jlong_games_and_playback_studios.firstunitedbank;

public class Error
{
    public static void main(String[]args) {
        for(int i = 0; i < 100; i++) {
            error();
        }
    }
    public static void error() {
        int errorPercentage = (int)(Math.random()*101);
        if(errorPercentage <= 25) {
            int errorPerson = (int)(Math.random()*3);
            if(errorPerson == 0) {
                errorID();
            }
            else if(errorPerson == 1) {
                errorPassport();
            }
            else if(errorPerson == 2) {
                errorCheck();
            }
        }
    }
    public static void errorID() {
        int error = (int)(Math.random()*5);
        if(error == 0) {
            System.out.println("ID, Name");
        }
        else if(error == 1) {
            System.out.println("ID, DoB");
        }
        else if(error == 2) {
            System.out.println("ID, Address");
        }
        else if(error == 3) {
            System.out.println("ID, Sex");
        }
        else if(error == 4) {
            System.out.println("ID, Photo");
        }
    }
    public static void errorPassport() {
        int error = (int)(Math.random()*5);
        if(error == 0) {
            System.out.println("Passport, Name");
        }
        else if(error == 1) {
            System.out.println("Passport, DoB");
        }
        else if(error == 2) {
            System.out.println("Passport, Address");
        }
        else if(error == 3) {
            System.out.println("Passport, Sex");
        }
        else if(error == 4) {
            System.out.println("Passport, Photo");
        }
    }
    public static void errorCheck() {
        System.out.println("Check, Name");
    }
}
