package Telephony.models;

import Telephony.contracts.Browsable;
import Telephony.contracts.Callable;

public class Smartphone implements Callable, Browsable {

    @Override
    public void Browse(String site) {
        if (isValidSite(site)){
            System.out.printf("Browsing: %s!%n", site);
        } else{
            throw new IllegalArgumentException("Invalid URL!");
        }
    }

    @Override
    public void call(String number) {
        if (isValidNumber(number)){
            System.out.printf("Calling... %s%n", number);
        } else {
            throw new IllegalArgumentException("Invalid number!");
        }
    }

    private boolean isValidSite(String site){
        for (int i = 0; i < site.length(); i++) {
             if (Character.isDigit(site.charAt(i))){
                 return  false;
             }
        }
        return true;
    }

    private boolean isValidNumber(String number) {
        for (int i = 0; i < number.length(); i++) {
            if (!Character.isDigit(number.charAt(i))){
                return  false;
            }
        }
        return true;
    }
}
