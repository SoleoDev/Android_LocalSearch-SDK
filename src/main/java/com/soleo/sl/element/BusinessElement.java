package com.soleo.sl.element;

import android.util.Log;

import com.soleo.lsapi.controllers.BusinessListingsController;
import com.soleo.lsapi.http.client.APICallBack;
import com.soleo.lsapi.http.client.HttpContext;
import com.soleo.lsapi.models.BusinessDetails;
import com.soleo.lsapi.models.Businesses;
import com.soleo.lsapi.models.CallBack;
import com.soleo.lsapi.models.CallCompletionCallback;
import com.soleo.lsapi.models.CallCompletionData;
import com.soleo.lsapi.models.Links;
import com.soleo.lsapi.models.PresentedData;
import com.soleo.lsapi.models.SelectedWithDInfo;
import com.soleo.lsapi.models.SelectedWithDetailsCall;

/**
 * <p>This class is where all data is held about a particular business that comes back from a search</p>
 * <p>Use this class to:</p>
 * <ul>
 *     <li>Make the calls to the server to progress the call flow</li>
 *     <li>Access Data about the business such as (name, location, hours, etc)</li>
 * </ul>
 * <p><strong>
 *     Update in 2.0: Instead of returning with an error code when making a call that has already
 *     been made, we return with the data that was already received when making the original call.
 * </strong></p>
 * @since SoleoLocalSearch SDK Ver - 1.0
 * @version 2.0
 * @author Scott Baron at SoleoCommunitcations
 */
public class BusinessElement
{
    //The Basic Needs for the functionality
    private BusinessListingsController controller;
    private Businesses business;

    //This is the list of models that are used by the controller
    private CallBack presentedCallBack;
    private PresentedData presentedData;
    private SelectedWithDetailsCall selectedWithDetailsCall;
    private SelectedWithDInfo selectedWithDInfo;
    private BusinessDetails businessDetails;
    private CallCompletionCallback callCompletionCallback;
    private CallCompletionData callCompletionData;

    //This is the Specific Data of an individual business
    private String businessName;
    private String businessAddress;
    private String businessCity;
    private String businessState;
    private String businessPostalCode;
    private Double businessLatitude;
    private Double businessLongitude;
    private Double businessDistance;
    private String businessType;
    private String isBusinessOpen;
    private String businessHours;
    private String[] businessDisplayHours;
    private String businessTimezone;
    private String businessPhoneNumber;
    private String monetizationPhoneNumber;
    private String businessCategory;

    //These are supporting resources
    private String jsessionID;
    private String trackingNum;
    //This Flag is used for staging check (instead of have a flag at every level)
    private int stagingFlag;

    /**
     * 9/22/16 - Can't be moved out of this package, it will be used to house future element
     * @param passedBis the business response that comes back when doing a search
     * @param controller the business listing controller so we can make calls with out a problem
     */
    public BusinessElement(Businesses passedBis, BusinessListingsController controller)
    {
        this.controller = controller;
        this.business = passedBis;
        this.stagingFlag = 0;

        //Setting the data that can be pulled from this stage of the callbacks
        this.businessName = this.business.getName();
        this.businessAddress = this.business.getAddress();
        this.businessCity = this.business.getCity();
        this.businessState = this.business.getState();
        this.businessPostalCode = this.business.getZip();
        this.businessLatitude = this.business.getLatitude();
        this.businessLongitude = this.business.getLongitude();
        this.businessType = this.business.getType();
        if (this.business.getDistance() != null)
        {
            this.businessDistance = this.business.getDistance().getMiles();
        }
        else
        {
            this.businessDistance = 0.0;
        }

        this.isBusinessOpen = null;
        this.businessHours = null;
        this.businessDisplayHours = null;
        this.businessTimezone = null;
        this.businessPhoneNumber = null;
        this.monetizationPhoneNumber = null;

        if (this.business.getCategory() != null)
        {
            this.businessCategory =  this.business.getCategory();
        }
        else
        {
            this.businessCategory =  "General";
        }

        parseURL(passedBis.getLinks().get(0).getHref());

    }

