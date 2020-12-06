package com.company;

import java.util.Optional;

public class SoundCard {
    private USB usb;

    public Optional<USB> getUsb() {
        return Optional.ofNullable(usb);
    }
    public void setUsb(USB usb) {
        this.usb = usb;
    }
}
