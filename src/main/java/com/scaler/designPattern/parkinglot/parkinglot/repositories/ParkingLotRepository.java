package com.scaler.designPattern.parkinglot.parkinglot.repositories;


import com.scaler.designPattern.parkinglot.parkinglot.models.Gate;
import com.scaler.designPattern.parkinglot.parkinglot.models.ParkingLot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLotRepository {

    private Map<Long, ParkingLot> parkingLots = new HashMap<>();

    public ParkingLot getParkingLotWithGate(Gate gate) {
        for (ParkingLot parkingLot: parkingLots.values()) {
            if (parkingLot.getGates().contains(gate)) {
                return parkingLot;
            }
        }

        return null;
    }
}