    /**
     * <p>This method is used to make the Presented Call to the Soleo API</p>
     * <strong>This is the first call that should be made after a search. Presented must be called on each business as it's seen by the user</strong>
     * @since ver. 1.0
     *
     * @param task <p>What is done when the response comes back from the servers
     *             onTaskCompleted is the task that is preformed if the call was successfully made
     *             TaskFail is called if the Task fail to complete. It will comeback with various error codes.
     *             </p>
     */
    public void presentedBusiness(OnTaskComplete<PresentedData> task)
    {
        final OnTaskComplete<PresentedData> job = task;
        final HttpContext temp;
        //Checking to make sure the flags are not tipped
        if(this.stagingFlag == 0)
        {
            Links link = this.business.getLinks().get(0);
            controller.createPresentedAsync(link.getHref(),
                    new APICallBack<CallBack>() {
                        @Override
                        public void onSuccess(HttpContext context, CallBack response , String Query) {
                            setPresentedData(response, job);
                        }

                        @Override
                        public void onFailure(HttpContext context, Throwable error) {
                            error.printStackTrace();
                            if (context.getRespone() != null) {
                                Log.e("Presented", "Problem doing Presented call");
                                job.TaskFailed(context.getRespone().getStatusCode());
                            } else {
                                Log.e("Presented", "Internal: Object Failed to deserialize from the server");
                                job.TaskFailed(1010);
                            }
                        }
                    });
        }
        else
        {
            Log.w("Presented Callback", "Internal Soft: Presented Call was already made - Returning with already cached data");
            task.onTaskCompeted(this);
            task.onTaskCompeted(this.presentedData);
        }
    }

    /**
     * Internal method used to access variables with out the need to make them final
     * @param passCall  The call that came back from the APICallback
     * @param task The task that is defined by the Developer
     */
    private void setPresentedData(CallBack passCall, OnTaskComplete<PresentedData> task)
    {
        this.presentedCallBack = passCall;
        this.presentedData = passCall.getData().get(0);
        this.stagingFlag = 1;
        task.onTaskCompeted(this.presentedData);
        task.onTaskCompeted(this);

    }

    /**
     * <p>This method makes a call to get different business details from the initial search</p>
     * <ul>
     *      <li>hours</li>
     *      <li>display hours</li>
     *      <li>isOpen</li>
     *      <li>timeZone</li>
     * </ul>
     * <strong>Note: This should be the 2nd call made to the server</strong>
     * @since ver. 1.0
     * @param task <p>What is done when the response comes back from the servers
     *             onTaskCompleted is the task that is preformed if the call was successfully made
     *             TaskFail is called if the Task fail to complete. It will comeback with various error codes.</p>
     */
    public void selectBusinessWithDetails(OnTaskComplete<BusinessDetails> task)
    {
        final OnTaskComplete<BusinessDetails> job = task;
        if(this.stagingFlag == 1)
        {
            Links links = this.presentedData.getLinks().get(1);
            this.controller.createSelectWithDetailsAsync(links.getHref(),
                    new APICallBack<SelectedWithDetailsCall>()
                    {
                        @Override
                        public void onSuccess(HttpContext context, SelectedWithDetailsCall response , String Query){
                            setSelectedWithDInfo(response, job);
                        }

                        @Override
                        public void onFailure(HttpContext context, Throwable error)
                        {
                            // NSHAW
                            if (context.getRespone() != null) {
                                Log.e("SelectedWithDetails", "Problem doing Selected with Details call");
                                job.TaskFailed(context.getRespone().getStatusCode());
                            } else {
                                Log.e("SelectedWithDetails", "Internal: Object Failed to deserialize from the server");
                                job.TaskFailed(1010);
                            }
                        }
                    });

        }
        else
        {
            //1000 is the error code for Callbacks being called out of place
            Log.w("Select w/Details Call", "Internal Soft: Call was already made - Returning with Already cached Data");
            task.onTaskCompeted(this.businessDetails);
            task.onTaskCompeted(this);
        }
    }

