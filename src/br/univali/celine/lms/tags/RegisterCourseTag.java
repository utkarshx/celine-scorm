package br.univali.celine.lms.tags;

import javax.servlet.jsp.JspException;


@SuppressWarnings("serial")
public class RegisterCourseTag extends NextURLBodyTagSupport {

	private String courseId;
	private String varLink = "varLink";

	@Override
	public int doStartTag() throws JspException {

		pageContext.setAttribute(varLink,
				"lms?action=registercourse&courseId=" + courseId 
					+ "&nextURL=" + getNextURL());
		
		return EVAL_BODY_INCLUDE;

	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getCourseId() {
		return courseId;
	}

	public String getVarLink() {
		return varLink;
	}

	public void setVarLink(String varLink) {
		this.varLink = varLink;
	}

}
