package com.application;

import java.io.FileInputStream;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class LoggerCreating {
    static Logger getLogger(){
        Logger logger = null;
        try(FileInputStream configFile = new FileInputStream("./logger.config")){
            LogManager.getLogManager().readConfiguration(configFile);
            logger = Logger.getLogger(LoggerCreating.class.getName());
        }catch (Exception ignore){
            ignore.printStackTrace();
        }
        return logger;
    }
}