    private void setSelectedWithDInfo(SelectedWithDetailsCall response, OnTaskComplete<BusinessDetails> task)
    {
        this.selectedWithDetailsCall = response;
        this.selectedWithDInfo = response.getData().get(0);
        this.businessDetails = this.selectedWithDInfo.getDetails();
        this.stagingFlag = 2;

        //Sets the data up to this point
        this.isBusinessOpen = this.businessDetails.getIsOpen();
        this.businessHours = this.businessDetails.getHours();
        String [] dHours = this.businessDetails.getDisplayHours().split(",");
        for(String str: dHours)
        {
            str = str.trim();
        }
        this.businessDisplayHours = dHours;
        this.businessTimezone = this.businessDetails.getTimeZone();


        task.onTaskCompeted(this.businessDetails);
        task.onTaskCompeted(this);
    }

    /**
     * <p>This Method is used to get the Completion number which is used to track the duration of a
     * Phone call made.  That is used in Monetization</p>
     * <p><strong>Note: This is the 3rd call that needs to be API</strong></p>
     * <p>Note:  As of version 2.0 we don't need to pass the ANI number in again</p>
     * @since ver. 1.0
     * @param task <p>What is done when the response comes back from the servers
     *             onTaskCompleted is the task that is preformed if the call was successfully made
     *             TaskFail is called if the Task fail to complete. It will comeback with various error codes.</p>
     */
    public void getCompletionNumber(OnTaskComplete<CallCompletionData> task)
    {
        final OnTaskComplete<CallCompletionData> job = task;
        if(this.stagingFlag == 2)
        {
            this.controller.getCompletionNumberCallBackAsync(this.selectedWithDInfo.getLinks().get(0).getHref(),
                    new APICallBack<CallCompletionCallback>()
                    {
                        @Override
                        public void onSuccess(HttpContext context, CallCompletionCallback response , String Query) {

                            setCallCompletionCallback(response, job);
                        }

                        @Override
                        public void onFailure(HttpContext context, Throwable error)
                        {
                            if (context.getRespone() != null) {
                                Log.e("Getting Phone numbers", "Problem getting call completion");
                                job.TaskFailed(context.getRespone().getStatusCode());
                            } else {
                                Log.e("Getting Phone Numbers", "Internal Error: Object failed to deserialize from server");
                                job.TaskFailed(1010);
                            }
                        }
                    });
        }
        else if(this.stagingFlag < 2)
        {
            Log.e("fetch Completion Number", "Must call stage: "
                + Integer.toString(this.stagingFlag) + " This is a Stage 2 call");
            job.TaskFailed(1000);
        }
        else
        {
            Log.w("Completion Call Made", "Internal Soft Error: This call to the server was already made - Returning with cached data");
            task.onTaskCompeted(this);
            task.onTaskCompeted(this.callCompletionData);
        }
    }

    /**
     * <p>This is an internal method that is used to break call backs out of there internal shell</p>
     * @since ver. 1.0
     * @param results <p>The results of the call back</p>
     * @param task <p>The developers defined task</p>
     */
    private void setCallCompletionCallback(CallCompletionCallback results,
                                           OnTaskComplete<CallCompletionData> task)
    {
        this.callCompletionCallback = results;
        this.callCompletionData = results.getData().get(0);
        this.stagingFlag = 3;

        //Stores the last of the data that comes back from callbacks
        this.businessPhoneNumber = this.callCompletionData.getDisplayPhoneNumber();
        this.monetizationPhoneNumber = this.callCompletionData.getCompletionPhoneNumber();

        task.onTaskCompeted(this.callCompletionData);
        task.onTaskCompeted(this);
    }

    /**
     * <p>This method is used to send a call back to the server that one of the phone numbers (Display
     * or Completion Number) was called. <strong>NOTE: You must have the phone call the Completion Number
     * for the Monetization to take effect, but ether number will make a successful call to the
     * server </strong></p>
     * <p><strong>This is the Final call that needs to be made to the API</strong></p>
     * @since ver. 1.0
     * @param task <p>What will be done after the call to the server is made.</p>
     */
    public void callMade(OnTaskComplete<Integer> task)
    {
        if(this.stagingFlag == 3)
        {
            final OnTaskComplete<Integer> job = task;
//            this.parseURL(this.callCompletionData.getLinks().get(1).getHref());
            this.controller.getCalledNumberAsync(this.callCompletionData.getLinks().get(1).getHref(),
                    new APICallBack<String>()
                    {
                        @Override
                        public void onSuccess(HttpContext context, String response , String Query) {

                            stagingFlag = 4;
                            job.onTaskCompeted(context.getRespone().getStatusCode());
                        }

                        @Override
                        public void onFailure(HttpContext context, Throwable error)
                        {
                            if (context.getRespone() != null) {
                                Log.e("SelectedWithDetails", "Problem doing Selected with Details call");
                                job.TaskFailed(context.getRespone().getStatusCode());
                            } else {
                                Log.e("Call Made", "Internal: Object Failed to deserialize, However at this point the Monitization Cycle should have been completed Still.");
                                job.TaskFailed(1010);
                            }
                        }
                    });
        }
        else if(this.stagingFlag < 3)
        {
            Log.e("Call Attempt", "This is a stage 3; You are on stage: "
                + Integer.toString(this.stagingFlag));
            task.TaskFailed(1000);
        }
        else
        {
            Log.w("Call Made", "Internal Soft Error: This call to the server was already made");
            task.TaskFailed(1001);
        }
    }

