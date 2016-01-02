package com.java8.lamda.examples;

/**
 * Created by prasniths on 02/01/16.
 */
public class StringCombiner {

    private final String delimeter;
    private final String prefix;
    private final String suffix;
    private StringBuilder builder;

    public StringCombiner(String delimeter, String prefix, String suffix) {
        this.delimeter = delimeter;
        this.prefix = prefix;
        this.suffix = suffix;
        builder = new StringBuilder();
    }

    public StringCombiner add(String element) {
        if (areAtStart()) {
            builder.append(prefix);
        } else {
            builder.append(delimeter);
        }
        builder.append(element);
        return this;
    }

    private boolean areAtStart() {
        return (builder.length() == 0);
    }

    public StringCombiner merge(StringCombiner other) {
        builder.append(other.builder);
        return this;
    }

    public String result() {
        String string = builder.append(suffix).toString();
        return string;
    }

}


