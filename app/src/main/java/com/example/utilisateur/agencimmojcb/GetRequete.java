package com.example.utilisateur.agencimmojcb;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Utilisateur on 28/03/2018.
 */

public class GetRequete{

    private final OkHttpClient client = new OkHttpClient();

    public String get(String url) throws IOException {

        // Prepare the request.
        Request request = new Request.Builder().url(url).build();
        // Execute the request.
        Response response = client.newCall(request).execute();
        // Get the result.
        return response.body().string();
    }
}