    /**
     * <p>This getter will give you access to the call back that has:</p>
     * <ul>
     *     <li>Name</li>
     *     <li>Address</li>
     *     <li>City</li>
     *     <li>Zip (Postal Code)</li>
     *     <li>State</li>
     *     <li>Latitude</li>
     *     <li>Longitude</li>
     *     <li>Type</li>
     * </ul>
     *
     * <p>Please see Doc located at <a href="https://developer.soleo.com/">developer.soleo.com/</a> for more information on each element and
     * what is available at each callback stage</p>
     * @since ver. 1.0
     * @return <p>A Businesses Data type which is generated from a JSON Response.</p>
     */
    public Businesses getBusiness() {
        return business;
    }

    /**
     * <p>This method returns a lower level data structure which is build from a JSON Response during
     * the presented callback.  <strong>Most Developers will not use this Data Structure (See Docs for
     * more info)</strong></p>
     * @since ver. 1.0
     * @return <p>CallBack Data structure built from the presented JSON response</p>
     */
    public CallBack getPresentedCallBack() {
        return presentedCallBack;
    }

    /**
     * <p>Higher level data structure, still not needed by most developers.</p>
     * @since ver. 1.0
     * @return <p>The data that comes back from the presented call, in a easier to access form</p>
     */
    public PresentedData getPresentedData() {
        return presentedData;
    }

    /**
     * <p>Lower level data structure that is built from a JSON Response during the selected with details
     * call.  It is recommended to use getSelectedWithDInfo() method if you would like to access the
     * Data Structure. </strong></p>
     * @since ver. 1.0
     * @return Lower Level Data Structure built from a JSON Response
     */
    public SelectedWithDetailsCall getSelectedWithDetailsCall() {
        return selectedWithDetailsCall;
    }

    /**
     * <p>Use to get access to the Data Structure generated during the selected with details call
     * Info contained in this Structure is, however it is easier to access with the getBusinessDetails():</p>
     * <ul>
     *     <li>isOpen</li>
     *     <li>hours</li>
     *     <li>displayHours</li>
     *     <li>timeZone</li>
     * </ul>
     * @since ver. 1.0
     * @return <p>The data that comes back from the getSelectedWithDetailsCall call, one level higher.</p>
     */
    public SelectedWithDInfo getSelectedWithDInfo() {
        return selectedWithDInfo;
    }

    /**
     * <p>Use to get access to the Data Structure generated during the selected with details call
     * Info contained in this Structure is:</p>
     * <ul>
     *     <li>isOpen</li>
     *     <li>hours</li>
     *     <li>displayHours</li>
     *     <li>timeZone</li>
     * </ul>
     * @since ver. 1.0
     * @return <p>The highest level data structure generated from the Select with details call</p>
     */
    public BusinessDetails getBusinessDetails() {
        return businessDetails;
    }

    /**
     * <p>Use this method to get access to the Lowest level data structure built from the get completion
     * API server call.  It is recommended to access this data from the @see getCallCompletionData() method
     * return.</p>
     * @since ver. 1.0
     * @return <p>Lowest level data structure built from a JSON response</p>
     */
    public CallCompletionCallback getCallCompletionCallback() {
        return callCompletionCallback;
    }

