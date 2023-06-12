package com.rusetskii.search;

import com.rusetskii.data.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SearchController {
    private static final Logger LOGGER = LoggerFactory.getLogger(SearchController.class);
    private final SearchIndexerService searchIndexerService;

    public SearchController(SearchIndexerService searchIndexerService) {
        this.searchIndexerService = searchIndexerService;
    }

    @GetMapping(value = SearchConstants.SEARCH_URL, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Item> search(@RequestParam("query") String query) {
        // TODO: move QueryParam to args
        QueryParams queryParams = new QueryParams(query);
        LOGGER.debug("search parameters [{}]", queryParams);
        return searchIndexerService.search(queryParams);
    }

    @GetMapping(value = SearchConstants.SUGGEST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Item> suggest(@RequestParam("q") String query) {
        // TODO: move QueryParam to args
        QueryParams queryParams = new QueryParams(query);
        LOGGER.debug("suggest parameters [{}]", queryParams);
        return searchIndexerService.suggest(queryParams);
    }

    @GetMapping(value = SearchConstants.INDEX_URL, produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean index() {
        LOGGER.info("Starting indexing...");
        return searchIndexerService.index();
    }
}
