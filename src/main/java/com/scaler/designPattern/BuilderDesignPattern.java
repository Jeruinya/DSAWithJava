package com.scaler.designPattern;

import com.scaler.design.impl.CivilEngineer;
import com.scaler.design.impl.House;
import com.scaler.design.impl.HouseBuilder;
import com.scaler.design.impl.IglooHouseBuilder;

class BuilderDesignPattern
{
    public static void main(String[] args)
    {
        HouseBuilder iglooBuilder = new IglooHouseBuilder();
        CivilEngineer engineer = new CivilEngineer(iglooBuilder);
 
        engineer.constructHouse();
 
        House house = engineer.getHouse();
 
        System.out.println("Builder constructed: "+ house);
    }
}