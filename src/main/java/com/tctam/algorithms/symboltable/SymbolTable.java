package com.tctam.algorithms.symboltable;

@SuppressWarnings("rawtypes")
public interface SymbolTable<Key extends Comparable, Value> {
    public abstract void put(Key key, Value value);

    public abstract Value get(Key key);
    
    public abstract void delete(Key key);
    
    public abstract void deleteMin();
    
    public abstract void deleteMax();
}
