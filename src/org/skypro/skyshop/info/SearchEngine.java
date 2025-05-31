package org.skypro.skyshop.info;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.List;

public class SearchEngine {
    private final List<Searchable> searchables;

    public SearchEngine(List<Product> capacity) {
        this.searchables = new ArrayList<>();
    }

    public void add(Searchable searchable) {
        searchables.add(searchable);
        }

    public List<Searchable> search(String query) {
        List<Searchable> results = new ArrayList<>();

        for (Searchable searchable : searchables) {
            if (searchable.getSearchTerm().toLowerCase().contains(query.toLowerCase())) {
                results.add(searchable);
            }
        }

        return results;
    }


    public Searchable searchWord(String term) throws BestResultNotFoundException {
        if (searchables.isEmpty()) {
            throw new BestResultNotFoundException(term);
        }

        Searchable bestResult = null;
        int maxScore = 0;

        for (Searchable searchable : searchables) {
            if (searchable == null) {
                continue;
            }
            String str = searchable.getSearchTerm().toLowerCase();
            String subStr = term.toLowerCase();
            int score = resultMax(str, subStr);

            if (score > maxScore) {
                maxScore = score;
                bestResult = searchable;
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
    public interface Searchable {
        String getSearchTerm();
    }
}

