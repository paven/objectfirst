/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package nu.mumma.lit310.objectsFirst.core.abstraction;



/**
 *
 * @author Gustafsp
 */
public interface UserInput {
    public Direction getDirection();
    /** returns the last action key once, and then returns an defoult */
    public Character getActionKey();
    /** returns the last action key even if it already been read */
    public Character getLastActionKey();

}
