package cn.netrookie.common;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;


public class HttpHelper {
    private CloseableHttpClient httpclient;
    private RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(1000 * 30).setConnectTimeout(1000 * 30).build();

    public void init() {
        if (httpclient != null) {
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        httpclient = HttpClients.createDefault();
    }

    public String urlGet(String url) throws URISyntaxException, IOException {
        HttpGet request = new HttpGet();
        request.setConfig(requestConfig);
        request.setURI(new URI(url));
        HttpResponse response = httpclient.execute(request);
        return IOUtils.toString(response.getEntity().getContent(), Charset.forName("UTF-8"));
    }

    public InputStream urlGet1(String url) throws URISyntaxException, IOException {
        HttpGet request = new HttpGet();
        request.setConfig(requestConfig);
        request.setURI(new URI(url));
        HttpResponse response = httpclient.execute(request);
        return response.getEntity().getContent();
    }

    public void release() {
        try {
            httpclient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}