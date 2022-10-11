package org.example.petrinet.core;

import lombok.Getter;

@Getter
public class ArcT2P extends Arc {

    public ArcT2P(String name, Transition transition, Place place, int weight) {
        super(name, place, transition, weight);
        this.transition.addOutgoing(this);
    }

    @Override
    public boolean fireable() {
        return !place.reachTokenLimits(weight);
    }

    @Override
    public void fire() {
        place.addTokens(weight);
    }

    @Override
    public String toString() {
        return "ArcT2P(name=" + name + ", t=" + transition.getName() + ", p=" + place.getName() + ", w=" + weight + ")";
    }
}
