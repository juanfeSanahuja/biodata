package org.opencb.biodata.tools.alignment.iterators;

import htsjdk.samtools.SAMRecord;
import htsjdk.samtools.SAMRecordIterator;
import org.opencb.biodata.tools.alignment.AlignmentFilters;

import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by pfurio on 25/10/16.
 */
public abstract class AlignmentIterator<T> implements Iterator<T>, AutoCloseable {

    protected SAMRecordIterator samRecordIterator;
    protected AlignmentFilters filters;

    protected SAMRecord prevNext;

    public AlignmentIterator(SAMRecordIterator samRecordIterator) {
        this(samRecordIterator, null);
    }

    public AlignmentIterator(SAMRecordIterator samRecordIterator, AlignmentFilters filters) {
        this.samRecordIterator = samRecordIterator;
        if (filters == null) {
            filters = new AlignmentFilters();
        }
        this.filters = filters;

        findNextMatch();
    }

    private boolean filter(SAMRecord samRecord) {
        return filters.apply(samRecord);
    }

    protected void findNextMatch() {
        while (samRecordIterator.hasNext()) {
            SAMRecord next = samRecordIterator.next();
            if (filter(next)) {
                prevNext = next;
                return;
            }
        }
        prevNext = null;
    }

    @Override
    public void close() throws Exception {
        samRecordIterator.close();
    }

}