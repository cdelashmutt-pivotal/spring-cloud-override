# spring-cloud-override
Simple strategy for looking up a user defined service from local environment, or the Cloud Foundry vcap services properties from a Spring Boot app.

This example uses spring profiles to enable different strategies for looking up a user defined service for an application.

When running in local mode, the UserServiceLocalConfig bean is enabled via the "default" profile for the app.  This bean looks for a specific property defined in the Environment for the Spring app.  As an example, the src/main/resources/application.properties file contains a property used for the url in the UserServiceLocalConfig bean.  Refer to http://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-external-config.html and http://docs.spring.io/spring/docs/current/spring-framework-reference/html/beans.html#beans-environment for other options for setting values for the environment of a Spring app.

When running in Cloud Foundry with the default java buildpack, the "cloud" profile is enabled, and then UserServiceCloudConfig bean gets injected instead of the UserServiceLocalConfig bean.  The UserServiceCloudConfig looks at a vcap.services.* property directly to get the specific values for the service.  In this example, just a "url" property.

The HelloController has a reference to a bean that implements the "UserService" interface and will get the appropriate bean injected depending upon the profile (or lack thereof) the app is run with.
