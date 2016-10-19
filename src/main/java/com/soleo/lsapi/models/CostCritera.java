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
 * <p>This data model is used to describe any costs that are associated with a particular business
 * search Results.  Learn more about Costs and Moneization at <a href="https://developer.soleo.com/docs/about_businesses"><u>Soleo Communications</u></a></p>
 * @version 1.0
 * @since Soleo Local Search SDK ver. 1.0
 * @author Scott Baron at Soleo Communications
 */
public class CostCritera 
        extends BaseModel
        implements java.io.Serializable {
    private static final long serialVersionUID = 4997067892764546034L;
    private String action;
    private Date validUntil;
    private double value;
    /**
     * <p>Specifies the actions to which costs apply for this business</p>
     * <p>This describes the event in which a cost is applied to the API Key's Account</p>
     * @since 1.0
     * @return A String value of the action that triggers cost.
     *      <blockquote><i>"CALLED</i></blockquote>
     */
    @JsonGetter("action")
    public String getAction ( ) { 
        return this.action;
    }
    
    /** SETTER
     * specifies the actions to which costs apply for this business: 
     */
    @JsonSetter("action")
    private void setAction (String value) { 
        this.action = value;
        notifyObservers(this.action);
    }
 
    /**
     * <p>specifies the time in UTC (Coordinated Universal Time) format when this business no longer incurs a cost if a cost action is performed.</p>
     * @since 1.0
     * @return A String representation of the Time the cost is valid to.
     *      <blockquote><i>"2016-02-02T18:46:45.763Z"</i></blockquote>
     */
    @JsonGetter("validUntil")
    public Date getValidUntil ( ) { 
        return this.validUntil;
    }
    
    /** SETTER
     * specifies the time in UTC (Coordinated Universal Time) format when this business no longer incurs a cost if a cost action is performed. 
     */
    @JsonSetter("validUntil")
    private void setValidUntil (Date value) { 
        this.validUntil = value;
        notifyObservers(this.validUntil);
    }
 
    /**
     * <p>The fixed amount cost (in dollars) that can be charged if a cost action is performed.</p>
     * @since 1.0
     * @return The amount of coast that is involved when the action takes place
     *          <blockquote><i>0.01306</i></blockquote>
     */
    @JsonGetter("value")
    public double getValue ( ) { 
        return this.value;
    }
    
    /** SETTER
     * the fixed amount cost (in dollars) that can be charged if a cost action is performed. 
     */
    @JsonSetter("value")
    private void setValue (double value) { 
        this.value = value;
        notifyObservers(this.value);
    }
 
}
 