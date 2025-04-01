package org.skypro.skyshop.product.search;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SearchEngine {

    List<Searchable> searchables;

    public SearchEngine(int size) {
        this.searchables = new ArrayList<>(size);
    }

    public void add(Searchable searchable) {
        searchables.add(searchable);
    }

    public Map<String, Searchable> search(String searchElement) {
        Map<String, Searchable> results = new TreeMap<>();
        for (Searchable searchable : searchables) {
            if (searchable != null && searchable.getSearchTerm().toLowerCase().contains(searchElement.toLowerCase())) {
                results.put(searchable.getSearchTerm(), searchable);
            }
        }
        return results;
    }

    private int getMaxFound(String str, String subStr) {
        int count = 0;
        int index = 0;
        int subStringIndex = str.indexOf(subStr, index);
        while (subStringIndex != -1) {
            count++;
            index = subStringIndex + subStr.length();
            subStringIndex = str.indexOf(subStr, index);
        }
        return count;
    }

    public Searchable getMostSuitableOfIdenticalPhrases(String searchPhrase) throws BestResultNotFound {
        Searchable searchResult = null;
        int maxFound = 0;
        int count;
        for (Searchable searchable : searchables) {
            if (searchable != null) {
                String str = searchable.getSearchTerm().toLowerCase();
                String subStr = searchPhrase.toLowerCase();
                count = getMaxFound(str, subStr);
                if (count > maxFound) {
                    maxFound = count;
                    searchResult = searchable;
                }
            }
        }
        if (searchResult == null) {
            throw new BestResultNotFound("Данные по фразе \"" + searchPhrase + "\" не найдены");
        }
        return searchResult;
    }

}
