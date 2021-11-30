package com.optum.fs.rest.service.util.com.amazon.interview.experience.experience15;

class PetrolPump {
    int petrol;
    int distance;

    public PetrolPump(int petrol, int distance) {
        this.petrol = petrol;
        this.distance = distance;
    }
}

public class CircularPetrolpumpTour {

    public static void main(String[] args) {
        PetrolPump[] arr = {new PetrolPump(6, 4),
                new PetrolPump(3, 6),
                new PetrolPump(7, 3)};

        int start = printTour(arr, arr.length);

        System.out.println(start == -1 ? "No Solution" : "Start = " + start);
    }

    private static int printTour(PetrolPump[] arr, int length) {
        int start = 0;
        int end = 1;
        int currPetrol = arr[start].petrol - arr[start].distance;
        while (currPetrol < 0 || end != start) {
            while (currPetrol < 0 && start != end) {
                currPetrol = currPetrol - (arr[start].petrol - arr[start].distance);
                start = (start + 1) % length;
                if (start == 0) {
                    return -1;
                }

            }
            currPetrol = currPetrol + arr[end].petrol - arr[end].distance;
            end = (end + 1) % length;
        }
        return start;
    }
}
