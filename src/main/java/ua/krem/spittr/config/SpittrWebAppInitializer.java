package ua.krem.spittr.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

/**
 * Description:
 * ====================================
 *
 * @author Sergiy
 * @since 3/30/2016
 */
public class SpittrWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    // Map DispatcherServlet to / of Web App
    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] {RootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] {WebConfig.class};
    }

    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        // registration.setMultipartConfig(new MultipartConfigElement("/tmp/spittr/uploads", 20000000, 40000000, 0));
        registration.setMultipartConfig(new MultipartConfigElement("/", 20000000, 40000000, 0));
    }
}
