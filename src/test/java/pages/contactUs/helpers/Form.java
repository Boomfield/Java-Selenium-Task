package pages.contactUs.helpers;

import lombok.Builder;

@Builder
public class Form {

    public String firstName;
    public String lastName;
    public String mail;
    public String companyName;
    public Topic topic;
    public RelationshipToSap relationshipToSap;

}
