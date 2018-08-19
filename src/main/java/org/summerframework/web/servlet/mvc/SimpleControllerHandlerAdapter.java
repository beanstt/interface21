/*
 * Copyright (c) 2011-2025 PiChen
 */

package org.summerframework.web.servlet.mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.summerframework.context.support.ApplicationObjectSupport;
import org.summerframework.web.servlet.HandlerAdapter;
import org.summerframework.web.servlet.LastModified;
import org.summerframework.web.servlet.ModelAndView;
import org.summerframework.web.servlet.DispatcherServlet;

/**
 * Adapter to use the Controller workflow interface with the generic
 * DispatcherServlet. This is an SPI class, not used directly by
 * application code.
 *
 * @author Rod Johnson
 * @version $Id$
 * @see DispatcherServlet
 */
public class SimpleControllerHandlerAdapter extends ApplicationObjectSupport implements HandlerAdapter {

    public boolean supports(Object handler) {
        return handler != null && Controller.class.isAssignableFrom(handler.getClass());
    }

    public ModelAndView handle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws ServletException, IOException {
        Controller controller = (Controller) handler;
        return controller.handleRequest(request, response);
    }

    public long getLastModified(HttpServletRequest request, Object handler) {
        if (handler instanceof LastModified) {
            return ((LastModified) handler).getLastModified(request);
        }
        return -1L;
    }

}
