/*
 * The MIT License
 *
 *  Copyright (c) 2015, Mahmoud Ben Hassine (mahmoud@benhassine.fr)
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy
 *  of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the rights
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in
 *  all copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 *  THE SOFTWARE.
 */

package org.easybatch.core.dispatcher;

import org.easybatch.core.api.Record;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * Test class for {@link org.easybatch.core.dispatcher.ContentBasedRecordDispatcherBuilder}.
 *
 * @author Mahmoud Ben Hassine (mahmoud@benhassine.fr)
 */
public class ContentBasedRecordDispatcherBuilderTest {

    private ContentBasedRecordDispatcherBuilder builder;

    @Before
    public void setUp() throws Exception {
        builder = new ContentBasedRecordDispatcherBuilder();
    }

    @Test(expected = IllegalStateException.class)
    public void whenPredicateToQueueMapIsEmpty_ThenShouldThrowIllegalStateException() throws Exception {
        builder.build();
    }

    @Test(expected = IllegalStateException.class)
    public void whenCallDispatchToWithoutCallingWhen_ThenShouldThrowIllegalStateException() throws Exception {
        builder.dispatchTo(new ArrayBlockingQueue<Record>(10));
    }

}