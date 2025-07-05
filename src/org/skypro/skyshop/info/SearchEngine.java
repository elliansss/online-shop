package org.skypro.skyshop.info;

import java.util.*;
import java.util.stream.Collectors;

public class SearchEngine {
    private Set<Searchable> searchables = new HashSet<>();

    public SearchEngine(Set<Searchable> capacity) {
        this.searchables = Objects.requireNonNull(capacity, "Значение не может быть null");
    }

    public void add(Searchable searchable) {
        searchables.add(searchable);
    }

    public Set<Searchable> search(String query) {
        return searchables.stream()
                .filter(searchable -> searchable.getName().toLowerCase().contains(query.toLowerCase()))
                .collect(Collectors.toCollection(() -> new TreeSet<>(new SearchResultComparator())));
    }

    public class SearchResultComparator implements Comparator<Searchable> {
        @Override
        public int compare(Searchable o1, Searchable o2) {

            int lengthCompare = Integer.compare(
                    o2.getName().length(),
                    o1.getName().length()

            );

            if (lengthCompare == 0) {
                return o1.getName().compareTo(o2.getName());
            }
            return lengthCompare;

        }
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

    public TreeMap<String, Searchable> search2(String query) {
        Set<Searchable> results = search(query);
        TreeMap<String, Searchable> resultMap = new TreeMap<>();
        for (Searchable searchable : results) {
            resultMap.put(searchable.getSearchTerm(), searchable);
        }
        return resultMap;
    }
}

