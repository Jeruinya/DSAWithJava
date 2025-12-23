package com.scaler.designPattern.parkinglot.parkinglot.strategies.feescalculation;


import com.scaler.designPattern.parkinglot.parkinglot.models.Ticket;

public interface FeesCalculationStrategy {
    int calculateFees(Ticket ticket);
}
