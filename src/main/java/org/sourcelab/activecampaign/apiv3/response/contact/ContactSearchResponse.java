package org.sourcelab.activecampaign.apiv3.response.contact;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.sourcelab.activecampaign.apiv3.request.contact.Contact;
import org.sourcelab.activecampaign.apiv3.response.Meta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ContactSearchResponse {
    private final List<Contact> contacts;
    private final Meta meta;

    @JsonCreator
    public ContactSearchResponse(
        @JsonProperty("contacts") final List<Contact> contacts,
        @JsonProperty("meta") final Meta meta
    ) {
        if (contacts == null) {
            this.contacts = Collections.emptyList();
        } else {
            this.contacts = Collections.unmodifiableList(new ArrayList<>(contacts));
        }
        this.meta = meta;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public Meta getMeta() {
        return meta;
    }

    @Override
    public String toString() {
        return "AccountListResponse{" +
            "contacts=" + contacts +
            ", meta=" + meta +
            '}';
    }
}