    /**
     * <p>Use this method to access the highest level data structure that is build from a Get completion
     * number API server call.  This Data structure provides the same basic data as getCallCompletionCallback
     * method return, however it is easier to access with this data type</p>
     * <p>Contains:</p>
     * <ul>
     *     <li>displayNumber</li>
     *     <li>completionNumber (monetizationNumber</li>
     * </ul>
     * @since ver. 1.0
     * @return <p>Highest Level Data type from the get completion data type</p>
     */
    public CallCompletionData getCallCompletionData() {
        return callCompletionData;
    }

    /**
     * <p>The Name of the Business</p>
     * @since ver. 1.0
     * @return <p>Business Name in the form of a String</p> <blockquote><i>John's Pizza</i></blockquote>
     */
    public String getBusinessName() {
        return businessName;
    }

    /**
     * <p>The address of the Business</p>
     * @since ver. 1.0
     * @return <p>Business' address in the form of a String</p>
     *      <blockquote><i>000 Street St</i></blockquote>
     */
    public String getBusinessAddress() {
        return businessAddress;
    }

    /**
     * <p>The city the business is located in</p>
     * @since ver. 1.0
     * @return <p>City the business is located in, in the form of a String</p><blockquote><i>Rochester</i></blockquote>
     */
    public String getBusinessCity() {
        return businessCity;
    }

    /**
     * <p>The State the business is located in</p>
     * @since ver. 1.0
     * @return <p>State the Business is located in, in the form of a String</p><blockquote><i>NY</i></blockquote>
     */
    public String getBusinessState() {
        return businessState;
    }

    /**
     * <p>The Business' Postal Code (Zip Code)</p>
     * @since ver. 1.0
     * @return <p>Business' Postal Code in the form of a String</p><blockquote><i>12345</i></blockquote>
     */
    public String getBusinessPostalCode() {
        return businessPostalCode;
    }

    /**
     * <p>Business' Geo Latitude Location (1 of 2)</p>
     * @since ver. 1.0
     * @return <p>Latitude Geo location in the form of a double</p><blockquote><i>43.152517</i></blockquote>
     */
    public Double getBusinessLatitude() {
        return businessLatitude;
    }

    /**
     * <p>Business' Geo Longitude Location (2 of 2)</p>
     * @since ver. 1.0
     * @return <p>Geo Longitude location in the form of a double</p><blockquote><i>-77.614179</i></blockquote>
     */
    public Double getBusinessLongitude() {
        return businessLongitude;
    }

    /**
     * <p>Distance you are away from the business</p>
     * @since ver. 1.x
     * @return <p>Double that represents the miles away from the business</p>
     */
    public Double getBusinessDistance(){
        return this.businessDistance;
    }

    /**
     * <p>Whether the Business is a Sponsored or Organic</p>
     * @since ver. 1.0
     * @return <p>Business type in the form of a String</p><blockquote><i>"Organic"</i></blockquote>
     */
    public String getBusinessType() {
        return businessType;
    }

    /**
     * <p>If the Business is currently open, this will only return a value if the Selected with Details
     * API call was made.</p>
     * @since ver. 1.0
     * @return <p>String of Yes, No, or Unknown if the Business is open. Null will return if call wasn't made</p>
     * <blockquote><i>"Yes"</i></blockquote>
     */
    public String isBusinessOpen() {
        if (this.isBusinessOpen != null)
            return isBusinessOpen;
        else
            return null;
    }

    /**
     * <p>The hours of the business, this will only return a value if the Selected with Details
     * API call was made.</p>
     * @since ver. 1.0
     * @return <p>String of hours or null if the call wasn't made</p><blockquote><i>"Su 07:00-15:00, Mo 05:30-15:00"</i></blockquote>
     */
    public String getBusinessHours() {
        if (this.businessHours != null)
            return businessHours;
        else
            return null;
    }

    /**
     * <p>The same hours but in a better display form, this will only return a value if the Selected with Details
     * API call was made.</p>
     * @since ver. 1.0
     * @return An array of the hours the Business is open
     * <blockquote><i>
     *     <ul>
     *         <li>[0] = "Sunday 07:00am-03:00pm"</li>
     *         <li>[1] = "Monday 05:30am-03:00pm"</li>
     *     </ul>
     * </i></blockquote>
     */
    public String[] getBusinessDisplayHours() {
        if(this.businessDisplayHours != null)
            return businessDisplayHours;
        else
            return null;
    }

