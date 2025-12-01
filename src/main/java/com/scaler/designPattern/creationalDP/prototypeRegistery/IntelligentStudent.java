package com.scaler.designPattern.creationalDP.prototypeRegistery;

//creating clone for child -->
public class IntelligentStudent extends Student {
    int iq; //

    public IntelligentStudent(){}

    public IntelligentStudent(IntelligentStudent s){
        super(s);
        this.iq = s.iq;
    }
}