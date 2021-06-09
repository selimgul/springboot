package com.example.configclient.controllers;

import com.example.configclient.config.AppConfiguration;
import com.example.configclient.model.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConfigController {

	private AppConfiguration appConfig;

	@Autowired
	public ConfigController(AppConfiguration appConfig) {
		this.appConfig = appConfig;
	}

	@RequestMapping(value = {"", "/","config"}, method = RequestMethod.GET)
	public Config getConfig() {

		Config config = new Config();
		config.setRabbitmqHost(appConfig.getRabbitmqHost());

		return config;
	}
}