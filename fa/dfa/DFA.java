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
    DFAState startState; // q0

    public DFA()
    {
        Q = new LinkedHashSet<DFAState>();
        sigma = new HashSet<Character>(); 
        delta = new LinkedHashMap<>();
        finalState = new HashSet<>(); // these may not have to be hash sets
        startState = new DFAState(null);
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
                startState = state;
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
        // turn string into array of char
        char[] sArray = s.toCharArray();
        DFAState currentState = startState;
        // iterate through entire array of char
        for (char c : sArray) 
        {
            if (!sigma.contains(c)) 
            {
                return false;
            }

            if (currentState.transitions.get(c) == null) 
            {
                return false;
            }

            currentState = currentState.transitions.get(c);
        }
       
        if (isFinal(currentState.getName())) 
        {
            return true;
        } else
        {
            return false;
        }
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

        if (startState.getName().equals(name)) 
        {
            exists = true;
        }

        return exists;
    }

    @Override
    public boolean addTransition(String fromState, String toState, char onSymb) 
    {
        DFAState stateFrom = (DFAState) getState(fromState);
        DFAState stateTo = (DFAState) getState(toState);

        if (stateFrom == null || stateTo == null) 
        {
            return false;
        }

        if (!sigma.contains(onSymb)) 
        {
            return false;
        }

        // actual transition logic 
        stateFrom.transitions.put(onSymb, stateTo);
        return true;
    }

    @Override
    public DFA swap(char symb1, char symb2) 
    {
        // go through each state in q, swap their transition keys
        return null; // replace later
    }

    public String toString()
    {
        // update return string
        String returnsString = "";
        returnsString += " Q = " + Q.toString() + "\n"
                + "Sigma = " + sigma.toString() + "\n"
				+ "delta =\n"
				+ "		0	1\n"
				+ "	a	a	b\n"
				+ "	b	a	b\n"
				+ "q0 = a\n"
				+ "F = { b }";


        return returnsString;
    }
    
}
