/*
 * Copyright (c) 2011-2025 PiChen
 */

package org.summerframework.web.context.support;

import javax.servlet.ServletContext;

import org.summerframework.beans.BeansException;
import org.summerframework.context.ApplicationContext;
import org.summerframework.context.ApplicationContextException;
import org.summerframework.ui.context.support.StaticUiApplicationContext;
import org.summerframework.web.context.WebApplicationContext;

/**
 * WebApplicationContext implementation for testing.
 * Not for use in production applications.
 */
public class StaticWebApplicationContext extends StaticUiApplicationContext implements WebApplicationContext {

    private String namespace;

    private ServletContext servletContext;

    public StaticWebApplicationContext() {
    }

    public StaticWebApplicationContext(ApplicationContext parent, String namespace)
            throws BeansException, ApplicationContextException {
        super(parent);
        this.namespace = namespace;
    }

    public String getNamespace() {
        return namespace;
    }

    /**
     * Normally this would cause loading, but this class doesn't rely on loading.
     *
     * @see WebApplicationContext#setServletContext(ServletContext)
     */
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
        refresh();
        WebApplicationContextUtils.publishConfigObjects(this);
        // Expose as a ServletContext object
        WebApplicationContextUtils.publishWebApplicationContext(this);
    }


    public ServletContext getServletContext() {
        return servletContext;
    }

}
