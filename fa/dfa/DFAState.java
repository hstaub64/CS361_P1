package fa.dfa;

import java.util.HashMap;

import fa.State;

/**
 * 
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
