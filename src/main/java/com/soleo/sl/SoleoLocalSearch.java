package com.soleo.sl;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.soleo.lsapi.Configuration;
import com.soleo.lsapi.controllers.BusinessListingsController;
import com.soleo.lsapi.controllers.CategoryInformationController;
import com.soleo.lsapi.http.client.APICallBack;
import com.soleo.lsapi.http.client.HttpContext;
import com.soleo.lsapi.models.Response;
import com.soleo.lsapi.models.Summary;
import com.soleo.lsapi.models.Businesses;
import com.soleo.lsapi.models.Categories;
import com.soleo.sl.element.BusinessElement;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.Executors;

/*
 * Creation Date 3/6/2016
 */
/**
 * <p>Use this class to initialize the SDK with a Context and API Key.  This class is used
 * to get the categories, add search criteria, and preform a search for businesses based on the set
 * search criteria</p>
 * <strong>Note: Be sure to have a Meta Data tag in the Manifest</strong>
 * <blockquote><i>meta-data android:name="apikey" android:value="***Your Tag Here***"</i></blockquote>
 * <p>For and API Key Please <a href="https://developer.soleo.com/member/register">visit here</a></p>
 * @version 1.2
 * @since SoleoLocalSearch SDK Ver - 1.0
 * @author Scott Baron at SoleoCommunications
 */
public class SoleoLocalSearch
{
    private String category;
    private String city;
    private String iPAddress;
    private String keyword;
    private String freeformquery;
    private String latitude;
    private String longitude;
    private String name;
    private String openOnly;
    private String postalCode;
    private String radius;
    private String referenceId;
    private String sort;
    private String sourceId;
    private String state;
    private String type;
    private String userAgent;
    private String maxSponsoredCount;
    private String maxOrganicsCounts;

    private BusinessListingsController businessListingsController;
    private CategoryInformationController categoryInformationController;
    private ArrayList<Businesses> rawBusinessResults;
    private ArrayList<BusinessElement> searchResults;
    private SearchKeys sKeys;
    private Summary searchSummary;

    /**
     * <p>This is the initializer of the SDK.</p>
     * <strong>Note: Include your API Key in your Android Manifest in a Meta Data Tag</strong>
     * <blockquote><i>meta-data android:name="apikey" android:value="**YOUR KEY HERE***"</i></blockquote>
     * @since v. 1.0
     * @param appContext the context of the application
     */
    public SoleoLocalSearch(Context appContext)
    {
        Configuration.initialize(appContext);
        this.categoryInformationController = new CategoryInformationController();
        this.businessListingsController = new BusinessListingsController();
    }

    /**
     * <p>This Method will add One search constraint to your search results.
     * For valid keys see full Documentation for a list of eligible keys</p>
     * @since v. 1.0
     * @param key Must be a valid search key. Casing of the key doesn't matter but it must be spelled correctly
     *            <blockquote><i>SearchKeys.category</i></blockquote>
     * @param value to set the search constraint too
     *            <blockquote><i>"food"</i></blockquote>
     * @return boolean returns True or false based on if the criteria was successfully added
     * @throws IllegalArgumentException if the key isn't a valid search key
     */
    public boolean addSearchCriteria(SearchKeys key, String value)
    {
        switch(key)
        {
            case category:
                this.category = setOrClear(value);
                return true;
            case city:
                this.city = value;
                return true;
            case ipaddress:
                this.iPAddress = value;
                return true;
            case keyword:
                this.keyword = setOrClear(value);
                return true;
            case freeformquery:
                this.freeformquery = setOrClear(value);
                return true;
            case latitude:
                this.latitude = value;
                return true;
            case longitude:
                this.longitude = value;
                return true;
            case name:
                this.name = value;
                return true;
            case openonly:
                this.openOnly = value;
                return true;
            case postalcode:
                this.postalCode = value;
                return true;
            case radius:
                this.radius = value;
                return true;
            case referenceid:
                this.referenceId = value;
                return true;
            case sort:
                this.sort = value;
                return true;
            case sourceid:
                this.sourceId = value;
                return true;
            case state:
                this.state = value;
                return true;
            case type:
                this.type = value;
                return true;
            case useragent:
                this.userAgent = value;
                return true;
            case maxSponsoredCount:
                this.maxSponsoredCount = value;
                return true;
            case maxOrganicsCount:
                this.maxOrganicsCounts = value;
                return true;

            default:
                throw new IllegalArgumentException("The Search Key you entered: " + key + " is not a valid Key");
        }
    }

