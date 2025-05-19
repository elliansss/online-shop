package org.skypro.skyshop.info;

public class SearchEngine {
    private final Searchable[] searchables;
    private int size = 0;

    public SearchEngine(int capacity) {
        this.searchables = new Searchable[capacity];
    }

    public void add(Searchable searchable) {
        if (size < searchables.length) {
            searchables[size] = searchable;
            size++;
        } else {
            System.out.println("Нет места");
        }
    }

    public Searchable[] search(String query) {
        Searchable[] results = new Searchable[5];
        int resultsIndex = 0;

        for (int i = 0; i < size; i++) {
            if (searchables[i].getSearchTerm().toLowerCase().contains(query.toLowerCase())) {
                results[resultsIndex] = searchables[i];
                resultsIndex++;
                if (resultsIndex == 5) {
                    break;
            }
        }
    }
        return results;
}

}

