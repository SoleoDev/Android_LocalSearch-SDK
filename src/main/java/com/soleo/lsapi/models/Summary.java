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
 * <p>Data model that is created after a search.  The information from the search is wrapped with in
 * {@link com.soleo.lsapi.models.ResultsCount}.</p>
 * <p>This data model is just the holder for the data model</p>
 * @since Soleo Local Search SDK ver. 1.0
 * @version 1.0
 * @author Scott Baron at Soleo Communications
 */
public class Summary 
        extends BaseModel
        implements java.io.Serializable {
    private static final long serialVersionUID = 4668172494087304559L;
    private ResultsCount resultsCount;
    private Date validUntil;
    private String jSessionID;

    //Link to get for reference.
    private String link;

    /**
     * <p>Indicates the number of businesses returned in the response by type.</p>
     * <p>{@link com.soleo.lsapi.models.ResultsCount} is a data model that has this information
     * broken down into there separate fields</p>
     * @since 1.0
     * @return a data model of type {@link com.soleo.lsapi.models.ResultsCount}
     */
    @JsonGetter("resultsCount")
    public ResultsCount getResultsCount ( ) { 
        return this.resultsCount;
    }
    
    /** SETTER
     * indicates the number of businesses returned in the response by type
     */
    @JsonSetter("resultsCount")
    private void setResultsCount (ResultsCount value) { 
        this.resultsCount = value;
        notifyObservers(this.resultsCount);
    }
 
    /**
     * <p>Specifies the time in UTC (Coordinated Universal Time) format when the session will expire.</p>
     * <strong>Note: You must complete the calls within this time before a Timeout occurs</strong>
     * <p>To learn more about the call back sequence visit <a href="https://developer.soleo.com/docs/callback_sequence_for_monetization"><u>Soleo Communications</u></a></p>
     * <p>To learn more about the different type of status codes visit Soleo <a href="https://developer.soleo.com/docs/response_codes"><u>here</u></a></p>
     * @since 1.0
     * @return a Date data type that can be used to compare against the current time
     *      <blockquote><i>2016-02-02T18:45:43.438Z</i></blockquote>
     */
    @JsonGetter("validUntil")
    public Date getValidUntil ( ) { 
        return this.validUntil;
    }
    
    /** SETTER
     * specifies the time in UTC (Coordinated Universal Time) format when the session will expire. 
     */
    @JsonSetter("validUntil")
    private void setValidUntil (Date value) { 
        this.validUntil = value;
        notifyObservers(this.validUntil);
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }


    public String getjSessionID() {
        return jSessionID;
    }

    public void setjSessionID(String jSessionID) {
        this.jSessionID = jSessionID;
    }
 
}
 