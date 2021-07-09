package com.optum.fs.rest.service.util.threads;

public final class ImmutableClass {
    private final String name;
    private final String ph;

    public ImmutableClass(String name, String ph) {
        this.name = name;
        this.ph = ph;
    }

    public String getName() {
        return name;
    }

    public String getPh() {
        return ph;
    }

    public static void main(String[] args) {
        ImmutableClass immutableClass = new ImmutableClass("Ash", "1");
        System.out.println(immutableClass.getName() + " " + immutableClass.getPh());
    }
}
