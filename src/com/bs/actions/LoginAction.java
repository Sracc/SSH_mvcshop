package com.bs.actions;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Cookie;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.bs.dao.MemberDao;
import com.bs.dao.UserDao;
import com.bs.dao.impl.MemberDaoImpl;
import com.bs.entity.User;

@Controller("loginAction")
@Scope("prototype")
public class LoginAction extends BaseAction {

	@Resource
	private UserDao userDao;
	@Resource
	private MemberDao memberDao = new MemberDaoImpl();

	// private static Logger logger = Logger.getLogger(LoginAction.class);
	private static Log logger = LogFactory.getLog("login");
	private HttpSession session = request.getSession(true);
	private ServletContext application = session.getServletContext();

	public String login() {
		session = request.getSession(true);
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		

		User user = null;

		try {
			user = userDao.login(username, password);
		} catch (RuntimeException e) {
			session.setAttribute("login_error", e.getMessage());
		}
		if (user != null && user.getRole().getId() != 2) {
			logger.info(user.getRole().getName() + user.getUsername() + "成功登陆.");
			session.removeAttribute("login_error");
			session.setAttribute("login_user", user);
			if (user.getRole().getId() == 2)
				session.setAttribute("member",
						memberDao.getByUserId(user.getId()));
			if (user.getRole().getId() == 1) {
				Cookie cookie = new Cookie("login_backend", user.getId() + "");
				cookie.setMaxAge(60 * 60 * 12);
				response.addCookie(cookie);
			}
			if (user.getRole().getId() == 2) {
				Cookie cookie = new Cookie("login_site", user.getId() + "");
				cookie.setMaxAge(60 * 60 * 12);
				response.addCookie(cookie);
			}
			List<User> loginUsers = (List<User>) application
					.getAttribute("loginUsers");
			if (loginUsers == null || loginUsers.size() == 0) {
				loginUsers = new ArrayList<User>();
			}
			User removeUser = null;
			for (User u : loginUsers) {
				if (u.getUsername().equals(user.getUsername())) {
					removeUser = u;
				}
			}
			if (removeUser != null)
				loginUsers.remove(removeUser);
			loginUsers.add(user);
			application.setAttribute("loginUsers", loginUsers);

			return "main_jsp";

		} else {
			return "login_jsp";
		}

	}

	public String loginOut() {
		Cookie cookie = new Cookie("login_backend", "");
		cookie.setMaxAge(60 * 60 * 12);
		response.addCookie(cookie);
		List<User> loginUsers = (List<User>) application
				.getAttribute("loginUsers");
		User user = (User) session.getAttribute("login_user");
		User removeUser = null;
		for (User u : loginUsers) {
			if (u.getUsername().equals(user.getUsername())) {
				removeUser = u;
			}
		}
		if (removeUser != null)
			loginUsers.remove(removeUser);
		loginUsers.remove(removeUser);
		session.removeAttribute("login_user");
		return "login_jsp";
	}

	public String loginOutAjax() {
		Cookie cookie = new Cookie("login_backend", "");
		cookie.setMaxAge(60 * 60 * 12);
		response.addCookie(cookie);
		List<User> loginUsers = (List<User>) application
				.getAttribute("loginUsers");
		User user = (User) session.getAttribute("login_user");
		User removeUser = null;
		for (User u : loginUsers) {
			if (u.getUsername().equals(user.getUsername())) {
				removeUser = u;
			}
		}
		if (removeUser != null)
			loginUsers.remove(removeUser);
		loginUsers.remove(removeUser);
		session.removeAttribute("login_user");
		return null;
	}

