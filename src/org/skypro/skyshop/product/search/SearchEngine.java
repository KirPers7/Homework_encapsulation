package org.skypro.skyshop.product.search;

public class SearchEngine {

    private final int size;
    Searchable[] searchables;
    static final int RECORDS_QUANTITY = 5;

    public SearchEngine(int size) {
        this.size = size;
        this.searchables = new Searchable[size];
    }

    public void add(Searchable searchable) {
        int count = 0;
        for (int i = 0; i < searchables.length; i++) {
            if (searchables[i] == null) {
                searchables[i] = searchable;
                break;
            } else if (searchables[i] != null) {
                count++;
            }
        }
        if (count == size) {
            System.out.println("Невозможно добавить объект");
        }
    }

    public Searchable[] search(String searchElement) {
        int count = 0;
        Searchable[] results = new Searchable[5];
        for (Searchable searchable : searchables) {
            if (searchable != null && searchable.getSearchTerm().toLowerCase().contains(searchElement.toLowerCase())) {
                results[count++] = searchable;
            }
            if (count == RECORDS_QUANTITY) {
                break;
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
