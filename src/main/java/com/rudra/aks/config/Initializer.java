
package com.rudra.aks.config;

import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;

// tag::class[]
public class Initializer extends AbstractHttpSessionApplicationInitializer {

	
	/*@Override
	protected void afterSessionRepositoryFilter(ServletContext servletContext) {
		appendFilters(servletContext, new UserAccountsFilter());
	}
	 */
}
// end::class[]
