package com.rusetskii.solr;

import com.rusetskii.data.Item;
import com.rusetskii.data.ItemRepository;
import com.rusetskii.searcher.SearchClient;
import jakarta.annotation.PreDestroy;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.Http2SolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

import static com.rusetskii.config.ConfigProperties.*;

@Component
public class SolrServer implements SearchClient {

    private Http2SolrClient solrClient;

    @Autowired
    private ItemRepository itemRepository;

    public SolrServer() {
        solrClient = new Http2SolrClient.Builder(String.format(SOLR_URL_PATTERN, SOLR_HOST, SOLR_PORT, CORE)).build();
    }

    @PreDestroy
    public void shutdown() {
        solrClient.close();
    }

    @Override
    public boolean index(Item document) {
        return false;
    }

    @Override
    public boolean index(List<Item> documents) {
        return false;
    }

    @Override
    public boolean indexAll() {
        try {
            solrClient.deleteByQuery("*:*");
            solrClient.commit();
            solrClient.addBeans(itemRepository.findAll());
            solrClient.commit();
            return true;
        } catch (SolrServerException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Item> search(SolrQuery searchQuery) {
        try {
            QueryResponse queryResponse = solrClient.query(searchQuery);
            return queryResponse.getBeans(Item.class);
        } catch (SolrServerException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Item> suggest(SolrQuery params) {
        return search(params);
    }
}
