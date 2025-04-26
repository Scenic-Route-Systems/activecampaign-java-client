package org.sourcelab.activecampaign.apiv3.request.contact;

import org.sourcelab.activecampaign.apiv3.request.DTOWithQueryString;

public class ContactSearch extends DTOWithQueryString {

  public ContactSearch withListId(final long listId) {
    queryParams.put("listid", listId + "");
    return this;
  }

  // yyyy-mm-dd
  public ContactSearch withCreatedAfter(final String createdAfter) {
    queryParams.put("filters[created_after]", createdAfter);
    return this;
  }
}
