package com.crowdtut.common;

import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Constants;
import com.jfinal.config.Routes;
import com.jfinal.config.Plugins;
import com.jfinal.config.Interceptors;
import com.jfinal.config.Handlers;

import org.bee.tl.ext.jfinal.BeetlRenderFactory;

import com.crowdtut.controller.IndexController;
import com.crowdtut.controller.VideoController;

public class Config extends JFinalConfig {
    public void configConstant(Constants constants) {
        constants.setDevMode(true);
        constants.setMainRenderFactory(new BeetlRenderFactory());
    }

    public void configRoute(Routes routes) {
        routes.add("/", IndexController.class);
        routes.add("/video", VideoController.class);
    }

    public void configPlugin(Plugins plugins) { }
    public void configInterceptor(Interceptors interceptors) { }
    public void configHandler(Handlers handlers) { }
}
