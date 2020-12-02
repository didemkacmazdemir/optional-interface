package com.company;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {

        SoundCard soundcard = new SoundCard();

        // Creating empty Optional object
        Optional<SoundCard> sc = Optional.empty();

        //here is an Optional with a non-null value
        Optional<SoundCard> sc2 = Optional.of(soundcard);
        //you can create an Optional object that may hold a null value
        //If SoundCard were null, the resulting Optional object would be empty.
        Optional<SoundCard> sc3 = Optional.ofNullable(soundcard);

        //Old way of check object is null or not
        if(soundcard != null){
            System.out.println("soundcard is not null");
        }

        //new way
            System.out.println(sc3.isPresent());
            System.out.println(sc3.isEmpty());
    }
}
