package fa.dfa;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;

import fa.State;

/**
 * @author Daylen Mathews & Haylee Staub
 */
public class DFA implements DFAInterface{

    // may have to update the instance variables to match 5 tuple
    LinkedHashSet Q;
    Set sigma;
    LinkedHashMap delta;
    DFAState finalState;
    DFAState startState;

    public DFA ()
    {
        Q = new LinkedHashSet<DFAState>();
        sigma = new HashSet<Character>(); 
        delta = new LinkedHashMap<>();
        finalState = new DFAState("");
        startState = new DFAState("");
    }

    @Override
    public boolean addState(String name) 
    {
        // will have to adjust Q.contains to look for state objects and not strings
        if (!(Q.contains(name))) {
            DFAState newState = new DFAState(name);
            Q.add(newState);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean setFinal(String name) 
    {
        // will have to adjust Q.contains to look for state objects and not strings
        if (Q.contains(name)) {
            finalState.setName(name);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean setStart(String name) 
    {
        // will have to adjust Q.contains to look for state objects and not strings
        if (Q.contains(name)) {
            startState.setName(name);
            return true;
        } else {
            return false;
        }
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
        // return the state in Q that has the name that matches the given name
        //return Q.contains();
    }

    @Override
    public boolean isFinal(String name) 
    {
        if (name.equals(finalState.name)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isStart(String name) 
    {
        if (name.equals(startState.name)) {
            return true;
        } else {
            return false;
        }
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
