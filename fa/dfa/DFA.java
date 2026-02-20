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

    public DFA()
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

        if (exists == false) 
        {
            Q.add(new DFAState(name));
            return true;
        } else
        {
            return false;
        }
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
       return false; // replace later
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
        State stateFrom = getState(fromState);
        State stateTo = getState(toState);

        if (stateFrom == null || stateTo == null) 
        {
            return false;
        }

        if (!sigma.contains(onSymb)) 
        {
            return false;
        }

        // actual transition logic 
        return true;
    }

    @Override
    public DFA swap(char symb1, char symb2) 
    {
        return null; // replace later
    }
    
}
