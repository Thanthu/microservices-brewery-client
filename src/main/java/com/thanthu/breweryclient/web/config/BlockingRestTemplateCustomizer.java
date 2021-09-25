package com.thanthu.breweryclient.web.config;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@EnableConfigurationProperties(BlockingRestTemplateConfig.class)
@Component
public class BlockingRestTemplateCustomizer implements RestTemplateCustomizer {

	private final BlockingRestTemplateConfig blockingRestTemplateConfig;
	
    public BlockingRestTemplateCustomizer(BlockingRestTemplateConfig blockingRestTemplateConfig) {
		this.blockingRestTemplateConfig = blockingRestTemplateConfig;
	}

	public ClientHttpRequestFactory clientHttpRequestFactory(){
        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
        connectionManager.setMaxTotal(blockingRestTemplateConfig.getMaxTotalConnections());
        connectionManager.setDefaultMaxPerRoute(blockingRestTemplateConfig.getDefaultMaxTotalConnections());

        RequestConfig requestConfig = RequestConfig
                .custom()
                .setConnectionRequestTimeout(blockingRestTemplateConfig.getConnectionRequestTimeout())
                .setSocketTimeout(blockingRestTemplateConfig.getSocketTimeout())
                .build();

        CloseableHttpClient httpClient = HttpClients
                .custom()
                .setConnectionManager(connectionManager)
                .setKeepAliveStrategy(new DefaultConnectionKeepAliveStrategy())
                .setDefaultRequestConfig(requestConfig)
                .build();

        return new HttpComponentsClientHttpRequestFactory(httpClient);
    }

    @Override
    public void customize(RestTemplate restTemplate) {
        restTemplate.setRequestFactory(this.clientHttpRequestFactory());
    }
}