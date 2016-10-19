/*
 * SoleoLocalSearchAPI
 *
 * This file was automatically generated for SOLEO by APIMATIC BETA v2.0 on 03/01/2016
 */
package com.soleo.lsapi.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.soleo.sl.element.BusinessElement;

/**
 * <p>The is the data model that is created when getCallCompletionNumber() is called from the
 * {@link BusinessElement}.  This classes primary purpose is to hold the
 * {@link com.soleo.lsapi.models.CallCompletionData} in a wrapper along with the link that was
 * just sent to the sever.</p>
 * @version 1.0
 * @since Soleo Local Search SDK ver. 1.0
 * @author Scott Baron at Soleo Communications
 */
public class CallCompletionCallback 
        extends BaseModel
        implements java.io.Serializable {
    private static final long serialVersionUID = 5262215662648479808L;
    private List<Links> links;
    private List<CallCompletionData> data;
    /**
     * <p>This method is used to get a list of links that was used to send a request to the server
     * The size of tis list will always be one (1).</p>
     * @since 1.0
     * @return List of type {@link com.soleo.lsapi.models.Links}
     */
    @JsonGetter("_links")
    public List<Links> getLinks ( ) { 
        return this.links;
    }
    
    /** SETTER
     * This is a Setter keep it hidden MEEEAAAAhhhhuuu
     */
    @JsonSetter("_links")
    private void setLinks (List<Links> value) { 
        this.links = value;
        notifyObservers(this.links);
    }
 
    /**
     * <p>This is the method that is used to get the data model that holds the call completion
     * and display number</p>
     * @since 1.0
     * @return the data model {@link com.soleo.lsapi.models.CallCompletionData}
     */
    @JsonGetter("data")
    public List<CallCompletionData> getData ( ) { 
        return this.data;
    }
    
    /**
     * Used to create the data model from the returned JSON
     * Hide it from the developer
     */
    @JsonSetter("data")
    private void setData (List<CallCompletionData> value) { 
        this.data = value;
        notifyObservers(this.data);
    }
 
}
 