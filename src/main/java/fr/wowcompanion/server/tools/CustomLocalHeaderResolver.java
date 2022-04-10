package fr.wowcompanion.server.tools;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

@Configuration
public class CustomLocalHeaderResolver extends AcceptHeaderLocaleResolver {

    List<Locale> LOCALES = Arrays.asList(new Locale("en"),new Locale("es"),new Locale("fr"));

    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        if (!StringUtils.hasText(request.getHeader("Accept-Language"))) {
            return Locale.getDefault();
        }
        
        List<Locale.LanguageRange> list = Locale.LanguageRange.parse(request.getHeader("Accept-Language"));
        return Locale.lookup(list,LOCALES);
    }
}
