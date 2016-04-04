package ua.krem.spittr.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Description:
 * ====================================
 *
 * @author Sergiy
 * @since 3/30/2016
 */
@Configuration
@EnableWebMvc
@ComponentScan("ua.krem.spittr.web")
public class WebConfig extends WebMvcConfigurerAdapter {

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        internalResourceViewResolver.setPrefix("/WEB-INF/views/");
        internalResourceViewResolver.setSuffix(".jsp");
        // internalResourceViewResolver.setExposeContextBeansAsAttributes(true);
        internalResourceViewResolver.setViewClass(org.springframework.web.servlet.view.JstlView.class);
        return internalResourceViewResolver;
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Bean(name = "ValidatorMessages")
    public MessageSource resourceBundleMessageSource() {
        ResourceBundleMessageSource resourceBundleMessageSource = new ResourceBundleMessageSource();
        //resourceBundleMessageSource.setBasename("D:\\Docs\\My\\JAVA\\IDEA-NEW\\Spittr\\src\\main\\resources\\ValidationMessages.properties");
        resourceBundleMessageSource.setBasename("ValidationMessages.properties");
        return resourceBundleMessageSource;
    }
}
