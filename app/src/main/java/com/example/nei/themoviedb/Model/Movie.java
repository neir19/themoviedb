
package com.example.nei.themoviedb.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Movie {
    @SerializedName("page")
    private Integer page;
    @SerializedName("total_results")
    private Integer totalResults;
    @SerializedName("total_pages")
    private Integer totalPages;
    @SerializedName("results")
    private List<Result> results = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Movie() {
    }

    /**
     * 
     * @param results
     * @param totalResults
     * @param page
     * @param totalPages
     */
    public Movie(Integer page, Integer totalResults, Integer totalPages, List<Result> results) {
        super();
        this.page = page;
        this.totalResults = totalResults;
        this.totalPages = totalPages;
        this.results = results;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

}
