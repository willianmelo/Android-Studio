package com.example.willian.firstapp;

import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by willi on 31/01/2018.
 */

public class ApiUtil {
    private ApiUtil(){}

    public static final String BASE_API_URL= "https://www.googleapis.com/books/v1/volumes";

    public static URL buildURL(String title)
    {
        String fullUrl = BASE_API_URL + "?q="+title;
        URL url = null;
        try
        {
            url = new URL(fullUrl);
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return url;
    }

    public static String getJason(URL url) throws IOException
    {
        HttpURLConnection connnection  = (HttpURLConnection) url.openConnection();

        try
        {
            InputStream stream = connnection.getInputStream();

            Scanner scanner = new Scanner(stream);
            scanner.useDelimiter("\\A");
            boolean hasData = scanner.hasNext();
            if (hasData)
                return scanner.next();

            return null;
        }catch(Exception ex)
        {
            Log.d("Error", ex.toString());
            return null;
        }
        finally {
            connnection.disconnect();
        }

    }
}
