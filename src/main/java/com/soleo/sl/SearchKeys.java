package com.soleo.sl;

/**
 * Search Keys should be used when adding search terms to a Business Listing Search
 * They are used so you don't have to worry about spelling or formatting.<hr/>
 * @version 2.0
 * @since SoleoLocalSearch SDK Ver - 1.0
 * @author Scott Baron at SoleoCommunication
 */
/*
 *  Created by sbaron on 3/2/2016.
 */
public enum SearchKeys
{
    /**
     * <p>The name of the business that you are looking for</p>
     * <strong>Note: If Name and Keyword search parameters are both provided, Keyword is ignored.</strong>
     * @since ver. 1.0
     */
    name,
    /**
     * @deprecated Made Out-dated during development of the SDK
     * <p>The address of the business you are looking for</p>
     */
    address,
    /**
     * <p>This will confine your results to a city</p>
     * <strong>Note: If City is used as a search parameter, you must also provide State to form a complete City/State pair.</strong>
     * @since ver. 1.0
     */
    city,
    /**
     * <p>The two-letter abbreviation of the state to use as a search point</p>
     * <strong>Note: If State is used as a search parameter, you must also provide City to form a complete City/State pair.</strong>
     * @since ver. 1.0
     */
    state,
    /**
     * <p>Confine your search to a postal code (zip code)</p>
     * <strong>
     *     <p>Valid Values:</p>
     *     <ul>
     *         <li>5-digit postal code</li>
     *         <li>9-digit postal code with dash (#####-####)</li>
     *         <li>9-digit with out dash (#########)</li>
     *     </ul>
     * </strong>
     * @since ver. 1.0
     */
    postalcode,
    /**
     * <p>The latitude of the search point for the circular fence</p>
     * <p>latitude has a maximum precision (numbers to the right of the decimal) of 7.
     * Latitude search parameters with precision greater than 7 will be truncated to 7.</p>
     * <strong>Note: If Longitude is used as a search parameter, you must also provide Latitude to form a complete geocode for the search point.</strong>
     * @since ver. 1.0
     */
    latitude,
    /**
     * <p>The longitude of the search point for the circular fence.</p>
     * <p>Longitude has a maximum precision (numbers to the right of the decimal) of 7.
     * Longitude search parameters with precision greater than 7 will be truncated to 7.</p>
     * <strong>Note: If Longitude is used as a search parameter, you must also provide Latitude to form a complete geocode for the search point.</strong>
     * @since ver. 1.0
     */
    longitude,
    /**
     * <p>This is the type of results you will get back</p>
     * <p>Valid Values are:</p>
     * <ul>
     *     <li>Sponsored</li>
     *     <li>Organic</li>
     * </ul>
     * <strong>Recommend: Leave as default unless your plan is set up for it</strong>
     * @since ver. 1.0
     */
    type,
    /**
     * <p>The category that defines (or relates to) the commercial offering of a business.</p>
     * <strong>Note: If Category and Keyword search parameters are both provided, Keyword is ignored.</strong>
     * @since ver. 1.0
     */
    category,
    /**
     * <p>The IP address of the end user.</p>
     * <strong>Note: Most application will not use this search term</strong>
     * @since ver. 1.0
     */
    ipaddress,
    /**
     * <p>A term to search against business names and categories.</p>
     * <strong>Note: If Category and Keyword search parameters are both provided, Keyword is ignored.</strong>
     * @since ver. 1.0
     */
    keyword,
    /**
     * <p>A term to search against business names and categories Using the Natural Language backend to analise the query</p>
     * <strong>Note: If Category, name and Keyword search parameters are either provided, All are ignored over freeformquery.</strong>
     * @since ver. 2.0
     */
    freeformquery,
    /**
     * <p>Will return results based on it's open status</p>
     * <strong>
     *     <p>Note: results will return business that are open or Not known to be closed</p>
     *     <p>Meaning that if we don't have information that indicates a business to be closed you will get that as a search results
     *     but the business may still be closed</p>
     * </strong>
     * @since ver. 1.0
     */
    openonly,
    /**
     * <p>Used to change the default when searching with Longitude and Latitude</p>
     * <p>The radius (in miles) which forms a circular fence around the search point.</p>
     * <strong>Note: If Radius is used as a search parameter, you must also provide Latitude and Longitude.</strong>
     * @since ver. 1.0
     */
    radius,
    /**
     * <p>A User Parameter that sends a unique identifier</p>
     * <strong>Note: This search would also require a business parameter, location parameter, and account parameter (APIKey) to execute successfully.</strong>
     * @since ver. 1.0
     */
    referenceid,
    /**
     * <p>Sorts the results that come back from a search request</p>
     * <p>Possible sort options</p>
     * <ul>
     *
     *     <li>distance</li>
     *     <li>value (sponsored or organic)</li>
     *     <li>value_distance (default)</li>
     * </ul>
     * <strong>Note: The default is the most commonly used sort method. If it works for your needs you don't need to explicitly add it to a search</strong>
     * @since ver. 1.0
     */
    sort,
    /**
     * <p>
     *     A unique string or identifier, provided by the developer, which represents the end user of the API request.
     * </p>
     * @since ver. 1.0
     */
    sourceid,
    /**
     * <p>Used in the header of the request</p>
     * <strong>Note: This is often given to you for free and in most cased doesn't need to be set</strong>
     * @since ver. 1.0
     */
    useragent,
    /**
     * <p>Field to indicate the Maximum number of sponsors desire.</p>
     * <strong>Note: Default is 3</strong>
     * @since ver. 2.0
     */
    maxSponsoredCount,
    /**
     * <p>Field to indicate the Maximum number of sponsors desire.</p>
     * <strong>Note: Default is 7</strong>
     * @since ver. 2.0
     */
    maxOrganicsCount,

}
