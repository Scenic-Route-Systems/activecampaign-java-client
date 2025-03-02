package org.sourcelab.activecampaign.apiv3.request.contact;

import org.sourcelab.activecampaign.apiv3.request.RequestWithQueryString;

public class ContactSearch extends RequestWithQueryString {

  public ContactSearch withListId(final long listId) {
    queryParams.put("listid", listId + "");
    return this;
  }

  // yyyy-mm-dd
  public ContactSearch withFilterCreatedAfter(final String filterCreatedAfter) {
    queryParams.put("filters[created_after]", filterCreatedAfter);
    return this;
  }
}
