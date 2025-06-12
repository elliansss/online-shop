package org.skypro.skyshop.info;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SearchEngine {
    private final List<Product> searchables;

    public SearchEngine(List<Product> capacity) {
        this.searchables = capacity;
    }

    public void add(Product searchable) {
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
    public Map<String, Searchable> search2(String query) {
        List<Searchable> results = search(query);
        Map<String, Searchable> resultMap = new TreeMap<>();
        for (Searchable searchable : results) {
            resultMap.put(searchable.getSearchTerm(), searchable);
        }
        return resultMap;
    }
}

