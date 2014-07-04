/*
 * Copyright 2009 David Jurgens
 *
 * This file is part of the S-Space package and is covered under the terms and
 * conditions therein.
 *
 * The S-Space package is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License version 2 as published
 * by the Free Software Foundation and distributed hereunder to you.
 *
 * THIS SOFTWARE IS PROVIDED "AS IS" AND NO REPRESENTATIONS OR WARRANTIES,
 * EXPRESS OR IMPLIED ARE MADE.  BY WAY OF EXAMPLE, BUT NOT LIMITATION, WE MAKE
 * NO REPRESENTATIONS OR WARRANTIES OF MERCHANT- ABILITY OR FITNESS FOR ANY
 * PARTICULAR PURPOSE OR THAT THE USE OF THE LICENSED SOFTWARE OR DOCUMENTATION
 * WILL NOT INFRINGE ANY THIRD PARTY PATENTS, COPYRIGHTS, TRADEMARKS OR OTHER
 * RIGHTS.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package edu.ucla.sspace.ri;

import java.io.*;
import java.util.*;

import org.junit.Ignore;
import org.junit.Test;

import edu.ucla.sspace.index.RandomIndexVectorGenerator;
import static org.junit.Assert.*;


public class TestRandomIndexing {

    @Test public void test() throws IOException {
    	
    	Properties parameters = new Properties();
    	
    	parameters.put(RandomIndexVectorGenerator.INDEX_VECTOR_RANDOMSEED_PROPERTY, "5");
    	
        RandomIndexing ri = new RandomIndexing(parameters);
        //ri.RANDOM.setSeed(SEED);

        String text = "the quick brown fox jumps over the lazy dog";
        ri.processDocument(new BufferedReader(new StringReader(text)));

        Set<String> words = new LinkedHashSet<String>();
        for (String s : text.split("\\s+")) 
            words.add(s);

        assertEquals(words, ri.getWords());
    }
}
