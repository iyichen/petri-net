package org.example.petrinet.core;

import java.util.ArrayList;
import java.util.List;

public class PetriNet {

    private final List<Place> places = new ArrayList<>();
    private final List<Transition> transitions = new ArrayList<>();
    private final List<Arc> arcs = new ArrayList<>();

    public List<Transition> fireableTransition() {
        List<Transition> result = new ArrayList<>();
        for (Transition t : transitions) {
            if (t.fireable()) {
                result.add(t);
            }
        }
        return result;
    }

    public void addPlace(Place place) {
        places.add(place);
    }

    public void addTransition(Transition transition) {
        transitions.add(transition);
    }

    public void addArc(Arc arc) {
        arcs.add(arc);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("---------------- Place ------------------").append("\n");
        for (Place place : places) {
            builder.append(place).append("\n");
        }
        builder.append("---------------- Transition ------------------").append("\n");
        for (Transition transition : transitions) {
            builder.append(transition).append("\n");
        }
        builder.append("---------------- Arc ------------------").append("\n");
        for (Arc arc : arcs) {
            builder.append(arc).append("\n");
        }
        return builder.toString();
    }
}
