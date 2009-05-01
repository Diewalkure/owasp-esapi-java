/**
 * OWASP Enterprise Security API (ESAPI)
 * 
 * This file is part of the Open Web Application Security Project (OWASP)
 * Enterprise Security API (ESAPI) project. For details, please see
 * <a href="http://www.owasp.org/index.php/ESAPI">http://www.owasp.org/index.php/ESAPI</a>.
 *
 * Copyright (c) 2007 - The OWASP Foundation
 * 
 * The ESAPI is published by OWASP under the BSD license. You should read and accept the
 * LICENSE before you use, modify, and/or redistribute this software.
 * 
 * @author Jeff Williams <a href="http://www.aspectsecurity.com">Aspect Security</a>
 * @created 2007
 */
package org.owasp.esapi;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * The Class AllTests.
 * 
 * @author Jeff Williams (jeff.williams@aspectsecurity.com)
 */
public class AllTests extends TestCase {
    
    /**
	 * Instantiates a new all tests.
	 * 
	 * @param testName
	 *            the test name
	 */
    public AllTests(String testName) {
        super(testName);
    }

    /* (non-Javadoc)
     * @see junit.framework.TestCase#setUp()
     */
    protected void setUp() throws Exception {
    	// none
    }

    /* (non-Javadoc)
     * @see junit.framework.TestCase#tearDown()
     */
    protected void tearDown() throws Exception {
    	// none
    }

    /**
	 * suite method automatically generated by JUnit module.
	 * 
	 * @return the test
	 */
    public static Test suite() {
        System.out.println( "INITIALIZING ALL TESTS" );
        
        // The following property must be set in order for the tests to find the resources directory
        // You can set it here, or you can launch JUnit with the VM argument
        //     -Dorg.owasp.esapi.resources="/Users/...ESAPI/test/testresources"
        // System.setProperty(SecurityConfiguration.RESOURCE_DIRECTORY, "C:/Users/.../ESAPI/test/testresources");

        
        // clear the User file to prep for tests
        File file = new File((ESAPI.securityConfiguration()).getResourceDirectory(), "users.txt");
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(new FileWriter(file));
            writer.println("# This is the user file associated with the ESAPI library from http://www.owasp.org");
            writer.println("# accountName | hashedPassword | roles | locked | enabled | rememberToken | csrfToken | oldPasswordHashes | lastPasswordChangeTime | lastLoginTime | lastFailedLoginTime | expirationTime | failedLoginCount");
            writer.println();
            writer.flush();
        } catch (IOException e) {
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
        
        TestSuite suite = new TestSuite("AllTests");
        suite.addTest(org.owasp.esapi.reference.LoggerTest.suite());
        suite.addTest(org.owasp.esapi.reference.SafeFileTest.suite());
        suite.addTest(org.owasp.esapi.reference.UserTest.suite());
        suite.addTest(org.owasp.esapi.ESAPITest.suite());
        suite.addTest(org.owasp.esapi.reference.RandomizerTest.suite());
        suite.addTest(org.owasp.esapi.reference.AccessControllerTest.suite());
        suite.addTest(org.owasp.esapi.reference.HTTPUtilitiesTest.suite());
        suite.addTest(org.owasp.esapi.reference.ValidatorTest.suite());
        suite.addTest(org.owasp.esapi.reference.EncryptorTest.suite());
        suite.addTest(org.owasp.esapi.reference.IntrusionDetectorTest.suite());
        suite.addTest(org.owasp.esapi.reference.AccessReferenceMapTest.suite());
        suite.addTest(org.owasp.esapi.reference.IntegerAccessReferenceMapTest.suite());
        suite.addTest(org.owasp.esapi.reference.ExecutorTest.suite());
        suite.addTest(org.owasp.esapi.reference.EncoderTest.suite());
        suite.addTest(org.owasp.esapi.reference.EncryptedPropertiesTest.suite());
        suite.addTest(org.owasp.esapi.reference.AuthenticatorTest.suite());

        // exceptions
        suite.addTest(org.owasp.esapi.errors.EnterpriseSecurityExceptionTest.suite());
        
        // filters
        suite.addTest(org.owasp.esapi.filters.ESAPIFilterTest.suite());
        return suite;
    }
    
}