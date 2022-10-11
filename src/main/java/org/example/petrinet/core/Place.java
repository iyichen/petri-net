package org.example.petrinet.core;

import java.util.ArrayList;
import java.util.List;

public class Place {

    private final String name;

    private List<Token> tokens;

    private final int tokenLimits;

    public Place(String name) {
        this(name, Integer.MAX_VALUE);
    }

    public Place(String name, int tokenLimits) {
        this.name = name;
        this.tokens = new ArrayList<>();
        this.tokenLimits = tokenLimits;
    }

    public boolean enoughTokens(int tokenCount) {
        return tokens.size() >= tokenCount;
    }

    public void removeTokens(int tokenCount) {
        tokens = new ArrayList<>(tokens.subList(tokenCount, tokens.size()));
    }

    public boolean reachTokenLimits(int tokenCount) {
        return tokens.size() + tokenCount > tokenLimits;
    }

    public void addTokens(int tokenCount) {
        for (int i = 0; i < tokenCount; i++) {
            tokens.add(Token.INSTANCE);
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Place(name=" + name + ", tokenSize=" + tokens.size() + ", tokenLimit=" + tokenLimits + ")";
    }
}
