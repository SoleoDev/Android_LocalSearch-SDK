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
 * <p>This is the data model that is returned after a Search has been requested by the application.</p>
 * <p>This data model contains the following data models which may be used in various way to display
 * information to the User.</p>
 * <p>The contained Data Models are:</p>
 * <ul>
 *     <li>{@link com.soleo.lsapi.models.Businesses} (a List of Business that are the results of the Search</li>
 *     <li>{@link com.soleo.lsapi.models.Summary} (A collection of data that describes the search results returned)</li>
 * </ul>
 * @version 1.0
 * @since Soleo Local Search SDK ver. 1.0
 * @author Scott Baron at Soleo Communications
 */
public class Response 
        extends BaseModel
        implements java.io.Serializable {
    private static final long serialVersionUID = 5735327486444102038L;
    private List<Links> links;
    private List<Businesses> businesses;
    private Summary summary;
    /**
     * <p>The top-level _links section contains a self section that is used to provide a self-referencing URL for the inital API request.</p>
     * @since 1.0
     * @return A data model of type {@link com.soleo.lsapi.models.Links}
     */
    @JsonGetter("_links")
    public List<Links> getLinks ( ) { 
        return this.links;
    }
    
    /** SETTER
     * The top-level _links section contains a self section that is used to provide a self-referencing URL for the inital API request. 
     */
    @JsonSetter("_links")
    private void setLinks (List<Links> value) { 
        this.links = value;
        //TODO: CHECK THIS OUT TO LINKS
        notifyObservers(this.links);
    }
 
    /**
     * <p>Contains data on 0 or more business that are returned in the search results.</p>
     * <strong>Note: Using the {@link com.soleo.sl.SoleoLocalSearch} Class you will be dealing with {@link BusinessElement}</strong>
     * @since 1.0
     * @return This returns a list of type {@link com.soleo.lsapi.models.Businesses}
     */
    @JsonGetter("businesses")
    public List<Businesses> getBusinesses ( ) { 
        return this.businesses;
    }
    
    /** SETTER
     * contains data on 0 or more business that are returned in the search results. 
     */
    @JsonSetter("businesses")
    private void setBusinesses (List<Businesses> value) { 
        this.businesses = value;
        notifyObservers(this.businesses);
    }
 
    /**
     * <p>Summary counts of the results returned from the search</p>
     * @since 1.0
     * @return A data model {@link com.soleo.lsapi.models.Summary}
     */
    @JsonGetter("summary")
    public Summary getSummary ( ) { 
        return this.summary;
    }
    
    /** SETTER
     * summary counts of the results returned
     */
    @JsonSetter("summary")
    private void setSummary (Summary value) { 
        this.summary = value;
        notifyObservers(this.summary);
    }
 
}
 