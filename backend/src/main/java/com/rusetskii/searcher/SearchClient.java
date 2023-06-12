package com.rusetskii.searcher;

import com.rusetskii.data.Item;
import com.rusetskii.search.QueryParams;
import com.rusetskii.search.SearchQuery;
import org.apache.solr.client.solrj.SolrQuery;

import java.util.List;

public interface SearchClient {
    /**
     * Indexes a single document into the search engine.
     *
     * @param document the document to index.
     * @return true if the indexing was successful, false otherwise.
     */
    boolean index(Item document);
    /**
     * Indexes all documents into the search engine.
     *
     * @return true if the indexing was successful, false otherwise.
     */
    boolean index(List<Item> documents);

    /**
     * Indexes all documents into the search engine.
     *
     * @return true if the indexing was successful, false otherwise.
     */
    boolean indexAll();
    /**
     * Searches for documents matching the given query parameters.
     *
     * @param params the parameters defining the search query.
     * @return a list of documents matching the query parameters.
     */
    List<Item> search(SolrQuery params);
    /**
     * Provides suggestions based on the given query parameters.
     *
     * @param params the parameters defining the query for which suggestions are required.
     * @return a list of suggested documents based on the query parameters.
     */
    List<Item> suggest(SolrQuery params);
}
