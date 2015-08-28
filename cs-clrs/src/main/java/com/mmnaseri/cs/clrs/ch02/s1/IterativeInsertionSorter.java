package com.mmnaseri.cs.clrs.ch02.s1;

import com.mmnaseri.cs.qa.annotation.Quality;
import com.mmnaseri.cs.qa.annotation.Stage;

import java.util.Comparator;

/**
 * @author Mohammad Milad Naseri (m.m.naseri@gmail.com)
 * @since 1.0 (8/27/15)
 */
@Quality(Stage.TESTED)
public class IterativeInsertionSorter<E extends Comparable<E>> extends InsertionSorter<E> {

    private final Comparator<E> comparator;

    public IterativeInsertionSorter(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    @Override
    public void sort(E[] items) {
        for (int i = 1; i < items.length; i++) {
            E item = items[i];
            int placement = findPlacement(items, item, i, comparator);
            /**
             * This call to System.arraycopy is equivalent to:
             * for (int j = i; j > placement; j --) {
             *     items[j] = items[j - 1];
             * }
             */
            System.arraycopy(items, placement, items, placement + 1, i - placement);
            items[placement] = item;
        }
    }

}
