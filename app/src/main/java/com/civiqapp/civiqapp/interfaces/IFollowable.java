package com.civiqapp.civiqapp.interfaces;
import 	org.json.JSONArray;
import java.util.Date;
import java.util.List;
/**
 * Created by keya on 7/26/2017.
 */

/***
 * Interface for followable entity
 */
public interface IFollowable
{

    /**
     * Get updates from this entity object since last update time
     * @param lastUpdateTime last update time
     * @return Updates in the form of JSONArray
     */
    JSONArray getUpdate(Date lastUpdateTime);
    List<IUser> getFollowers();
    int getFollowerCount();
    void addFollower();
    void loseFollower();
 }
