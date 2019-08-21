package Interfaces;

import Exceptions.TADVectorException;

public interface InterfaceTADVector {

    public int elemAtRank(int v) throws TADVectorException;
    public int replaceAtRank(int v, int o) throws TADVectorException;
    public void insertAtRank(int v, int o);
    public int removeAtRank(int v) throws TADVectorException;
    public int size();
    public boolean isEmpty();
} 