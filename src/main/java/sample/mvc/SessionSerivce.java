package sample.mvc;

import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.springframework.session.Session;
import org.springframework.session.SessionRepository;
import org.springframework.session.web.http.HttpSessionManager;
import org.springframework.stereotype.Service;

import com.rudra.aks.user.UserBO;

@Service
public class SessionSerivce {

	private static final Logger logger = Logger.getLogger(SessionSerivce.class);
	
	public void addUserToSession(UserBO user, HttpServletRequest httpRequest) {
		logger.info("Start : " + getClass().getName() + " addUserToService()");
		
		HttpSessionManager sessionManager =(HttpSessionManager) httpRequest.getAttribute(HttpSessionManager.class.getName());
		String alias = httpRequest.getParameter("username");
		
		@SuppressWarnings("unchecked")
		SessionRepository<Session> sessionRepository = (SessionRepository<Session>) httpRequest.getAttribute(SessionRepository.class.getName());
	}
	
	
}
