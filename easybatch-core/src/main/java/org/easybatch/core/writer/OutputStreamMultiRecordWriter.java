/*
 *  The MIT License
 *
 *   Copyright (c) 2015, Mahmoud Ben Hassine (mahmoud@benhassine.fr)
 *
 *   Permission is hereby granted, free of charge, to any person obtaining a copy
 *   of this software and associated documentation files (the "Software"), to deal
 *   in the Software without restriction, including without limitation the rights
 *   to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *   copies of the Software, and to permit persons to whom the Software is
 *   furnished to do so, subject to the following conditions:
 *
 *   The above copyright notice and this permission notice shall be included in
 *   all copies or substantial portions of the Software.
 *
 *   THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *   IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *   FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *   AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *   LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *   OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 *   THE SOFTWARE.
 */

package org.easybatch.core.writer;

import org.easybatch.core.api.RecordWritingException;

import java.io.OutputStreamWriter;
import java.util.List;

import static org.easybatch.core.util.Utils.checkNotNull;

/**
 * Writes a chunks of records to an output stream.
 *
 * @author Mahmoud Ben Hassine (mahmoud@benhassine.fr)
 */
public class OutputStreamMultiRecordWriter extends AbstractMultiRecordWriter {

    private OutputStreamRecordWriter outputStreamRecordWriter;

    /**
     * Writes a chunks of records to an output stream.
     *
     * @param outputStreamWriter the output stream to write records to
     */
    public OutputStreamMultiRecordWriter(final OutputStreamWriter outputStreamWriter) {
        checkNotNull(outputStreamWriter, "output stream writer");
        outputStreamRecordWriter = new OutputStreamRecordWriter(outputStreamWriter);
    }

    @Override
    protected void writeRecord(final Object multiRecord) throws RecordWritingException {
        List records = getRecords(multiRecord);
        for (Object record : records) {
            outputStreamRecordWriter.writeRecord(record);
        }
    }
}
