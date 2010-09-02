package br.univali.celine.lms.tags;

import java.io.IOException;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;

import br.univali.celine.lmsscorm.User;

public class SaveUserFormTag extends NextURLTagSupport {

	private String nameFieldName = "Nick : ";
	private String nameFieldPassw = "Senha : ";
	private String label = "Enviar";
	private String nameFieldAdmin = "Administrador";


	@Override
	public void doTag() throws JspException, IOException {

		PageContext pageContext = (PageContext) getJspContext();
		JspWriter out = pageContext.getOut();
		HttpSession session = pageContext.getSession(); 
		User user = (User) session.getAttribute("editUser");
		session.removeAttribute("editUser");

		out.println("<form action='lms' method='post'>");

		if (user == null) {

			out.println("<input type='hidden' name='action' value='adduser'/>");
			mountForm("", "", false);

		} else {

			out.println("<input type='hidden' name='action' value='updateuser'/>");
			out.println("<input type='hidden' name='oldName' value='" + user.getName() + "'>");
			mountForm(user.getName(), user.getPassw(), user.isAdmin());

		}

		out.println("<input type='hidden' name='nextURL' value='" + getNextURL() + "'/>");
		out.println("<input type='hidden' name='thisURL' value='" + getThisURL() + "'/>");

		out.println("<input type='submit' value='" + label + "'/>");
		out.println("</form>");

	}

	private void mountForm(String name, String passw, boolean admin) throws IOException {
		
		JspWriter out = getJspContext().getOut();
		out.println("<div class='saveuser_name'>");
		out.println(nameFieldName);
		out.println("<input type='text' name='name' value='" + name + "'/>");
		out.println("</div>");

		out.println("<div class='saveuser_passw'>");
		out.println(nameFieldPassw);
		out.println("<input type='password' name='passw' value='" + passw + "'/>");
		out.println("</div>");

		out.println("<div class='saveuser_admin'>");

		out.println("<input id='admin' type='checkbox' value='true'" + (admin?"checked='checked'":"") + " name='admin'>&nbsp;");
		out.println("<label for=\"admin\">" + nameFieldAdmin + "</label>");

		out.println("</div>");
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getNameFieldAdmin() {
		return nameFieldAdmin;
	}

	public void setNameFieldAdmin(String nameFieldAdmin) {
		this.nameFieldAdmin = nameFieldAdmin;
	}

	public String getNameFieldName() {
		return nameFieldName;
	}

	public void setNameFieldName(String nameFieldName) {
		this.nameFieldName = nameFieldName;
	}

	public String getNameFieldPassw() {
		return nameFieldPassw;
	}

	public void setNameFieldPassw(String nameFieldPassw) {
		this.nameFieldPassw = nameFieldPassw;
	}

}
