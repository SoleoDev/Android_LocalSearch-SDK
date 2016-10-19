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
 * <p>This is the data model for level two (2) of the categories.  The category information that is
 * contained in this data model is more specific from it's parent, {@link com.soleo.lsapi.models.Child}.</p>
 * <strong>Note: This is the lowest the category tree will go.</strong>
 * @since Soleo Local Search SDK ver. 1.0
 * @version 1.1
 * @author Scott Baron at Soleo Communications
 */
public class Child2 
        extends BaseModel
        implements java.io.Serializable {
    private static final long serialVersionUID = 4733265404848446044L;
    private List<String> children;
    private String id;
    private String text;
    /**
     * <p>Similar method to {@link com.soleo.lsapi.models.Child} and {@link com.soleo.lsapi.models.Categories}
     * however the SDK can not go behind level two (2).</p>
     * <strong>Note: Should always be an empty array</strong>
     * @since 1.0
     * @return a Null String
     */
    @JsonGetter("children")
    public List<String> getChildren ( ) { 
        return this.children;
    }
    
    /** SETTER
     * Should always be null
     */
    @JsonSetter("children")
    private void setChildren (List<String> value) { 
        this.children = value;
        notifyObservers(this.children);
    }
 
    /**
     * <p>ID of the current sub-category.</p>
     * <p>The current sub-category ID in the form of a String.</p>
     * @since 1.0
     * @return A string value that contains the sub-category ID
     *      <blockquote><i>"cat_1.54"</i></blockquote>
     */
    @JsonGetter("id")
    public String getId ( ) { 
        return this.id;
    }
    
    /** SETTER
     * Id of the current category,
     */
    @JsonSetter("id")
    private void setId (String value) { 
        this.id = value;
        notifyObservers(this.id);
    }
 
    /**
     * <p>Description of the category</p>
     * <p>This can also be referred to as the category name.</p>
     * @since 1.0
     * @return The name of the Category in the form of a String
     *      <blockquote><i>"Concert Halls & Theaters"</i></blockquote>
     */
    @JsonGetter("text")
    public String getText ( ) { 
        return this.text;
    }
    
    /** SETTER
     * Description of the category,
     */
    @JsonSetter("text")
    private void setText (String value) { 
        this.text = value;
        notifyObservers(this.text);
    }
 
}
 