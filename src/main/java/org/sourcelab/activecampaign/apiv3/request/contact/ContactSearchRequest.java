package org.sourcelab.activecampaign.apiv3.request.contact;

import org.sourcelab.activecampaign.JacksonFactory;
import org.sourcelab.activecampaign.apiv3.response.contact.ContactRetrieveResponse;
import org.sourcelab.activecampaign.apiv3.response.contact.ContactSearchResponse;
import org.sourcelab.http.rest.request.Request;
import org.sourcelab.http.rest.request.RequestMethod;
import org.sourcelab.http.rest.request.body.NoBodyContent;
import org.sourcelab.http.rest.request.body.RequestBodyContent;

import java.io.IOException;

public class ContactSearchRequest implements Request<ContactSearchResponse> {
    private final long listId;
    // TODO: yyyy-mm-dd format
    private final String filterCreatedAfter;

    // TODO: replace with a Search class
    public ContactSearchRequest(final long listId, final String filterCreatedAfter) {
        this.listId = listId;
        this.filterCreatedAfter = filterCreatedAfter;
    }

    // TODO: better way to compose query params
    @Override
    public String getApiEndpoint() {
        return "api/3/contacts?listid=" + listId + "&filters[created_after]=" + filterCreatedAfter;
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
    public ContactSearchResponse parseResponse(final String response) throws IOException {
        return JacksonFactory.newInstance().readValue(response, ContactSearchResponse.class);
    }
}
