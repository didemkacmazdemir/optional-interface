package com.company;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {

        SoundCard soundcard = new SoundCard();

        // Creating empty Optional object
        Optional<SoundCard> sc = Optional.empty();

        //here is an Optional with a non-null value
        Optional<SoundCard> sc2 = Optional.of(soundcard);

    }
}
