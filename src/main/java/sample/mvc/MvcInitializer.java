

package sample.mvc;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.rudra.aks.config.HttpSessionConfig;

/**
 * 
 * @author Ankush.Verman
 *
 */
public class MvcInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	// tag::config[]
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { HttpSessionConfig.class };
	}
	// end::config[]

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { MvcConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}
}
