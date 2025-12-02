package com.scaler.designPattern.creationalDP.abstractFactory;

import com.scaler.designPattern.creationalDP.abstractFactory.component.button.Button;
import com.scaler.designPattern.creationalDP.abstractFactory.component.menu.Menu;

public class Client {

    public static void main(String[] args) {
        Flutter flutter = new Flutter(SupportedPlatforms.ANDROID);
        UIFactory uiFactory = flutter.createUIFactory();
        Button button = uiFactory.createButton();
        button.changeSize();

        Menu menu = uiFactory.createMenu();
    }
}