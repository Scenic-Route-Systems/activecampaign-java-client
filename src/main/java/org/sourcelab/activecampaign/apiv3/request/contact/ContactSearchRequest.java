package org.sourcelab.activecampaign.apiv3.request.contact;

import org.sourcelab.activecampaign.JacksonFactory;
import org.sourcelab.activecampaign.apiv3.response.contact.ContactSearchResponse;
import org.sourcelab.http.rest.request.Request;
import org.sourcelab.http.rest.request.RequestMethod;
import org.sourcelab.http.rest.request.body.NoBodyContent;
import org.sourcelab.http.rest.request.body.RequestBodyContent;

import java.io.IOException;

public class ContactSearchRequest implements Request<ContactSearchResponse> {

    private final ContactSearch contactSearch;
    private final long offset;

    public ContactSearchRequest(final ContactSearch contactSearch, long offset) {
      this.contactSearch = contactSearch;
      this.offset = offset;
    }

    @Override
    public String getApiEndpoint() {
        return "api/3/contacts?offset=" + offset + "&" + contactSearch.buildQueryString();
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
