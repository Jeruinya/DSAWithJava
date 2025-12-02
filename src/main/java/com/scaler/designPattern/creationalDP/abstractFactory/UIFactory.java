package com.scaler.designPattern.creationalDP.abstractFactory;

import com.scaler.designPattern.creationalDP.abstractFactory.component.button.Button;
import com.scaler.designPattern.creationalDP.abstractFactory.component.dropdowns.DropDown;
import com.scaler.designPattern.creationalDP.abstractFactory.component.menu.Menu;

public interface UIFactory {

    public Button createButton();
    public Menu createMenu();
    public DropDown createDropdown();
}