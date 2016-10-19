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
 * <p>This data model is created as the level one (1) of the different categories.</p>
 * <p>Each category in level one (1) has a corresponding Child Data model. This data model can
 * be used to send a direct category name into a search.</p>
 * @since Soleo Communications SDK ver. 1.0
 * @version 1.0
 * @author Scott Baron at Soleo Communications
 */
public class Child 
        extends BaseModel
        implements java.io.Serializable {
    private static final long serialVersionUID = 5084703679389504718L;
    private List<Child2> children;
    private String id;
    private String text;
    /**
     * <p>A list of  child categories of the current category.</p>
     * <p>This would be the second (2nd) level of categories.  This is a list of categories that
     * are more specific to the current category.</p>
     * @since 1.0
     * @return a list of type {@link com.soleo.lsapi.models.Child2}
     */
    @JsonGetter("children")
    public List<Child2> getChildren ( ) { 
        return this.children;
    }
    
    /** SETTER
     * a list of  chlid categories of the current category
     */
    @JsonSetter("children")
    private void setChildren (List<Child2> value) { 
        this.children = value;
        notifyObservers(this.children);
    }
 
    /**
     * <p>The internal ID for the category. This is the category specific ID for the category</p>
     * @since 1.0
     * @return A String that is the category ID
     *      <blockquote><i>"cat_1"</i></blockquote>
     */
    @JsonGetter("id")
    public String getId ( ) { 
        return this.id;
    }
    
    /** SETTER
     * The internal ID for the category.
     */
    @JsonSetter("id")
    private void setId (String value) { 
        this.id = value;
        notifyObservers(this.id);
    }
 
    /**
     * <p>A text description of the category. This is the name of the category</p>
     * @since 1.0
     * @return A String of the name of the category
     *          <blockquote><i>"Arts & Entertainment"</i></blockquote>
     */
    @JsonGetter("text")
    public String getText ( ) { 
        return this.text;
    }
    
    /** SETTER
     * a text description of the category
     */
    @JsonSetter("text")
    private void setText (String value) { 
        this.text = value;
        notifyObservers(this.text);
    }
 
}
 