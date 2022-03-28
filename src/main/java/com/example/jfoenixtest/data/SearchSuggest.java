package com.example.jfoenixtest.data;

import java.util.Objects;

public class SearchSuggest implements Comparable<SearchSuggest>{
    public String key;
    public String value;

    public SearchSuggest(String key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SearchSuggest suggest = (SearchSuggest) o;
        return Objects.equals(key, suggest.key);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public int compareTo(SearchSuggest o) {
        try {
            int key = Integer.parseInt(this.key);
            int otherKey = Integer.parseInt(o.key);
            return key < otherKey ? -1 : 1;
        } catch (NumberFormatException ignored) {
        }
        return 0;
    }
}
