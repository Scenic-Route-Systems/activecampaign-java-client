package org.sourcelab.activecampaign.apiv3.request.contact;

import org.sourcelab.activecampaign.apiv3.request.DTOWithQueryString;

import java.util.List;

public class ContactSearch extends DTOWithQueryString {

  public ContactSearch withIds(final List<Long> ids) {
    for (final Long id : ids) {
      queryParams.put("ids[]", id.toString());
    }
    return this;
  }

  public ContactSearch withListId(final long listId) {
    queryParams.put("listid", listId + "");
    return this;
  }

  // yyyy-mm-dd
  public ContactSearch withCreatedBefore(final String createdBefore) {
    queryParams.put("filters[created_before]", createdBefore);
    return this;
  }

  // yyyy-mm-dd
  public ContactSearch withCreatedAfter(final String createdAfter) {
    queryParams.put("filters[created_after]", createdAfter);
    return this;
  }

  // yyyy-mm-dd
  public ContactSearch withUpdatedBefore(final String updatedBefore) {
    queryParams.put("filters[updated_before]", updatedBefore);
    return this;
  }

  // yyyy-mm-dd
  public ContactSearch withUpdatedAfter(final String updatedAfter) {
    queryParams.put("filters[updated_after]", updatedAfter);
    return this;
  }
}
