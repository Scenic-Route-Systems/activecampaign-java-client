package org.sourcelab.activecampaign.apiv3.request.deal;

import org.sourcelab.activecampaign.JacksonFactory;
import org.sourcelab.activecampaign.apiv3.response.deal.DealSearchResponse;
import org.sourcelab.http.rest.request.Request;
import org.sourcelab.http.rest.request.RequestMethod;
import org.sourcelab.http.rest.request.body.NoBodyContent;
import org.sourcelab.http.rest.request.body.RequestBodyContent;

import java.io.IOException;

public class DealSearchRequest implements Request<DealSearchResponse> {

    private final DealSearch dealSearch;

    public DealSearchRequest(final DealSearch dealSearch) {
      this.dealSearch = dealSearch;
    }

    @Override
    public String getApiEndpoint() {
        return "api/3/deals?" + dealSearch.buildQueryString();
    }

    @Override
    public RequestMethod getRequestMethod() {
        return RequestMethod.GET;
    }

    @Override
    public RequestBodyContent getRequestBody() {
        return new NoBodyContent();
    }

    @Override
    public DealSearchResponse parseResponse(final String response) throws IOException {
        return JacksonFactory.newInstance().readValue(response, DealSearchResponse.class);
    }
}
