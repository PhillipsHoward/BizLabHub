package fr.wildcodeschool.hackbus;

import fr.wildcodeschool.hackbus.models.UserModel;

public interface PresenceListener {
    void onChange(UserModel user);
}
