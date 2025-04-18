package org.sourcelab.activecampaign.apiv3.request.deal;

import org.sourcelab.activecampaign.apiv3.request.RequestWithQueryString;

public class DealSearch extends RequestWithQueryString {

  public DealSearch withContact(final String contact) {
    queryParams.put("filters[contact]", contact);
    return this;
  }

  // yyyy-mm-dd
  public DealSearch withCreatedAfter(final String after) {
    queryParams.put("filters[created_after]", after);
    return this;
  }
}
