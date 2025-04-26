package org.sourcelab.activecampaign.apiv3.request.deal;

import org.sourcelab.activecampaign.JacksonFactory;
import org.sourcelab.activecampaign.apiv3.response.deal.DealCustomFieldValueListResponse;
import org.sourcelab.http.rest.request.Request;
import org.sourcelab.http.rest.request.RequestMethod;
import org.sourcelab.http.rest.request.body.NoBodyContent;
import org.sourcelab.http.rest.request.body.RequestBodyContent;

import java.io.IOException;

public class DealCustomFieldValueListRequest implements Request<DealCustomFieldValueListResponse> {

    private final Long dealId;

    public DealCustomFieldValueListRequest(final Long dealId) {
      this.dealId = dealId;
    }

    @Override
    public String getApiEndpoint() {
        return "api/3/dealCustomFieldData?&filters[dealId]=" + dealId;
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
    public DealCustomFieldValueListResponse parseResponse(final String response) throws IOException {
        return JacksonFactory.newInstance().readValue(response, DealCustomFieldValueListResponse.class);
    }
}