    /**
     * <p>The time zone of the business location, this will only return a value if the Selected with Details
     * API call was made.</p>
     * @since ver. 1.0
     * @return a String containing the timezone <blockquote><i>"GMT-5"</i></blockquote>
     */
    public String getBusinessTimezone() {
        if(this.businessTimezone != null)
            return businessTimezone;
        else
            return null;
    }

    /**
     * <p>The Actual phone number of the business, this will only return a value if getCompletionNumber
     * API call was made</p> <strong>Note: This number show only be displayed to the user, need to call the monetization
     * Phone Number to enable duration tracking </strong>
     * @since ver. 1.0
     * @return Business Number in the form of a string<blockquote><i>"1234567890"</i></blockquote>
     */
    public String getBusinessPhoneNumber() {
        if(this.businessPhoneNumber != null)
            return businessPhoneNumber;
        else
            return null;
    }

    /**
     * <p>The Phone number with duration tracking enabled, this should be the number the phone calls,
     * this will only return a value if getCompletionNumber API call was made</p>
     * @since ver. 1.0
     * @return Duration Tracking Phone Number in the form of a string <blockquote><i>"0987654321"</i></blockquote>
     */
    public String getMonetizationPhoneNumber() {
        if(this.monetizationPhoneNumber != null)
            return monetizationPhoneNumber;
        else
            return null;
    }

    public String getIsBusinessOpen() {
        return isBusinessOpen;
    }

    public String getJsessionID() {
        return jsessionID;
    }

    public String getTrackingNum() {
        return trackingNum;
    }

    /**
     * <p>The Business Category</p>
     * @since ver. 1.3
     * @return <p>Business Category type as a String</p><blockquote><i>12345</i></blockquote>
     */
    public String getBusinessCategory() {
        return businessCategory;
    }

    //*********************************************************************************************************
//**************** This is the Start of the Supporting Methods ********************************************
//*********************************************************************************************************

    /**
     * <p>This interface should be implemented to handle what should be done
     * after the task completes.  And what you want to do with the data received from call back from the API.</p>
     * @since ver. 1.0
     * @param <T> The type of response you will get from the server in the form of a call back.
     *           <blockquote>
     *               <p>One of the following types</p>
     *               <ul>
     *                  <li>PresentedDate</li>
     *                  <li>BusinessDetails</li>
     *                  <li>CallCompletionData</li>
     *               </ul>
     *              <strong>Note: You can receive the whole BusinessElement also</strong>
     *           </blockquote>
     */
    public interface OnTaskComplete<T>
    {
        /**
         * <p>This Method should be used if you want to work with only the data
         * that was just received from the call to the Server.  <i>An empty implementation
         * will not throw an error</i></p>
         * @since ver. 1.0
         * @param results The data that just came back in the form of a call back and it's data model
         */
        void onTaskCompeted(T results);

        /**
         * <p>This Method should be used if you want access to any of the data
         * that has been <strong>retrieved from the server on a particular business
         * to data.</strong>  Future calls may need to be made in-order to get required data
         * An empty implementation will not throw an error</p>
         * @since ver. 1.0
         * @param allData The whole BusinessElement so the data can be accessed however needed
         */
        void onTaskCompeted(BusinessElement allData);

        /**
         * <p>This Method is used to retrieve any error codes that may accuse during
         * the call process.  An empty implementation will not throw an error, however
         * it is recommended you handle the serverCode someway for information in Debugging</p>
         * @since ver. 1.0
         * @param serverCode The error code.  Could be a number of codes.  Please read
         *                   docs for details on the error codes and possible solutions
         */
        void TaskFailed(int serverCode);
    }

    /**
     * ***Internal User Method***
     * Internal URL Parse Method, should be hidden from the developer
     * @param fullURL the URL from the Links Class
     */
    private void parseURL(String fullURL)
    {
        int start = fullURL.lastIndexOf('/');
        int end = fullURL.indexOf(';');
        this.trackingNum = fullURL.substring(start+1, end);
        start = fullURL.indexOf('=');
        end = fullURL.indexOf('?');
        this.jsessionID = fullURL.substring(start + 1, end);
    }
}
