package org.example.petrinet.core;

public class ArcP2T extends Arc {

    public ArcP2T(String name, Place place, Transition transition, int weight) {
        super(name, place, transition, weight);
        this.transition.addIncoming(this);
    }

    @Override
    public boolean fireable() {
        return place.enoughTokens(weight);
    }

    @Override
    public void fire() {
        place.removeTokens(weight);
    }

    @Override
    public String toString() {
        return "ArcP2T(name=" + name + ", p=" + place.getName() + ", t=" + transition.getName() + ", w=" + weight + ")";
    }
}
