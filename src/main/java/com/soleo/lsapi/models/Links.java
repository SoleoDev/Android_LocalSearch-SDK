/*
 * SoleoLocalSearchAPI
 *
 * This file was automatically generated for SOLEO by APIMATIC BETA v2.0 on 03/01/2016
 */
package com.soleo.lsapi.models;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.soleo.sl.element.BusinessElement;

/**
 * <p>This data model is used to hold the links that are used to advance in the the Monetization
 * Callback Sequence.</p>
 * <p>More information about the call back Sequence can be found at <a href="https://developer.soleo.com/docs/callback_sequence_for_monetization">
 *     <u>Soleo Communications</u></a></p>
 * <strong>Note: The callbacks can be preformed using the {@link BusinessElement}</strong>
 * @version 1.0
 * @since Soleo Local Search SDK ver. 1.0
 * @author Scott Baron at Soleo Communications
 */
public class Links 
        extends BaseModel
        implements java.io.Serializable {
    private static final long serialVersionUID = 4843803133937484302L;
    private String href;
    private String method;
    private String rel;
    /**
     * <p>The full URL of the link.</p>
     * <p>This is the URL to the call in the form of a String.</p>
     * @since 1.0
     * @return A String representation of the URL
     *      <blockquote><i>"https://trialapi.soleo.com/SearchNormalizationApplication/businesses/presented/e84a95d4-d8e6-4414-a9f6-0c04b41499fb;jsessionid=69718E57D98722111B48401EC559B91E.0a0b01f1?APIKey=$APIKEY"</i></blockquote>
     */
    @JsonGetter("href")
    public String getHref ( ) { 
        return this.href;
    }
    
    /** SETTER
     * The full URL of the link.
     */
    @JsonSetter("href")
    private void setHref (String value) { 
        this.href = value;
        notifyObservers(this.href);
    }
 
    /**
     * <p>HTTP method to use for this link.</p>
     * <ul>
     *     <li>"GET"</li>
     *     <li>"POST"</li>
     * </ul>
     * @since 1.0
     * @return A String representation of the Method Needed
     */
    @JsonGetter("method")
    public String getMethod ( ) { 
        return this.method;
    }
    
    /** SETTER
     * HTTP method to use for this link ("GET" or "POST")
     */
    @JsonSetter("method")
    private void setMethod (String value) { 
        this.method = value;
        notifyObservers(this.method);
    }
 
    /**
     * <p>URN of the link (or "self" if it is a link back to itself)</p>
     * <p>This can be used to see the call that the link will make to the server.</p>
     * <strong>Note: Do not make a call to the server with a URN with a value of "self"</strong>
     * @since 1.0
     * @return A String value of the URN
     *      <blockquote><i>"urn:soleo:businesses:presented"</i></blockquote>
     */
    @JsonGetter("rel")
    public String getRel ( ) { 
        return this.rel;
    }
    
    /** SETTER
     * URN of the link (or "self" if it is a link back to itself)
     */
    @JsonSetter("rel")
    private void setRel (String value) { 
        this.rel = value;
        notifyObservers(this.rel);
    }
 
}
 
