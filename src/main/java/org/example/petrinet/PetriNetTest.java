package org.example.petrinet;

import com.sun.tools.javac.util.Assert;
import org.example.petrinet.core.*;

import java.util.List;

/**
 * -> ( P1(2tokens) ) ----> | T1 | ----> ( P2(0tokens) ) --2--> | T2 | --
 * |                                                                     |
 * --------------------------------2-------------------------------------
 * <p>
 * NEXT
 * <p>
 * -> ( P1(1tokens) ) ----> | T1 | ----> ( P2(1tokens) ) --2--> | T2 | --
 * |                                                                     |
 * --------------------------------2-------------------------------------
 * <p>
 * NEXT
 * <p>
 * -> ( P1(0tokens) ) ----> | T1 | ----> ( P2(2tokens) ) --2--> | T2 | --
 * |                                                                     |
 * --------------------------------2-------------------------------------
 * <p>
 * NEXT
 * <p>
 * -> ( P1(2tokens) ) ----> | T1 | ----> ( P2(0tokens) ) --2--> | T2 | --
 * |                                                                     |
 * --------------------------------2-------------------------------------
 */
public class PetriNetTest {

    public static void main(String[] args) {
        PetriNet petriNet = new PetriNet();

        Place p1 = new Place("p1");
        petriNet.addPlace(p1);
        Place p2 = new Place("p2");
        petriNet.addPlace(p2);

        Transition t1 = new Transition("t1");
        petriNet.addTransition(t1);
        Transition t2 = new Transition("t2");
        petriNet.addTransition(t2);

        Arc p1t1 = new ArcP2T("p1-t1", p1, t1, 1);
        petriNet.addArc(p1t1);
        Arc t1p2 = new ArcT2P("t1-p2", t1, p2, 1);
        petriNet.addArc(t1p2);

        Arc p2t2 = new ArcP2T("p2-t2", p2, t2, 2);
        petriNet.addArc(p2t2);
        Arc t2p1 = new ArcT2P("t2-p1", t2, p1, 2);
        petriNet.addArc(t2p1);

        System.out.println(petriNet);

        // init
        p1.addTokens(2);
        System.out.println(petriNet);

        List<Transition> transitions = petriNet.fireableTransition();
        Assert.check(transitions.size() == 1);
        Assert.check(transitions.get(0) == t1);

        transitions.forEach(Transition::fire);
        System.out.println(petriNet);

        transitions = petriNet.fireableTransition();
        Assert.check(transitions.size() == 1);
        Assert.check(transitions.get(0) == t1);

        transitions.forEach(Transition::fire);
        System.out.println(petriNet);

        transitions = petriNet.fireableTransition();
        Assert.check(transitions.size() == 1);
        Assert.check(transitions.get(0) == t2);

        System.out.println(petriNet);

    }
}
