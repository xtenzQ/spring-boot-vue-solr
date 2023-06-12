package com.rusetskii.solr;

import com.rusetskii.search.QueryParams;
import com.rusetskii.searcher.QueryBuilder;
import org.apache.solr.client.solrj.SolrQuery;
import org.springframework.stereotype.Service;

@Service
public class SolrQueryBuilder implements QueryBuilder {

    private static final String SEARCHER_HANDLER = "/searcher";
    @Override
    public SolrQuery build(QueryParams queryParams) {
        SolrQuery solrQuery = new SolrQuery();
        solrQuery.setRequestHandler(SEARCHER_HANDLER);
        solrQuery.setQuery(queryParams.getQuery());
        return solrQuery;
    }
}
