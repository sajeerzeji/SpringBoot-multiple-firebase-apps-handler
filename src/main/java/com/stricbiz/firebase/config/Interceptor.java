package com.stricbiz.firebase.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class Interceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(
            HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String firebaseApp = request.getHeader("FirebaseApp");
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(
                        new ClassPathResource(firebaseApp + ".json").getInputStream()))
                .build();
        FirebaseApp.initializeApp(options);

        return true;
    }

    @Override
    public void postHandle(
            HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        removeFirebaseAppInstance();
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception exception) throws Exception {
        removeFirebaseAppInstance();
    }

    private void removeFirebaseAppInstance() {
        if (FirebaseApp.getApps() != null && FirebaseApp.getApps().isEmpty()) {
            FirebaseApp.getInstance().delete();
        }
    }
}
