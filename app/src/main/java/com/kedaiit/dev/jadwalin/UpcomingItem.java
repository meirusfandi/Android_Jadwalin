package com.kedaiit.dev.jadwalin;

import java.io.Serializable;

public class UpcomingItem implements Serializable {
    String idEvent, strEvent, dateEvent;

    public UpcomingItem(String idEvent, String strEvent, String dateEvent ) {
        this.idEvent = idEvent;
        this.strEvent = strEvent;
        this.dateEvent = dateEvent;
    }

    public String getidEvent() {
        return idEvent;
    }

    public String getstrEvent() {
        return strEvent;
    }

    public String getdateEvent() {
        return dateEvent;
    }

}
