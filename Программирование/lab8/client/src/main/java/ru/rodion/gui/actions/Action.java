package ru.rodion.gui.actions;


import ru.rodion.gui.GuiManager;
import ru.rodion.network.User;
import ru.rodion.utility.Client;

import javax.swing.*;
import java.util.ResourceBundle;

public abstract class Action extends AbstractAction {
    protected ResourceBundle resourceBundle;

    protected User user;
    protected Client client;
    protected GuiManager guiManager;

    public Action(User user, Client client, GuiManager guiManager) {
        this.user = user;
        this.client = client;
        this.guiManager = guiManager;
        this.resourceBundle = ResourceBundle.getBundle("GuiLabels", guiManager.getLocale());
    }
}
