package com.thanthu.breweryclient.web.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConstructorBinding
@ConfigurationProperties(prefix = "tun.http")
public class BlockingRestTemplateConfig {

	private final Integer maxTotalConnections;
	private final Integer defaultMaxTotalConnections;
	private final Integer connectionRequestTimeout;
	private final Integer socketTimeout;

	public BlockingRestTemplateConfig(Integer maxTotalConnections, Integer defaultMaxTotalConnections,
			Integer connectionRequestTimeout, Integer socketTimeout) {
		super();
		this.maxTotalConnections = maxTotalConnections;
		this.defaultMaxTotalConnections = defaultMaxTotalConnections;
		this.connectionRequestTimeout = connectionRequestTimeout;
		this.socketTimeout = socketTimeout;
	}

	public Integer getMaxTotalConnections() {
		return maxTotalConnections;
	}

	public Integer getDefaultMaxTotalConnections() {
		return defaultMaxTotalConnections;
	}

	public Integer getConnectionRequestTimeout() {
		return connectionRequestTimeout;
	}

	public Integer getSocketTimeout() {
		return socketTimeout;
	}

}
