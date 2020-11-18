package com.westpac.webapp.testRunner;

import io.appium.java_client.service.local.AppiumDriverLocalService;

public final class AppiumServerController {

    private final static AppiumDriverLocalService service;

    static  {
        service = AppiumDriverLocalService.buildDefaultService();
    }
    public static void startAppiumServer(){
        try{
        	service.start();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void stopAppiumServer() {
        try{
            if (service.isRunning()) {
                service.stop();
            }
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
