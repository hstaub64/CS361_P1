package fa.dfa;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;

import fa.State;

/**
 * @author Daylen Mathews & Haylee Staub
 */
public class DFA implements DFAInterface{

    // idea to use LinkedHashSet from classmate Amy
    LinkedHashSet<DFAState> Q; // Q
    Set<Character> sigma; // Sigma
    LinkedHashMap<DFAState, Character> delta; // Delta
    Set<DFAState> finalState; // F
    Set<DFAState> startState; // q0

    public DFA ()
    {
        Q = new LinkedHashSet<DFAState>();
        sigma = new HashSet<Character>(); 
        delta = new LinkedHashMap<>();
        finalState = new HashSet<>(); // these may not have to be hash sets
        startState = new HashSet<>();
    }

    @Override
    public boolean addState(String name) 
    {
        boolean exists = false;

        for (DFAState state : Q) 
        {
            if (state.getName().equals(name)) 
            {
                exists = true;
            }
        }

        return exists;
    }

    @Override
    public boolean setFinal(String name) 
    {
        for (DFAState state : Q) 
        {
            if (state.getName().equals(name)) 
            {
                finalState.add(state);
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean setStart(String name) 
    {
        for (DFAState state : Q) 
        {
            if (state.getName().equals(name)) 
            {
                startState.add(state);
                return true;
            }
        }

        return false;
    }

    @Override
    public void addSigma(char symbol) 
    {
        sigma.add(symbol);
    }

    @Override
    public boolean accepts(String s) 
    {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'accepts'");
    }

    @Override
    public Set<Character> getSigma() 
    {
        return sigma;
    }

    @Override
    public State getState(String name) 
    {
        for (DFAState state : Q) 
        {
            if (state.getName().equals(name)) 
            {
                return state;
            }
        }
        return null;
    }

    @Override
    public boolean isFinal(String name) 
    {
        boolean exists = false;

        for (DFAState state : finalState) 
        {
            if (state.getName().equals(name)) 
            {
                exists = true;
            }
        }

        return exists;
    }

    @Override
    public boolean isStart(String name) 
    {
        boolean exists = false;

        for (DFAState state : startState) 
        {
            if (state.getName().equals(name)) 
            {
                exists = true;
            }
        }

        return exists;
    }

    @Override
    public boolean addTransition(String fromState, String toState, char onSymb) 
    {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addTransition'");
    }

    @Override
    public DFA swap(char symb1, char symb2) 
    {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'swap'");
    }
    
}
