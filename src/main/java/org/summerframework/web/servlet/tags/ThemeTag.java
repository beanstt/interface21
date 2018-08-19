/*
 * Copyright (c) 2011-2025 PiChen
 */

package org.summerframework.web.servlet.tags;

import org.summerframework.context.MessageSource;
import org.summerframework.context.NoSuchMessageException;
import org.summerframework.ui.context.Theme;
import org.summerframework.ui.context.ThemeSource;

/**
 * Custom tag to look up a theme message in the scope of this page.
 * Messages are looked up using the ApplicationContext's ThemeSource,
 * and thus should support internationalization.
 * <p>
 * <p>Regards a HTML escaping setting, either on this tag instance,
 * the page level, or the web.xml level.
 * <p>
 * <p>If "code" isn't set or cannot be resolved, "text" will be used
 * as default message.
 *
 * @author Jean-Pierre Pawlak
 * @author Juergen Hoeller
 * @see Theme
 * @see ThemeSource
 * @see #setCode
 * @see #setText
 * @see #setHtmlEscape
 * @see HtmlEscapeTag#setDefaultHtmlEscape
 * @see HtmlEscapeTag#HTML_ESCAPE_CONTEXT_PARAM
 */
public class ThemeTag extends MessageTag {

    /**
     * Use the theme MessageSource for theme message resolution.
     */
    protected MessageSource getMessageSource() {
        Theme theme = getRequestContext().getTheme();
        return (theme != null) ? theme.getMessageSource() : null;
    }

    /**
     * Return exception message that indicates the current theme.
     */
    protected String getNoSuchMessageExceptionDescription(NoSuchMessageException ex) {
        return "Theme '" + getRequestContext().getTheme().getName() + "': " + ex.getMessage();
    }

}
