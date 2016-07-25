package utils.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by maksym.ryumin on 7/15/2016.
 */
public class PropertiesHolder {
    private static final Logger logger = LoggerFactory.getLogger(PropertiesHolder.class);

    private static Properties properties;

    //Might need to be synchronized.
    public static Properties getProperties() {
        if (null == properties) {
            try {
                properties = PropertiesLoaderUtils.loadAllProperties("u4i.properties");
            } catch (IOException e) {
                logger.error("Cannot load property file.");
            }
        }
        return properties;
    }


    public static String getAdminLoginName(){
        return PropertiesHolder.getProperties().getProperty("user.admin.login_name");
    }

    public static String getAdminPassword(){

        return PropertiesHolder.getProperties().getProperty("user.admin.password");
    }

    public static String getAdminUserName(){
        return PropertiesHolder.getProperties().getProperty("user.admin.username");
    }

}
