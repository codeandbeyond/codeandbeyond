package com.optum.fs.rest.service.util.amazon.company.preparation.easy;

class ParkingSystem {
    int count[];

    public static void main(String[] args) {
        ParkingSystem parkingSystem = new ParkingSystem(1,2,3);
        parkingSystem.addCar(1);
    }

    public ParkingSystem(int big, int medium, int small) {
        count = new int[]{0, big, medium, small};
    }

    public boolean addCar(int carType) {
        return count[carType]-- > 0;
    }
}