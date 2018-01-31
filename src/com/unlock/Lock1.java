package com.unlock;
/*
 * This class represents a lock. Each lock has a unique identifier, and the room in
 * it is placed.
 */

/**
 * @author Kasi Periyasamy
 * created on Sep 03, 2013
 * modified on Sep 25, 2017
 */

public class Lock1 implements Comparable {
    private int id;
    private int roomNumber;
    
    public Lock1 (int param_id, int param_roomNumber) {
        id = param_id;
        roomNumber = param_roomNumber;
    }
    
    public int getID () {
        return id;
    }
    
    public int getRoomNumber () {
        return roomNumber;
    }
    
        
    /** 
     * This method is used to compare two locks based on their IDs.
     * @param param_lock the lock object to be compared
     * @return true if both objects have the same ID numbers.
     */
    
    @Override
    public boolean equals (Object param_lock) {
        return ((Lock1)param_lock).getID() == this.id;
    }
    /**
     * This method overrides the hashCode of the current object to the ID value.
     * In Java, it is necessary to override both hashCode() and equal() together.
     * @return the original hashCode of the object.
     */
    
//    @Override
//    public int hashCode () {
//        return this.hashCode();
//    }
//    
    /**
     * This method overrides the compareTo method for Object.
     */
    public int compareTo (Object obj) {
        if (this.equals (obj)) return 0;
        else return -1;
    }
}
