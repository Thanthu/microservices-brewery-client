package com.thanthu.breweryclient.web.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConstructorBinding
@ConfigurationProperties(prefix = "tun.http")
public class BlockingRestTemplateConfig {

	private final Integer maxtotalconnections;
	private final Integer defaultmaxtotalconnections;
	private final Integer connectionrequesttimeout;
	private final Integer sockettimeout;

	public BlockingRestTemplateConfig(Integer maxtotalconnections, Integer defaultmaxtotalconnections,
			Integer connectionrequesttimeout, Integer sockettimeout) {
		this.maxtotalconnections = maxtotalconnections;
		this.defaultmaxtotalconnections = defaultmaxtotalconnections;
		this.connectionrequesttimeout = connectionrequesttimeout;
		this.sockettimeout = sockettimeout;
	}

	public Integer getMaxtotalconnections() {
		return maxtotalconnections;
	}

	public Integer getDefaultmaxtotalconnections() {
		return defaultmaxtotalconnections;
	}

	public Integer getConnectionrequesttimeout() {
		return connectionrequesttimeout;
	}

	public Integer getSockettimeout() {
		return sockettimeout;
	}
	

}
