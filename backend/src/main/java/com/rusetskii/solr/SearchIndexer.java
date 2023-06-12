package com.rusetskii.solr;

import com.rusetskii.data.Item;
import com.rusetskii.search.QueryParams;
import com.rusetskii.search.SearchIndexerService;
import com.rusetskii.searcher.QueryBuilder;
import com.rusetskii.searcher.SearchClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchIndexer implements SearchIndexerService {

    @Autowired
    private SearchClient searchClient;

    @Autowired
    private QueryBuilder queryBuilder;

    @Override
    public List<Item> search(QueryParams queryParams) {
        SolrQuery query = queryBuilder.build(queryParams);
        return searchClient.search(query);
    }

    @Override
    public List<Item> suggest(QueryParams queryParams) {
        SolrQuery query = queryBuilder.build(queryParams);
        return searchClient.suggest(query);
    }

    @Override
    public boolean index() {
        return searchClient.indexAll();
    }
}
