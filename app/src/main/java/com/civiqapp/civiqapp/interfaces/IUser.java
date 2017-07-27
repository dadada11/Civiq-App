package com.civiqapp.civiqapp.interfaces;
import org.json.JSONArray;

import java.util.Date;
import java.util.List;

/**
 * Created by keya on 7/26/2017.
 */

public interface IUser
{
    void subscribe(IFollowable entity);
    void unsubscribe(IFollowable entity);
    Date getLastUpdateTime();
    void setLastUpdateTIme(Date timeOfLatestUpdate);
    String getUserName();
    String getUserHomeAdress();
    String getLegislativeDistrict();
    String getCity();
    String getCounty();
    List<IFollowable> getDefaultIFollowables();
    JSONArray getUpdatesFromAllSubscriptions(Date lastUpdateTime);

 }
