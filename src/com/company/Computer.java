package com.company;

import java.util.Optional;

public class Computer {
    private SoundCard soundCard;

    public Optional<SoundCard> getSoundCard() {
        return Optional.ofNullable(soundCard);
    }

    public void setSoundCard(SoundCard soundCard) {
        this.soundCard = soundCard;
    }
}
