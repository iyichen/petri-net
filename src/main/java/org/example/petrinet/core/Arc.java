package org.example.petrinet.core;

public abstract class Arc {

    protected String name;

    protected Place place;

    protected Transition transition;

    protected int weight;

    public Arc(String name, Place place, Transition transition, int weight) {
        this.name = name;
        this.place = place;
        this.transition = transition;
        this.weight = weight;
    }

    public abstract boolean fireable();

    public abstract void fire();

}
