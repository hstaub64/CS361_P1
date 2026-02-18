/**
 * @author Daylen Mathews & Haylee Staub
 */
package fa.dfa;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import fa.State;

public class DFA implements DFAInterface{

    HashSet Q;
    HashSet sigma;
    HashMap delta;
    String finalState;
    String startState;

    public DFA ()
    {
        Q = new HashSet<>();
        sigma = new HashSet<>(); 
        delta = new HashMap<>();
        finalState = "";
        startState = "";
    }

    @Override
    public boolean addState(String name) 
    {
        if (!(Q.contains(name))) {
              Q.add(name);
              return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean setFinal(String name) 
    {
        if (Q.contains(name)) {
            finalState = name;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean setStart(String name) 
    {
        if (Q.contains(name)) {
            startState = name;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void addSigma(char symbol) 
    {
        Q.add(symbol);
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSigma'");
    }

    @Override
    public State getState(String name) 
    {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getState'");
    }

    @Override
    public boolean isFinal(String name) 
    {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isFinal'");
    }

    @Override
    public boolean isStart(String name) 
    {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isStart'");
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
