package fa.dfa;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import fa.State;

/**
 * Class for constructing a DFA, including four parts of the 5-tuple:
 * Q as a set of states, sigma as a set of characters for the alphabet,
 * F as a set of final states, and q0 as a start state.
 * 
 * @author Daylen Mathews & Haylee Staub
 */
public class DFA implements DFAInterface{

    // idea to use LinkedHashSet from classmate Amy
    LinkedHashSet<DFAState> Q; // Q
    LinkedHashSet<Character> sigma; // Sigma
    Set<DFAState> finalState; // F
    DFAState startState; // q0

    public DFA()
    {
        Q = new LinkedHashSet<DFAState>();
        sigma = new LinkedHashSet<Character>(); 
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

        // copy all the states
        for (DFAState state : this.Q) 
        {
            newDFA.addState(state.getName());
        }

        // copy all character in sigma
        for (Character c : this.sigma) 
        {
            newDFA.addSigma(c);
        }

        // copy and swap all transitions
        for (DFAState state : this.Q) 
        {
            for (Character key : state.transitions.keySet()) 
            {
                if (key.equals(symb1))
                {
                    newDFA.addTransition(state.getName(), state.transitions.get(key).getName(), symb2);
                } else if (key.equals(symb2)) 
                {
                    newDFA.addTransition(state.getName(), state.transitions.get(key).getName(), symb1);
                }
                
            }
        }

        // copy all final states
        for (DFAState state : this.finalState) 
        {
            newDFA.setFinal(state.getName());
        }

        // copy the start state
        newDFA.setStart(this.startState.getName());

        return newDFA;
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

    /**
     * Private helper method to convert the Sigma set
     * to a string 
     * 
     * @param sigma to convert to string
     * @return a string representation of the characters
     * in sigma
     */
    private String sigmaToString(Set<Character> sigma)
    {
        String retVal = "";

        for (Character c : sigma) 
        {
            retVal += Character.toString(c) + " ";
        }

        return retVal;
    }
    
}
