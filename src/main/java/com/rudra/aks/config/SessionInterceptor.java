package com.rudra.aks.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.session.Session;
import org.springframework.session.SessionRepository;
import org.springframework.session.web.http.HttpSessionManager;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.rudra.aks.user.Account;

@Component
public class SessionInterceptor extends HandlerInterceptorAdapter {

	private static final Logger logger = Logger.getLogger(SessionInterceptor.class);
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		logger.info("Session Interceptor : postHandle()");
		
		//request.getSession().setAttribute("username", request.getAttribute("username"));
		HttpSessionManager sessionManager = (HttpSessionManager) request.getAttribute(HttpSessionManager.class.getName());
		@SuppressWarnings("unchecked")
		SessionRepository<Session> repo = (SessionRepository<Session>) request.getAttribute(SessionRepository.class.getName());

		String currentSessionAlias = sessionManager.getCurrentSessionAlias(request);
		Map<String, String> sessionIds = sessionManager.getSessionIds(request);
		String unauthenticatedAlias = null;

		String contextPath = request.getContextPath();
		List<Account> accounts = new ArrayList<Account>();
		Account currentAccount = null;
		for (Map.Entry<String, String> entry : sessionIds.entrySet()) {
			String alias = entry.getKey();
			String sessionId = entry.getValue();
			logger.info("session alias :  " + alias);
			logger.info("sessionid : " + sessionId);
			Session session = repo.getSession(sessionId);
			if (session == null) {
				continue;
			}

			String username = session.getAttribute("username");
			//String username = (String) request.getParameter("username");
			if (username == null) {
				unauthenticatedAlias = alias;
				continue;
			}

			String logoutUrl = sessionManager.encodeURL("./logout", alias);
			String switchAccountUrl = sessionManager.encodeURL("./", alias);
			Account account = new Account(username, logoutUrl, switchAccountUrl);
			if (currentSessionAlias.equals(alias)) {
				currentAccount = account;
			}
			else {
				accounts.add(account);
			}
		}

		// tag::addAccountUrl[]
		String addAlias = unauthenticatedAlias == null ? // <1>
				sessionManager.getNewSessionAlias(request)
				: // <2>
				unauthenticatedAlias; // <3>
		String addAccountUrl = sessionManager.encodeURL(contextPath, addAlias); // <4>
		
		
		request.setAttribute("currentAccount", currentAccount);
		request.setAttribute("addAccountUrl", addAccountUrl);
		request.setAttribute("accounts", accounts);

		logger.info("===== Request Attributed added as ===== ");
		logger.info("Current Accuotn : " + currentAccount);
		logger.info("Add account url : " + addAccountUrl);
		logger.info("List of Accounts: " + accounts);
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		return true;
	}
	
	

}
