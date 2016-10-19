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
 * <p>This Data model is the inner data model used in {@link com.soleo.lsapi.models.SelectedWithDInfo}
 * This data model is constructed after the Selected With Details call is made to the server.  Which
 * is the second (2nd) call in the monetization call flow.</p>
 * <p>Information on the Monetization Call Flow can be found <a href="TODO">Soleo Communications</a></p>
 * @author Scott Baron at Soleo Communications
 * @version 1.1
 * @since Soleo Local Search SDK ver. 1.0
 */
public class BusinessDetails 
        extends BaseModel
        implements java.io.Serializable {
    private static final long serialVersionUID = 4706489202014556881L;
    private List<String> descriptors;
    private String displayHours;
    private String hours;
    private String isOpen;
    private String timeZone;
    /**
     * <p>A list of descriptive text elements about the business. In the form of a String</p>
     * <strong>This can contain various thing that we know about the business.</strong>
     * @since 1.0
     * @return A list of descriptors in the form of a text String<br/>
     *          <strong>Note: Minimally you should get back the exact category that the business is listed under.
     *          Also note that the exact category may be more specific than you asked for.</strong>
     *          <blockquote><i>TODO</i></blockquote>
     */
    @JsonGetter("descriptors")
    public List<String> getDescriptors ( ) { 
        return this.descriptors;
    }
    
    /** SETTER
     * It's a setter hid it*****
     * A list of descriptive text elements about the bsuiness.
     */
    @JsonSetter("descriptors")
    private void setDescriptors (List<String> value) { 
        this.descriptors = value;
        notifyObservers(this.descriptors);
    }
 
    /**
     * <p>The business's open hours in a format that is closer to how a user would expect them to
     * be displayed.  Further parsing may be needed for your needs.</p>
     * <strong>This same information is returned in the form of a String Array in {@link BusinessElement}
     * Which is the element that is given to you after a search.</strong>
     * @since 1.0
     * @return The Normal open hours of a particular business
     *          <blockquote><i>"Sunday 09:00am-04:00pm, Monday 08:00am-09:00pm" - (if the business was only open 2 days)</i></blockquote>
     *          <strong>The hours will return null if the hours are not known</strong>
     */
    @JsonGetter("displayHours")
    public String getDisplayHours ( ) { 
        return this.displayHours;
    }
    
    /** SETTER
     * The business's open hours in a directly displayable format.
     */
    @JsonSetter("displayHours")
    private void setDisplayHours (String value) { 
        this.displayHours = value;
        notifyObservers(this.displayHours);
    }
 
    /**
     * <p>The business's open hours in a standard format that may make comparing dates and times
     * easier</p>
     * @since 1.0
     * @return A String of the hours in 24 hour format for times and abbreviated day names
     *      <blockquote><i>"Su 09:1600, Mo 08:00-21:00" - (if the business was only open 2 days)</i></blockquote>
     */
    @JsonGetter("hours")
    public String getHours ( ) { 
        return this.hours;
    }
    
    /** SETTER
     * The business's open hours in a standard format.
     */
    @JsonSetter("hours")
    private void setHours (String value) { 
        this.hours = value;
        notifyObservers(this.hours);
    }
 
    /**
     * <p>The will return a Sting that will contain one of three values:
     *      <ul>
     *          <li>"Yes"</li>
     *          <li>"No"</li>
     *          <li>"Unknown"</li>
     *      </ul>
     * </p>
     * <strong>Note: If you are looking for only open businesses in your search.  You will receive businesses
     * that return "Yes" or "Unknown" - To learn more about Search Params please visit
     * <a href=""><u>Soleo Communications</u></a></strong>
     */
    @JsonGetter("isOpen")
    public String getIsOpen ( ) { 
        return this.isOpen;
    }
    
    /** SETTER
     * "Yes" means the business is currently known to be open.
     */
    @JsonSetter("isOpen")
    private void setIsOpen (String value) { 
        this.isOpen = value;
        notifyObservers(this.isOpen);
    }
 
    /**
     * <p>The time zone for the open hours/business. In the form of a String.</p>
     * @since 1.0
     * @return String containing the Time Zone.
     *      <blockquote><i>"GMT-5"</i></blockquote>
     */
    @JsonGetter("timeZone")
    public String getTimeZone ( ) { 
        return this.timeZone;
    }
    
    /** SETTER
     * The time zone for the open hours.
     */
    @JsonSetter("timeZone")
    private void setTimeZone (String value) { 
        this.timeZone = value;
        notifyObservers(this.timeZone);
    }
 
}
 