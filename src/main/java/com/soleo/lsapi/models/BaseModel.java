/*
 * SoleoLocalSearchAPI
 *
 * This file was automatically generated for SOLEO by APIMATIC BETA v2.0 on 03/01/2016
 */
package com.soleo.lsapi.models;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;

class BaseModel
        extends java.util.Observable {
    //Map to store additional properties
    protected Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /** Any GETTER
     * Needed for serialization of additional properties
     */
    @JsonAnyGetter
    public Map<String,Object> getAdditionalProperties ( ) {
        return additionalProperties;
    }

    /** Any SETTER
     * Needed for deserialization of additional properties
     */
    @JsonAnySetter
    public void setAdditionalProperties (String name, Object value) {
        additionalProperties.put(name, value);
    }

    /**
     * Provides access to all properties using property name as key
     * If the property was not found, additionalProperties map is explored
     * @param key The property name, which may or may not be declared
     * @return
     */
    public Object getValue(String key)
            throws NoSuchElementException {
        //see if we can draw value form a field
        Field field = getFieldMatchingKey(key);
        if(field != null) {
            try {
                return field.get(this);
            } catch(Exception ex) {
                return null;
            }
        }

        //see if we can draw a value fom a JsonGetter mathod
        Method method = getMethodMatchingKey(key, true);
        if(method != null) {
            try {
                return method.invoke(this);
            } catch(Exception ex) {
                return null;
            }
        }

        //fallback on additionalProperties map
        if(additionalProperties.containsKey(key)) {
            return additionalProperties.get(key);
        }

        //could not locate the key
        throw new NoSuchElementException("Value not found with the given key: " + key);
    }

    /**
     *
     * @param key
     * @return
     */
    public void setValue(String key, Object value) {
        //see if we can set a value from a JsonGetter mathod
        //this has preference over field access, since it will notify observers
        Method method = getMethodMatchingKey(key, false);
        if(method != null) {
            try {
                method.invoke(this, value);
            } catch(Exception ex) {
            }
        }

        //see if we can set value to a field
        Field field = getFieldMatchingKey(key);
        if(field != null) {
            try {
                field.set(this, value);
            } catch(Exception ex) {
            }
        }

        //fallback on additionalProperties map
        if(additionalProperties.containsKey(key)) {
            additionalProperties.put(key, value);
        }
    }

    /**
     * Attempts to locate a field with matching name
     * @param key a string value to match field name
     * @return
     */
    private Field getFieldMatchingKey(String key) {
        Field[] fields = this.getClass().getDeclaredFields();
        for(Field field : fields) {
            if(field.getName().equalsIgnoreCase(key)) {
                field.setAccessible(true);
                return field;
            }
        }
        return  null;
    }

    /**
     * Attempts to locate a method with matching JsonGetter annotation
     * @param key a string value to match method JsonGetter annotation
     * @return
     */
    private Method getMethodMatchingKey(String key, boolean getter) {
        Method[] methods = this.getClass().getMethods();
        for(Method method : methods) {
            Annotation annotation = method.getAnnotation((getter) ? JsonGetter.class : JsonSetter.class);
            if (annotation != null) {
                if((getter) && ((JsonGetter) annotation).value().equalsIgnoreCase(key)) {
                    return  method;
                } else if((!getter) && ((JsonSetter) annotation).value().equalsIgnoreCase(key)) {
                    return  method;
                }
            }
        }
        return  null;
    }
}
