package com.rusetskii.search;

import com.rusetskii.data.Item;

import java.util.List;

public interface SearchIndexerService {
    List<Item> search(QueryParams queryParams);
    List<Item> suggest(QueryParams queryParams);
    boolean index();
}
