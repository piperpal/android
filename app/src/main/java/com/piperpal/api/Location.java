package com.piperpal.api;
import java.util.HashMap;
import java.util.Map;

public class Location {

    public String id;
    public String name;
    public String service;
    public String location;
    public String modified;
    public String created;
    public String glat;
    public String glon;
    public String paid;
    public String token;
    public String type;
    public String distance;
    public String email;
    public Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The id
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     * The service
     */
    public String getService() {
        return service;
    }

    /**
     *
     * @param service
     * The service
     */
    public void setService(String service) {
        this.service = service;
    }

    /**
     *
     * @return
     * The location
     */
    public String getLocation() {
        return location;
    }

    /**
     *
     * @param location
     * The location
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     *
     * @return
     * The modified
     */
    public String getModified() {
        return modified;
    }

    /**
     *
     * @param modified
     * The modified
     */
    public void setModified(String modified) {
        this.modified = modified;
    }

    /**
     *
     * @return
     * The created
     */
    public String getCreated() {
        return created;
    }

    /**
     *
     * @param created
     * The created
     */
    public void setCreated(String created) {
        this.created = created;
    }

    /**
     *
     * @return
     * The glat
     */
    public String getGlat() {
        return glat;
    }

    /**
     *
     * @param glat
     * The glat
     */
    public void setGlat(String glat) {
        this.glat = glat;
    }

    /**
     *
     * @return
     * The glon
     */
    public String getGlon() {
        return glon;
    }

    /**
     *
     * @param glon
     * The glon
     */
    public void setGlon(String glon) {
        this.glon = glon;
    }

    /**
     *
     * @return
     * The paid
     */
    public String getPaid() {
        return paid;
    }

    /**
     *
     * @param paid
     * The paid
     */
    public void setPaid(String paid) {
        this.paid = paid;
    }

    /**
     *
     * @return
     * The token
     */
    public String getToken() {
        return token;
    }

    /**
     *
     * @param token
     * The token
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     *
     * @return
     * The type
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @param type
     * The type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     *
     * @return
     * The distance
     */
    public String getDistance() {
        return distance;
    }

    /**
     *
     * @param distance
     * The distance
     */
    public void setDistance(String distance) {
        this.distance = distance;
    }

    /**
     *
     * @return
     * The email
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     * The email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}