package com.scaler.designPattern.parkinglot.parkinglot.strategies.spotassignment;


import com.scaler.designPattern.parkinglot.parkinglot.models.Gate;
import com.scaler.designPattern.parkinglot.parkinglot.models.ParkingSpot;
import com.scaler.designPattern.parkinglot.parkinglot.models.VehicleType;

public interface SpotAssignmentStrategy {
    ParkingSpot assignSpot(VehicleType vehicleType, Gate gate);
}
