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
 * <p>This is the data model that is formed from the root of the category tree that returns from
 * the server.  This data model wraps the {@link com.soleo.lsapi.models.Child} in a list.
 * {@link com.soleo.lsapi.models.Child2} is wrapped in Child.  This data model is not a category
 * itself.</p>
 * <blockquote><i>{@link com.soleo.lsapi.models.Categories} -> {@link com.soleo.lsapi.models.Child}
 * -> {@link com.soleo.lsapi.models.Child2}</i></blockquote>
 * @since Soleo Local Search SDK ver. 1.0
 * @version 1.0
 * @author Scott Baron at Soleo Communications
 */
public class Categories 
        extends BaseModel
        implements java.io.Serializable {
    private static final long serialVersionUID = 5439732337333383891L;
    private List<Child> children;
    private String id;
    private String text;
    /**
     * <p>List of child categories of the current category.</p>
     * <p>This returns all of the level one (1) categories.  Learn more about categories and the
     * different levels at <a href="https://developer.soleo.com/docs/About_Categories"><u>Soleo Communications</u></a></p>
     * @since 1.0
     * @return List of type {@link com.soleo.lsapi.models.Child}
     */
    @JsonGetter("children")
    public List<Child> getChildren ( ) { 
        return this.children;
    }
    
    /** SETTER
     * List of child categories of the current category
     * Be sure to hide this from the developer
     */
    @JsonSetter("children")
    private void setChildren (List<Child> value) { 
        this.children = value;
        notifyObservers(this.children);
    }
 
    /**
     * <p>The internal ID for the root category.  This is a constant and will always return the
     * same String for the root category.</p>
     * @since 1.0
     * @return A String that is the ID that is for the root category
     *          <blockquote><i>"cat_#"</i></blockquote>
     */
    @JsonGetter("id")
    public String getId ( ) { 
        return this.id;
    }
    
    /** SETTER
     * The internal ID for the category
     */
    @JsonSetter("id")
    private void setId (String value) { 
        this.id = value;
        notifyObservers(this.id);
    }
 
    /**
     * <p>This is the name of the category it's self.  In this case because this is the root category
     * it will return the name root</p>
     * @since 1.0
     * @return String containing the name of the Category.  In this case it will be a constant.
     *      <blockquote><i>"Root"</i></blockquote>
     */
    @JsonGetter("text")
    public String getText ( ) { 
        return this.text;
    }
    
    /** SETTER
     * Text description of the category
     */
    @JsonSetter("text")
    private void setText (String value) { 
        this.text = value;
        notifyObservers(this.text);
    }
 
}
 