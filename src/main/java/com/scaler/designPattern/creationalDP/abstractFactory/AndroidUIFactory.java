package com.scaler.designPattern.creationalDP.abstractFactory;

import com.scaler.designPattern.creationalDP.abstractFactory.component.button.AndroidButton;
import com.scaler.designPattern.creationalDP.abstractFactory.component.dropdowns.AndroidDropDown;
import com.scaler.designPattern.creationalDP.abstractFactory.component.menu.AndroidMenu;

public class AndroidUIFactory implements UIFactory {

    @Override
    public AndroidButton createButton() {
        return new AndroidButton();
    }

    @Override
    public AndroidDropDown createDropdown() {
        return new AndroidDropDown();
    }

    @Override
    public AndroidMenu createMenu() {
        return new AndroidMenu();
    }
}