	public String loginf() throws Exception {
		session = request.getSession(true);
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = null;
		String error = "";
		PrintWriter out = response.getWriter();
		try {
			user = userDao.login(username, password);
		} catch (RuntimeException e) {
			error += e.getMessage();
		}
		if (user != null && user.getRole().getId() != 1) {
			logger.info(user.getRole().getName() + user.getUsername() + "成功登陆.");
			session.setAttribute("login_user", user);
			if (user.getRole().getId() == 2)
				session.setAttribute("member",
						memberDao.getByUserId(user.getId()));
			if (user.getRole().getId() == 1) {
				Cookie cookie = new Cookie("login_backend", user.getId() + "");
				cookie.setMaxAge(60 * 60 * 12);
				response.addCookie(cookie);
			}
			if (user.getRole().getId() == 2) {
				Cookie cookie = new Cookie("login_site", user.getId() + "");
				cookie.setMaxAge(60 * 60 * 12);
				response.addCookie(cookie);
			}
			List<User> loginUsers = (List<User>) application
					.getAttribute("loginUsers");
			if (loginUsers == null || loginUsers.size() == 0) {
				loginUsers = new ArrayList<User>();
			}
			User removeUser = null;
			for (User u : loginUsers) {
				if (u.getUsername().equals(user.getUsername())) {
					removeUser = u;
				}
			}
			if (removeUser != null)
				loginUsers.remove(removeUser);
			loginUsers.add(user);
			application.setAttribute("loginUsers", loginUsers);

			out.write("true");
		} else {
			out.write(error);
		}
		out.flush();
		out.close();
		return null;
	}

	public String loginOutf() {
		Cookie cookie = new Cookie("login_site", "");
		cookie.setMaxAge(60 * 60 * 12);
		response.addCookie(cookie);
		List<User> loginUsers = (List<User>) application
				.getAttribute("loginUsers");
		User user = (User) session.getAttribute("login_user");
		User removeUser = null;
		for (User u : loginUsers) {
			if (u.getUsername().equals(user.getUsername())) {
				removeUser = u;
			}
		}
		if (removeUser != null)
			loginUsers.remove(removeUser);
		loginUsers.remove(removeUser);
		session.removeAttribute("login_user");
		return "index";
	}

	public String loginOutfAjax() {
		Cookie cookie = new Cookie("login_site", "");
		cookie.setMaxAge(60 * 60 * 12);
		response.addCookie(cookie);
		List<User> loginUsers = (List<User>) application
				.getAttribute("loginUsers");
		User user = (User) session.getAttribute("login_user");
		User removeUser = null;
		for (User u : loginUsers) {
			if (u.getUsername().equals(user.getUsername())) {
				removeUser = u;
			}
		}
		if (removeUser != null)
			loginUsers.remove(removeUser);
		loginUsers.remove(removeUser);
		session.removeAttribute("login_user");
		return null;
	}

	public String loginAccount() throws Exception {
		session = request.getSession(true);
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		String id = request.getParameter("id");
		User user = null;
		if (id != null && !id.equals("")) {
			List<User> userList = userDao.query("");
			int flag = 0;
			for (User u : userList) {
				if (id.equals("" + u.getId()))
					flag = 1;
			}
			if (flag == 1) {
				user = userDao.getById(Integer.parseInt(id));
			}
		}
		PrintWriter out = response.getWriter();
		if (user != null && user.getId() != 0) {
			session.setAttribute("login_user", user);
			if (user.getRole().getId() == 2)
				session.setAttribute("member",
						memberDao.getByUserId(user.getId()));
			if (user.getRole().getId() == 1) {
				Cookie cookie = new Cookie("login_backend", user.getId() + "");
				cookie.setMaxAge(60 * 60 * 12);
				response.addCookie(cookie);
			}
			if (user.getRole().getId() == 2) {
				Cookie cookie = new Cookie("login_site", user.getId() + "");
				cookie.setMaxAge(60 * 60 * 12);
				response.addCookie(cookie);
			}

			List<User> loginUsers = (List<User>) application
					.getAttribute("loginUsers");
			if (loginUsers == null || loginUsers.size() == 0) {
				loginUsers = new ArrayList<User>();
			}
			User removeUser = null;
			for (User u : loginUsers) {
				if (u.getUsername().equals(user.getUsername())) {
					removeUser = u;
				}
			}
			if (removeUser != null)
				loginUsers.remove(removeUser);
			loginUsers.add(user);
			application.setAttribute("loginUsers", loginUsers);

			out.write("1");
		} else {
			out.write("0");
		}
		out.flush();
		out.close();
		return null;
	}

	public String execute() {
		return "login";
	}

}
