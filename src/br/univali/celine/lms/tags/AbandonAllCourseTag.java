/**
 * CELINE SCORM
 *
 * Copyright 2014 Adilson Vahldick.
 * https://celine-scorm.googlecode.com/
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package br.univali.celine.lms.tags;

import javax.servlet.jsp.JspException;


@SuppressWarnings("serial")
public class AbandonAllCourseTag extends NextURLBodyTagSupport {

	private String varLink = "varLink";

	@Override
	public int doStartTag() throws JspException {

		pageContext.setAttribute(varLink,
				"lms?action=abandonallcourse"
				+ "&nextURL=" + getNextURL());
		
		return EVAL_BODY_INCLUDE;
	}

	public String getVarLink() {
		return varLink;
	}

	public void setVarLink(String varLink) {
		this.varLink = varLink;
	}

}
