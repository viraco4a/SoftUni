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
        return site.matches("\\D+");
    }

    private boolean isValidNumber(String site) {
        return site.matches("\\d+");
    }
}
