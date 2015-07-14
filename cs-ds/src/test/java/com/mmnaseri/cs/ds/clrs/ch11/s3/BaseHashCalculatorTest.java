package com.mmnaseri.cs.ds.clrs.ch11.s3;

import com.mmnaseri.cs.ds.clrs.ch11.HashCalculator;
import com.mmnaseri.cs.ds.clrs.ch11.HashTable;
import com.mmnaseri.cs.ds.clrs.ch11.s2.BaseLargeKeysHashTableTest;
import com.mmnaseri.cs.ds.clrs.ch11.s2.ChainingHashTable;

import java.util.ArrayList;

/**
 * @author Mohammad Milad Naseri (m.m.naseri@gmail.com)
 * @since 1.0 (7/13/15)
 */
public abstract class BaseHashCalculatorTest extends BaseLargeKeysHashTableTest {

    @Override
    protected HashTable<Integer>[] getHashTables() {
        final ArrayList<HashTable<Integer>> hashTables = new ArrayList<>();
        for (int capacity : getCapacities()) {
            for (HashCalculator calculator : getHashCalculators()) {
                hashTables.add(new ChainingHashTable<Integer>(capacity, calculator));
            }
        }
        //noinspection unchecked
        return hashTables.toArray(new HashTable[hashTables.size()]);
    }

    protected  abstract HashCalculator[] getHashCalculators();

    protected int[] getCapacities() {
        return new int[]{25};
    }
}
