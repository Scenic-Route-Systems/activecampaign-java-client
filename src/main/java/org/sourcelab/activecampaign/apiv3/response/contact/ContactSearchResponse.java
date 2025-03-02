package org.sourcelab.activecampaign.apiv3.response.contact;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.sourcelab.activecampaign.apiv3.request.contact.Contact;
import org.sourcelab.activecampaign.apiv3.request.contact.ContactBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ContactSearchResponse {
    private final List<Contact> contacts = new ArrayList<>();

    @JsonCreator
    public ContactSearchResponse(
        @JsonProperty("contacts") final List<Map<String, Object>> contactsValues
    ) {
        for (Map<String, Object> contactValues : contactsValues) {
            final ContactBuilder builder = Contact.newBuilder()
                .withPhone((String) contactValues.get("phone"))
                .withFirstName((String) contactValues.get("firstName"))
                .withLastName((String) contactValues.get("lastName"))
                .withEmail((String) contactValues.get("email"))
                .withId((String) contactValues.get("id"));

            if (contactValues.containsKey("links")) {
                builder.withLinks((Map<String, String>) contactValues.get("links"));
            }

            contacts.add(builder.build());
        }
    }

    public List<Contact> getContacts() {
        return contacts;
    }
}
