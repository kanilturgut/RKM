package com.kanilturgut.RKM.helpers;

import android.content.Context;
import com.androidquery.AQuery;

/**
 * Author   : kanilturgut
 * Date     : 16/05/14
 * Time     : 15:46
 */
public class AQueryOperation {

    public static AQuery aQuery = null;

    public static AQuery getInstance() throws NullPointerException{
        return aQuery;
    }

    public static AQuery getInstance(Context context) {
        if (aQuery == null)
            aQuery = new AQuery(context);

        return aQuery;
    }
}
