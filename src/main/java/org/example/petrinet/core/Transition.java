package org.example.petrinet.core;

import java.util.ArrayList;
import java.util.List;

public class Transition {

    private final String name;

    private final List<Arc> incoming;

    private final List<Arc> outgoing;

    public Transition(String name) {
        this.name = name;
        this.incoming = new ArrayList<>();
        this.outgoing = new ArrayList<>();
    }

    public boolean fireable() {
        boolean fireable = true;

        for (Arc arc : incoming) {
            fireable = fireable && arc.fireable();
        }

        for (Arc arc : outgoing) {
            fireable = fireable && arc.fireable();
        }
        return fireable;
    }

    public void fire() {
        for (Arc arc : incoming) {
            arc.fire();
        }
        for (Arc arc : outgoing) {
            arc.fire();
        }
    }

    public void addIncoming(Arc arc) {
        this.incoming.add(arc);
    }

    public void addOutgoing(Arc arc) {
        this.outgoing.add(arc);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Transition(name=" + name + ", incoming=" + incoming.size() + ", outgoing=" + outgoing.size() + ")";
    }
}
