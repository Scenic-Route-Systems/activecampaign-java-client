package org.sourcelab.activecampaign.apiv3.response.deal;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.sourcelab.activecampaign.apiv3.request.deal.Deal;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DealSearchResponse {
//    private final List<Deal> deals;
    private final List<Deal> deals = new ArrayList<>();

    @JsonCreator
    public DealSearchResponse(
//        @JsonProperty("deals") final List<Deal> deals
        // TODO: temporarily keeping this so I can see all the values for debugging
        @JsonProperty("deals") final List<Map<String, Object>> dealsValues
    ) {
//        this.deals = deals;

        for (Map<String, Object> dealValues : dealsValues) {
            final Deal deal = new Deal(
                Long.parseLong((String) dealValues.get("id")),
                null, //@JsonProperty("contact") final String contact,
                null, //@JsonProperty("organization") final String organization,
                null, //@JsonProperty("title") final String title,
                null, //@JsonProperty("description") final String description,
                null, //@JsonProperty("stage") final String stage,
                null, //@JsonProperty("status") final String status,
                (Map<String, String>) dealValues.get("links")
            );

            deals.add(deal);
        }
    }

    public List<Deal> getDeals() {
        return deals;
    }
}
