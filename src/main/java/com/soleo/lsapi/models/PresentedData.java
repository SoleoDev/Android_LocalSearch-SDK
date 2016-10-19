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
 * <p>This Data model is created after the presented call is made to the server</p>
 * <strong>Note: The work of making the Presented Call is wrapped in the {@link BusinessElement}</strong>
 * <p>This Data model doesn't contain any information that the typical user will care about.</p>
 * @version 1.0
 * @since Soleo Local Search SDK ver. 1.0
 * @author Scott Baron at Soleo Communications
 */
public class PresentedData 
        extends BaseModel
        implements java.io.Serializable {
    private static final long serialVersionUID = 5471479656489042383L;
    private List<Links> links;
    private String action;
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
     * Used to build the data from the JSON Response
     */
    @JsonSetter("_links")
    private void setLinks (List<Links> value) { 
        this.links = value;
        notifyObservers(this.links);
    }
 
    /**
     * <p>This describes the action that is next in the sequence</p>
     * <strong>Note: This String is normally a fixed action</strong>
     * @since 1.0
     * @return A String that describes the next set in the sequence
     *      <blockquote><i>"select"</i></blockquote>
     */
    @JsonGetter("action")
    public String getAction ( ) { 
        return this.action;
    }
    
    /** SETTER
     * Used by the Typeface to set the value from the JSON Response
     */
    @JsonSetter("action")
    private void setAction (String value) { 
        this.action = value;
        notifyObservers(this.action);
    }
 
}
 