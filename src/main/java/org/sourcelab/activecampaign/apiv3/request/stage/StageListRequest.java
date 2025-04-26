package org.sourcelab.activecampaign.apiv3.request.stage;

import org.sourcelab.activecampaign.JacksonFactory;
import org.sourcelab.activecampaign.apiv3.response.stage.StageListResponse;
import org.sourcelab.http.rest.request.GetRequest;

import java.io.IOException;

public class StageListRequest implements GetRequest<StageListResponse> {

    @Override
    public String getApiEndpoint() {
        return "api/3/dealStages";
    }

    @Override
    public StageListResponse parseResponse(final String response) throws IOException {
        return JacksonFactory.newInstance().readValue(response, StageListResponse.class);
    }
}
