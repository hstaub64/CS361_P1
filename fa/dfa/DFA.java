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
    // LinkedHashMap<DFAState, Character> delta; // Delta
    Set<DFAState> finalState; // F
    DFAState startState; // q0

    public DFA()
    {
        Q = new LinkedHashSet<DFAState>();
        sigma = new HashSet<Character>(); 
        // delta = new LinkedHashMap<>(); this may be unnecessary with the transitions in DFAState
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
        DFA newDFA = new DFA();
        newDFA.Q = Q;
        newDFA.sigma = sigma;
        newDFA.finalState = finalState;
        newDFA.startState = startState;

        for (DFAState state : newDFA.Q) 
        {
            DFAState prevSwapOne = state.transitions.get(symb1);
            DFAState prevSwapTwo = state.transitions.get(symb2);

            // first swap
            state.transitions.remove(prevSwapOne, symb1);
            addTransition(state.getName(), prevSwapOne.getName(), symb2);

            // second swap
            state.transitions.remove(prevSwapTwo, symb2);
            addTransition(state.getName(), prevSwapTwo.getName(), symb1);
        }

        return newDFA;
    }

    private String sigmaToString(Set<Character> sigma)
    {
        String retVal = "";

        for (Character c : sigma) 
        {
            retVal += Character.toString(c) + " ";
        }

        return retVal;
    }

    public String toString()
    {
        // lots of copy paste, could simplify using private methods

        // String for Q
        String returnsString = "";
        returnsString += "Q = {";

        for (DFAState state : Q) 
        {
            returnsString += state.getName() + " ";
        }

        returnsString += "}\n";

        // String for sigma
        returnsString += "Sigma = {" + sigmaToString(sigma) + "}\n";

        // String for delta
        returnsString += "delta =\n" + sigmaToString(sigma) + "\n";

        for (DFAState state : Q) 
        {
            returnsString += state.getName() + " ";

            for (Character c : sigma) 
            {
                returnsString += state.transitions.get(c) + " ";
            }
            returnsString += "\n";
        }

        // String for q0
        returnsString += "q0 = " + startState.getName() + "\n";

        // string for F
        returnsString += "F = {";

        for (DFAState state : finalState) 
        {
            returnsString += state.getName() + " ";
        }

        returnsString += "}";

        return returnsString;
    }
    
}
