package com.misc;

public class KeyIndexedSorting {
    int R = 4;
    Student[] a = new Student[]{new Student("Aswathama", 1), new Student("Dronacharaya", 2), new Student("Karna", 3),
            new Student("Duryodhan", 1), new Student("Arjun", 2), new Student("Bibhisan", 2),
            new Student("Ram", 4), new Student("Laxman", 4), new Student("Bharath", 3)};
    int N = a.length;
    Student[] aux = new Student[N];
    int[] count = new int[R + 1];

    // Compute frequency counts.
    public void countFrequency() {
        for (int i = 0; i < N; i++) {
            count[a[i].getKey() + 1]++;
        }
        toIndices();
    }

    // Transform counts to indices.
    public void toIndices() {
        for (int r = 0; r < R; r++) {
            count[r + 1] += count[r];
        }
        toRecords();
    }

    // Distribute the records.
    public void toRecords() {
        for (int i = 0; i < N; i++) {
            aux[count[a[i].getKey()]++] = a[i];
        }
        copyBack();
    }

    // Copy back.
    public void copyBack() {
        for (int i = 0; i < N; i++) {
            a[i] = aux[i];
        }
        show();
    }

    public void show() {
        for (Student student : a) {
            System.out.println(student.getKey() + " -> " + student.getName());
        }
    }

    public static void main(String[] args) {
        KeyIndexedSorting kis = new KeyIndexedSorting();
        kis.countFrequency();

    }

}
