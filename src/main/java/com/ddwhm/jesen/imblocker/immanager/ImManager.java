package com.ddwhm.jesen.imblocker.immanager;

public interface ImManager {
    default void makeOn() {
    }

    default void makeOff() {
    }

    default boolean getStatus() {
        return false;
    }
}
