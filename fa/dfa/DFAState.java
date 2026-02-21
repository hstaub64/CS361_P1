package fa.dfa;

import java.util.HashMap;

import fa.State;

/**
 * Class representing a state for a DFA, including each states
 * transitions and the name of the state
 * 
 * @author Daylen Mathews & Haylee Staub
 */
public class DFAState extends State
{
    String name;
    HashMap<Character, DFAState> transitions;

    public DFAState(String name) 
    {
        super(name);
        transitions = new HashMap<>();
    }


}
