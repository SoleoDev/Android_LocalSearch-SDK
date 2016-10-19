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
 * <p>This is the Data Model in which {@link com.soleo.lsapi.models.PresentedData} is Wrapped in.
 * This contains very little user displayable information.  Most developers will not use any method
 * or data in this model </p>
 * @author Scott Baron at Soleo Communications
 * @version 1.0
 * @since Soleo Local Search SKD ver. 1.0
 */
public class CallBack 
        extends BaseModel
        implements java.io.Serializable {
    private static final long serialVersionUID = 5079199602534761992L;
    private List<Links> links;
    private List<PresentedData> data;
    /**
     * TODO - Check the error code refreanced
     * <p>This will return an array of type {@link com.soleo.lsapi.models.Links} with a size of one (1).
     * The link data model contained in this Array will be the URL that was <strong>just called.</strong>
     * If you are manually calling the links do not uses this Array to do so.  It will fail and return
     * a 404 status code.  "Request already sent".</p>
     * <strong>It is recommended you use {@link BusinessElement} to make your calls to the server</strong>
     * <p>For more information on response codes please visit <a href="https://developer.soleo.com/docs/response_codes"><u>Soleo Communications</u></a></p>
     * @since 1.0
     * @return An array List of type {@link com.soleo.lsapi.models.Links}
     */
    @JsonGetter("_links")
    public List<Links> getLinks ( ) { 
        return this.links;
    }
    
    /** SETTER
     * Blah
     */
    @JsonSetter("_links")
    private void setLinks (List<Links> value) { 
        this.links = value;
        notifyObservers(this.links);
    }
 
    /**
     * <p>This method will return a list of type {@link com.soleo.lsapi.models.PresentedData} with a size of one (1).</p>
     * <strong>Note: If you have to gain access to {@link com.soleo.lsapi.models.PresentedData}
     * it is recommended doing so with the {@link BusinessElement} class.</strong>
     * @since 1.0
     * @return ArrayList of Type {@link com.soleo.lsapi.models.PresentedData}
     */
    @JsonGetter("data")
    public List<PresentedData> getData ( ) { 
        return this.data;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("data")
    private void setData (List<PresentedData> value) { 
        this.data = value;
        notifyObservers(this.data);
    }
 
}
 