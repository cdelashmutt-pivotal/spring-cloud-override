# spring-cloud-override
Simple strategy for looking up a user defined service from local environment, or the Cloud Foundry vcap services properties from a Spring Boot app.

This example uses spring profiles to enable different strategies for looking up a user defined service for an application.

When running in local mode, the LocalConfig configuration class is used via the "default" profile for the app.  This class looks for a specific property defined in the Environment for the Spring app.  In this example, the src/main/resources/application.properties file contains a property used for the url in the UserService bean.  Refer to http://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-external-config.html and http://docs.spring.io/spring/docs/current/spring-framework-reference/html/beans.html#beans-environment for other options for setting values for the environment of a Spring app.

When running in Cloud Foundry with the default java buildpack, the "cloud" profile is enabled, and then the CloudConfig configuration class gets used instead of the LocalConfig class.  The CloudConfig looks at all vcap.services.user-service.credentials.* propertys to inject any that match property names on the UserService class.  In this example, just a "url" property.

To add more properties, simply add the property to the UserService class, and then add a cooresponding entry to the application.properties file, and also update the user defined service in Cloud Foundry with the updated properties.

As an example, the HelloController gets the UserService bean injected depending upon the profile (or lack thereof) the app is run with.
