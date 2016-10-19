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
 * <p>This is a Data model that is wrapped in the {@link com.soleo.lsapi.models.Summary} Data Model.</p>
 * <strong>Note: This is where the Summary data actually lives</strong>
 * @version 1.0
 * @since Soleo Local Search SDK ver. 1.0
 * @author Scott Baron at Soleo Communications
 */
public class ResultsCount 
        extends BaseModel
        implements java.io.Serializable {
    private static final long serialVersionUID = 5541557518551533468L;
    private int organic = 0;
    private int sponsored = 0;
    /**
     * <p>Number of organic search results (listings)</p>
     * @since 1.0
     * @return An Integer that is the number of organic listings in the search results
     *      <blockquote><i>7</i></blockquote>
     */
    @JsonGetter("organic")
    public int getOrganic ( ) { 
        return this.organic;
    }
    
    /** SETTER
     * Number of organic search results (listings)
     */
    @JsonSetter("organic")
    private void setOrganic (int value) { 
        this.organic = value;
        notifyObservers(this.organic);
    }
 
    /**
     * <p>Number of sponsored search results (Ads)</p>
     * @since 1.0
     * @return an Integer that is the number of sponsored listings returned in the search results
     *      <blockquote><i>3</i></blockquote>
     */
    @JsonGetter("sponsored")
    public int getSponsored ( ) { 
        return this.sponsored;
    }
    
    /** SETTER
     * Number of sponsered search results (Ads)
     */
    @JsonSetter("sponsored")
    private void setSponsored (int value) { 
        this.sponsored = value;
        notifyObservers(this.sponsored);
    }
 
}
 