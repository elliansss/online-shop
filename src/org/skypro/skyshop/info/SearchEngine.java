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


    public Searchable searchWord(String term) throws BestResultNotFoundException {
        if (size == 0) {
            throw new BestResultNotFoundException(term);
        }

        Searchable bestResult = null;
        int maxScore = 0;

        for (int i = 0; i < size; i++) {
            if (searchables[i] == null) {
                continue;
            }
            String str = searchables[i].getSearchTerm().toLowerCase();
            String subStr = term.toLowerCase();
            int score = resultMax(str, subStr);

            if (score > maxScore) {
                maxScore = score;
                bestResult = searchables[i];
            }
        }

        if (bestResult == null) {
            throw new BestResultNotFoundException(term);
        }

        return bestResult;
    }

    private int resultMax(String str, String subStr) {
        int score = 0;
        int index = 0;
        while ((index = str.indexOf(subStr, index)) != -1) {
            score++;
            index = index + subStr.length();
        }
        return score;
    }
}

