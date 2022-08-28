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

//    public Form(String firstName, String lastName, String mail, String companyName, Topic topic, RelationshipToSap relationshipToSap) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.mail = mail;
//        this.companyName = companyName;
//        this.topic = topic;
//        this.relationshipToSap = relationshipToSap;
//    }
}
