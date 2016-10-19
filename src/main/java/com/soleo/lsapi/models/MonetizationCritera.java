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
 * <p>This data model describes the value gained when a described event takes place.</p>
 * @version 1.0
 * @since Soleo Local Search SDK ver. 1.0
 * @author Scott Baron at Soleo Communications
 */
public class MonetizationCritera 
        extends BaseModel
        implements java.io.Serializable {
    private static final long serialVersionUID = 5185177995290541802L;
    private String action;
    private String criteria;
    private Date validUntil;
    private String value;
    /**
     * <p>The event that needs to take place for money to be credited to the API Key Account</p>
     * <p>Learn more about Monetization at <a href="https://developer.soleo.com/docs/callback_sequence_for_monetization"><u>Soleo Communications</u></a></p>
     * @since 1.0
     * @return The action in the form of a String
     *      <blockquote><i>"CALLED"</i></blockquote>
     */
    @JsonGetter("action")
    public String getAction ( ) { 
        return this.action;
    }
    
    /** SETTER
     * action specifies the sponsor's desired outcome (or outcomes): 
     */
    @JsonSetter("action")
    private void setAction (String value) { 
        this.action = value;
        notifyObservers(this.action);
    }
 
    /**
     *  <p>Criteria only applies to the "Called" action.  It specifies the expected minimum duration of the phone call between the end user and the business, in seconds, that is required for the action to be monetized.</p>
     *  <p>Learn more about Monetization at <a href="https://developer.soleo.com/docs/callback_sequence_for_monetization"><u>Soleo Communications</u></a></p>
     *  @since 1.0
     *  @return A String of the Criteria
     *          <blockquote><i>"30"</i></blockquote>
     */
    @JsonGetter("criteria")
    public String getCriteria ( ) { 
        return this.criteria;
    }
    
    /** SETTER
     *  criteria only applies to the "Called" action.  It specifies the expected minimum duration of the phone call between the end user and the business, in seconds, that is required for the action to be monetized. 
     */
    @JsonSetter("criteria")
    private void setCriteria (String value) { 
        this.criteria = value;
        notifyObservers(this.criteria);
    }
 
    /**
     * <p>Specifies the time in UTC (Coordinated Universal Time) format when this business is no longer monetizeable.</p>
     * <strong>Note: This time is very important. Because the Event described in the action will only generate value if taken place within this time</strong>
     * <p>Learn more about Monetization at <a href="https://developer.soleo.com/docs/callback_sequence_for_monetization"><u>Soleo Communications</u></a></p>
     * @since 1.0
     * @return A date data type that can be used to compare the current time
     */
    @JsonGetter("validUntil")
    public Date getValidUntil ( ) { 
        return this.validUntil;
    }
    
    /** SETTER
     * specifies the time in UTC (Coordinated Universal Time) format when this business is no longer monetizeable. 
     */
    @JsonSetter("validUntil")
    private void setValidUntil (Date value) { 
        this.validUntil = value;
        notifyObservers(this.validUntil);
    }
 
    /**
     * <p>Value is the fixed amount revenue opportunity (in dollars) that can be obtained if the monetization action and criteria are met.</p>
     * <p>Learn more about Monetization at <a href="https://developer.soleo.com/docs/callback_sequence_for_monetization"><u>Soleo Communications</u></a></p>
     * @since 1.0
     * @return A String that represents the value that can be earned
     */
    @JsonGetter("value")
    public String getValue ( ) { 
        return this.value;
    }
    
    /** SETTER
     * value is the fixed amount revenue opportunity (in dollars) that can be obtained if the monetization action and criteria are met. 
     */
    @JsonSetter("value")
    private void setValue (String value) { 
        this.value = value;
        notifyObservers(this.value);
    }
 
}
 