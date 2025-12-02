package com.scaler.designPattern.creationalDP.abstractFactory;

import com.scaler.designPattern.creationalDP.abstractFactory.component.button.Button;
import com.scaler.designPattern.creationalDP.abstractFactory.component.button.IosButton;
import com.scaler.designPattern.creationalDP.abstractFactory.component.dropdowns.DropDown;
import com.scaler.designPattern.creationalDP.abstractFactory.component.dropdowns.IosDropDown;
import com.scaler.designPattern.creationalDP.abstractFactory.component.menu.IosMenu;
import com.scaler.designPattern.creationalDP.abstractFactory.component.menu.Menu;

public class IosUIFactory implements UIFactory {

    @Override
    public DropDown createDropdown() {
        return new IosDropDown();
    }

    @Override
    public Button createButton() {
        return new IosButton();
    }

    @Override
    public Menu createMenu() {
        return null; //new IosMenu();
    }
}