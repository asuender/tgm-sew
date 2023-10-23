package asuender;

import java.util.*;

/**
 * @author Andreas Suender
 * @version 05-12-2022
 */
public class Regex {
    private List<String> strings;
    private String regex;

    private void initList() {
        this.strings = new ArrayList<>();
    }

    public String[] getStrings() {
        return this.strings.toArray(new String[0]);
    }

    public String getString(int i) {
        return null;
    }

    public void setStrings(String[] st) {
        this.strings = Arrays.asList(st);
    }

    public void addString(String s) {
        this.strings.add(s);
    }

    public void setStrings(List<String> l) {
        this.strings = l;
    }

    public void addStrings(String[] st) {
        this.strings.addAll(Arrays.asList(st));
    }

    public String getRegex() {
        return this.regex;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }

    public Regex(List<String> l) {
        this.strings = l;
    }

    public Regex(List<String> l, String regex) {
        this.strings = l;
        this.regex = regex;
    }

    public Regex(String[] st, String regex) {
        this.strings = Arrays.asList(st);
        this.regex = regex;
    }

    public Regex(String[] st) {
        this.strings = Arrays.asList(st);
    }

    public Regex() {
        initList();
    }

    public Regex(String s) {
        this();
        this.regex = s;
    }

    public Regex(String s, String regex) {
        this(regex);
    }

    public boolean match(int i) {
        if (i < 0 || i >= this.strings.size()) {
            throw new IndexOutOfBoundsException();
        }

        String s = this.strings.get(i);
        if (s == null) {
            throw new NoSuchElementException();
        }

        return s.matches(this.regex);
    }

    public boolean match() {
        return this.match(0);
    }
}
