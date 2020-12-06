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

            //Nested Objects
        Computer c = new Computer();
        SoundCard s = new SoundCard();
        USB u = new USB();
        u.setUsbname("USB 32GB");
        s.setUsb(u);
        c.setSoundCard(s);
        //You can pass c gor getting usb name or you can pass null computer object to see orElse val
        Computer computer = new Computer();
        String usbName = Optional.ofNullable(computer)
                .flatMap(comp -> comp.getSoundCard())
                .flatMap(sndcard -> sndcard.getUsb())
                .map(usb -> usb.getUsbname()).orElse("The Value Can Not Determined");

        System.out.println(usbName);
    }
}
