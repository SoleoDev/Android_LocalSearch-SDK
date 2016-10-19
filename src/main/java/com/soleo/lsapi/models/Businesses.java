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
 * <p>This is that data model that is used to create each business that comes back from preforming
 * a search.  This model contains the basic information about a business.  This is the first data
 * model that is formed when starting the monetization sequence.</p>
 * <strong>Note: It is recommended to get the information from the BusinessElement Class</strong>
 * @version 1.0
 * @since Soleo Local Search SDK Ver. 1.0
 * @author Scott Baron at Soleo Communications
 */
public class Businesses 
        extends BaseModel
        implements java.io.Serializable {
    private static final long serialVersionUID = 5245843737367879928L;
    private List<Links> links;
    private String address;
    private String city;
    private CostCritera costCritera;
    private Distance distance;
    private Double latitude;
    private Double longitude;
    private MonetizationCritera monetizationCritera;
    private String name;
    private String state;
    private String type;
    private String zip;
    private String category;
    /**
     * <p>Use this method to get the List of Link elements that are used to advance through the
     * monetization sequence.</p>
     * <strong>Note: The method <i>presentedBusiness(OnTaskComplete task)</i> in {@link BusinessElement}
     * preforms this step of the monetization.</strong>
     * @since 1.0
     * @return An array List of the {@link com.soleo.lsapi.models.Links} Data Model
     */
    @JsonGetter("_links")
    public List<Links> getLinks ( ) { 
        return this.links;
    }
    
    /** SETTER
     * This is an internal use method.  If the developer ends up programming to this method...Godspeed
     * The _links section for each business is used to provide a callback URL to begin the monetization sequence.
     * @since 1.0
     */
    @JsonSetter("_links")
    private void setLinks (List<Links> value) { 
        this.links = value;
        notifyObservers(this.links);
    }
 
    /**
     * <p>Use this to get the address of the business in form of a string.  The same method with
     * same return is located in the {@link BusinessElement}.</p>
     * @since 1.0
     * @return The address of the business in the form of a String<br/>
     *          <blockquote><i>"123 Street Rd"</i></blockquote>
     *
     */
    @JsonGetter("address")
    public String getAddress ( ) { 
        return this.address;
    }
    
    /** SETTER
     * This should be hidden from the developer.  If it's not fix it. :<|
     * the location of the business expressed as a street address.
     * @since 1.0
     */
    @JsonSetter("address")
    private void setAddress (String value) { 
        this.address = value;
        notifyObservers(this.address);
    }
 
    /**
     * <p>The city in which the business is located.  Returns in the form of a String</p>
     * @since 1.0
     * @return A String that is the city in which the Business is located in<br/>
     *          <blockquote><i>"Rochester"</i></blockquote>
     */
    @JsonGetter("city")
    public String getCity ( ) { 
        return this.city;
    }
    
    /** SETTER
     * Again a Setter should not be visibility accessible to a programmer. So Fix it if it is (=<|
     * the city in which the business is located. 
     */
    @JsonSetter("city")
    private void setCity (String value) { 
        this.city = value;
        notifyObservers(this.city);
    }
 
    /**
     * <p>costCriteria specifies any costs associated with specific actions for this business.
     * Please contact <a href="mailto:localsearchapisupport@soleo.com"><u>localsearchapisupport@soleo.com</u></a> for adjustments requests.</p>
     * <strong>Note: Most developers will need to do nothing with this data model</strong>
     * @since 1.0
     * @return a {@link com.soleo.lsapi.models.CostCritera} data model
     */
    @JsonGetter("costCritera")
    public CostCritera getCostCritera ( ) { 
        return this.costCritera;
    }
    
    /** SETTER
     * You've made it down this far.  You should know the deal with Setters By now (=[|
     * costCriteria specifies any costs associated with specific actions for this business. 
     */
    @JsonSetter("costCritera")
    private void setCostCritera (CostCritera value) { 
        this.costCritera = value;
        notifyObservers(this.costCritera);
    }
 
    /**
     * <p>The distance in miles from the search location to the business.</p>
     * @since 1.0
     * @return a {@link com.soleo.lsapi.models.Distance} data model containing that information
     */
    @JsonGetter("distance")
    public Distance getDistance ( ) { 
        return this.distance;
    }
    
    /** SETTER
     * Will anyone find this things? as long as it's not in terms of visibility when programming
     * it's Okay (=<P
     * The distance in miles from the search location to the business.
     */
    @JsonSetter("distance")
    private void setDistance (Distance value) { 
        this.distance = value;
        notifyObservers(this.distance);
    }
 
    /**
     * <p>The vertical component of the geocode location of a business.
     * latitude is specified in decimal degrees with values between -90.0 and 90.0,
     * with no more than 6 decimal places. </p>
     * @since 1.0
     * @return The latitude of the business in the form of a double<br/>
     *          <blockquote><i>41.878026</i></blockquote>
     */
    @JsonGetter("latitude")
    public Double getLatitude ( ) { 
        return this.latitude;
    }
    
    /** SETTER
     * I'm just going to make this Face (=<| but I'll Also do this (=<)
     * the vertical component of the geocode location of a business.  latitude is specified in decimal degrees with values between -90.0 and 90.0, with no more than 6 decimal places. 
     */
    @JsonSetter("latitude")
    private void setLatitude (Double value) { 
        this.latitude = value;
        notifyObservers(this.latitude);
    }
 
    /**
     * <p>The horizontal component of the geocode location of a business.  L
     * Longitude is specified in decimal degrees with values between - 180.0 and 0,
     * with no more than 6 decimal places.</p>
     * @since 1.0
     * @return The Longitude in the form of a double
     *          <blockquote><i>-87.641549</i></blockquote>
     */
    @JsonGetter("longitude")
    public Double getLongitude ( ) { 
        return this.longitude;
    }
    
    /** SETTER
     * It should be a private setter....k.... |=<|
     * the horizontal component of the geocode location of a business.  longitude is specified in decimal degrees with values between - 180.0 and 0, with no more than 6 decimal places. 
     */
    @JsonSetter("longitude")
    private void setLongitude (Double value) { 
        this.longitude = value;
        notifyObservers(this.longitude);
    }
 
    /**
     * <p>MonetizationCriteria specifies the revenue generation opportunity for a business along with what is needed to generate that revenue.
     * This can be used to monitor potential income for the developer.  This is commonly not something displayed to the user.</p>
     * <strong>Note: For more information on Monetization. Visit <a href="https://developer.soleo.com/docs/callback_sequence_for_monetization">
     *     <u>Soleo Communications</u></a>
     * </strong>
     * @since 1.0
     * @return A {@link com.soleo.lsapi.models.MonetizationCritera} data model.
     */
    @JsonGetter("monetizationCritera")
    public MonetizationCritera getMonetizationCritera ( ) { 
        return this.monetizationCritera;
    }
    
    /** SETTER
     * This is used by the Type face to create the data model. DON"T SHOW IT TO THE DEVELOPER ... [=<|
     * monetizationCriteria specifies the revenue generation opportunity for a business along with what is needed to generate that revenue. 
     */
    @JsonSetter("monetizationCritera")
    private void setMonetizationCritera (MonetizationCritera value) { 
        this.monetizationCritera = value;
        notifyObservers(this.monetizationCritera);
    }
 
    /**
     * <p>The name of the business. In the form of a String</p>
     * @since 1.0
     * @return A String of the Business name
     *          <blockquote><i>"John's Doe Stuff"</i></blockquote>
     */
    @JsonGetter("name")
    public String getName ( ) { 
        return this.name;
    }
    
    /** SETTER
     * Internal Method that is used by the TypeFace to create the Data model from JSON. Should stay
     * hidden from the developer [=-<|
     * the name of the business. 
     */
    @JsonSetter("name")
    private void setName (String value) { 
        this.name = value;
        notifyObservers(this.name);
    }
 
    /**
     * <p>The state in which the business is located in. In the form of a String</p>
     * @since 1.0
     * @return a String containing the State in abbreviated form.
     *      <blockquote><i>"NY"</i></blockquote>
     */
    @JsonGetter("state")
    public String getState ( ) { 
        return this.state;
    }
    
    /** SETTER
     * I really hate writing setter comments because the basic Idea is generated.  And the developer
     * should not see this method....any of the setters. [8-<|   (The face game is getting stronger)
     * the state in which the business is located. 
     */
    @JsonSetter("state")
    private void setState (String value) { 
        this.state = value;
        notifyObservers(this.state);
    }
 
    /**
     *  <p>Type specifies that the business is one of the following:
     *      <ul>
     *          <li>"Organic": An organic business</li>
     *          <li>"Sponsored": A sponsored business</li>
     *      </ul>
     *      Learn more about Sponsored and Organic Business at <a href="https://developer.soleo.com/docs/about_businesses"><u>Soleo Communications</u></a>
     *  </p>
     *  <strong>Note: This is information that the developer cares about and may change
     *  the way you display information to the user.  But the User doesn't/shouldn't care</strong>
     *  @since 1.0
     *  @return String of the type of monetization the business is.
     *          <blockquote><i>"Sponsored"</i></blockquote>
     */
    @JsonGetter("type")
    public String getType ( ) { 
        return this.type;
    }
    
    /** SETTER
     * This is used by the Type face to construct Businesses from the JSON.  Developer shouldn't see or use this method
     *  type specifies that the business is one of the following:      "Organic": An organic business     "Sponsored": A sponsored business
     */
    @JsonSetter("type")
    private void setType (String value) { 
        this.type = value;
        notifyObservers(this.type);
    }
 
    /**
     * <p>The postal code (Zip Code) in which the business is located.</p>
     * <p>Postal codes are expressed as either 5 (ex. 14618) or 9 digits (ex. 146185513 or 14618-5513).
     * Postal codes with 9 digits may contain a delimiter (usually a hyphen) between the 5th and 6th digits (ex. 14618-5513).</p>
     * @since 1.0
     * @return A String of the Businesses Postal Code (Zip Code)
     *          <blockquote><i>"12345"</i></blockquote>
     */
    @JsonGetter("zip")
    public String getZip ( ) { 
        return this.zip;
    }
    
    /** SETTER
     * Used to construct the element from JSON. Do Not Let the Developer see.
     * the postal code in which the business is located.  Postal codes are expressed as either 5 (ex. 14618) or 9 digits (ex. 146185513 or 14618-5513).  Postal codes with 9 digits may contain a delimiter (usually a hyphen) between the 5th and 6th digits (ex. 14618-5513). 
     */
    @JsonSetter("zip")
    private void setZip (String value) { 
        this.zip = value;
        notifyObservers(this.zip);
    }

    /**
     * <p>The Category for the business.</p>
     * <p>Category for the Business as translated by the system to human readable field</p>
     * @since 1.3
     * @return A String of the Businesses Postal Code (Zip Code)
     *          <blockquote><i>"12345"</i></blockquote>
     */
    @JsonGetter("categoryName")
    public String getCategory ( ) {
        return this.category;
    }

    /** SETTER
     * Used to construct the element from JSON. Do Not Let the Developer see.
     * Category for the Business as translated by the system to human readable field.
     */
    @JsonSetter("categoryName")
    private void setCategory (String value) {
        this.category = value;
        notifyObservers(this.category);
    }
 
}
 