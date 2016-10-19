/*
 * SoleoLocalSearchAPI
 *
 * This file was automatically generated for SOLEO by APIMATIC BETA v2.0 on 03/01/2016
 */
package com.soleo.lsapi.controllers;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;
import com.fasterxml.jackson.core.type.TypeReference;

import com.soleo.lsapi.http.client.HttpClient;
import com.soleo.lsapi.http.client.HttpContext;
import com.soleo.lsapi.http.request.HttpRequest;
import com.soleo.lsapi.http.response.HttpResponse;
import com.soleo.lsapi.http.response.HttpStringResponse;
import com.soleo.lsapi.http.client.APICallBack;
import com.soleo.lsapi.*;
import com.soleo.lsapi.models.*;

public class CategoryInformationController extends BaseController {
    /**
     * Initialize the base controller using the given http client
     */
    public CategoryInformationController() {
        super();
    }

    /**
     * Initialize the base controller using the given http client
     *
     * @param _client The given http client */
    public CategoryInformationController(HttpClient _client) {
        super(_client);
    }

    /**
     * The Caetegory endpoint allows the developer to get a list of the top level categories used by Soleo (level 1 or levels 1 & 2)
     * @param    aPIKey    Required parameter: API Key from developer.soleo.com
     * @param    level    Required parameter: Number of category levels to return (1 or 2)
	 * @return	Returns the Categories response from the API call*/
    public void getCategoryAsync(
            final String aPIKey,
            final String level,
            final APICallBack<Categories> callBack
    ) {
        //the base uri for api requests
        String baseUri = Configuration.baseUri;

        //prepare query string for API call
        StringBuilder queryBuilder = new StringBuilder(baseUri);
        queryBuilder.append("/category/{level}");

        //process template parameters
        APIHelper.appendUrlWithTemplateParameters(queryBuilder, new HashMap<String, Object>() {
            private static final long serialVersionUID = 5674787151015337577L;
            {
                    put( "level", level );
            }});

        //process query parameters
        APIHelper.appendUrlWithQueryParameters(queryBuilder, new HashMap<String, Object>() {
            private static final long serialVersionUID = 4816558806996671366L;
            {
                    put( "APIKey", aPIKey );
                    put( "APIKey", Configuration.getAPIKey() );
            }});
        //validate and preprocess url
        final String queryUrl = APIHelper.cleanUrl(queryBuilder);

        //load all headers for the outgoing API request
        Map<String, String> headers = new HashMap<String, String>() {
            private static final long serialVersionUID = 5144695001056598296L;
            {
                    put( "user-agent", "SOLEO.SDK.1.0" );
            }
        };

        //prepare and invoke the API call request to fetch the response
        final HttpRequest request = clientInstance.get(queryUrl, headers, null);

        int timeout = 7; //seconds
        request.getParameters().put("http.socket.timeout", timeout * 1000);
        request.getParameters().put("http.connection.timeout", timeout * 1000);
        request.getParameters().put("http.connection-manager.timeout", new Long(timeout * 1000));
        request.getParameters().put("http.protocol.head-body-timeout", timeout * 1000);

        //invoke request and get response
        Runnable responseTask = new Runnable() {
            public void run() {
                //make the API call
                clientInstance.executeAsStringAsync(request, new APICallBack<HttpResponse>() {
                    public void onSuccess(HttpContext context, HttpResponse response , String Query) {
                        try {
                            //Error handling using HTTP status codes
                            int responseCode = response.getStatusCode();
                            if (responseCode == 400)
                                throw new APIException("Bad request (API)", 400, response.getRawBody());

                            else if (responseCode == 403)
                                throw new APIException("Inactive/Unknown Key (Proxy)", 403, response.getRawBody());

                            else if (responseCode == 410)
                                throw new APIException("Gone (API)", 410, response.getRawBody());

                            else if (responseCode == 504)
                                throw new APIException("Gateway Timeout (proxy)", 504, response.getRawBody());

                            else if (responseCode == 500)
                                throw new APIException("The server experienced an internal issue and could not process the API request.", 500, response.getRawBody());

                            else if ((responseCode < 200) || (responseCode > 206)) //[200,206] = HTTP OK
                                throw new APIException("HTTP Response Not OK", responseCode, response.getRawBody());

                            //extract result from the http response
                            Categories result = APIHelper.deserialize(((HttpStringResponse)response).getBody(),
                                                        new TypeReference<Categories>(){});

                            //let the caller know of the success
                            callBack.onSuccess(context, result, queryUrl);
                        } catch (APIException error) {
                            //let the caller know of the error
                            callBack.onFailure(context, error);
                        } catch (IOException ioException) {
                            //let the caller know of the caught IO Exception
                            callBack.onFailure(context, ioException);
                        } catch (Exception exception) {
                            //let the caller know of the caught Exception
                            callBack.onFailure(context, exception);
                        }
                    }
                    public void onFailure(HttpContext context, Throwable error) {
                        //let the caller know of the failure
                        callBack.onFailure(context, error);
                    }
                });
            }
        };

        //execute async using thread pool
        APIHelper.getScheduler().execute(responseTask);
    }
        
}