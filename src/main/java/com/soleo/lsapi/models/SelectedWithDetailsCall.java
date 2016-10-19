/*
 * SoleoLocalSearchAPI
 *
 * This file was automatically generated for SOLEO by APIMATIC BETA v2.0 on 03/01/2016
 */
package com.soleo.lsapi.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

/**
 * <p>This Data model is created after a Selected with Details call was made to the server.</p>
 * <p>This data model has the {@link com.soleo.lsapi.models.SelectedWithDInfo} data model wrapped with it.</p>
 * @since Soleo Local Search SDK ver. 1.0
 * @version 1.0
 * @author Scott Baron at Soleo Communications
 *
 */
public class SelectedWithDetailsCall 
        extends BaseModel
        implements java.io.Serializable {
    private static final long serialVersionUID = 5063409042020938655L;
    private List<Links> links;
    private List<SelectedWithDInfo> data;
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
     * Set the links using JSON
     */
    @JsonSetter("_links")
    private void setLinks (List<Links> value) { 
        this.links = value;
        notifyObservers(this.links);
    }
 
    /**
     * <p>This method is used to get the {@link com.soleo.lsapi.models.SelectedWithDInfo} Data Model.</p>
     * @since 1.0
     * @return a list of type {@link com.soleo.lsapi.models.SelectedWithDInfo}
     */
    @JsonGetter("data")
    public List<SelectedWithDInfo> getData ( ) { 
        return this.data;
    }
    
    /** SETTER
     * Sets the data that comes back from the request using JSON
     */
    @JsonSetter("data")
    private void setData (List<SelectedWithDInfo> value) { 
        this.data = value;
        notifyObservers(this.data);
    }
 
}
 