    /*
     * This Overload is here so the developer has a little more freedom in the data types they enter
     * The integer is converted to a string and then we call the method from above to add the search
     * constraints
     */
    /**
     * <p>This overload allows for an integer amount as a search value.  It is converted into
     * a form that the SDK can use, so you can avoid that dirty work.</p>
     * @since v. 1.0
     * @param key Must be a valid search key. Casing of the key doesn't matter but it must be spelled correctly
     *            <blockquote><i>SearchKeys.postalcode</i></blockquote>
     * @param value - value to set the search constraint too
     *            <blockquote><i>12345</i></blockquote>
     * @return True or false based on if the criteria was successfully added
     * @throws IllegalArgumentException If the Key is not a valid key
     */
    public boolean addSearchCriteria(SearchKeys key, int value)
    {
        String newValue = Integer.toString(value);
        return addSearchCriteria(key, newValue);
    }

    /**
     * <p>This allows for multiple search entries to be added at once but the keys to the maps must still match
     * proper search keys.  The type of map is open for the choice of the developer</p>
     * @since v. 1.0
     * @param data A map with keys that match exact search keys. The map must have keys of type String
     * and values of type integer or type String.  It will accept type Object for a hybrid of integer and String
     * but there is a check performed to insure each entry is of integer or string.
     *             <blockquote><i>
     *                  <ul>
     *                      <li>SearchKeys.category: "food"</li>
     *                      <li>SearchKeys.postalcode: 12345</li>
     *                  </ul>
     *             </i></blockquote>
     * @return True if the map finished iteration successfully, however. it doesn't mean all terms were added
     * successfully
     * @throws IllegalArgumentException If the Key is not a valid
     */
    public boolean addSearchCriteria(Map<SearchKeys, Object> data)
    {
        for(SearchKeys str: data.keySet())
        {
            if(data.get(str) instanceof String)
            {
                addSearchCriteria(str, (String)data.get(str));
            }
            else if(data.get(str) instanceof Integer)
            {
                addSearchCriteria(str, (Integer)data.get(str));
            }
            else
                System.out.println(data.get(str).getClass() + " is not a valid Data Type. Paired with key: " +
                        str);
        }
        return true;
    }

    /**
     * <p>This method is used to remove search Criteria before a search.  It can be used before
     * another search is done also</p>
     * @since 1.1
     * @param key The key you need you like to remove from the search
     *            <blockquote><i>{@link com.soleo.sl.SearchKeys}.category</i></blockquote>
     * @return If the term was found and removed it will return a true otherwise false
     * @throws IllegalArgumentException If a invalid search key was passed into the method
     */
    public boolean removeSearchCriteria(SearchKeys key)
    {
        switch(key)
        {
            case category:
                this.category = null;
                return true;
            case city:
                this.city = null;
                return true;
            case ipaddress:
                this.iPAddress = null;
                return true;
            case keyword:
                this.keyword = null;
                return true;
            case freeformquery:
                this.freeformquery = null;
                return true;
            case latitude:
                this.latitude = null;
                return true;
            case longitude:
                this.longitude = null;
                return true;
            case name:
                this.name = null;
                return true;
            case openonly:
                this.openOnly = null;
                return true;
            case postalcode:
                this.postalCode = null;
                return true;
            case radius:
                this.radius = null;
                return true;
            case referenceid:
                this.referenceId = null;
                return true;
            case sort:
                this.sort = null;
                return true;
            case sourceid:
                this.sourceId = null;
                return true;
            case state:
                this.state = null;
                return true;
            case type:
                this.type = null;
                return true;
            case useragent:
                this.userAgent = null;
                return true;
            case maxSponsoredCount:
                this.maxSponsoredCount = null;
                return true;
            case maxOrganicsCount:
                this.maxOrganicsCounts = null;
                return true;
            default:
                throw new IllegalArgumentException("The Search Key you entered: " + key + " is not a valid Key");
        }
    }


    /**
     * <p>Use this method when all the search params have been loaded using the add search criteria
     * methods.</p>
     * @since v. 1.0
     * @param ANI The phone number of the device using the application in the form of a String
     *            <blockquote><i>"1234567890"</i></blockquote>
     * @param task The task that needs to be preformed after the search
     */
    public void requestBusinessSearch(String ANI, OnServiceComplete<ArrayList<BusinessElement>> task)
    {
        final OnServiceComplete<ArrayList<BusinessElement>> job = task;
//Use a ternary expression????
        this.businessListingsController.getBusinessesAsync(null, null, ANI, this.category,
                this.city, this.iPAddress, this.keyword, this.freeformquery,this.latitude, this.longitude,
                this.name, this.openOnly, this.postalCode, this.radius, this.referenceId, this.sort,
                this.sourceId, this.state, this.type, this.userAgent, this.maxSponsoredCount,this.maxOrganicsCounts,
                new APICallBack<Response>()
                {
                    @Override
                    public void onSuccess(HttpContext context, Response response, String query)
                    {
                        createBusinessResponse(response, job);
                        searchSummary.setLink(query);
                    }

                    @Override
                    public void onFailure(HttpContext context, Throwable error)
                    {
                        if (context.getRespone() != null) {
                            Log.e("Getting the List", "Problem doing Presented call");
                            job.onFail(context.getRespone().getStatusCode());
                        } else {
                            Log.e("Getting the List", "Internal: Object Failed to deserialize from the server");
                            job.onFail(1010);
                        }
                    }
                });
    }

