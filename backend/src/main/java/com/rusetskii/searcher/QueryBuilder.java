package com.rusetskii.searcher;

import com.rusetskii.search.QueryParams;
import org.apache.solr.client.solrj.SolrQuery;

/**
 * An interface for building queries for a search engine.
 */
public interface QueryBuilder {

    /**
     * Builds a query object for the search engine.
     *
     * @return the query object built by the query builder.
     */
    SolrQuery build(QueryParams queryParams);
}
