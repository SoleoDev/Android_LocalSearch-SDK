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
 * <p>A data model that contains the information about how far a business is from a search
 * location.</p>
 * @since Soleo Local Search SDK ver. 1.0
 * @version 1.0
 * @author Scott Baron at Soleo Communications
 */
public class Distance 
        extends BaseModel
        implements java.io.Serializable {
    private static final long serialVersionUID = 5242110748948979285L;
    private Double miles;
    /**
     * <p>Distance of business from the search location in the form of miles</p>
     * @since 1.0
     * @return The distance in the form of a double in units of miles.
     *      <blockquote><i>8.52</i></blockquote>
     */
    @JsonGetter("miles")
    public Double getMiles ( ) { 
        return this.miles;
    }
    
    /** SETTER
     * distance of business from the search location
     */
    @JsonSetter("miles")
    private void setMiles (Double value) { 
        this.miles = value;
        notifyObservers(this.miles);
    }
 
}
 