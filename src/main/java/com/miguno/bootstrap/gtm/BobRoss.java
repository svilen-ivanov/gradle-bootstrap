package com.miguno.bootstrap.gtm;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSet.Builder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.PrintStream;
import java.util.Set;

/**
 * A simple class that implements a few features that we can write unit tests for. It uses Google Guava for the sole
 * reason that we have an external compile-time dependency in this bootstrap project.
 * <p/>
 * To make the example code simpler this class does not follow pure OO style. (If it did, we would create a Painting
 * object from painting elements and let our painter paint that painting object, for instance.)
 * <p/>
 * "And from all of us here I'd like to wish you happy painting and God bless, my friend."
 */
public class BobRoss {

    private final static Logger log = LoggerFactory.getLogger(BobRoss.class);

    private final Set<String> paintingElements;
    private final PrintStream printStream;

    public BobRoss(Set<String> paintingElements) {
        this(paintingElements, System.out);
    }

    public BobRoss(Set<String> paintingElements, PrintStream printStream) {
        Builder<String> builder = new ImmutableSet.Builder<String>().addAll(paintingElements);
        if (!paintingElements.contains("happy tree")) {
            builder.add("happy tree");
        }
        this.paintingElements = builder.build();
        this.printStream = printStream;
    }

    public Set<String> getPaintingElements() {
        return this.paintingElements;
    }

    public void paintPicture() {
        for (String p : paintingElements) {
            printStream.println("Now we will paint the " + p);
        }
    }

    public static void main(String[] args) {
        log.info("Test message");
        Set<String> paintingElements = ImmutableSet.of("sky", "lake", "mountain", "happy tree", "little squirrel");
        BobRoss bob = new BobRoss(paintingElements);
        bob.paintPicture();
    }

}
