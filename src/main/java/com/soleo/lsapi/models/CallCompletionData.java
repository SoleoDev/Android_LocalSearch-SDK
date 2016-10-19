/*
 * SoleoLocalSearchAPI
 *
 * This file was automatically generated for SOLEO by APIMATIC BETA v2.0 on 03/01/2016
 */
package com.soleo.lsapi.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class CallCompletionData 
        extends BaseModel
        implements java.io.Serializable {
    private static final long serialVersionUID = 5714342574287819057L;
    private List<Links> links;
    private String action;
    private String completionPhoneNumber;
    private String displayPhoneNumber;
    private String validUntil;
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("_links")
    public List<Links> getLinks ( ) { 
        return this.links;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("_links")
    private void setLinks (List<Links> value) { 
        this.links = value;
        notifyObservers(this.links);
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("action")
    public String getAction ( ) { 
        return this.action;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("action")
    private void setAction (String value) { 
        this.action = value;
        notifyObservers(this.action);
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("completionPhoneNumber")
    public String getCompletionPhoneNumber ( ) { 
        return this.completionPhoneNumber;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("completionPhoneNumber")
    private void setCompletionPhoneNumber (String value) { 
        this.completionPhoneNumber = value;
        notifyObservers(this.completionPhoneNumber);
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("displayPhoneNumber")
    public String getDisplayPhoneNumber ( ) { 
        return this.displayPhoneNumber;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("displayPhoneNumber")
    private void setDisplayPhoneNumber (String value) { 
        this.displayPhoneNumber = value;
        notifyObservers(this.displayPhoneNumber);
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("validUntil")
    public String getValidUntil ( ) { 
        return this.validUntil;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("validUntil")
    private void setValidUntil (String value) { 
        this.validUntil = value;
        notifyObservers(this.validUntil);
    }
 
}
 