package fa.dfa;

import fa.State;

/**
 * 
 * 
 * @author Daylen Mathews & Haylee Staub
 */
public class DFAState extends State{
    String name;

    public DFAState(String name) {
        super(name);
    }

    /**
     * Update the name of a state to a new name
     * 
     * @param newName as the new name for state
     */
    public void setName(String newName) {
        this.name = newName;
    }

    /**
     * Gets the state with the given name label
     * 
     * @param name of the state
     * @return the state with the given name
     */
    public State getDFAState (String name) {
        return DFAState.this.name;
    }
}
