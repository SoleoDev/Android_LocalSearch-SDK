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
 * <p>This data model contains the information that comes back from a selected with details call.</p>
 * <p>The information that is contained in the Data model is:</p>
 * <ul>
 *     <li>{@link com.soleo.lsapi.models.BusinessDetails}</li>
 * </ul>
 * @version 1.0
 * @since Soleo Local Search SDK ver. 1.0
 * @author Scott Baron at Soleo Communications
 */
public class SelectedWithDInfo 
        extends BaseModel
        implements java.io.Serializable {
    private static final long serialVersionUID = 5053544288990707141L;
    private List<Links> links;
    private BusinessDetails details;
    /**
     * <p>The method is used to get a list of links to progress the Call back Sequence</p>
     * <p>The size of this list in almost all cases is one (1). </p>
     * <strong>Note: You can use {@link BusinessElement} to advance the Sequence with out having to deal with the HTTP Requests</strong>
     * @since 1.0
     * @return A list of type {@link com.soleo.lsapi.models.Links}
     */
    @JsonGetter("_links")
    public List<Links> getLinks ( ) { 
        return this.links;
    }
    
    /** SETTER
     * This is used by the Type face to create the link from JSON
     */
    @JsonSetter("_links")
    private void setLinks (List<Links> value) { 
        this.links = value;
        notifyObservers(this.links);
    }
 
    /**
     * <p>Gets the data model that contains the Following information:</p>
     * <ul>
     *     <li>isOpen</li>
     *     <li>hours</li>
     *     <li>displayHours</li>
     *     <li>timeZone</li>
     * </ul>
     * @since 1.0
     * @return a data model of type {@link com.soleo.lsapi.models.BusinessDetails}
     */
    @JsonGetter("details")
    public BusinessDetails getDetails ( ) { 
        return this.details;
    }
    
    /** SETTER
     * Builds the Deatails Data model from Json
     */
    @JsonSetter("details")
    private void setDetails (BusinessDetails value) { 
        this.details = value;
        notifyObservers(this.details);
    }
 
}
 