    /**
     * <p>This will give you a data structure that holds the results of the search, make sure to launch
     * a search and that search comes back with results before accessing this variable.</p>
     * @since v. 1.0
     * @return The {@link com.soleo.lsapi.models.Summary} data Model
     */
    public Summary getSearchSummary()
    {
        return this.searchSummary;
    }

    private void createBusinessResponse(Response results, OnServiceComplete<ArrayList<BusinessElement>> job)
    {
        this.rawBusinessResults = (ArrayList<Businesses>)results.getBusinesses();
        this.searchSummary = results.getSummary();
//        this.searchSummary.setLink(rawBusinessResults.get(0).getLinks().get(0).getHref());
        this.searchResults = new ArrayList<BusinessElement>();
        for(Businesses bus: this.rawBusinessResults)
        {
            BusinessElement newEle = new BusinessElement(bus, this.businessListingsController);
            this.searchResults.add(newEle);
        }
        job.onServiceFinish(this.searchResults);
    }

    /**
     * <p>Use this method to get a list of valid categories from the API Endpoint</p>
     * @since v. 1.0
     * @param task The task after the data comes back from the server.
     */
    public void getCategoriesRequest(OnServiceComplete<Categories> task)
    {
        final OnServiceComplete<Categories> job = task;
        this.categoryInformationController.getCategoryAsync(null, "1",
                new APICallBack<Categories>() {
                    @Override
                    public void onSuccess(HttpContext context, Categories response, String query) {
                        job.onServiceFinish(response);
                    }

                    @Override
                    public void onFailure(HttpContext context, Throwable error) {
                        Log.e("Category Service", "Failed to retrieve the data");
                        job.onFail(400);
                    }
                });
    }

    /**
     * <p>This Method will return a list of categories with the depth of the list defined by the
     * application that called it.</p>
     * <strong>Note: As of the current release the category depth must be a one (1) or a two(2).</strong>
     * @since 1.1
     * @param catLevel The Level of the category tree you would like to return in the call back
     * @param task What to do with the category tree after it returns.
     */
    public void getCategoriesRequest(int catLevel, OnServiceComplete<Categories> task)
    {
        final OnServiceComplete<Categories> job =task;
        String level = Integer.toString(catLevel);
        this.categoryInformationController.getCategoryAsync(null, level,
                new APICallBack<Categories>() {
                    @Override
                    public void onSuccess(HttpContext context, Categories response, String query) {
                        job.onServiceFinish(response);
                    }

                    @Override
                    public void onFailure(HttpContext context, Throwable error) {
                        Log.e("Category Request", "Failed to retrieve Data");
                        job.onFail(400);
                    }
                });
    }

    /**
     * <p>This is used to get all the categories from the business that returned from a search</p>
     * @since 1.2
     * @param inputList the list of business elements that returned from a search
     * @param task what you would like to do with the information once completed
     */
    public void getCategoriesFromList(final ArrayList<BusinessElement> inputList, final OnServiceComplete<ArrayList<String>> task)
    {

        Runnable responseTask = new Runnable() {
            public void run()
            {
                ArrayList<String> tempList = new ArrayList<>();
                try {
                    for ( BusinessElement test : inputList) {
                        if (!tempList.contains(test.getBusinessCategory())) {
                            tempList.add(test.getBusinessCategory());
                        }
                    }
                    task.onServiceFinish(tempList);
                }
                catch (Exception ex)
                {
                    Log.e("CategoriesFromList", "Error parsing " + ex.getMessage() );
                    ex.printStackTrace();
                    task.onFail(1010);
                }

            }
        };

        Executors.newCachedThreadPool().execute(responseTask);

    }


//*********************************************************************************************************
//**************** This is the Start of the Supporting Methods ********************************************
//*********************************************************************************************************
    public interface OnServiceComplete<T>{
        /**
         * <p>This is the method that is called when the response comes back successfully</p>
         * <ul>
         *     <li>ArrayList of {@link BusinessElement}</li>
         *     <li>{@link com.soleo.lsapi.models.Categories}</li>
         * </ul>
         * @since v. 1.0
         * @param task The job that will be preformed with the received data
         */
        void onServiceFinish(T task);

        /**
         * <p>What happens if the request fails.</p>
         * @since v. 1.0
         * @param statusCode code received from the server of type int
         *                   <blockquote><i>400</i></blockquote>
         */
        void onFail(int statusCode);
    }

    private String setOrClear(String value) {
        return (TextUtils.isEmpty(value) ? null : value);
    }
    
    
}
