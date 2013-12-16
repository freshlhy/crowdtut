package com.crowdtut.common;

import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Constants;
import com.jfinal.config.Routes;
import com.jfinal.config.Plugins;
import com.jfinal.config.Interceptors;
import com.jfinal.config.Handlers;

import org.bee.tl.ext.jfinal.BeetlRenderFactory;

import com.crowdtut.controller.IndexController;

public class Config extends JFinalConfig {
    public void configConstant(Constants me) {
        me.setDevMode(true);
        me.setMainRenderFactory(new BeetlRenderFactory());
    }

    public void configRoute(Routes me) {
        me.add("/", IndexController.class);
    }

    public void configPlugin(Plugins me) { }
    public void configInterceptor(Interceptors me) { }
    public void configHandler(Handlers me) { }
}
