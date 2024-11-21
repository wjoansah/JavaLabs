package com.wjoansah.design_patterns.builder;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class SearchQuery {
    private final String keyword;
    private final Date startDate;
    private final Date endDate;
    private final List<String> categories;
    private final int minResults;
    private final int maxResults;
    private final boolean sortAscending;

    private SearchQuery(Builder builder) {
        this.keyword = builder.getKeyword();
        this.startDate = builder.getStartDate();
        this.endDate = builder.getEndDate();
        this.categories = builder.getCategories();
        this.minResults = builder.getMinResults();
        this.maxResults = builder.getMaxResults();
        this.sortAscending = builder.isSortAscending();
    }

    public String getKeyword() {
        return keyword;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public List<String> getCategories() {
        return categories;
    }

    public int getMinResults() {
        return minResults;
    }

    public int getMaxResults() {
        return maxResults;
    }

    public boolean isSortAscending() {
        return sortAscending;
    }

    @Override
    public String toString() {
        return "SearchQuery{" +
                "keyword='" + keyword + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", categories=" + categories +
                ", minResults=" + minResults +
                ", maxResults=" + maxResults +
                ", sortAscending=" + sortAscending +
                '}';
    }


    public static class Builder {
        private String keyword;
        private Date startDate;
        private Date endDate;
        private List<String> categories;
        private int minResults;
        private int maxResults;
        private boolean sortAscending;

        public String getKeyword() {
            return keyword;
        }

        public Date getStartDate() {
            return startDate;
        }

        public Date getEndDate() {
            return endDate;
        }

        public List<String> getCategories() {
            return categories;
        }

        public int getMinResults() {
            return minResults;
        }

        public int getMaxResults() {
            return maxResults;
        }

        public boolean isSortAscending() {
            return sortAscending;
        }

        public Builder keyword(String keyword) {
            this.keyword = keyword;
            return this;
        }

        public Builder startDate(Date startDate) {
            this.startDate = startDate;
            return this;
        }

        public Builder endDate(Date endDate) {
            this.endDate = endDate;
            return this;
        }

        public Builder categories(List<String> categories) {
            this.categories = categories;
            return this;
        }

        public Builder minResults(int minResults) {
            this.minResults = minResults;
            return this;
        }

        public Builder maxResults(int maxResults) {
            this.maxResults = maxResults;
            return this;
        }

        public Builder sortAscending(boolean sortAscending) {
            this.sortAscending = sortAscending;
            return this;
        }

        // Build method to create the final SearchQuery object
        public SearchQuery build() {
            // You could add validation here, if necessary
            if (startDate != null && endDate != null && startDate.after(endDate)) {
                throw new IllegalArgumentException("Start date must be before end date.");
            }
            return new SearchQuery(this);
        }

        public static void main(String[] args) {
            SearchQuery searchQuery = new SearchQuery.Builder()
                    .keyword("java programming")
                    .startDate(new Date(1633024800000L)) // Oct 1, 2021
                    .endDate(new Date(1635703199000L))   // Oct 31, 2021
                    .categories(Arrays.asList("technology", "programming"))
                    .minResults(10)
                    .maxResults(50)
                    .sortAscending(false)
                    .build();

            System.out.println(searchQuery);
        }
    }
}

