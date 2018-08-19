/*
 * Copyright (c) 2011-2025 PiChen
 */

package org.summerframework.jdbc.mock;

import java.sql.SQLException;
import java.sql.SQLWarning;

import com.mockobjects.sql.MockStatement;

/**
 * Warning support should really be in Mock objects core
 * <p>
 * (c)  Rod Johnson, 2003
 *
 * @author Rod Johnson
 */
public class SpringMockStatement extends MockStatement {

    private SQLWarning warning;


    public void setupReportWarningOnExecute(SQLWarning warnings) {
        this.warning = warnings;
    }

    /**
     * @see java.sql.Statement#getWarnings()
     */
    public SQLWarning getWarnings() throws SQLException {
        // CHECK NOT BEFORE execute?

        return this.warning;
    }

}
