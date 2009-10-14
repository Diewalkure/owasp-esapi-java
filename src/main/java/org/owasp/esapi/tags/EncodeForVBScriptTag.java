package org.owasp.esapi.tags;

import java.io.IOException;

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.owasp.esapi.ESAPI;
import org.owasp.esapi.Encoder;

/**
 *
 * @author jwilliams
 */
public class EncodeForVBScriptTag extends BodyTagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	
    /**
     *
     * @return
     * @throws javax.servlet.jsp.JspTagException
     */
    public int doAfterBody() throws JspTagException {


		BodyContent body = getBodyContent();
		
		String content = body.getString();
		JspWriter out = body.getEnclosingWriter();
		
		Encoder e = ESAPI.encoder();
		
		try {
			
			out.print( e.encodeForVBScript(content) );
			body.clearBody();
			
		} catch (IOException ioe) {
			throw new JspTagException("error writing to body's enclosing writer",ioe);
		}
		
		return SKIP_BODY;

	}
}